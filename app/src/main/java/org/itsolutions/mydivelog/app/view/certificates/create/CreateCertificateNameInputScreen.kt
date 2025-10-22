package org.itsolutions.mydivelog.app.view.certificates.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.app.domain.validation.Rules
import org.itsolutions.mydivelog.app.domain.validation.ValidationField
import org.itsolutions.mydivelog.app.presentation.certificates.create.CreateCertificateViewModel
import org.itsolutions.mydivelog.design.components.buttons.DSPrimaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.inputs.DSTextInput
import org.itsolutions.mydivelog.design.components.inputs.ValidationOverrides
import org.itsolutions.mydivelog.design.components.section.DSBottomSection
import org.itsolutions.mydivelog.design.components.section.DSTopSection
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.components.spacers.WeightedSpacer
import org.itsolutions.mydivelog.design.components.text.DSTitleWithSubtitle
import org.itsolutions.mydivelog.design.theme.DesignSystem

@Composable
internal fun CreateCertificateNameInputScreen(
    state: CreateCertificateViewModel.UiState.CertificateData,
    onClick: () -> Unit
) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxHeight().verticalScroll(scrollState)) {
        DSTopSection {
            DSTitleWithSubtitle(
                title = R.string.create_certificate_enter_certificate_details_title,
                subtitle = R.string.create_certificate_enter_certificate_details_subtitle,
            )
            VerticalSpacer(DesignSystem.spacing.md)

            DSTextInput(
                label = stringResource(R.string.create_certificate_name_input_title),
                placeholder = stringResource(R.string.create_certificate_name_input_placeholder),
                customError = ValidationOverrides(
                    required = R.string.create_certificate_empty_certificate_name
                ),
                field = state.certificateName
            )

            VerticalSpacer(DesignSystem.spacing.sm)

            DSTextInput(
                label = stringResource(R.string.create_certificate_number_input_title),
                placeholder = stringResource(R.string.create_certificate_number_input_placeholder),
                customError = ValidationOverrides(
                    required = R.string.create_certificate_empty_certificate_number,
                    existsInDatabase = R.string.create_certificate_certificate_number_already_exists
                ),
                field = state.certificateNumber,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Characters
                ),
            )
            VerticalSpacer(DesignSystem.spacing.sm)
        }
        WeightedSpacer()
        DSBottomSection {
            DSPrimaryButtonMaxWidth(R.string.continue_text) {
                onClick()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CreateCertificateNameInputScreenPreview() {
    CreateCertificateNameInputScreen(
        state = CreateCertificateViewModel.UiState.CertificateData(
            organization = DiveOrganization.SSI,
            certificateName = ValidationField("", Rules.notEmpty()),
            certificateNumber = ValidationField("", Rules.notEmpty()),
            certificateIssuerId = ValidationField("", Rules.notEmpty()),
            certificateIssuerName = ValidationField("", Rules.notEmpty()),
            certificateIssueDate = ValidationField(null, Rules.afterToday())
        ),
        onClick = { }
    )
}