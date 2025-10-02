package org.itsolutions.mydivelog.design.components.text

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme

@Composable
fun DSCardTitleWithText(
    @StringRes title: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    DSCardTitleWithText(
        title = stringResource(title),
        text = stringResource(text),
        modifier = modifier
    )
}

@Composable
fun DSCardTitleWithText(
    title: String,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    DSCardTitleWithText(
        title = title,
        text = stringResource(text),
        modifier = modifier
    )
}

@Composable
fun DSCardTitleWithText(
    @StringRes title: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    DSCardTitleWithText(
        title = stringResource(title),
        text = text,
        modifier = modifier
    )
}

@Composable
fun DSCardTitleWithTextCentered(
    title: String,
    text: String,
    modifier: Modifier = Modifier,
) {
    DSCardTitleWithText(
        title = title,
        text = text,
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}

@Composable
fun DSCardTitleWithText(
    title: String,
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    Column {
        DSCardTitle(text = title, textAlign = textAlign, modifier = modifier)
        DSCardText(text = text, textAlign = textAlign, modifier = modifier)
    }
}

@Preview
@Composable
private fun DSCardTitleWithTextPreview() {
    MyDiveLogTheme {
        Column(Modifier.background(Color.White)) {
            DSCardTitleWithText(
                title = "This is my card title",
                text = "This is my looooooooooooooong card text that I want to show"
            )
        }
    }
}