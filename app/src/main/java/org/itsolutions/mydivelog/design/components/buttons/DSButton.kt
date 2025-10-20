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
    enabled: Boolean = true,
    verticalPadding: Dp = DesignSystem.spacing.md,
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
) {
    val padding = PaddingValues(horizontal = DesignSystem.spacing.lg, vertical = verticalPadding)
    val content: @Composable RowScope.() -> Unit = {
        leadingIcon?.let {
            Icon(painterResource(it), null)
            HorizontalSpacer(DesignSystem.spacing.xs)
        }
        Text(
            text = text,
            softWrap = true,
            modifier = Modifier.weight(1f, fill = false),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge
        )
        trailingIcon?.let {
            HorizontalSpacer(DesignSystem.spacing.xs)
            Icon(painterResource(it), null)
        }
    }

    when (variant) {
        DSButtonType.PRIMARY -> Button(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            contentPadding = padding,
            content = content,
            shape = RoundedCornerShape(DesignSystem.radius.md)
        )
        DSButtonType.SECONDARY -> OutlinedButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            contentPadding = padding,
            content = content,
            shape = RoundedCornerShape(DesignSystem.radius.md)
        )
    }
}

@Preview
@Composable
private fun DSButtonPreview() {
    DSButton(
        text = "Button",
        variant = DSButtonType.PRIMARY,
        onClick = { }
    )
}