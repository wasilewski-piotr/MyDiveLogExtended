package org.itsolutions.mydivelog.design.components.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.itsolutions.mydivelog.extensions.bottomPadding
import org.itsolutions.mydivelog.extensions.horizontalPadding

@Composable
fun DSBottomSection(content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalPadding()
            .bottomPadding()
            .imePadding(),
        content = content
    )
}