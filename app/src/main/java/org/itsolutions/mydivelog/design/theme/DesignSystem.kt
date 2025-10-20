package org.itsolutions.mydivelog.design.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import org.itsolutions.mydivelog.design.theme.spacings.DSRadius
import org.itsolutions.mydivelog.design.theme.spacings.DSSize
import org.itsolutions.mydivelog.design.theme.spacings.DSSpacing
import org.itsolutions.mydivelog.design.theme.typography.DSTypography

internal val LocalSpacing = staticCompositionLocalOf { DSSpacing() }
internal val LocalRadius  = staticCompositionLocalOf { DSRadius() }
internal val LocalTypography = staticCompositionLocalOf { DSTypography() }
internal val LocalSize = staticCompositionLocalOf { DSSize() }

object DesignSystem {
    val spacing @Composable get() = LocalSpacing.current
    val radius @Composable get() = LocalRadius.current
    val typography @Composable get() = LocalTypography.current
    val size @Composable get() = LocalSize.current
}