package org.itsolutions.mydivelog.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import org.itsolutions.mydivelog.design.theme.spacings.DS
import org.itsolutions.mydivelog.design.theme.spacings.LocalRadius
import org.itsolutions.mydivelog.design.theme.spacings.LocalSpacing
import org.itsolutions.mydivelog.design.theme.spacings.Radius
import org.itsolutions.mydivelog.design.theme.spacings.Spacing

@Composable
fun MyDiveLogTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val scheme = if (darkTheme) darkColorScheme() else lightColorScheme()

    CompositionLocalProvider(
        LocalSpacing provides Spacing(),
        LocalRadius provides Radius()
    ) {
        MaterialTheme(
            colorScheme = scheme,
            shapes = Shapes(
                extraSmall = RoundedCornerShape(DS.radius.sm),
                small = RoundedCornerShape(DS.radius.sm),
                medium = RoundedCornerShape(DS.radius.md),
                large = RoundedCornerShape(DS.radius.lg),
                extraLarge = RoundedCornerShape(DS.radius.xl)
            ),
            content = content
        )
    }
}