package org.itsolutions.mydivelog.design.app.dialogs

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.design.app.dialogs.alert.DSAlertDialogPreviewActivity
import org.itsolutions.mydivelog.design.app.dialogs.date.DSDatePickerDialogPreviewActivity
import org.itsolutions.mydivelog.design.components.buttons.DSPrimaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity
import org.itsolutions.mydivelog.extensions.activityLauncher
import org.itsolutions.mydivelog.extensions.verticalPadding

internal class DSDialogsPreviewActivity : MyDiveLogThemedActivity() {
    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = "Dialogs",
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
            DSPrimaryButtonMaxWidth("Date Picker Dialog") {
                launch(DSDatePickerDialogPreviewActivity.createInstance(context))
            }
            DSPrimaryButtonMaxWidth("Alert Dialog") {
                launch(DSAlertDialogPreviewActivity.createInstance(context))
            }
        }
    }

    companion object {
        fun createInstance(context: Context) = Intent(context, DSDialogsPreviewActivity::class.java)
    }
}