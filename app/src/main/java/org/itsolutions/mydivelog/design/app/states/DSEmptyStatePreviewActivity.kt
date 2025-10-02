package org.itsolutions.mydivelog.design.app.states

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.states.DSEmptyState
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity

internal class DSEmptyStatePreviewActivity : MyDiveLogThemedActivity() {

    @Composable
    override fun TopBar() {
        DSTopNavigation(
            title = "Empty State",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController) {
        DSEmptyState(R.string.empty_state_no_organizations_found)
    }

    companion object {
        fun createInstance(context: Context) = Intent(context, DSEmptyStatePreviewActivity::class.java)
    }
}