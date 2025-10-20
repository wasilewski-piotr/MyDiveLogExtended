package org.itsolutions.mydivelog.app.presentation.certificates.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.itsolutions.mydivelog.app.domain.model.Certificate
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.app.domain.model.results.DataError
import org.itsolutions.mydivelog.app.domain.model.results.Result
import org.itsolutions.mydivelog.app.domain.model.results.onError
import org.itsolutions.mydivelog.app.domain.model.results.onSuccess
import org.itsolutions.mydivelog.app.domain.repository.CertificateRepository
import javax.inject.Inject

@HiltViewModel
class CertificatesListViewModel @Inject constructor(
    private val certificateRepository: CertificateRepository
): ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Init)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private fun updateState(function: (UiState) -> UiState) {
        _uiState.update(function)
    }

    private fun updateWithOrganizationState(function: (UiState.WithOrganization) -> UiState) {
        updateState { if (it is UiState.WithOrganization) function(it) else it }
    }

    private fun updateLoadingState(function: (UiState.Loading) -> UiState) {
        updateState { if (it is UiState.Loading) function(it) else it }
    }

    fun setOrganization(organization: DiveOrganization?) {
        updateState { UiState.Loading(organization) }
        getCertificates()
    }

    fun deleteCertificate(certificate: Certificate) {
        updateWithOrganizationState {
            UiState.Loading(it.organization)
        }
        viewModelScope.launch {
            certificateRepository.deleteCertificate(certificate)
                .onSuccess { getCertificates() }
                .onError { error -> updateLoadingState { UiState.FullScreenError(error, certificate, it.organization) } }
        }
    }

    fun getCertificates() {
        val state = uiState.value
        when (state) {
            is UiState.Loading -> {
                viewModelScope.launch {
                    state.organization?.let {
                       getCertificatesFromDatabase(certificateRepository.getCertificatesForOrganization(it))
                    } ?: getCertificatesFromDatabase(certificateRepository.getAllCertificates())
                }
            }
            else -> {
                updateWithOrganizationState {
                    UiState.Loading(it.organization)
                }
                getCertificates()
            }
        }
    }

    private fun getCertificatesFromDatabase(call: Result<List<Certificate>, DataError>) {
        call.onSuccess { certificates -> updateLoadingState { UiState.Ready(certificates, it.organization) } }
            .onError { error -> updateState { UiState.Error(error, null) } }
    }

    sealed interface UiState {
        data object Init : UiState
        data class Loading(val organization: DiveOrganization?) : UiState

        sealed interface WithOrganization : UiState {
            val organization: DiveOrganization?
        }

        data class Ready(
            val certificates: List<Certificate>,
            override val organization: DiveOrganization?
        ) : WithOrganization

        data class Error(
            val error: DataError,
            override val organization: DiveOrganization?
        ) : WithOrganization

        data class FullScreenError(
            val error: DataError,
            val certificate: Certificate,
            override val organization: DiveOrganization?
        ) : WithOrganization
    }
}