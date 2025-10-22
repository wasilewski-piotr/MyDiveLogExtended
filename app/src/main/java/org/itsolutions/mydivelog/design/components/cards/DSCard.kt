package org.itsolutions.mydivelog.design.components.cards

import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.design.theme.DesignSystem

@Composable
fun DSCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    colors: CardColors = CardDefaults.cardColors(),
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        shape = RoundedCornerShape(DesignSystem.radius.md),
        modifier = modifier
            .combinedClickable(
                enabled = onClick != null,
                onClick = onClick ?: { },
                onLongClick = onLongClick
            ),
        content = {
            Column(Modifier.padding(DesignSystem.spacing.md)) {
                content()
            }
        },
        colors = colors,
    )
}

@Preview(showBackground = true)
@Composable
private fun DSCardPreview() {
    DSCard {
        Text("Card")
    }
}