package org.itsolutions.mydivelog.design.app.inputs

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.design.app.inputs.date.DSDateInputPreviewActivity
import org.itsolutions.mydivelog.design.app.inputs.text.DSTextInputPreviewActivity
import org.itsolutions.mydivelog.design.components.buttons.DSPrimaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity
import org.itsolutions.mydivelog.extensions.activityLauncher
import org.itsolutions.mydivelog.extensions.verticalPadding

internal class DSInputsPreviewActivity : MyDiveLogThemedActivity() {
    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = "Inputs",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        val launch = activityLauncher()
        val context = LocalContext.current

        Column(
            modifier = Modifier.Companion.verticalPadding(),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.xs)
        ) {
            DSPrimaryButtonMaxWidth("Text Input") {
                launch(DSTextInputPreviewActivity.Companion.createInstance(context))
            }
            DSPrimaryButtonMaxWidth("Date Input") {
                launch(DSDateInputPreviewActivity.Companion.createInstance(context))
            }
        }
    }

    companion object{
        fun createInstance(context: Context) = Intent(context, DSInputsPreviewActivity::class.java)
    }
}