package org.itsolutions.mydivelog.design.components.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.theme.DesignSystem

@Composable
fun DSSecondaryButtonMaxWidth(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
    verticalPadding: Dp = DesignSystem.spacing.md,
    onClick: () -> Unit,
) {
    DSSecondaryButton(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        enabled = enabled,
        onClick = onClick,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        verticalPadding = verticalPadding
    )
}

@Composable
fun DSSecondaryButton(
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
        variant = DSButtonType.SECONDARY,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        verticalPadding = verticalPadding
    )
}

@Composable
fun DSSecondaryButtonSmall(
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
        modifier = modifier.height(DesignSystem.spacing.xl),
        enabled = enabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        verticalPadding = DesignSystem.spacing.xxs,
        horizontalPadding = DesignSystem.spacing.sm,
        textStyle = MaterialTheme.typography.labelSmall,
        iconSpacer = DesignSystem.spacing.xxs,
        iconModifier = Modifier.size(DesignSystem.size.small_icon),
        shape = RoundedCornerShape(DesignSystem.radius.sm)
    )
}

@Preview(showBackground = true)
@Composable
private fun DSSecondaryButtonMaxWidthPreview() {
    DSSecondaryButtonMaxWidth(
        text = "Secondary Button Max Width",
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSSecondaryButtonMaxWidthWithLeadingIconPreview() {
    DSSecondaryButtonMaxWidth(
        text = "Secondary Button Max Width",
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSSecondaryButtonMaxWidthWithTrailingIconPreview() {
    DSSecondaryButtonMaxWidth(
        text = "Secondary Button Max Width",
        trailingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSSecondaryButtonMaxWidthWithIconsPreview() {
    DSSecondaryButtonMaxWidth(
        text = "Secondary Button Max Width",
        trailingIcon = R.drawable.bar_chart,
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSSecondaryButtonPreview() {
    DSSecondaryButton(
        text = "Secondary Button",
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSSecondaryButtonWithLeadingIconPreview() {
    DSSecondaryButton(
        text = "Secondary Button",
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSSecondaryButtonWithTrailingIconPreview() {
    DSSecondaryButton(
        text = "Secondary Button",
        trailingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSSecondaryButtonWithIconsPreview() {
    DSSecondaryButton(
        text = "Secondary Button",
        trailingIcon = R.drawable.bar_chart,
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSSecondaryButtonSmallPreview() {
    DSSecondaryButtonSmall(
        text = "Secondary Button",
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSSecondaryButtonSmallWithLeadingIconPreview() {
    DSSecondaryButtonSmall(
        text = "Secondary Button",
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSSecondaryButtonSmallWithTrailingIconPreview() {
    DSSecondaryButtonSmall(
        text = "Secondary Button",
        trailingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSSecondaryButtonSmallWithIconsPreview() {
    DSSecondaryButtonSmall(
        text = "Secondary Button",
        trailingIcon = R.drawable.bar_chart,
        leadingIcon = R.drawable.bar_chart,
        onClick = { }
    )
}