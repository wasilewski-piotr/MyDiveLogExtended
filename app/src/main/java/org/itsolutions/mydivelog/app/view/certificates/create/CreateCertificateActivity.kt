package org.itsolutions.mydivelog.app.view.certificates.create

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import dagger.hilt.android.AndroidEntryPoint
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity

@AndroidEntryPoint
class CreateCertificateActivity : MyDiveLogThemedActivity() {

    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = title,
            type = type,
            onClick = action
        )
    }

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        topBarSettings.CreateCertificateNavHost(
            navController = navController,
            onBack = { navController.popBackStack() },
            onFinish = {
                setResult(RESULT_OK)
                finish()
            }
        )
    }

    companion object {
        fun createInstance(context: Context) = Intent(context, CreateCertificateActivity::class.java)
    }
}