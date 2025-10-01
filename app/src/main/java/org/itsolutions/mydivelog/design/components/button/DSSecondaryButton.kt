package org.itsolutions.mydivelog.design.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DSSecondaryButtonMaxWidth(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    DSSecondaryButton(
        text = text,
        modifier = Modifier.fillMaxWidth().then(modifier),
        enabled = enabled,
        onClick = onClick
    )
}

@Composable
fun DSSecondaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    DSButton(
        text = text,
        variant = DSButtonType.SECONDARY,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    )
}

@Preview
@Composable
private fun DSSecondaryButtonMaxWidthPreview() {
    DSSecondaryButtonMaxWidth(
        text = "Secondary Button Max Width",
        onClick = { }
    )
}

@Preview
@Composable
private fun DSSecondaryButtonPreview() {
    DSSecondaryButton(
        text = "Secondary Button",
        onClick = { }
    )
}