package org.itsolutions.mydivelog.design.components.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.itsolutions.mydivelog.design.theme.DesignSystem

@Composable
fun DSCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        shape = RoundedCornerShape(DesignSystem.radius.md),
        modifier = modifier,
        enabled = onClick != null,
        onClick = onClick ?: { },
        content = {
            Column(Modifier.padding(DesignSystem.spacing.md)) {
                content()
            }
        }
    )
}