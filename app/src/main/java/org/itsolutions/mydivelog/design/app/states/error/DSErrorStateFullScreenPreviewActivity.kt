package org.itsolutions.mydivelog.design.app.states.error

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.design.app.states.DSStatesPreviewActivity.DSStateTypes
import org.itsolutions.mydivelog.design.components.buttons.DSButtonsOrientation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.states.error.DSErrorStateFullScreen
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity

internal class DSErrorStateFullScreenPreviewActivity : MyDiveLogThemedActivity() {

    var errorStateType by mutableStateOf<DSStateTypes?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        errorStateType = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(EXTRA_TYPE, DSStateTypes::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra(EXTRA_TYPE) as DSStateTypes?
        }
    }

    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = title,
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        when (errorStateType) {
            DSStateTypes.BUTTONS_HORIZONTAL -> {
                topBarSettings.title("Error | Buttons Horizontal")
                DSErrorStateFullScreen(
                    title = "Error",
                    subtitle = "Something went wrong!",
                    primaryButtonText = "Close",
                    primaryButtonAction = { },
                    secondaryButtonText = "Retry",
                    secondaryButtonAction = { },
                    orientation = DSButtonsOrientation.HORIZONTAL
                )
            }
            DSStateTypes.BUTTONS_VERTICAL -> {
                topBarSettings.title("Error | Buttons Vertical")
                DSErrorStateFullScreen(
                    title = "Error",
                    subtitle = "Something went wrong!",
                    primaryButtonText = "Close",
                    primaryButtonAction = { },
                    secondaryButtonText = "Retry",
                    secondaryButtonAction = { },
                    orientation = DSButtonsOrientation.VERTICAL
                )
            }
            else -> {
                topBarSettings.title("Error | Single Button")
                DSErrorStateFullScreen(
                    title = "Error",
                    subtitle = "Something went wrong!",
                    primaryButtonText = "Close",
                    primaryButtonAction = { }
                )
            }
        }
    }

    companion object {
        private const val EXTRA_TYPE = "error_state_type"
        fun createInstance(context: Context, type: DSStateTypes) = Intent(context, DSErrorStateFullScreenPreviewActivity::class.java).apply {
            putExtra(EXTRA_TYPE, type)
        }
    }
}