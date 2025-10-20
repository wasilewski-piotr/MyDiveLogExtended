package org.itsolutions.mydivelog.design.components.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme

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
        modifier = Modifier.fillMaxWidth().then(modifier),
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
        modifier = modifier.height(DesignSystem.spacing.xxl),
        enabled = enabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        verticalPadding = DesignSystem.spacing.xxs,
        horizontalPadding = DesignSystem.spacing.sm,
        textStyle = MaterialTheme.typography.labelSmall,
        iconModifier = Modifier.size(DesignSystem.size.small_icon)
    )
}

@Preview
@Composable
private fun DSSecondaryButtonMaxWidthPreview() {
    MyDiveLogTheme {
        DSSecondaryButtonMaxWidth(
            text = "Secondary Button Max Width",
            onClick = { }
        )
    }
}

@Preview
@Composable
private fun DSSecondaryButtonMaxWidthWithLeadingIconPreview() {
    MyDiveLogTheme {
        DSSecondaryButtonMaxWidth(
            text = "Secondary Button Max Width",
            leadingIcon = R.drawable.bar_chart,
            onClick = { }
        )
    }
}

@Preview
@Composable
private fun DSSecondaryButtonMaxWidthWithTrailingIconPreview() {
    MyDiveLogTheme {
        DSSecondaryButtonMaxWidth(
            text = "Secondary Button Max Width",
            trailingIcon = R.drawable.bar_chart,
            onClick = { }
        )
    }
}

@Preview
@Composable
private fun DSSecondaryButtonMaxWidthWithIconsPreview() {
    MyDiveLogTheme {
        DSSecondaryButtonMaxWidth(
            text = "Secondary Button Max Width",
            trailingIcon = R.drawable.bar_chart,
            leadingIcon = R.drawable.bar_chart,
            onClick = { }
        )
    }
}

@Preview
@Composable
private fun DSSecondaryButtonPreview() {
    MyDiveLogTheme {
        DSSecondaryButton(
            text = "Secondary Button",
            onClick = { }
        )
    }
}

@Preview
@Composable
private fun DSSecondaryButtonWithLeadingIconPreview() {
    MyDiveLogTheme {
        DSSecondaryButton(
            text = "Secondary Button",
            leadingIcon = R.drawable.bar_chart,
            onClick = { }
        )
    }
}

@Preview
@Composable
private fun DSSecondaryButtonWithTrailingIconPreview() {
    MyDiveLogTheme {
        DSSecondaryButton(
            text = "Secondary Button",
            trailingIcon = R.drawable.bar_chart,
            onClick = { }
        )
    }
}

@Preview
@Composable
private fun DSSecondaryButtonWithIconsPreview() {
    MyDiveLogTheme {
        DSSecondaryButton(
            text = "Secondary Button",
            trailingIcon = R.drawable.bar_chart,
            leadingIcon = R.drawable.bar_chart,
            onClick = { }
        )
    }
}

@Preview
@Composable
private fun DSSecondaryButtonSmallPreview() {
    MyDiveLogTheme {
        DSSecondaryButtonSmall(
            text = "Secondary Button",
            onClick = { }
        )
    }
}

@Preview
@Composable
private fun DSSecondaryButtonSmallWithLeadingIconPreview() {
    MyDiveLogTheme {
        DSSecondaryButtonSmall(
            text = "Secondary Button",
            leadingIcon = R.drawable.bar_chart,
            onClick = { }
        )
    }
}

@Preview
@Composable
private fun DSSecondaryButtonSmallWithTrailingIconPreview() {
    MyDiveLogTheme {
        DSSecondaryButtonSmall(
            text = "Secondary Button",
            trailingIcon = R.drawable.bar_chart,
            onClick = { }
        )
    }
}

@Preview
@Composable
private fun DSSecondaryButtonSmallWithIconsPreview() {
    MyDiveLogTheme {
        DSSecondaryButtonSmall(
            text = "Secondary Button",
            trailingIcon = R.drawable.bar_chart,
            leadingIcon = R.drawable.bar_chart,
            onClick = { }
        )
    }
}