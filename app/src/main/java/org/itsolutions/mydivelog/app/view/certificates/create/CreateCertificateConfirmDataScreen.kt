package org.itsolutions.mydivelog.app.view.certificates.create

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.app.domain.validation.Rules
import org.itsolutions.mydivelog.app.domain.validation.ValidationField
import org.itsolutions.mydivelog.app.presentation.certificates.create.CreateCertificateViewModel
import org.itsolutions.mydivelog.design.components.buttons.DSCombinedButtonsHorizontally
import org.itsolutions.mydivelog.design.components.cards.DSCertificateCard
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.components.spacers.WeightedSpacer
import org.itsolutions.mydivelog.design.components.text.DSTitleWithSubtitle
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme
import org.itsolutions.mydivelog.extensions.verticalPadding
import java.time.LocalDate

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

@Preview
@Composable
private fun CreateCertificateConfirmDataScreenPreview() {
    MyDiveLogTheme {
        CreateCertificateConfirmDataScreen(
            state = CreateCertificateViewModel.UiState.CertificateData(
                organization = DiveOrganization.SSI,
                certificateName = ValidationField("Open Water Diver", Rules.notEmpty()),
                certificateNumber = ValidationField("54564654654N3287Y45-PL", Rules.notEmpty()),
                certificateIssuerId = ValidationField("5347534", Rules.notEmpty()),
                certificateIssuerName = ValidationField("Bob Budowniczy", Rules.notEmpty()),
                certificateIssueDate = ValidationField(LocalDate.now(), Rules.afterToday())
            ),
            createCertificate = { },
            cancel = { }
        )
    }
}