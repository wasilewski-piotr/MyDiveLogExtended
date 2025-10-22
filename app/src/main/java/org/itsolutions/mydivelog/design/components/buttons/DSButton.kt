package org.itsolutions.mydivelog.design.components.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import org.itsolutions.mydivelog.design.components.spacers.HorizontalSpacer
import org.itsolutions.mydivelog.design.theme.DesignSystem

internal enum class DSButtonType {
    PRIMARY,
    SECONDARY
}

@Composable
internal fun DSButton(
    text: String,
    variant: DSButtonType,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    enabled: Boolean = true,
    verticalPadding: Dp = DesignSystem.spacing.md,
    horizontalPadding: Dp = DesignSystem.spacing.lg,
    iconSpacer: Dp = DesignSystem.spacing.xs,
    textStyle: TextStyle = MaterialTheme.typography.labelLarge,
    shape: RoundedCornerShape = RoundedCornerShape(DesignSystem.radius.md),
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
) {
    val padding = PaddingValues(horizontal = horizontalPadding, vertical = verticalPadding)
    val content: @Composable RowScope.() -> Unit = {
        leadingIcon?.let {
            Icon(painterResource(it), null, modifier = iconModifier)
            HorizontalSpacer(iconSpacer)
        }
        Text(
            text = text,
            softWrap = true,
            modifier = Modifier.weight(1f, fill = false),
            textAlign = TextAlign.Center,
            style = textStyle
        )
        trailingIcon?.let {
            HorizontalSpacer(iconSpacer)
            Icon(painterResource(it), null, modifier = iconModifier)
        }
    }

    when (variant) {
        DSButtonType.PRIMARY -> Button(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            contentPadding = padding,
            content = content,
            shape = shape
        )
        DSButtonType.SECONDARY -> OutlinedButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            contentPadding = padding,
            content = content,
            shape = shape
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DSButtonPreview() {
    DSButton(
        text = "Button",
        variant = DSButtonType.PRIMARY,
        onClick = { }
    )
}