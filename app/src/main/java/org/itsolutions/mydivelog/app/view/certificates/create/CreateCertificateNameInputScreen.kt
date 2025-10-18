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
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.presentation.certificates.create.CreateCertificateViewModel
import org.itsolutions.mydivelog.design.components.buttons.DSPrimaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.inputs.DSTextInput
import org.itsolutions.mydivelog.design.components.inputs.ValidationOverrides
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.components.spacers.WeightedSpacer
import org.itsolutions.mydivelog.design.components.text.DSTitleWithSubtitle
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.extensions.verticalPadding

@Composable
internal fun CreateCertificateNameInputScreen(
    state: CreateCertificateViewModel.UiState.CertificateData,
    onClick: () -> Unit
) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxHeight().verticalScroll(scrollState).verticalPadding()) {
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

        WeightedSpacer()
        DSPrimaryButtonMaxWidth(R.string.continue_text) {
            onClick()
        }
    }
}