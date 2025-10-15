package org.itsolutions.mydivelog.app.presentation.certificates

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.app.domain.model.results.DataError
import org.itsolutions.mydivelog.app.domain.model.results.onError
import org.itsolutions.mydivelog.app.domain.model.results.onSuccess
import org.itsolutions.mydivelog.app.domain.repository.CertificateRepository
import javax.inject.Inject

@HiltViewModel
class CertificatesViewModel @Inject constructor(
    private val certificateRepository: CertificateRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init { getDistinctOrganizations() }

    private fun updateState(function: (UiState) -> UiState) {
        _uiState.update(function)
    }

    fun onRetry(retryAction: () -> Unit) {
        updateState { UiState.Loading }
        retryAction()
    }

    fun getDistinctOrganizations() {
        viewModelScope.launch {
            certificateRepository.getDistinctOrganizations()
                .onSuccess { organizations -> updateState { UiState.Ready(organizations) } }
                .onError { error -> updateState { UiState.Error(error) } }
        }
    }

    sealed interface UiState {
        data object Loading : UiState
        data class Ready(val organizations: List<DiveOrganization>) : UiState
        data class Error(val error: DataError) : UiState
    }
}