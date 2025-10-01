package org.itsolutions.mydivelog.design.theme

import android.graphics.Color.TRANSPARENT
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.itsolutions.mydivelog.design.theme.spacings.DS

abstract class MyDiveLogThemedActivity : ComponentActivity() {

    @Composable protected open fun TopBar() {}
    @Composable protected open fun BottomBar(navController: NavHostController) {}
    @Composable protected abstract fun Content(navController: NavHostController)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                lightScrim = TRANSPARENT,
                darkScrim = TRANSPARENT
            ),
            navigationBarStyle = SystemBarStyle.auto(
                lightScrim = TRANSPARENT,
                darkScrim = TRANSPARENT
            )
        )

        window.isNavigationBarContrastEnforced = false

        setContent {
            val navController = rememberNavController()
            MyDiveLogTheme {
                Scaffold(
                    contentWindowInsets = WindowInsets.safeDrawing,
                    topBar = { TopBar() },
                    bottomBar = { BottomBar(navController) }
                ) { padding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                            .padding(DS.spacing.lg)
                    ) {
                        Content(navController)
                    }
                }
            }
        }
    }
}