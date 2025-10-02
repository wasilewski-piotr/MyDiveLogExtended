package org.itsolutions.mydivelog.design.components.text

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme

@Composable
fun DSTitleWithSubtitle(
    @StringRes title: Int,
    @StringRes subtitle: Int,
    modifier: Modifier = Modifier
) {
    DSTitleWithSubtitle(
        title = stringResource(title),
        subtitle = stringResource(subtitle),
        modifier = modifier
    )
}

@Composable
fun DSTitleWithSubtitle(
    title: String,
    @StringRes subtitle: Int,
    modifier: Modifier = Modifier
) {
    DSTitleWithSubtitle(
        title = title,
        subtitle = stringResource(subtitle),
        modifier = modifier
    )
}

@Composable
fun DSTitleWithSubtitle(
    @StringRes title: Int,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    DSTitleWithSubtitle(
        title = stringResource(title),
        subtitle = subtitle,
        modifier = modifier
    )
}

@Composable
fun DSTitleWithSubtitle(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        DSTitle(title)
        VerticalSpacer(DesignSystem.spacing.xs)
        DSSubtitle(subtitle)
    }
}

@Preview
@Composable
private fun DSTitleWithSubtitlePreview() {
    MyDiveLogTheme {
        Column(Modifier.background(Color.White)) {
            DSTitleWithSubtitle(
                title = "This is my title",
                subtitle = "This is my looooooooooooooong subtitle that I want to show"
            )
        }
    }
}