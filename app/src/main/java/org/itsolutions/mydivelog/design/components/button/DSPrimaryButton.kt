package org.itsolutions.mydivelog.design.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DSPrimaryButtonMaxWidth(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    DSPrimaryButton(
        text = text,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        onClick = onClick
    )
}

@Composable
fun DSPrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    DSButton(
        text = text,
        variant = DSButtonType.PRIMARY,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    )
}

@Preview
@Composable
private fun DSPrimaryButtonMaxWidthPreview() {
    DSPrimaryButtonMaxWidth(
        text = "Primary Button Max Width",
        onClick = { }
    )
}

@Preview
@Composable
private fun DSPrimaryButtonPreview() {
    DSPrimaryButton(
        text = "Primary Button",
        onClick = { }
    )
}