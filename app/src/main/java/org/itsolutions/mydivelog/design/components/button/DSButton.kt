package org.itsolutions.mydivelog.design.components.button

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
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
) {
    val padding = PaddingValues(horizontal = DesignSystem.spacing.lg, vertical = DesignSystem.spacing.sm)
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
            shape = RoundedCornerShape(DesignSystem.radius.sm)
        )
        DSButtonType.SECONDARY -> OutlinedButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            contentPadding = padding,
            content = content,
            shape = RoundedCornerShape(DesignSystem.radius.sm)
        )
    }
}