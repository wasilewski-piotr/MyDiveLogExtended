package org.itsolutions.mydivelog.design.app.states.success

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
import org.itsolutions.mydivelog.design.components.states.success.DSSuccessStateFullScreen
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity

internal class DSSuccessStateFullScreenPreviewActivity : MyDiveLogThemedActivity() {

    var successStateType by mutableStateOf<DSStateTypes?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        successStateType = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
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
        when (successStateType) {
            DSStateTypes.BUTTONS_HORIZONTAL -> {
                topBarSettings.title("Success | Buttons Horizontal")
                DSSuccessStateFullScreen(
                    title = "Success",
                    subtitle = "You did it!",
                    primaryButtonText = "Continue",
                    primaryButtonAction = { },
                    secondaryButtonText = "Close",
                    secondaryButtonAction = { },
                    orientation = DSButtonsOrientation.HORIZONTAL
                )
            }
            DSStateTypes.BUTTONS_VERTICAL -> {
                topBarSettings.title("Success | Buttons Vertical")
                DSSuccessStateFullScreen(
                    title = "Success",
                    subtitle = "You did it!",
                    primaryButtonText = "Continue",
                    primaryButtonAction = { },
                    secondaryButtonText = "Close",
                    secondaryButtonAction = { },
                    orientation = DSButtonsOrientation.VERTICAL
                )
            }
            else -> {
                topBarSettings.title("Success | Single Button")
                DSSuccessStateFullScreen(
                    title = "Success",
                    subtitle = "You did it!",
                    primaryButtonText = "Continue",
                    primaryButtonAction = { }
                )
            }
        }
    }

    companion object {
        private const val EXTRA_TYPE = "success_state_type"
        fun createInstance(context: Context, type: DSStateTypes) = Intent(context, DSSuccessStateFullScreenPreviewActivity::class.java).apply {
            putExtra(EXTRA_TYPE, type)
        }
    }
}