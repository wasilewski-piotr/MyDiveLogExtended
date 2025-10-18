package org.itsolutions.mydivelog.design.components.buttons

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.components.buttons.DSButtonsOrientation.HORIZONTAL
import org.itsolutions.mydivelog.design.components.buttons.DSButtonsOrientation.HORIZONTAL_INVERTED
import org.itsolutions.mydivelog.design.components.buttons.DSButtonsOrientation.VERTICAL
import org.itsolutions.mydivelog.design.components.buttons.DSButtonsOrientation.VERTICAL_INVERTED
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.theme.DesignSystem

enum class DSButtonsOrientation {
    VERTICAL, HORIZONTAL, VERTICAL_INVERTED, HORIZONTAL_INVERTED
}

@Composable
fun DSCombinedButtons(
    @StringRes primaryText: Int,
    onPrimaryClick: () -> Unit,
    @StringRes secondaryText: Int,
    onSecondaryClick: () -> Unit,
    orientation: DSButtonsOrientation,
    @DrawableRes primaryLeadingIcon: Int? = null,
    @DrawableRes primaryTrailingIcon: Int? = null,
    @DrawableRes secondaryLeadingIcon: Int? = null,
    @DrawableRes secondaryTrailingIcon: Int? = null,
) {
    DSCombinedButtons(
        primaryText = stringResource(primaryText),
        secondaryText = stringResource(secondaryText),
        onPrimaryClick = onPrimaryClick,
        onSecondaryClick = onSecondaryClick,
        orientation = orientation,
        primaryLeadingIcon = primaryLeadingIcon,
        primaryTrailingIcon = primaryTrailingIcon,
        secondaryLeadingIcon = secondaryLeadingIcon,
        secondaryTrailingIcon = secondaryTrailingIcon
    )
}

@Composable
fun DSCombinedButtons(
    primaryText: String,
    onPrimaryClick: () -> Unit,
    secondaryText: String,
    onSecondaryClick: () -> Unit,
    orientation: DSButtonsOrientation,
    @DrawableRes primaryLeadingIcon: Int? = null,
    @DrawableRes primaryTrailingIcon: Int? = null,
    @DrawableRes secondaryLeadingIcon: Int? = null,
    @DrawableRes secondaryTrailingIcon: Int? = null,
) {
    when (orientation) {
        VERTICAL, VERTICAL_INVERTED -> DSCombinedButtonsVertically(
            orientation = orientation,
            primaryText = primaryText,
            onPrimaryClick = onPrimaryClick,
            secondaryText = secondaryText,
            onSecondaryClick = onSecondaryClick,
            primaryTrailingIcon = primaryTrailingIcon,
            primaryLeadingIcon = primaryLeadingIcon,
            secondaryLeadingIcon = secondaryLeadingIcon,
            secondaryTrailingIcon = secondaryTrailingIcon,
        )
        HORIZONTAL, HORIZONTAL_INVERTED -> DSCombinedButtonsHorizontally(
            orientation = orientation,
            primaryText = primaryText,
            onPrimaryClick = onPrimaryClick,
            secondaryText = secondaryText,
            onSecondaryClick = onSecondaryClick,
            primaryTrailingIcon = primaryTrailingIcon,
            primaryLeadingIcon = primaryLeadingIcon,
            secondaryLeadingIcon = secondaryLeadingIcon,
            secondaryTrailingIcon = secondaryTrailingIcon,
        )
    }
}

@Composable
fun DSCombinedButtonsVertically(
    primaryText: String,
    onPrimaryClick: () -> Unit,
    secondaryText: String,
    onSecondaryClick: () -> Unit,
    orientation: DSButtonsOrientation = VERTICAL,
    @DrawableRes primaryLeadingIcon: Int? = null,
    @DrawableRes primaryTrailingIcon: Int? = null,
    @DrawableRes secondaryLeadingIcon: Int? = null,
    @DrawableRes secondaryTrailingIcon: Int? = null,
) {
    Column {
        when (orientation) {
            VERTICAL_INVERTED -> {
                DSSecondaryButtonMaxWidth(
                    text = secondaryText,
                    onClick = onSecondaryClick,
                    leadingIcon = secondaryLeadingIcon,
                    trailingIcon = secondaryTrailingIcon,
                    verticalPadding = DesignSystem.spacing.sm
                )
                DSPrimaryButtonMaxWidth(
                    text = primaryText,
                    onClick = onPrimaryClick,
                    leadingIcon = primaryLeadingIcon,
                    trailingIcon = primaryTrailingIcon,
                    verticalPadding = DesignSystem.spacing.sm
                )
            }
            else -> {
                DSPrimaryButtonMaxWidth(
                    text = primaryText,
                    onClick = onPrimaryClick,
                    leadingIcon = primaryLeadingIcon,
                    trailingIcon = primaryTrailingIcon,
                    verticalPadding = DesignSystem.spacing.sm
                )
                DSSecondaryButtonMaxWidth(
                    text = secondaryText,
                    onClick = onSecondaryClick,
                    leadingIcon = secondaryLeadingIcon,
                    trailingIcon = secondaryTrailingIcon,
                    verticalPadding = DesignSystem.spacing.sm
                )
            }
        }
    }
}

@Composable
fun DSCombinedButtonsHorizontally(
    primaryText: String,
    onPrimaryClick: () -> Unit,
    secondaryText: String,
    onSecondaryClick: () -> Unit,
    orientation: DSButtonsOrientation = HORIZONTAL,
    @DrawableRes primaryLeadingIcon: Int? = null,
    @DrawableRes primaryTrailingIcon: Int? = null,
    @DrawableRes secondaryLeadingIcon: Int? = null,
    @DrawableRes secondaryTrailingIcon: Int? = null,
) {
    Row(
        modifier = Modifier.height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(DesignSystem.spacing.sm),
    ) {
        when (orientation) {
            HORIZONTAL_INVERTED -> {
                DSPrimaryButtonMaxWidth(
                    text = primaryText,
                    onClick = onPrimaryClick,
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    leadingIcon = primaryLeadingIcon,
                    trailingIcon = primaryTrailingIcon,
                    verticalPadding = DesignSystem.spacing.sm
                )
                DSSecondaryButtonMaxWidth(
                    text = secondaryText,
                    onClick = onSecondaryClick,
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    leadingIcon = secondaryLeadingIcon,
                    trailingIcon = secondaryTrailingIcon,
                    verticalPadding = DesignSystem.spacing.sm
                )
            }
            else -> {
                DSSecondaryButtonMaxWidth(
                    text = secondaryText,
                    onClick = onSecondaryClick,
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    leadingIcon = secondaryLeadingIcon,
                    trailingIcon = secondaryTrailingIcon,
                    verticalPadding = DesignSystem.spacing.sm
                )
                DSPrimaryButtonMaxWidth(
                    text = primaryText,
                    onClick = onPrimaryClick,
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    leadingIcon = primaryLeadingIcon,
                    trailingIcon = primaryTrailingIcon,
                    verticalPadding = DesignSystem.spacing.sm
                )
            }
        }
    }
}

@Preview
@Composable
private fun DSButtonsCombinedVerticallyPreview() {
    DSCombinedButtonsVertically(
        orientation = VERTICAL,
        primaryText = "Primary Button",
        onPrimaryClick = { },
        secondaryText = "Secondary Button",
        onSecondaryClick = { }
    )
}

@Preview
@Composable
private fun DSButtonsCombinedVerticallyInvertedPreview() {
    DSCombinedButtonsVertically(
        orientation = VERTICAL_INVERTED,
        primaryText = "Primary Button",
        onPrimaryClick = { },
        secondaryText = "Secondary Button",
        onSecondaryClick = { }
    )
}

@Preview
@Composable
private fun DSButtonsCombinedVerticallyWithIconsPreview() {
    Column {
        DSCombinedButtonsVertically(
            orientation = VERTICAL,
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryLeadingIcon = R.drawable.bar_chart,
            secondaryLeadingIcon = R.drawable.bar_chart
        )
        VerticalSpacer(DesignSystem.spacing.sm)
        DSCombinedButtonsVertically(
            orientation = VERTICAL,
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryTrailingIcon = R.drawable.bar_chart,
            secondaryTrailingIcon = R.drawable.bar_chart
        )
        VerticalSpacer(DesignSystem.spacing.sm)
        DSCombinedButtonsVertically(
            orientation = VERTICAL,
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryLeadingIcon = R.drawable.bar_chart,
            secondaryLeadingIcon = R.drawable.bar_chart,
            primaryTrailingIcon = R.drawable.bar_chart,
            secondaryTrailingIcon = R.drawable.bar_chart,
        )
    }
}

@Preview
@Composable
private fun DSButtonsCombinedVerticallyInvertedWithIconsPreview() {
    Column {
        DSCombinedButtonsVertically(
            orientation = VERTICAL_INVERTED,
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryLeadingIcon = R.drawable.bar_chart,
            secondaryLeadingIcon = R.drawable.bar_chart
        )
        VerticalSpacer(DesignSystem.spacing.sm)
        DSCombinedButtonsVertically(
            orientation = VERTICAL_INVERTED,
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryTrailingIcon = R.drawable.bar_chart,
            secondaryTrailingIcon = R.drawable.bar_chart
        )
        VerticalSpacer(DesignSystem.spacing.sm)
        DSCombinedButtonsVertically(
            orientation = VERTICAL_INVERTED,
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryLeadingIcon = R.drawable.bar_chart,
            secondaryLeadingIcon = R.drawable.bar_chart,
            primaryTrailingIcon = R.drawable.bar_chart,
            secondaryTrailingIcon = R.drawable.bar_chart,
        )
    }
}

@Preview
@Composable
private fun DSButtonsCombinedHorizontallyPreview() {
    DSCombinedButtonsHorizontally(
        orientation = HORIZONTAL,
        primaryText = "Primary Button",
        onPrimaryClick = { },
        secondaryText = "Secondary Button",
        onSecondaryClick = { }
    )
}

@Preview
@Composable
private fun DSButtonsCombinedHorizontallyInvertedPreview() {
    DSCombinedButtonsHorizontally(
        orientation = HORIZONTAL_INVERTED,
        primaryText = "Primary Button",
        onPrimaryClick = { },
        secondaryText = "Secondary Button",
        onSecondaryClick = { }
    )
}

@Preview
@Composable
private fun DSButtonsCombinedHorizontallyWithIconsPreview() {
    Column {
        DSCombinedButtonsHorizontally(
            orientation = HORIZONTAL,
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryLeadingIcon = R.drawable.bar_chart,
            secondaryLeadingIcon = R.drawable.bar_chart,
        )
        VerticalSpacer(DesignSystem.spacing.sm)
        DSCombinedButtonsHorizontally(
            orientation = HORIZONTAL,
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryTrailingIcon = R.drawable.bar_chart,
            secondaryTrailingIcon = R.drawable.bar_chart,
        )
        VerticalSpacer(DesignSystem.spacing.sm)
        DSCombinedButtonsHorizontally(
            orientation = HORIZONTAL,
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryLeadingIcon = R.drawable.bar_chart,
            secondaryLeadingIcon = R.drawable.bar_chart,
            primaryTrailingIcon = R.drawable.bar_chart,
            secondaryTrailingIcon = R.drawable.bar_chart,
        )
    }
}

@Preview
@Composable
private fun DSButtonsCombinedHorizontallyInvertedWithIconsPreview() {
    Column {
        DSCombinedButtonsHorizontally(
            orientation = HORIZONTAL_INVERTED,
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryLeadingIcon = R.drawable.bar_chart,
            secondaryLeadingIcon = R.drawable.bar_chart,
        )
        VerticalSpacer(DesignSystem.spacing.sm)
        DSCombinedButtonsHorizontally(
            orientation = HORIZONTAL_INVERTED,
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryTrailingIcon = R.drawable.bar_chart,
            secondaryTrailingIcon = R.drawable.bar_chart,
        )
        VerticalSpacer(DesignSystem.spacing.sm)
        DSCombinedButtonsHorizontally(
            orientation = HORIZONTAL_INVERTED,
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryLeadingIcon = R.drawable.bar_chart,
            secondaryLeadingIcon = R.drawable.bar_chart,
            primaryTrailingIcon = R.drawable.bar_chart,
            secondaryTrailingIcon = R.drawable.bar_chart,
        )
    }
}