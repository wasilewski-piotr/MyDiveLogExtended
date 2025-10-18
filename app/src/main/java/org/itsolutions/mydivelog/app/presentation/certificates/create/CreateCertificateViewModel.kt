package org.itsolutions.mydivelog.app.presentation.certificates.create

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
import org.itsolutions.mydivelog.app.domain.model.results.onError
import org.itsolutions.mydivelog.app.domain.model.results.onSuccess
import org.itsolutions.mydivelog.app.domain.repository.CertificateRepository
import org.itsolutions.mydivelog.app.domain.validation.Rules
import org.itsolutions.mydivelog.app.domain.validation.ValidationError
import org.itsolutions.mydivelog.app.domain.validation.ValidationField
import org.itsolutions.mydivelog.app.domain.validation.validateAll
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class CreateCertificateViewModel @Inject constructor(
    private val certificateRepository: CertificateRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.SelectOrganization)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private fun updateState(function: (UiState) -> UiState) {
        _uiState.update(function)
    }

    fun updateOrganization(organization: DiveOrganization) {
        updateState {
            UiState.CertificateData(
                organization = organization,
                certificateName = ValidationField("", Rules.notEmpty()),
                certificateNumber = ValidationField("", Rules.notEmpty()),
                certificateIssuerName = ValidationField("", Rules.notEmpty()),
                certificateIssuerId = ValidationField("", Rules.notEmpty()),
                certificateIssueDate = ValidationField(null, Rules.afterToday())
            )
        }
    }

    fun validateIssuerInputs(navigate: () -> Unit) {
        val currentState = _uiState.value
        when (currentState) {
            is UiState.CertificateData -> {
                if (
                    validateAll(
                        currentState.certificateIssuerId,
                        currentState.certificateIssuerName,
                        currentState.certificateIssueDate
                    )
                ) {
                    navigate()
                }
            }

            else -> { /* Do nothing */ }
        }
    }

    fun validateNameInputs(navigate: () -> Unit) {
        val currentState = _uiState.value
        if (currentState is UiState.CertificateData) {
            if (validateAll(currentState.certificateName, currentState.certificateNumber)) {
                viewModelScope.launch {
                    if (certificateRepository.checkCertificateExistsByNumber(currentState.certificateNumber.value)) {
                        currentState.certificateNumber.set(ValidationError.ExistsInDatabase)
                    } else {
                        navigate()
                    }
                }
            }
        }
    }

    fun saveCertificateInDatabase() {
        val state = _uiState.value

        val readyState = when (state) {
            is UiState.CreatingCertificate -> state.certificate
            is UiState.CertificateData -> {
                updateState { UiState.CreatingCertificate(state) }
                saveCertificateInDatabase()
                return
            }
            else -> {
                updateState { UiState.Error(DataError.Local.UNKNOWN) }
                return
            }
        }

        readyState.certificateIssueDate.value?.let { date ->
            val certificate = Certificate(
                certificateName = readyState.certificateName.value,
                certificateNumber = readyState.certificateNumber.value,
                organization = readyState.organization,
                issuedBy = readyState.certificateIssuerName.value,
                issuerId = readyState.certificateIssuerId.value,
                issueDate = date
            )

            viewModelScope.launch {
                certificateRepository.createCertificate(certificate)
                    .onSuccess { updateState { UiState.Success(certificate) } }
                    .onError { error -> updateState { UiState.Error(error) } }
            }
        } ?: updateState { UiState.Error(DataError.Local.MISSING_CERTIFICATE_ISSUE_DATE) }
    }

    sealed interface UiState {
        data object SelectOrganization : UiState

        data class CertificateData(
            val certificateName: ValidationField<String>,
            val certificateNumber: ValidationField<String>,
            val certificateIssuerName: ValidationField<String>,
            val certificateIssuerId: ValidationField<String>,
            val certificateIssueDate: ValidationField<LocalDate?>,
            val organization: DiveOrganization
        ): UiState

        data class CreatingCertificate(val certificate: CertificateData) : UiState
        data class Success(val certificate: Certificate) : UiState
        data class Error(val error: DataError) : UiState
    }
}