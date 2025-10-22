package org.itsolutions.mydivelog.extensions

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.itsolutions.mydivelog.design.theme.DesignSystem

@Composable
fun Modifier.verticalPadding() = this.padding(vertical = DesignSystem.spacing.lg)

@Composable
fun Modifier.horizontalPadding() = this.padding(horizontal = DesignSystem.spacing.md)

@Composable
fun Modifier.topPadding() = this.padding(top = DesignSystem.spacing.xl)

@Composable
fun Modifier.bottomPadding() = this.padding(bottom = DesignSystem.spacing.lg)

fun Modifier.extendOutsideParent(
    start: Dp = 0.dp,
    end: Dp = 0.dp,
    top: Dp = 0.dp,
    bottom: Dp = 0.dp,
    isRtl: Boolean = false
) = this.layout { measurable, constraints ->

    val newConstraints = constraints.copy(
        maxWidth = constraints.maxWidth + start.roundToPx() + end.roundToPx(),
        maxHeight = constraints.maxHeight + top.roundToPx() + bottom.roundToPx()
    )

    val placeable = measurable.measure(newConstraints)

    val xOffset = if (isRtl) {
        ((start - end) / 2).roundToPx()
    } else {
        ((end - start) / 2).roundToPx()
    }

    val yOffset = ((bottom - top) / 2).roundToPx()
    layout(placeable.width, placeable.height) {
        placeable.place(xOffset, yOffset)
    }
}