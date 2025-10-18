package org.itsolutions.mydivelog.app.view.certificates.create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.design.components.cards.DSOrganizationCard
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.components.text.DSTitleWithSubtitle
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.extensions.verticalPadding

@Composable
internal fun CreateCertificateSelectOrganizationScreen(onOrganizationClick: (DiveOrganization) -> Unit) {
    val scrollState = rememberScrollState()
    Column(Modifier.verticalScroll(scrollState).verticalPadding()) {
        DSTitleWithSubtitle(
            title = R.string.create_certificate_choose_your_diving_organization_title,
            subtitle = R.string.create_certificate_choose_your_diving_organization_subtitle,
        )
        VerticalSpacer(DesignSystem.spacing.md)
        Column(verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.md)) {
            DiveOrganization.entries.sortedBy { it.name }.forEach { organization ->
                DSOrganizationCard(organization) {
                    onOrganizationClick(organization)
                }
            }
        }
    }
}