package org.itsolutions.mydivelog.design.app

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.design.components.cards.DSCard
import org.itsolutions.mydivelog.design.components.cards.DSCertificateCard
import org.itsolutions.mydivelog.design.components.cards.DSOrganizationCard
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.section.DSSection
import org.itsolutions.mydivelog.design.components.text.DSCardTitleWithText
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity
import org.itsolutions.mydivelog.extensions.verticalPadding
import java.time.LocalDate

internal class DSCardPreviewActivity : MyDiveLogThemedActivity() {

    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = "Cards",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.fillMaxSize().verticalPadding().verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.xl)
        ) {
            DSSection("DSCard") {
                DSCard {
                    DSCardTitleWithText(
                        title = "Card Title Example",
                        text = "Card Text Example"
                    )
                }
            }
            DSSection("DSOrganizationCard") {
                DSOrganizationCard(
                    organization = DiveOrganization.SSI
                )
            }
            DSSection("DSOrganizationCard | Clickable") {
                DSOrganizationCard(
                    organization = DiveOrganization.SSI,
                    onClick = { }
                )
            }
            DSSection("DSCertificateCard | Small") {
                DSCertificateCard(
                    organization = DiveOrganization.SSI,
                    certificateName = "Open Water Diver",
                    certificateNumber = "65465434N54654324-PL",
                )
            }
            DSSection("DSCertificateCard | Small Clickable") {
                DSCertificateCard(
                    organization = DiveOrganization.SSI,
                    certificateName = "Open Water Diver",
                    certificateNumber = "65465434N54654324-PL",
                    onClick = { }
                )
            }
            DSSection("DSCertificateCard") {
                DSCertificateCard(
                    organization = DiveOrganization.SSI,
                    issueDate = LocalDate.now(),
                    issuerName = "Bob budowniczy",
                    issuerId = "696546",
                    certificateName = "Open Water Diver",
                    certificateNumber = "65465434N54654324-PL",
                )
            }
        }
    }

    companion object {
        fun createInstance(context: Context) = Intent(context, DSCardPreviewActivity::class.java)
    }
}