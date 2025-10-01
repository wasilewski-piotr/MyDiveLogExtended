package org.itsolutions.mydivelog.design.components.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.itsolutions.mydivelog.design.theme.spacings.DS

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
) {
    val content: @Composable RowScope.() -> Unit = { Text(text = text, style = MaterialTheme.typography.labelLarge) }
    val padding = PaddingValues(horizontal = DS.spacing.lg, vertical = DS.spacing.sm)

    when (variant) {
        DSButtonType.PRIMARY -> Button(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            contentPadding = padding,
            content = content,
            shape = RoundedCornerShape(DS.radius.sm)
        )
        DSButtonType.SECONDARY -> OutlinedButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            contentPadding = padding,
            content = content,
            shape = RoundedCornerShape(DS.radius.sm)
        )
    }
}