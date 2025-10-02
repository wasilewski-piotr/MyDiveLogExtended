package org.itsolutions.mydivelog.design.components.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.itsolutions.mydivelog.design.components.card.DSCard
import org.itsolutions.mydivelog.design.theme.DesignSystem

@Composable
internal fun DSSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    DSSectionContent(title, modifier) {
        Column(
            verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.md),
            content = content
        )
    }
}

@Composable
internal fun DSSectionInCard(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    DSSectionContent(title, modifier) {
        DSCard {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.md),
                content = content
            )
        }
    }
}

@Composable
private fun DSSectionContent(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = DesignSystem.spacing.xs)
        )
        content()
    }
}