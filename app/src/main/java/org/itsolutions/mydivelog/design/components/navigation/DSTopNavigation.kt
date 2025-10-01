package org.itsolutions.mydivelog.design.components.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

enum class DSTopNavigationType {
    EXIT,
    BACK,
}

@Composable
fun DSTopNavigation(
    title: String,
    type: DSTopNavigationType,
    onClick: () -> Unit
) {
    Column {
        DSTopNavigationBar(title, type, onClick)
        HorizontalDivider(thickness = 1.dp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DSTopNavigationBar(
    title: String,
    type: DSTopNavigationType,
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge
            )
        },
        navigationIcon = {
            when (type) {
                DSTopNavigationType.BACK -> { DSTopNavigationIcon(type, onClick) }
                else -> { }
            }
        },
        actions = {
            when (type) {
                DSTopNavigationType.EXIT -> { DSTopNavigationIcon(type, onClick) }
                else -> { }
            }
        }
    )
}

@Composable
private fun DSTopNavigationIcon(
    type: DSTopNavigationType,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = when (type) {
                DSTopNavigationType.EXIT -> Icons.Filled.Close
                DSTopNavigationType.BACK -> Icons.AutoMirrored.Filled.ArrowBack
            },
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun DSTopNavigationBackPreview() {
    DSTopNavigation("Title", DSTopNavigationType.BACK) { }
}

@Preview
@Composable
private fun DSTopNavigationExitPreview() {
    DSTopNavigation("Title", DSTopNavigationType.EXIT) { }
}