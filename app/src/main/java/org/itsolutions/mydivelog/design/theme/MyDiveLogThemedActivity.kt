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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType

abstract class MyDiveLogThemedActivity : ComponentActivity() {

    @Composable protected open fun TopBar(
        type: DSTopNavigationType,
        title: String,
        action: () -> Unit
    ) { }
    @Composable protected open fun BottomBar(navController: NavHostController) { }
    @Composable protected open fun Content(
        navController: NavHostController,
        topBarSettings: TopBarSettings
    ) { }

    data class TopBarSettings(
        val action: (() -> Unit) -> Unit,
        val title: (String?) -> Unit,
        val visibility: (Boolean) -> Unit = { true },
        val type: (DSTopNavigationType) -> Unit = { DSTopNavigationType.BACK },
    )

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
            val topBarVisibility = rememberSaveable { mutableStateOf(true) }
            val topBarType = rememberSaveable { mutableStateOf(DSTopNavigationType.BACK) }
            val topBarTitle = rememberSaveable { mutableStateOf<String?>(null) }
            val topBarAction = remember { mutableStateOf({}) }

            val topBarSettings = TopBarSettings(
                title = { topBarTitle.value = it },
                visibility = { topBarVisibility.value = it },
                type = { topBarType.value = it },
                action = { topBarAction.value = it }
            )

            MyDiveLogTheme {
                Scaffold(
                    contentWindowInsets = WindowInsets.safeDrawing,
                    topBar = {
                        if (topBarVisibility.value) {
                            TopBar(
                                type = topBarType.value,
                                title = topBarTitle.value ?: "",
                                action = topBarAction.value
                            )
                        }
                    },
                    bottomBar = { BottomBar(navController) }
                ) { padding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(padding)
                            .padding(horizontal = DesignSystem.spacing.lg)
                    ) {
                        Content(
                            navController = navController,
                            topBarSettings = topBarSettings
                        )
                    }
                }
            }
        }
    }
}