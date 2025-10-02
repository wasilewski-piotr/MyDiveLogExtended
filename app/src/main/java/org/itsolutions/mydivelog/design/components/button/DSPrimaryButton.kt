package org.itsolutions.mydivelog.design.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R

@Composable
fun DSPrimaryButtonMaxWidth(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
    onClick: () -> Unit,
) {
    DSPrimaryButton(
        text = text,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        onClick = onClick,
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon
    )
}

@Composable
fun DSPrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
    onClick: () -> Unit,
) {
    DSButton(
        text = text,
        variant = DSButtonType.PRIMARY,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}

@Preview
@Composable
private fun DSPrimaryButtonMaxWidthPreview() {
    DSPrimaryButtonMaxWidth(
        text = "Primary Button Max Width",
        onClick = { }
    )
}

@Preview
@Composable
private fun DSPrimaryButtonMaxWidthWithLeadingIconPreview() {
    DSPrimaryButtonMaxWidth(
        text = "Primary Button Max Width",
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview
@Composable
private fun DSPrimaryButtonMaxWidthWithTrailingIconPreview() {
    DSPrimaryButtonMaxWidth(
        text = "Primary Button Max Width",
        trailingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview
@Composable
private fun DSPrimaryButtonMaxWidthWithIconsPreview() {
    DSPrimaryButtonMaxWidth(
        text = "Primary Button Max Width",
        trailingIcon = R.drawable.bar_chart,
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview
@Composable
private fun DSPrimaryButtonPreview() {
    DSPrimaryButton(
        text = "Primary Button",
        onClick = { }
    )
}

@Preview
@Composable
private fun DSPrimaryButtonWithLeadingIconPreview() {
    DSPrimaryButton(
        text = "Primary Button",
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview
@Composable
private fun DSPrimaryButtonWithTrailingIconPreview() {
    DSPrimaryButton(
        text = "Primary Button",
        trailingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview
@Composable
private fun DSPrimaryButtonWithIconsPreview() {
    DSPrimaryButton(
        text = "Primary Button",
        trailingIcon = R.drawable.bar_chart,
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}