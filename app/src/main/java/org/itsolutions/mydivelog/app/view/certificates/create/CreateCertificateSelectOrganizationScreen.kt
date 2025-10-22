package org.itsolutions.mydivelog.app.view.certificates.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.design.components.cards.DSOrganizationCard
import org.itsolutions.mydivelog.design.components.section.DSListSection
import org.itsolutions.mydivelog.design.components.section.DSTopSection
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.components.text.DSTitleWithSubtitle
import org.itsolutions.mydivelog.design.theme.DesignSystem

@Composable
internal fun CreateCertificateSelectOrganizationScreen(onOrganizationClick: (DiveOrganization) -> Unit) {
    val scrollState = rememberScrollState()
    Column(Modifier.verticalScroll(scrollState)) {
        DSTopSection {
            DSTitleWithSubtitle(
                title = R.string.create_certificate_choose_your_diving_organization_title,
                subtitle = R.string.create_certificate_choose_your_diving_organization_subtitle,
            )
            VerticalSpacer(DesignSystem.spacing.md)
        }
        HorizontalDivider(thickness = 1.dp)
        DSListSection {
            DiveOrganization.entries.sortedBy { it.name }.forEach { organization ->
                DSOrganizationCard(organization) {
                    onOrganizationClick(organization)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CreateCertificateSelectOrganizationScreenPreview() {
    CreateCertificateSelectOrganizationScreen { }
}