package org.itsolutions.mydivelog.design.components.states

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.results.DataError
import org.itsolutions.mydivelog.app.domain.model.results.toMessageResource
import org.itsolutions.mydivelog.design.components.button.DSSecondaryButton
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme

@Composable
fun DSErrorState(
    error: DataError,
    onRetry: () -> Unit
) {
    val message = error.toMessageResource()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DSEmptyStateContent(stringResource(message))
        VerticalSpacer(DesignSystem.spacing.sm)
        DSSecondaryButton(
            text = stringResource(R.string.retry),
            onClick = onRetry
        )
    }
}

@Composable
@Preview
private fun DSErrorStatePreview() {
    MyDiveLogTheme {
        Column(Modifier.background(Color.White)) {
            DSErrorState(
                error = DataError.Local.CERTIFICATE_ALREADY_EXISTS,
                onRetry = { }
            )
        }
    }
}