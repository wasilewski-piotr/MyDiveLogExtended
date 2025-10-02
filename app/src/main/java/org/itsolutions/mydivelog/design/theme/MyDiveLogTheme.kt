package org.itsolutions.mydivelog.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import org.itsolutions.mydivelog.design.theme.spacings.DSRadius
import org.itsolutions.mydivelog.design.theme.spacings.DSSpacing
import org.itsolutions.mydivelog.design.theme.typography.provideDSTypography

@Composable
fun MyDiveLogTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val scheme = if (darkTheme) darkColorScheme() else lightColorScheme()
    val dsTypography = provideDSTypography()

    CompositionLocalProvider(
        LocalSpacing provides DSSpacing(),
        LocalRadius provides DSRadius(),
        LocalTypography provides dsTypography
    ) {
        MaterialTheme(
            colorScheme = scheme,
            shapes = Shapes(
                extraSmall = RoundedCornerShape(DesignSystem.radius.sm),
                small = RoundedCornerShape(DesignSystem.radius.sm),
                medium = RoundedCornerShape(DesignSystem.radius.md),
                large = RoundedCornerShape(DesignSystem.radius.lg),
                extraLarge = RoundedCornerShape(DesignSystem.radius.xl)
            ),
            content = content
        )
    }
}