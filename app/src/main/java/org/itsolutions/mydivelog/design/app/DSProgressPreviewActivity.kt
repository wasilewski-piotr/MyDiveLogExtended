package org.itsolutions.mydivelog.design.app

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.progress.DSCircularProgressIndicator
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity

internal class DSProgressPreviewActivity  : MyDiveLogThemedActivity() {

    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = "Progress",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        DSCircularProgressIndicator()
    }

    companion object {
        fun createInstance(context: Context) = Intent(context, DSProgressPreviewActivity::class.java)
    }
}