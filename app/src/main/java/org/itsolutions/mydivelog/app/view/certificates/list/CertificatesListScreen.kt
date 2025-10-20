package org.itsolutions.mydivelog.app.view.certificates.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.Certificate
import org.itsolutions.mydivelog.app.domain.model.results.DataError
import org.itsolutions.mydivelog.app.domain.model.results.toMessageResource
import org.itsolutions.mydivelog.app.presentation.certificates.list.CertificatesListViewModel.UiState
import org.itsolutions.mydivelog.app.presentation.certificates.list.CertificatesListViewModel.UiState.Error
import org.itsolutions.mydivelog.app.presentation.certificates.list.CertificatesListViewModel.UiState.Ready
import org.itsolutions.mydivelog.design.components.cards.DSCertificateCard
import org.itsolutions.mydivelog.design.components.progress.DSCircularProgressIndicator
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.components.states.empty.DSEmptyState
import org.itsolutions.mydivelog.design.components.states.error.DSErrorState
import org.itsolutions.mydivelog.design.components.states.error.DSErrorStateFullScreen
import org.itsolutions.mydivelog.design.components.text.DSTitleWithSubtitle
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.extensions.verticalPadding

@Composable
fun CertificatesListScreen(
    uiState: UiState,
    onClick: (Certificate) -> Unit,
    onLongClick: (Certificate) -> Unit,
    onRetry: () -> Unit,
    onRetryDelete: (Certificate) -> Unit,
    onFinish: () -> Unit
) {
    when (uiState) {
        is Error, is Ready -> {
            CertificatesListScreenContent(
                uiState = uiState,
                onRetry = onRetry,
                onClick = onClick,
                onLongClick = onLongClick,
            )
        }

        is UiState.FullScreenError -> {
            DSErrorStateFullScreen(
                title = stringResource(R.string.error_title),
                subtitle = stringResource(uiState.error.toMessageResource()),
                primaryButtonText = stringResource(R.string.close),
                primaryButtonAction = onFinish,
                secondaryButtonText = stringResource(R.string.retry),
                secondaryButtonAction = { onRetryDelete(uiState.certificate) }
            )
        }

        else -> {
            DSCircularProgressIndicator()
        }
    }
}

@Composable
private fun CertificatesListScreenContent(
    uiState: UiState.WithOrganization,
    onRetry: () -> Unit,
    onClick: (Certificate) -> Unit,
    onLongClick: (Certificate) -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .verticalPadding()
    ) {
        DSTitleWithSubtitle(
            title = uiState.organization?.let {
                stringResource(R.string.certificates_list_by_organization_screen_title, it.name)
            } ?: stringResource(R.string.certificates_list_screen_title),
            subtitle = uiState.organization?.let {
                stringResource(R.string.certificates_list_by_organization_screen_subtitle, it.name)
            } ?: stringResource(R.string.certificates_list_screen_subtitle),
        )
        VerticalSpacer(DesignSystem.spacing.md)
        when (uiState) {
            is Ready -> {
                val certificates = uiState.certificates
                if (certificates.isEmpty()) {
                    Box(Modifier.fillMaxSize().weight(1f, true)) {
                        if (uiState.organization == null) {
                            DSEmptyState(R.string.empty_state_no_certificates_found)
                        } else {
                            DSEmptyState(
                                stringResource(
                                    id =R.string.empty_state_no_certificates_found_for_this_organization,
                                    formatArgs = arrayOf(uiState.organization.name)
                                )
                            )
                        }
                    }
                } else {
                    Column(verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.md)) {
                        certificates.forEach { certificate ->
                            DSCertificateCard(
                                certificateName = certificate.certificateName,
                                certificateNumber = certificate.certificateNumber,
                                organization = certificate.organization,
                                onClick = { onClick(certificate) },
                                onLongClick = { onLongClick(certificate) }
                            )
                        }
                    }
                }
            }

            else -> {
                val error = if (uiState is Error) uiState.error else DataError.Local.UNKNOWN
                DSErrorState(error) { onRetry() }
            }
        }
    }
}