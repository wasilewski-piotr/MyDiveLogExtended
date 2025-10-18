package org.itsolutions.mydivelog.design.theme.spacings

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class DSSpacing(
    val xxs: Dp = 2.dp,
    val xs: Dp = 4.dp,
    val sm: Dp = 8.dp,
    val md: Dp = 12.dp,
    val lg: Dp = 16.dp,
    val xl: Dp = 24.dp,
    val xxl: Dp = 32.dp,
)

@Immutable
data class DSRadius(
    val xs: Dp = 4.dp,
    val sm: Dp = 8.dp,
    val md: Dp = 12.dp,
    val lg: Dp = 20.dp,
    val xl: Dp = 28.dp,
    val xxl: Dp = 32.dp,
    val xxxl: Dp = 48.dp,
    val xxxxl: Dp = 60.dp,
    val pill: Dp = 1000.dp
)