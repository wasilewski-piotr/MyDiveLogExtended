package org.itsolutions.mydivelog.design.app

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.components.navigation.DSBottomNavigationBar
import org.itsolutions.mydivelog.design.components.navigation.DSBottomNavigationElement
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.section.DSSection
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity
import org.itsolutions.mydivelog.extensions.verticalPadding

class DSNavigationPreviewActivity : MyDiveLogThemedActivity() {

    @Composable
    override fun TopBar() {
        DSTopNavigation(
            title = "Top Navigation",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController) {
        var currentRoute by rememberSaveable { mutableStateOf("Two") }

        Column(
            modifier = Modifier.verticalPadding(),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.xl)
        ) {
            DSSection("DSTopNavigation") { DSTopNavigation("DSTopNavigationType.BACK", DSTopNavigationType.BACK) { } }
            DSSection("DSTopNavigation") { DSTopNavigation("DSTopNavigationType.EXIT", DSTopNavigationType.EXIT) { } }
            DSSection("DSBottomNavigation") {
                DSBottomNavigationBar(
                    currentRoute = currentRoute,
                    entries = listOf(
                        DSBottomNavigationElement(
                            route = "One",
                            label = R.string.bottom_navigation_home,
                            icon = R.drawable.scuba_diving
                        ),
                        DSBottomNavigationElement(
                            route = "Two",
                            label = R.string.bottom_navigation_home,
                            icon = R.drawable.emoji_people
                        ),
                        DSBottomNavigationElement(
                            route = "Three",
                            label = R.string.bottom_navigation_home,
                            icon = R.drawable.scuba_diving
                        ),
                        DSBottomNavigationElement(
                            route = "Four",
                            label = R.string.bottom_navigation_home,
                            icon = R.drawable.emoji_people
                        ),
                        DSBottomNavigationElement(
                            route = "Five",
                            label = R.string.bottom_navigation_home,
                            icon = R.drawable.scuba_diving
                        ),
                    ),
                    onClick = { currentRoute = it.route }
                )
            }
        }
    }

    companion object {
        fun createInstance(context: Context) = Intent(context, DSNavigationPreviewActivity::class.java)
    }
}