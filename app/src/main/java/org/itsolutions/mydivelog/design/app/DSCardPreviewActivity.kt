package org.itsolutions.mydivelog.design.app

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.design.components.card.DSCard
import org.itsolutions.mydivelog.design.components.card.DSOrganizationCard
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.section.DSSection
import org.itsolutions.mydivelog.design.components.text.DSCardTitleWithText
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity
import org.itsolutions.mydivelog.extensions.verticalPadding

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
        Column(
            modifier = Modifier.verticalPadding(),
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
                    organization = DiveOrganization.SSI,
                    onClick = { }
                )
            }
        }
    }

    companion object {
        fun createInstance(context: Context) = Intent(context, DSCardPreviewActivity::class.java)
    }
}