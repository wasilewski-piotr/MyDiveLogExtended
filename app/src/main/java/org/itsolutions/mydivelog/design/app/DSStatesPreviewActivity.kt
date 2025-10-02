package org.itsolutions.mydivelog.design.app

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.design.app.states.DSEmptyStatePreviewActivity
import org.itsolutions.mydivelog.design.app.states.DSErrorStatePreviewActivity
import org.itsolutions.mydivelog.design.components.button.DSPrimaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity
import org.itsolutions.mydivelog.extensions.activityLauncher
import org.itsolutions.mydivelog.extensions.verticalPadding

internal class DSStatesPreviewActivity  : MyDiveLogThemedActivity() {

    @Composable
    override fun TopBar() {
        DSTopNavigation(
            title = "States",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController) {
        val launch = activityLauncher()
        val context = LocalContext.current

        Column(modifier = Modifier.verticalPadding()) {
            DSPrimaryButtonMaxWidth("Empty State") {
                launch(DSEmptyStatePreviewActivity.Companion.createInstance(context))
            }
            DSPrimaryButtonMaxWidth("Error State") {
                launch(DSErrorStatePreviewActivity.createInstance(context))
            }
        }
    }

    companion object {
        fun createInstance(context: Context) = Intent(context, DSStatesPreviewActivity::class.java)
    }
}