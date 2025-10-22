package org.itsolutions.mydivelog.design.components.buttons

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.theme.DesignSystem

@Composable
fun DSPrimaryButtonMaxWidth(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
    verticalPadding: Dp = DesignSystem.spacing.md,
    onClick: () -> Unit,
) {
    DSPrimaryButtonMaxWidth(
        text = stringResource(text),
        modifier = modifier,
        enabled = enabled,
        onClick = onClick,
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon,
        verticalPadding = verticalPadding
    )
}

@Composable
fun DSPrimaryButtonMaxWidth(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
    verticalPadding: Dp = DesignSystem.spacing.md,
    onClick: () -> Unit,
) {
    DSPrimaryButton(
        text = text,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        onClick = onClick,
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon,
        verticalPadding = verticalPadding
    )
}

@Composable
fun DSPrimaryButton(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
    verticalPadding: Dp = DesignSystem.spacing.md,
    onClick: () -> Unit,
) {
    DSPrimaryButton(
        text = stringResource(text),
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        verticalPadding = verticalPadding
    )
}

@Composable
fun DSPrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
    verticalPadding: Dp = DesignSystem.spacing.md,
    onClick: () -> Unit,
) {
    DSButton(
        text = text,
        variant = DSButtonType.PRIMARY,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        verticalPadding = verticalPadding
    )
}

@Preview(showBackground = true)
@Composable
private fun DSPrimaryButtonMaxWidthPreview() {
    DSPrimaryButtonMaxWidth(
        text = "Primary Button Max Width",
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSPrimaryButtonMaxWidthWithLeadingIconPreview() {
    DSPrimaryButtonMaxWidth(
        text = "Primary Button Max Width",
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSPrimaryButtonMaxWidthWithTrailingIconPreview() {
    DSPrimaryButtonMaxWidth(
        text = "Primary Button Max Width",
        trailingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSPrimaryButtonMaxWidthWithIconsPreview() {
    DSPrimaryButtonMaxWidth(
        text = "Primary Button Max Width",
        trailingIcon = R.drawable.bar_chart,
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSPrimaryButtonPreview() {
    DSPrimaryButton(
        text = "Primary Button",
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSPrimaryButtonWithLeadingIconPreview() {
    DSPrimaryButton(
        text = "Primary Button",
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSPrimaryButtonWithTrailingIconPreview() {
    DSPrimaryButton(
        text = "Primary Button",
        trailingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSPrimaryButtonWithIconsPreview() {
    DSPrimaryButton(
        text = "Primary Button",
        trailingIcon = R.drawable.bar_chart,
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}