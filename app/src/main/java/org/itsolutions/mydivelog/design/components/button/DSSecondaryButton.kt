package org.itsolutions.mydivelog.design.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R

@Composable
fun DSSecondaryButtonMaxWidth(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
    onClick: () -> Unit,
) {
    DSSecondaryButton(
        text = text,
        modifier = Modifier.fillMaxWidth().then(modifier),
        enabled = enabled,
        onClick = onClick,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}

@Composable
fun DSSecondaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
    onClick: () -> Unit,
) {
    DSButton(
        text = text,
        variant = DSButtonType.SECONDARY,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}

@Preview
@Composable
private fun DSSecondaryButtonMaxWidthPreview() {
    DSSecondaryButtonMaxWidth(
        text = "Secondary Button Max Width",
        onClick = { }
    )
}

@Preview
@Composable
private fun DSSecondaryButtonMaxWidthWithLeadingIconPreview() {
    DSSecondaryButtonMaxWidth(
        text = "Secondary Button Max Width",
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview
@Composable
private fun DSSecondaryButtonMaxWidthWithTrailingIconPreview() {
    DSSecondaryButtonMaxWidth(
        text = "Secondary Button Max Width",
        trailingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview
@Composable
private fun DSSecondaryButtonMaxWidthWithIconsPreview() {
    DSSecondaryButtonMaxWidth(
        text = "Secondary Button Max Width",
        trailingIcon = R.drawable.bar_chart,
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview
@Composable
private fun DSSecondaryButtonPreview() {
    DSSecondaryButton(
        text = "Secondary Button",
        onClick = { }
    )
}

@Preview
@Composable
private fun DSSecondaryButtonWithLeadingIconPreview() {
    DSSecondaryButton(
        text = "Secondary Button",
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview
@Composable
private fun DSSecondaryButtonWithTrailingIconPreview() {
    DSSecondaryButton(
        text = "Secondary Button",
        trailingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview
@Composable
private fun DSSecondaryButtonWithIconsPreview() {
    DSSecondaryButton(
        text = "Secondary Button",
        trailingIcon = R.drawable.bar_chart,
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}