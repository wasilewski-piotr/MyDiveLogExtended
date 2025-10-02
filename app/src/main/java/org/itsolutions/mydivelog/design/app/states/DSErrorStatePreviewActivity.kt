package org.itsolutions.mydivelog.design.app.states

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.app.domain.model.results.DataError
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.states.DSErrorState
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity

internal class DSErrorStatePreviewActivity  : MyDiveLogThemedActivity() {

    @Composable
    override fun TopBar() {
        DSTopNavigation(
            title = "Error State",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController) {
        DSErrorState(
            error = DataError.Local.CERTIFICATE_ALREADY_EXISTS
        ) { }
    }

    companion object {
        fun createInstance(context: Context) = Intent(context, DSErrorStatePreviewActivity::class.java)
    }
}