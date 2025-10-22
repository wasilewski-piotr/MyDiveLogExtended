package org.itsolutions.mydivelog.design.components.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.itsolutions.mydivelog.extensions.horizontalPadding
import org.itsolutions.mydivelog.extensions.topPadding

@Composable
fun DSTopSection(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalPadding()
            .topPadding(),
        content = content
    )
}