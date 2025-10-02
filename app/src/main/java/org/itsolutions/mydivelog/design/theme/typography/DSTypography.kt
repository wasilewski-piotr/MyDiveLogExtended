package org.itsolutions.mydivelog.design.theme.typography

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

data class DSTypography(
    val screenTitle: TextStyle = TextStyle.Default,
    val screenSubtitle: TextStyle = TextStyle.Default,
    val cardTitle: TextStyle = TextStyle.Default,
    val cardText: TextStyle = TextStyle.Default
)

@Composable
internal fun provideDSTypography(): DSTypography {
    return DSTypography(
        screenTitle = MaterialTheme.typography.headlineLarge,
        screenSubtitle = MaterialTheme.typography.bodyLarge,
        cardTitle = MaterialTheme.typography.titleMedium,
        cardText = MaterialTheme.typography.bodyMedium
    )
}