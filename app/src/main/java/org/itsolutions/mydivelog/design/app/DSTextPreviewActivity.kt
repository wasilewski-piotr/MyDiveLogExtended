package org.itsolutions.mydivelog.design.app

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.section.DSSectionInCard
import org.itsolutions.mydivelog.design.components.text.DSCardText
import org.itsolutions.mydivelog.design.components.text.DSCardTitle
import org.itsolutions.mydivelog.design.components.text.DSCardTitleWithText
import org.itsolutions.mydivelog.design.components.text.DSCardTitleWithTextCentered
import org.itsolutions.mydivelog.design.components.text.DSSubtitle
import org.itsolutions.mydivelog.design.components.text.DSTitle
import org.itsolutions.mydivelog.design.components.text.DSTitleWithSubtitle
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity
import org.itsolutions.mydivelog.extensions.verticalPadding

internal class DSTextPreviewActivity : MyDiveLogThemedActivity() {

    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = "Text",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.fillMaxWidth().verticalScroll(scrollState).verticalPadding(),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.xl)
        ) {
            DSSectionInCard("DSTitle") { DSTitle("Title Example") }
            DSSectionInCard("DSSubtitle") { DSSubtitle("Subtitle Example") }
            DSSectionInCard("DSTitleWithSubtitle") { DSTitleWithSubtitle(title = "Title Example", subtitle = "Subtitle Example") }
            DSSectionInCard("DSCardTitle") { DSCardTitle("Card Title") }
            DSSectionInCard("DSCardText") { DSCardText("Card Text") }
            DSSectionInCard("DSCardTitleWithText") { DSCardTitleWithText(title = "Title Example", text = "Subtitle Example") }
            DSSectionInCard("DSCardTitleWithTextCentered") {
                DSCardTitleWithTextCentered(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Title Example",
                    text = "Subtitle Example"
                )
            }
        }
    }

    companion object {
        fun createInstance(context: Context) = Intent(context, DSTextPreviewActivity::class.java)
    }
}