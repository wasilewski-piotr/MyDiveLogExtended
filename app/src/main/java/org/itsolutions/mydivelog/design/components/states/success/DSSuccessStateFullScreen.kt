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

@Preview(showBackground = true)
@Composable
private fun DSSuccessStatePreviewSingleButton() {
    DSSuccessStateFullScreen(
        title = "Success",
        subtitle = "You did it!",
        primaryButtonText = "Continue",
        primaryButtonAction = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSSuccessStatePreviewCombinedButtonsHorizontal() {
    DSSuccessStateFullScreen(
        title = "Success",
        subtitle = "You did it!",
        primaryButtonText = "Continue",
        primaryButtonAction = { },
        secondaryButtonText = "Close",
        secondaryButtonAction = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSSuccessStatePreviewCombinedButtonsVertical() {
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