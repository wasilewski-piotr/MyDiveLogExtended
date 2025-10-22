package org.itsolutions.mydivelog.app.view.certificates

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.app.presentation.certificates.CertificatesViewModel
import org.itsolutions.mydivelog.app.view.certificates.create.CreateCertificateActivity
import org.itsolutions.mydivelog.app.view.certificates.list.CertificatesListActivity
import org.itsolutions.mydivelog.design.components.buttons.DSButtonsOrientation
import org.itsolutions.mydivelog.design.components.buttons.DSCombinedButtons
import org.itsolutions.mydivelog.design.components.buttons.DSPrimaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.cards.DSOrganizationCard
import org.itsolutions.mydivelog.design.components.progress.DSCircularProgressIndicator
import org.itsolutions.mydivelog.design.components.section.DSListSectionScrollable
import org.itsolutions.mydivelog.design.components.section.DSTopSection
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.components.states.empty.DSEmptyState
import org.itsolutions.mydivelog.design.components.states.error.DSErrorState
import org.itsolutions.mydivelog.design.components.text.DSSubtitle
import org.itsolutions.mydivelog.design.components.text.DSTitleWithSubtitle
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.extensions.activityLauncherWithResult

@Composable
fun CertificatesScreen(viewModel: CertificatesViewModel) {
    with(viewModel) {
        val context = LocalContext.current
        val uiState = uiState.collectAsState().value
        val launcher = activityLauncherWithResult {
            if (it.resultCode == Activity.RESULT_OK) {
                onRetry {
                    getDistinctOrganizations()
                }
            }
        }

        when (uiState) {
            CertificatesViewModel.UiState.Loading -> DSCircularProgressIndicator()
            is CertificatesViewModel.UiState.Ready -> {
                CertificatesScreenContent(
                    organizations = uiState.organizations,
                    onPrimaryButtonClick = { launcher(CreateCertificateActivity.createInstance(context)) },
                    onSecondaryButtonClick = { launcher(CertificatesListActivity.createInstance(context)) },
                    onCardClick = { launcher(CertificatesListActivity.createInstance(context, it)) }
                )
            }
            is CertificatesViewModel.UiState.Error -> {
                DSErrorState(uiState.error) {
                    onRetry {
                        getDistinctOrganizations()
                    }
                }
            }
        }
    }
}

@Composable
private fun CertificatesScreenContent(
    organizations: List<DiveOrganization>,
    onPrimaryButtonClick: () -> Unit,
    onSecondaryButtonClick: () -> Unit,
    onCardClick: (DiveOrganization) -> Unit,
) {
    Column {
        DSTopSection {
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
        }
        HorizontalDivider(thickness = 1.dp)
        CertificatesList(organizations, onCardClick)
    }
}

@Composable
private fun ColumnScope.CertificatesList(
    organizations: List<DiveOrganization>,
    onCardClick: (DiveOrganization) -> Unit,
) {
    if (organizations.isEmpty()) {
        DSEmptyState(R.string.empty_state_no_organizations_found)
    } else {
        DSListSectionScrollable {
            organizations.forEach { organization ->
                DSOrganizationCard(organization) {
                    onCardClick(organization)
                }
            }
        }
    }
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

@Preview(showBackground = true)
@Composable
private fun CertificatesScreenPreview() {
    CertificatesScreenContent(
        organizations = emptyList(),
        onPrimaryButtonClick = { },
        onSecondaryButtonClick = { },
        onCardClick = { }
    )
}