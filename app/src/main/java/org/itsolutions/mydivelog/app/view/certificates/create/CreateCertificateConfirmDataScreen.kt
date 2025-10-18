package org.itsolutions.mydivelog.app.view.certificates.create

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.presentation.certificates.create.CreateCertificateViewModel
import org.itsolutions.mydivelog.design.components.buttons.DSCombinedButtonsHorizontally
import org.itsolutions.mydivelog.design.components.cards.DSCertificateCard
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.components.spacers.WeightedSpacer
import org.itsolutions.mydivelog.design.components.text.DSTitleWithSubtitle
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.extensions.verticalPadding

@Composable
internal fun CreateCertificateConfirmDataScreen(
    state: CreateCertificateViewModel.UiState.CertificateData,
    createCertificate: () -> Unit,
    cancel: () -> Unit
) {
    Column(modifier = Modifier.verticalPadding()) {
        DSTitleWithSubtitle(
            title = R.string.create_certificate_review_data_title,
            subtitle = R.string.create_certificate_review_data_subtitle
        )
        VerticalSpacer(DesignSystem.spacing.xl)
        DSCertificateCard(
            issueDate = state.certificateIssueDate.value,
            issuerName = state.certificateIssuerName.value,
            issuerId = state.certificateIssuerId.value,
            certificateName = state.certificateName.value,
            certificateNumber = state.certificateNumber.value,
            organization = state.organization
        )
        WeightedSpacer()
        DSCombinedButtonsHorizontally(
            primaryText = stringResource(R.string.create_certificate_review_data_button_label),
            onPrimaryClick = createCertificate,
            secondaryText = stringResource(R.string.cancel),
            onSecondaryClick = cancel
        )
    }
}