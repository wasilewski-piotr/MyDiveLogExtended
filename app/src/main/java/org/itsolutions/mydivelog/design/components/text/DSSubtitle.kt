package org.itsolutions.mydivelog.design.components.text

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme

@Composable
fun DSSubtitle(@StringRes text: Int, modifier: Modifier = Modifier) =
    DSSubtitle(text = stringResource(text), modifier = modifier)

@Composable
fun DSSubtitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = DesignSystem.typography.screenSubtitle,
        modifier = modifier
    )
}

@Preview
@Composable
fun DSSubtitlePreview() {
    MyDiveLogTheme {
        Column(Modifier.background(Color.White)) {
            DSSubtitle("Subtitle")
            DSSubtitle(R.string.bottom_navigation_certificates)
        }
    }
}