package org.itsolutions.mydivelog.design.app.states.success

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.design.app.states.DSStatesPreviewActivity.DSStateTypes.BUTTONS_HORIZONTAL
import org.itsolutions.mydivelog.design.app.states.DSStatesPreviewActivity.DSStateTypes.BUTTONS_VERTICAL
import org.itsolutions.mydivelog.design.app.states.DSStatesPreviewActivity.DSStateTypes.SINGLE_BUTTON
import org.itsolutions.mydivelog.design.components.buttons.DSPrimaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity
import org.itsolutions.mydivelog.extensions.activityLauncher
import org.itsolutions.mydivelog.extensions.verticalPadding

internal class DSSuccessStatesFullScreenPreviewActivity : MyDiveLogThemedActivity() {

    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = "Success State",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        val launcher = activityLauncher()
        val context = LocalContext.current
        Column(
            modifier = Modifier.Companion.verticalPadding(),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.xs)
        ) {
            DSPrimaryButtonMaxWidth("Success State | Single Button") {
                launcher(
                    DSSuccessStateFullScreenPreviewActivity.createInstance(
                        context = context,
                        type = SINGLE_BUTTON
                    )
                )
            }
            DSPrimaryButtonMaxWidth("Success State | Buttons Horizontal") {
                launcher(
                    DSSuccessStateFullScreenPreviewActivity.createInstance(
                        context = context,
                        type = BUTTONS_HORIZONTAL
                    )
                )
            }
            DSPrimaryButtonMaxWidth("Success State | Buttons Vertical") {
                launcher(
                    DSSuccessStateFullScreenPreviewActivity.createInstance(
                        context = context,
                        type = BUTTONS_VERTICAL
                    )
                )
            }
        }
    }

    companion object {
        fun createInstance(context: Context) =
            Intent(context, DSSuccessStatesFullScreenPreviewActivity::class.java)
    }
}