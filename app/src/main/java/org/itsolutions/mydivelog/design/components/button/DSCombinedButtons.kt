package org.itsolutions.mydivelog.design.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.design.theme.spacings.DS

enum class DSButtonsOrientation {
    VERTICAL, HORIZONTAL
}

@Composable
fun DSCombinedButtons(
    primaryText: String,
    onPrimaryClick: () -> Unit,
    secondaryText: String,
    onSecondaryClick: () -> Unit,
    orientation: DSButtonsOrientation
) {
    when (orientation) {
        DSButtonsOrientation.VERTICAL -> DSCombinedButtonsVertically(
            primaryText = primaryText,
            onPrimaryClick = onPrimaryClick,
            secondaryText = secondaryText,
            onSecondaryClick = onSecondaryClick
        )
        DSButtonsOrientation.HORIZONTAL -> DSCombinedButtonsHorizontally(
            primaryText = primaryText,
            onPrimaryClick = onPrimaryClick,
            secondaryText = secondaryText,
            onSecondaryClick = onSecondaryClick
        )
    }
}

@Composable
fun DSCombinedButtonsVertically(
    primaryText: String,
    onPrimaryClick: () -> Unit,
    secondaryText: String,
    onSecondaryClick: () -> Unit,
) {
    Column {
        DSPrimaryButtonMaxWidth(
            text = primaryText,
            onClick = onPrimaryClick
        )
        DSSecondaryButtonMaxWidth(
            text = secondaryText,
            onClick = onSecondaryClick
        )
    }
}

@Composable
fun DSCombinedButtonsHorizontally(
    primaryText: String,
    onPrimaryClick: () -> Unit,
    secondaryText: String,
    onSecondaryClick: () -> Unit,
) {
    Row(horizontalArrangement = Arrangement.spacedBy(DS.spacing.sm)) {
        DSSecondaryButtonMaxWidth(
            text = secondaryText,
            onClick = onSecondaryClick,
            modifier = Modifier.weight(1f)
        )
        DSPrimaryButtonMaxWidth(
            text = primaryText,
            onClick = onPrimaryClick,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
private fun DSButtonsCombinedVerticallyPreview() {
    DSCombinedButtonsVertically(
        primaryText = "Primary Button",
        onPrimaryClick = { },
        secondaryText = "Secondary Button",
        onSecondaryClick = { }
    )
}

@Preview
@Composable
private fun DSButtonsCombinedHorizontallyPreview() {
    DSCombinedButtonsHorizontally(
        primaryText = "Primary Button",
        onPrimaryClick = { },
        secondaryText = "Secondary Button",
        onSecondaryClick = { }
    )
}