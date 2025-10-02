package org.itsolutions.mydivelog.design.components.text

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme

@Composable
fun DSCardTitle(@StringRes text: Int, modifier: Modifier = Modifier) =
    DSCardTitle(text = stringResource(text), modifier = modifier)

@Composable
fun DSCardTitle(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        style = DesignSystem.typography.cardTitle,
        modifier = modifier,
        textAlign = textAlign
    )
}

@Preview
@Composable
private fun DSCardTitlePreview() {
    MyDiveLogTheme {
        Column(Modifier.background(Color.White)) {
            DSCardTitle("Card Title")
            DSCardTitle(R.string.bottom_navigation_certificates)
        }
    }
}