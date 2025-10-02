package org.itsolutions.mydivelog.design.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.theme.DesignSystem

enum class DSButtonsOrientation {
    VERTICAL, HORIZONTAL
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
        DSButtonsOrientation.VERTICAL -> DSCombinedButtonsVertically(
            primaryText = primaryText,
            onPrimaryClick = onPrimaryClick,
            secondaryText = secondaryText,
            onSecondaryClick = onSecondaryClick,
            primaryTrailingIcon = primaryTrailingIcon,
            primaryLeadingIcon = primaryLeadingIcon,
            secondaryLeadingIcon = secondaryLeadingIcon,
            secondaryTrailingIcon = secondaryTrailingIcon,
        )
        DSButtonsOrientation.HORIZONTAL -> DSCombinedButtonsHorizontally(
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
    @DrawableRes primaryLeadingIcon: Int? = null,
    @DrawableRes primaryTrailingIcon: Int? = null,
    @DrawableRes secondaryLeadingIcon: Int? = null,
    @DrawableRes secondaryTrailingIcon: Int? = null,
) {
    Column {
        DSPrimaryButtonMaxWidth(
            text = primaryText,
            onClick = onPrimaryClick,
            leadingIcon = primaryLeadingIcon,
            trailingIcon = primaryTrailingIcon
        )
        DSSecondaryButtonMaxWidth(
            text = secondaryText,
            onClick = onSecondaryClick,
            leadingIcon = secondaryLeadingIcon,
            trailingIcon = secondaryTrailingIcon
        )
    }
}

@Composable
fun DSCombinedButtonsHorizontally(
    primaryText: String,
    onPrimaryClick: () -> Unit,
    secondaryText: String,
    onSecondaryClick: () -> Unit,
    @DrawableRes primaryLeadingIcon: Int? = null,
    @DrawableRes primaryTrailingIcon: Int? = null,
    @DrawableRes secondaryLeadingIcon: Int? = null,
    @DrawableRes secondaryTrailingIcon: Int? = null,
) {
    Row(horizontalArrangement = Arrangement.spacedBy(DesignSystem.spacing.sm)) {
        DSSecondaryButtonMaxWidth(
            text = secondaryText,
            onClick = onSecondaryClick,
            modifier = Modifier.weight(1f),
            leadingIcon = secondaryLeadingIcon,
            trailingIcon = secondaryTrailingIcon
        )
        DSPrimaryButtonMaxWidth(
            text = primaryText,
            onClick = onPrimaryClick,
            modifier = Modifier.weight(1f),
            leadingIcon = primaryLeadingIcon,
            trailingIcon = primaryTrailingIcon
        )
    }
}

@Preview
@Composable
private fun DSButtonsCombinedVerticallyPreview() {
    DSCombinedButtonsVertically(
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
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryLeadingIcon = R.drawable.bar_chart,
            secondaryLeadingIcon = R.drawable.bar_chart
        )
        VerticalSpacer(DesignSystem.spacing.sm)
        DSCombinedButtonsVertically(
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryTrailingIcon = R.drawable.bar_chart,
            secondaryTrailingIcon = R.drawable.bar_chart
        )
        VerticalSpacer(DesignSystem.spacing.sm)
        DSCombinedButtonsVertically(
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
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryLeadingIcon = R.drawable.bar_chart,
            secondaryLeadingIcon = R.drawable.bar_chart,
        )
        VerticalSpacer(DesignSystem.spacing.sm)
        DSCombinedButtonsHorizontally(
            primaryText = "Primary Button",
            onPrimaryClick = { },
            secondaryText = "Secondary Button",
            onSecondaryClick = { },
            primaryTrailingIcon = R.drawable.bar_chart,
            secondaryTrailingIcon = R.drawable.bar_chart,
        )
        VerticalSpacer(DesignSystem.spacing.sm)
        DSCombinedButtonsHorizontally(
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