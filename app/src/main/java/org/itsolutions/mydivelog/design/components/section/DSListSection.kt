package org.itsolutions.mydivelog.design.components.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.extensions.horizontalPadding
import org.itsolutions.mydivelog.extensions.verticalPadding

@Composable
fun ColumnScope.DSListSectionScrollable(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val scrollState = rememberScrollState()
    DSListSection(
        modifier = modifier.verticalScroll(scrollState),
        content = content
    )
}

@Composable
fun ColumnScope.DSListSection(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    val listModifier = Modifier.background(MaterialTheme.colorScheme.secondaryContainer)
    Column(
        modifier = listModifier
            .fillMaxSize()
            .then(modifier)
            .horizontalPadding()
            .verticalPadding(),
        verticalArrangement = Arrangement.spacedBy(DesignSystem.spacing.xs),
        content = content
    )
    Box(
        modifier = listModifier
            .fillMaxWidth()
            .weight(1f)
    )
}