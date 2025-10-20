package org.itsolutions.mydivelog.design.app.pickers.date

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.pickers.DSDatePicker
import org.itsolutions.mydivelog.design.components.section.DSSection
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity
import org.itsolutions.mydivelog.extensions.verticalPadding

internal class DSDatePickerPreviewActivity : MyDiveLogThemedActivity() {

    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = "Date Picker",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        Column(
            modifier = Modifier.Companion.verticalPadding(),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.xl)
        ) {
            DSSection("DSDatePicker") {
                DSDatePicker(
                    onDateSelected = { finish() },
                    onDismissPicker = { finish() }
                )
            }
        }
    }

    companion object {
        fun createInstance(context: Context) =
            Intent(context, DSDatePickerPreviewActivity::class.java)
    }
}