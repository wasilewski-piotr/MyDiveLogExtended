package org.itsolutions.mydivelog.design.app

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.design.components.buttons.DSPrimaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity
import org.itsolutions.mydivelog.extensions.activityLauncher
import org.itsolutions.mydivelog.extensions.verticalPadding

internal class MyDiveLogDesignActivity : MyDiveLogThemedActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = "My Dive Log Design System",
            type = DSTopNavigationType.EXIT,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        val launch = activityLauncher()
        val context = LocalContext.current

        Column(modifier = Modifier.verticalPadding()) {
            DSPrimaryButtonMaxWidth("Buttons") {
                launch(DSButtonPreviewActivity.Companion.createInstance(context))
            }
            DSPrimaryButtonMaxWidth("Cards") {
                launch(DSCardPreviewActivity.createInstance(context))
            }
            DSPrimaryButtonMaxWidth("Navigation") {
                launch(DSNavigationPreviewActivity.createInstance(context))
            }
            DSPrimaryButtonMaxWidth("Progress") {
                launch(DSProgressPreviewActivity.createInstance(context))
            }
            DSPrimaryButtonMaxWidth("States") {
                launch(DSStatesPreviewActivity.createInstance(context))
            }
            DSPrimaryButtonMaxWidth("Text") {
                launch(DSTextPreviewActivity.createInstance(context))
            }
        }
    }
}