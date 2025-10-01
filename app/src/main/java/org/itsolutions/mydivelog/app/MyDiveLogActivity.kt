package org.itsolutions.mydivelog.app

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import org.itsolutions.mydivelog.app.presentation.menu.buddies.BuddiesViewModel
import org.itsolutions.mydivelog.app.presentation.menu.certificates.CertificatesViewModel
import org.itsolutions.mydivelog.app.presentation.menu.dives.DivesViewModel
import org.itsolutions.mydivelog.app.presentation.menu.home.HomeViewModel
import org.itsolutions.mydivelog.app.presentation.menu.statistics.StatisticsViewModel
import org.itsolutions.mydivelog.app.view.menu.MyDiveLogMenu
import org.itsolutions.mydivelog.app.view.menu.buddies.BuddiesScreen
import org.itsolutions.mydivelog.app.view.menu.certificates.CertificatesScreen
import org.itsolutions.mydivelog.app.view.menu.dives.DivesScreen
import org.itsolutions.mydivelog.app.view.menu.home.HomeScreen
import org.itsolutions.mydivelog.app.view.menu.statistics.StatisticsScreen
import org.itsolutions.mydivelog.design.components.navigation.DSBottomNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSBottomNavigationNavHost
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity

@HiltAndroidApp
class MyDiveLogApplication : Application()

@AndroidEntryPoint
class MyDiveLogActivity : MyDiveLogThemedActivity() {

    val menuItems = MyDiveLogMenu.entries.map { it.item }

    @Composable
    override fun BottomBar(navController: NavHostController) {
        DSBottomNavigation(navController, menuItems)
    }

    @Composable
    override fun Content(navController: NavHostController) {
        DSBottomNavigationNavHost(
            navController = navController,
            startDestination = MyDiveLogMenu.HOME.item,
            entries = menuItems,
        ) { destination ->
            when (enumValueOf<MyDiveLogMenu>(destination.route)) {
                MyDiveLogMenu.HOME -> {
                    val viewModel: HomeViewModel = hiltViewModel()
                    HomeScreen(viewModel)
                }
                MyDiveLogMenu.CERTIFICATES -> {
                    val viewModel: CertificatesViewModel = hiltViewModel()
                    CertificatesScreen(viewModel)
                }
                MyDiveLogMenu.MY_DIVES -> {
                    val viewModel: DivesViewModel = hiltViewModel()
                    DivesScreen(viewModel)
                }
                MyDiveLogMenu.BUDDIES -> {
                    val viewModel: BuddiesViewModel = hiltViewModel()
                    BuddiesScreen(viewModel)
                }
                MyDiveLogMenu.STATISTICS -> {
                    val viewModel: StatisticsViewModel = hiltViewModel()
                    StatisticsScreen(viewModel)
                }
            }
        }
    }
}