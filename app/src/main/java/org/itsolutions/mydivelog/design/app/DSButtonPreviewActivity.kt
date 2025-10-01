package org.itsolutions.mydivelog.design.app

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.itsolutions.mydivelog.design.components.button.DSButtonsOrientation
import org.itsolutions.mydivelog.design.components.button.DSCombinedButtons
import org.itsolutions.mydivelog.design.components.button.DSPrimaryButton
import org.itsolutions.mydivelog.design.components.button.DSPrimaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.button.DSSecondaryButton
import org.itsolutions.mydivelog.design.components.button.DSSecondaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.section.DSSection
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity

class DSButtonPreviewActivity : MyDiveLogThemedActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun TopBar() {
        DSTopNavigation(
            title = "Buttons",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    private fun CombinedButtonsExample(orientation: DSButtonsOrientation) =
        DSCombinedButtons(
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            orientation = orientation
        )

    @Composable
    override fun Content() {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.verticalScroll(scrollState),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            DSSection("DSPrimaryButton") { DSPrimaryButton("Primary Button") { } }
            DSSection("DSPrimaryButtonMaxWidth") { DSPrimaryButtonMaxWidth("Primary Button Max Width") { } }
            DSSection("DSSecondaryButton") { DSSecondaryButton("Secondary Button") { } }
            DSSection("DSSecondaryButtonMaxWidth") { DSSecondaryButtonMaxWidth("Secondary Button Max Width") { } }
            DSSection("DSCombinedButtonsHorizontally") { CombinedButtonsExample(DSButtonsOrientation.HORIZONTAL) }
            DSSection("DSCombinedButtonsVertically") { CombinedButtonsExample(DSButtonsOrientation.VERTICAL) }
        }
    }

    companion object {
        fun createInstance(context: Context) = Intent(context, DSButtonPreviewActivity::class.java)
    }
}