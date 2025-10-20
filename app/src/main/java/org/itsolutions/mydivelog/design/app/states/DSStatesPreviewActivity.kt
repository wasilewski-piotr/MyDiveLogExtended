package org.itsolutions.mydivelog.design.app.states

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.design.app.states.empty.DSEmptyStatePreviewActivity
import org.itsolutions.mydivelog.design.app.states.error.DSErrorStatePreviewActivity
import org.itsolutions.mydivelog.design.app.states.error.DSErrorStatesFullScreenPreviewActivity
import org.itsolutions.mydivelog.design.app.states.success.DSSuccessStatesFullScreenPreviewActivity
import org.itsolutions.mydivelog.design.components.buttons.DSPrimaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity
import org.itsolutions.mydivelog.extensions.activityLauncher
import org.itsolutions.mydivelog.extensions.verticalPadding

internal class DSStatesPreviewActivity : MyDiveLogThemedActivity() {

    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = "States",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        val launch = activityLauncher()
        val context = LocalContext.current

        Column(
            modifier = Modifier.verticalPadding(),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.xs)
        ) {
            DSPrimaryButtonMaxWidth("Empty State") {
                launch(DSEmptyStatePreviewActivity.createInstance(context))
            }
            DSPrimaryButtonMaxWidth("Error State") {
                launch(DSErrorStatePreviewActivity.createInstance(context))
            }
            DSPrimaryButtonMaxWidth("Error State | Full Screen") {
                launch(DSErrorStatesFullScreenPreviewActivity.createInstance(context))
            }
            DSPrimaryButtonMaxWidth("Success State | Full Screen") {
                launch(DSSuccessStatesFullScreenPreviewActivity.createInstance(context))
            }
        }
    }

    internal enum class DSStateTypes {
        SINGLE_BUTTON, BUTTONS_HORIZONTAL, BUTTONS_VERTICAL
    }

    companion object {
        fun createInstance(context: Context) = Intent(context, DSStatesPreviewActivity::class.java)
    }
}