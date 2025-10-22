package org.itsolutions.mydivelog.design.components.navigation

import androidx.annotation.StringRes
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.itsolutions.mydivelog.R

enum class DSTopNavigationType {
    EXIT,
    BACK,
}

@Composable
fun DSTopNavigation(
    @StringRes title: Int,
    type: DSTopNavigationType,
    onClick: () -> Unit
) {
    DSTopNavigation(
        title = stringResource(title),
        type = type,
        onClick = onClick
    )
}

@Composable
fun DSTopNavigation(
    title: String,
    type: DSTopNavigationType,
    onClick: () -> Unit
) {
    Column {
        DSTopNavigationBar(type, title, onClick)
        if (title.isNotBlank()) {
            HorizontalDivider(thickness = 1.dp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DSTopNavigationBar(
    type: DSTopNavigationType,
    title: String? = null,
    onClick: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            title?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
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

@Preview(showBackground = true)
@Composable
private fun DSTopNavigationBackPreview() {
    DSTopNavigation(title = "Title", type = DSTopNavigationType.BACK) { }
}

@Preview(showBackground = true)
@Composable
private fun DSTopNavigationExitPreview() {
    DSTopNavigation(title = "Title", type = DSTopNavigationType.EXIT) { }
}

@Preview(showBackground = true)
@Composable
private fun DSTopNavigationStringResBackPreview() {
    DSTopNavigation(R.string.certificates_screen_new_certificate, DSTopNavigationType.BACK) { }
}

@Preview(showBackground = true)
@Composable
private fun DSTopNavigationStringResExitPreview() {
    DSTopNavigation(R.string.certificates_screen_new_certificate, DSTopNavigationType.EXIT) { }
}