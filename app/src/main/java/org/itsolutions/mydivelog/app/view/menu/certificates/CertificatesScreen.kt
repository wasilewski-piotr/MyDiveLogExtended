package org.itsolutions.mydivelog.app.view.menu.certificates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.app.presentation.menu.certificates.CertificatesViewModel
import org.itsolutions.mydivelog.design.components.button.DSButtonsOrientation
import org.itsolutions.mydivelog.design.components.button.DSCombinedButtons
import org.itsolutions.mydivelog.design.components.button.DSPrimaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.card.DSOrganizationCard
import org.itsolutions.mydivelog.design.components.progress.DSCircularProgressIndicator
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.components.states.DSEmptyState
import org.itsolutions.mydivelog.design.components.states.DSErrorState
import org.itsolutions.mydivelog.design.components.text.DSSubtitle
import org.itsolutions.mydivelog.design.components.text.DSTitleWithSubtitle
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.extensions.extendOutsideParent
import org.itsolutions.mydivelog.extensions.topPadding

@Composable
fun CertificatesScreen(viewModel: CertificatesViewModel) {
    val uiState = viewModel.uiState.collectAsState().value

    when (uiState) {
        CertificatesViewModel.UiState.Loading -> CertificatesProgressScreen()
        is CertificatesViewModel.UiState.Ready -> {
            CertificatesScreenContent(
                organizations = uiState.organizations,
                onPrimaryButtonClick = { /* TODO ADD */ },
                onSecondaryButtonClick = { /* TODO ADD */ }
            )
        }
        is CertificatesViewModel.UiState.Error -> {
            DSErrorState(uiState.error) {
//                TODO ADD ON RETRY
            }
        }
    }
}

@Composable
private fun CertificatesProgressScreen() {
    DSCircularProgressIndicator()
}

@Composable
private fun CertificatesScreenContent(
    organizations: List<DiveOrganization>,
    onPrimaryButtonClick: () -> Unit,
    onSecondaryButtonClick: () -> Unit,
) {
    Column(modifier = Modifier.topPadding()) {
        DSTitleWithSubtitle(
            title = R.string.certificates_screen_title,
            subtitle = R.string.certificates_screen_subtitle
        )
        VerticalSpacer(DesignSystem.spacing.sm)
        CertificatesScreenButtonsSection(
            organizations = organizations,
            onPrimaryButtonClick = onPrimaryButtonClick,
            onSecondaryButtonClick = onSecondaryButtonClick,
        )
        VerticalSpacer(DesignSystem.spacing.sm)
        DSSubtitle(R.string.certificates_screen_my_organizations)
        VerticalSpacer(DesignSystem.spacing.sm)
        HorizontalDivider(
            modifier = Modifier.extendOutsideParent(
                start = DesignSystem.spacing.lg,
                end = DesignSystem.spacing.lg
            ),
            thickness = 1.dp
        )
        CertificatesList(organizations)
    }
}

@Composable
private fun CertificatesList(organizations: List<DiveOrganization>) {
    val scrollState = rememberScrollState()
    if (organizations.isEmpty()) {
        CertificatesEmptyStateScreen()
    } else {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(scrollState).topPadding(),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.md)
        ) {
            organizations.forEach { organization ->
                DSOrganizationCard(organization) {
//                    TODO ADD ON CARD CLICK
                }
            }
        }
    }
}

@Composable
private fun CertificatesEmptyStateScreen() {
    DSEmptyState(R.string.empty_state_no_organizations_found)
}

@Composable
private fun CertificatesScreenButtonsSection(
    organizations: List<DiveOrganization>,
    onPrimaryButtonClick: () -> Unit,
    onSecondaryButtonClick: () -> Unit,
) {
    if (organizations.isEmpty()) {
        DSPrimaryButtonMaxWidth(
            text = R.string.certificates_screen_new_certificate,
            leadingIcon = R.drawable.add,
            onClick = onPrimaryButtonClick
        )
    } else {
        DSCombinedButtons(
            primaryText = R.string.certificates_screen_new_certificate,
            secondaryText = R.string.certificates_screen_view_all_certificates,
            onPrimaryClick = onPrimaryButtonClick,
            onSecondaryClick = onSecondaryButtonClick,
            orientation = DSButtonsOrientation.HORIZONTAL_INVERTED,
            primaryLeadingIcon = R.drawable.add,
            secondaryLeadingIcon = R.drawable.bar_chart
        )
    }
}

@Preview
@Composable
private fun CertificatesScreenPreview() {
    CertificatesScreenContent(
        organizations = emptyList(),
        onPrimaryButtonClick = { },
        onSecondaryButtonClick = { }
    )
}