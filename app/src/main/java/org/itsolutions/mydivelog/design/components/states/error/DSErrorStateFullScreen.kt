package org.itsolutions.mydivelog.design.components.states.error

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
fun DSErrorStateFullScreen(
    @StringRes subtitle: Int,
    @StringRes primaryButtonText: Int,
    primaryButtonAction: () -> Unit,
    @StringRes title: Int? = null,
    @StringRes secondaryButtonText: Int? = null,
    secondaryButtonAction: (() -> Unit)? = null,
    @DrawableRes primaryLeadingIcon: Int? = null,
    @DrawableRes primaryTrailingIcon: Int? = null,
    @DrawableRes secondaryLeadingIcon: Int? = null,
    @DrawableRes secondaryTrailingIcon: Int? = null,
    orientation: DSButtonsOrientation = DSButtonsOrientation.HORIZONTAL
) {
    DSErrorStateFullScreen(
        title = title?.let { stringResource(it) },
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
fun DSErrorStateFullScreen(
    subtitle: String,
    primaryButtonText: String,
    primaryButtonAction: () -> Unit,
    title: String? = null,
    secondaryButtonText: String? = null,
    secondaryButtonAction: (() -> Unit)? = null,
    @DrawableRes primaryLeadingIcon: Int? = null,
    @DrawableRes primaryTrailingIcon: Int? = null,
    @DrawableRes secondaryLeadingIcon: Int? = null,
    @DrawableRes secondaryTrailingIcon: Int? = null,
    orientation: DSButtonsOrientation = DSButtonsOrientation.HORIZONTAL
) {
    DSStateFullScreen(
        title = title ?: stringResource(R.string.error_title),
        subtitle = subtitle,
        icon = R.drawable.error_icon
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
private fun DSErrorStatePreviewSingleButton() {
    MyDiveLogTheme {
        DSErrorStateFullScreen(
            title = "Error",
            subtitle = "Something went wrong!",
            primaryButtonText = "Close",
            primaryButtonAction = { }
        )
    }
}

@Preview
@Composable
private fun DSErrorStatePreviewCombinedButtonsHorizontal() {
    MyDiveLogTheme {
        DSErrorStateFullScreen(
            title = "Error",
            subtitle = "Something went wrong!",
            primaryButtonText = "Close",
            primaryButtonAction = { },
            secondaryButtonText = "Retry",
            secondaryButtonAction = { }
        )
    }
}

@Preview
@Composable
private fun DSErrorStatePreviewCombinedButtonsVertical() {
    MyDiveLogTheme {
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
}