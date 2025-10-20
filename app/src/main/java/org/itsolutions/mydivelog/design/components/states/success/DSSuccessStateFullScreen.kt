package org.itsolutions.mydivelog.design.components.states.success

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.components.buttons.DSButtonsOrientation
import org.itsolutions.mydivelog.design.components.buttons.DSCombinedButtons
import org.itsolutions.mydivelog.design.components.buttons.DSPrimaryButtonMaxWidth
import org.itsolutions.mydivelog.design.components.states.DSStateFullScreen
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme

@Composable
fun DSSuccessStateFullScreen(
    @StringRes title: Int,
    @StringRes subtitle: Int,
    @StringRes primaryButtonText: Int,
    primaryButtonAction: () -> Unit,
    @StringRes secondaryButtonText: Int? = null,
    secondaryButtonAction: (() -> Unit)? = null,
    @DrawableRes primaryLeadingIcon: Int? = null,
    @DrawableRes primaryTrailingIcon: Int? = null,
    @DrawableRes secondaryLeadingIcon: Int? = null,
    @DrawableRes secondaryTrailingIcon: Int? = null,
    orientation: DSButtonsOrientation = DSButtonsOrientation.HORIZONTAL
) {
    DSSuccessStateFullScreen(
        title = stringResource(title),
        subtitle = stringResource(subtitle),
        primaryButtonText = stringResource(primaryButtonText),
        primaryButtonAction = primaryButtonAction,
        secondaryButtonText = secondaryButtonText?.let { stringResource(it) },
        secondaryButtonAction = secondaryButtonAction,
        primaryLeadingIcon = primaryLeadingIcon,
        primaryTrailingIcon = primaryTrailingIcon,
        secondaryLeadingIcon = secondaryLeadingIcon,
        secondaryTrailingIcon = secondaryTrailingIcon,
        orientation = orientation,
    )
}

@Composable
fun DSSuccessStateFullScreen(
    title: String,
    subtitle: String,
    primaryButtonText: String,
    primaryButtonAction: () -> Unit,
    secondaryButtonText: String? = null,
    secondaryButtonAction: (() -> Unit)? = null,
    @DrawableRes primaryLeadingIcon: Int? = null,
    @DrawableRes primaryTrailingIcon: Int? = null,
    @DrawableRes secondaryLeadingIcon: Int? = null,
    @DrawableRes secondaryTrailingIcon: Int? = null,
    orientation: DSButtonsOrientation = DSButtonsOrientation.HORIZONTAL
) {
    DSStateFullScreen(
        title = title,
        subtitle = subtitle,
        icon = R.drawable.success_icon
    ) {
        secondaryButtonAction?.let {
            DSCombinedButtons(
                primaryText = primaryButtonText,
                onPrimaryClick = primaryButtonAction,
                secondaryText = secondaryButtonText.orEmpty(),
                onSecondaryClick = secondaryButtonAction,
                orientation = orientation,
                primaryLeadingIcon = primaryLeadingIcon,
                primaryTrailingIcon = primaryTrailingIcon,
                secondaryLeadingIcon = secondaryLeadingIcon,
                secondaryTrailingIcon = secondaryTrailingIcon,
            )
        } ?: DSPrimaryButtonMaxWidth(
            text = primaryButtonText,
            onClick = primaryButtonAction,
            leadingIcon = primaryLeadingIcon,
            trailingIcon = primaryTrailingIcon
        )
    }
}

@Preview
@Composable
private fun DSSuccessStatePreviewSingleButton() {
    MyDiveLogTheme {
        DSSuccessStateFullScreen(
            title = "Success",
            subtitle = "You did it!",
            primaryButtonText = "Continue",
            primaryButtonAction = { }
        )
    }
}

@Preview
@Composable
private fun DSSuccessStatePreviewCombinedButtonsHorizontal() {
    MyDiveLogTheme {
        DSSuccessStateFullScreen(
            title = "Success",
            subtitle = "You did it!",
            primaryButtonText = "Continue",
            primaryButtonAction = { },
            secondaryButtonText = "Close",
            secondaryButtonAction = { }
        )
    }
}

@Preview
@Composable
private fun DSSuccessStatePreviewCombinedButtonsVertical() {
    MyDiveLogTheme {
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
}