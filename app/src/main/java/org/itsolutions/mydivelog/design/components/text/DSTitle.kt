package org.itsolutions.mydivelog.design.components.text

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.theme.DesignSystem

@Composable
fun DSTitle(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) =
    DSTitle(text = stringResource(text), modifier = modifier, textAlign = textAlign)

@Composable
fun DSTitle(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        style = DesignSystem.typography.screenTitle,
        textAlign = textAlign,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun DSTitlePreview() {
    DSTitle("Title")
    DSTitle(R.string.bottom_navigation_certificates)
}