package org.itsolutions.mydivelog.design.app

import android.content.Context
import android.content.Intent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.components.buttons.DSButtonsOrientation
import org.itsolutions.mydivelog.design.components.buttons.DSCombinedButtons
import org.itsolutions.mydivelog.design.components.buttons.DSPrimaryButton
import org.itsolutions.mydivelog.design.components.buttons.DSPrimaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.buttons.DSSecondaryButton
import org.itsolutions.mydivelog.design.components.buttons.DSSecondaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.buttons.DSSecondaryButtonSmall
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigation
import org.itsolutions.mydivelog.design.components.navigation.DSTopNavigationType
import org.itsolutions.mydivelog.design.components.section.DSSection
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity
import org.itsolutions.mydivelog.extensions.verticalPadding

internal class DSButtonPreviewActivity : MyDiveLogThemedActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun TopBar(type: DSTopNavigationType, title: String, action: () -> Unit) {
        DSTopNavigation(
            title = "Buttons",
            type = DSTopNavigationType.BACK,
            onClick = ::finish
        )
    }

    @Composable
    private fun CombinedButtonsExample(
        orientation: DSButtonsOrientation,
        @DrawableRes primaryLeadingIcon: Int? = null,
        @DrawableRes primaryTrailingIcon: Int? = null,
        @DrawableRes secondaryLeadingIcon: Int? = null,
        @DrawableRes secondaryTrailingIcon: Int? = null,
    ) =
        DSCombinedButtons(
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            orientation = orientation,
            primaryLeadingIcon = primaryLeadingIcon,
            primaryTrailingIcon = primaryTrailingIcon,
            secondaryLeadingIcon = secondaryLeadingIcon,
            secondaryTrailingIcon = secondaryTrailingIcon
        )

    @Composable
    override fun Content(navController: NavHostController, topBarSettings: TopBarSettings) {
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.verticalScroll(scrollState).verticalPadding(),
            verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.xl)
        ) {
            DSSection("DSPrimaryButton") { DSPrimaryButton("Primary Button") { } }
            DSSection("DSPrimaryButton | Leading icon") {
                DSPrimaryButton(
                    text = "Primary Button",
                    leadingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSPrimaryButton | Trailing icon") {
                DSPrimaryButton(
                    text = "Primary Button",
                    trailingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSPrimaryButton | Both icons") {
                DSPrimaryButton(
                    text = "Primary Button",
                    leadingIcon = R.drawable.bar_chart,
                    trailingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSPrimaryButtonMaxWidth") { DSPrimaryButtonMaxWidth("Primary Button Max Width") { } }
            DSSection("DSPrimaryButtonMaxWidth | Leading icon") {
                DSPrimaryButtonMaxWidth(
                    text = "Primary Button Max Width",
                    leadingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSPrimaryButtonMaxWidth | Trailing icon") {
                DSPrimaryButtonMaxWidth(
                    text = "Primary Button Max Width",
                    trailingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSPrimaryButtonMaxWidth | Both icons") {
                DSPrimaryButtonMaxWidth(
                    text = "Primary Button Max Width",
                    leadingIcon = R.drawable.bar_chart,
                    trailingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSSecondaryButtonSmall") { DSSecondaryButtonSmall("Secondary Button Small") { } }
            DSSection("DSSecondaryButtonSmall | Leading icon") {
                DSSecondaryButtonSmall(
                    text = "Secondary Button Small",
                    leadingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSSecondaryButtonSmall | Trailing icon") {
                DSSecondaryButtonSmall(
                    text = "Secondary Button Small",
                    trailingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSSecondaryButtonSmall | Both icons") {
                DSSecondaryButtonSmall(
                    text = "Secondary Button Small",
                    leadingIcon = R.drawable.bar_chart,
                    trailingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSSecondaryButton") { DSSecondaryButton("Secondary Button") { } }
            DSSection("DSSecondaryButton | Leading icon") {
                DSSecondaryButton(
                    text = "Secondary Button",
                    leadingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSSecondaryButton | Trailing icon") {
                DSSecondaryButton(
                    text = "Secondary Button",
                    trailingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSSecondaryButton | Both icons") {
                DSSecondaryButton(
                    text = "Secondary Button",
                    leadingIcon = R.drawable.bar_chart,
                    trailingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSSecondaryButtonMaxWidth") { DSSecondaryButtonMaxWidth("Secondary Button Max Width") { } }
            DSSection("DSSecondaryButtonMaxWidth | Leading icon") {
                DSSecondaryButtonMaxWidth(
                    text = "Secondary Button Max Width",
                    leadingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSSecondaryButtonMaxWidth | Trailing icon") {
                DSSecondaryButtonMaxWidth(
                    text = "Secondary Button Max Width",
                    trailingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSSecondaryButtonMaxWidth | Both icons") {
                DSSecondaryButtonMaxWidth(
                    text = "Secondary Button Max Width",
                    leadingIcon = R.drawable.bar_chart,
                    trailingIcon = R.drawable.bar_chart
                ) { }
            }
            DSSection("DSCombinedButtonsHorizontally") { CombinedButtonsExample(DSButtonsOrientation.HORIZONTAL) }
            DSSection("DSCombinedButtonsHorizontally | Long button text") {
                DSCombinedButtons(
                    primaryText = "Primary Button Very Long Name",
                    onPrimaryClick = { },
                    secondaryText = "Secondary Button Very Long Name",
                    onSecondaryClick = { },
                    orientation = DSButtonsOrientation.HORIZONTAL
                )
            }
            DSSection("DSCombinedButtonsHorizontally | Long button text") {
                DSCombinedButtons(
                    primaryText = "Button",
                    onPrimaryClick = { },
                    secondaryText = "Secondary Button Very Long Name",
                    onSecondaryClick = { },
                    orientation = DSButtonsOrientation.HORIZONTAL
                )
            }
            DSSection("DSCombinedButtonsHorizontally | Leading icon") {
                CombinedButtonsExample(
                    orientation = DSButtonsOrientation.HORIZONTAL,
                    primaryLeadingIcon = R.drawable.bar_chart,
                    secondaryLeadingIcon = R.drawable.bar_chart,
                )
            }
            DSSection("DSCombinedButtonsHorizontally | Trailing icon") {
                CombinedButtonsExample(
                    orientation = DSButtonsOrientation.HORIZONTAL,
                    primaryTrailingIcon = R.drawable.bar_chart,
                    secondaryTrailingIcon = R.drawable.bar_chart,
                )
            }
            DSSection("DSCombinedButtonsHorizontally | Both icons") {
                CombinedButtonsExample(
                    orientation = DSButtonsOrientation.HORIZONTAL,
                    primaryLeadingIcon = R.drawable.bar_chart,
                    secondaryLeadingIcon = R.drawable.bar_chart,
                    primaryTrailingIcon = R.drawable.bar_chart,
                    secondaryTrailingIcon = R.drawable.bar_chart,
                )
            }
            DSSection("DSCombinedButtonsHorizontallyInverted") { CombinedButtonsExample(DSButtonsOrientation.HORIZONTAL_INVERTED) }
            DSSection("DSCombinedButtonsHorizontallyInverted | Long button text") {
                DSCombinedButtons(
                    primaryText = "Primary Button Very Long Name",
                    onPrimaryClick = { },
                    secondaryText = "Secondary Button Very Long Name",
                    onSecondaryClick = { },
                    orientation = DSButtonsOrientation.HORIZONTAL_INVERTED
                )
            }
            DSSection("DSCombinedButtonsHorizontallyInverted | Long button text") {
                DSCombinedButtons(
                    primaryText = "Button",
                    onPrimaryClick = { },
                    secondaryText = "Secondary Button Very Long Name",
                    onSecondaryClick = { },
                    orientation = DSButtonsOrientation.HORIZONTAL_INVERTED
                )
            }
            DSSection("DSCombinedButtonsHorizontallyInverted | Leading icon") {
                CombinedButtonsExample(
                    orientation = DSButtonsOrientation.HORIZONTAL_INVERTED,
                    primaryLeadingIcon = R.drawable.bar_chart,
                    secondaryLeadingIcon = R.drawable.bar_chart,
                )
            }
            DSSection("DSCombinedButtonsHorizontallyInverted | Trailing icon") {
                CombinedButtonsExample(
                    orientation = DSButtonsOrientation.HORIZONTAL_INVERTED,
                    primaryTrailingIcon = R.drawable.bar_chart,
                    secondaryTrailingIcon = R.drawable.bar_chart,
                )
            }
            DSSection("DSCombinedButtonsHorizontallyInverted | Both icons") {
                CombinedButtonsExample(
                    orientation = DSButtonsOrientation.HORIZONTAL_INVERTED,
                    primaryLeadingIcon = R.drawable.bar_chart,
                    secondaryLeadingIcon = R.drawable.bar_chart,
                    primaryTrailingIcon = R.drawable.bar_chart,
                    secondaryTrailingIcon = R.drawable.bar_chart,
                )
            }
            DSSection("DSCombinedButtonsVertically") { CombinedButtonsExample(DSButtonsOrientation.VERTICAL) }
            DSSection("DSCombinedButtonsVertically | Leading icon") {
                CombinedButtonsExample(
                    orientation = DSButtonsOrientation.VERTICAL,
                    primaryLeadingIcon = R.drawable.bar_chart,
                    secondaryLeadingIcon = R.drawable.bar_chart,
                )
            }
            DSSection("DSCombinedButtonsVertically | Trailing icon") {
                CombinedButtonsExample(
                    orientation = DSButtonsOrientation.VERTICAL,
                    primaryTrailingIcon = R.drawable.bar_chart,
                    secondaryTrailingIcon = R.drawable.bar_chart,
                )
            }
            DSSection("DSCombinedButtonsVertically | Both icons") {
                CombinedButtonsExample(
                    orientation = DSButtonsOrientation.VERTICAL,
                    primaryLeadingIcon = R.drawable.bar_chart,
                    secondaryLeadingIcon = R.drawable.bar_chart,
                    primaryTrailingIcon = R.drawable.bar_chart,
                    secondaryTrailingIcon = R.drawable.bar_chart,
                )
            }
            DSSection("DSCombinedButtonsVerticallyInverted") { CombinedButtonsExample(DSButtonsOrientation.VERTICAL_INVERTED) }
            DSSection("DSCombinedButtonsVerticallyInverted | Leading icon") {
                CombinedButtonsExample(
                    orientation = DSButtonsOrientation.VERTICAL_INVERTED,
                    primaryLeadingIcon = R.drawable.bar_chart,
                    secondaryLeadingIcon = R.drawable.bar_chart,
                )
            }
            DSSection("DSCombinedButtonsVerticallyInverted | Trailing icon") {
                CombinedButtonsExample(
                    orientation = DSButtonsOrientation.VERTICAL_INVERTED,
                    primaryTrailingIcon = R.drawable.bar_chart,
                    secondaryTrailingIcon = R.drawable.bar_chart,
                )
            }
            DSSection("DSCombinedButtonsVerticallyInverted | Both icons") {
                CombinedButtonsExample(
                    orientation = DSButtonsOrientation.VERTICAL_INVERTED,
                    primaryLeadingIcon = R.drawable.bar_chart,
                    secondaryLeadingIcon = R.drawable.bar_chart,
                    primaryTrailingIcon = R.drawable.bar_chart,
                    secondaryTrailingIcon = R.drawable.bar_chart,
                )
            }
        }
    }

    companion object {
        fun createInstance(context: Context) = Intent(context, DSButtonPreviewActivity::class.java)
    }
}