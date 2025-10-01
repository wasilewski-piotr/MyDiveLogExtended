package org.itsolutions.mydivelog.design.theme.spacings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Spacing(
    val xs: Dp = 4.dp,
    val sm: Dp = 8.dp,
    val md: Dp = 12.dp,
    val lg: Dp = 16.dp,
    val xl: Dp = 24.dp,
    val xxl: Dp = 32.dp,
    val screenGutter: Dp = 16.dp
)

@Immutable
data class Radius(
    val sm: Dp = 8.dp,
    val md: Dp = 12.dp,
    val lg: Dp = 20.dp,
    val xl: Dp = 28.dp,
    val pill: Dp = 1000.dp
)

internal val LocalSpacing = staticCompositionLocalOf { Spacing() }
internal val LocalRadius  = staticCompositionLocalOf { Radius() }

object DS {
    val spacing @Composable get() = LocalSpacing.current
    val radius   @Composable get() = LocalRadius.current
}