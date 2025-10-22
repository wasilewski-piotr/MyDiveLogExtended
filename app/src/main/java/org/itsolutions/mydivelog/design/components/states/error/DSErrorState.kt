package org.itsolutions.mydivelog.design.components.states.error

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.results.DataError
import org.itsolutions.mydivelog.app.domain.model.results.toMessageResource
import org.itsolutions.mydivelog.design.components.buttons.DSSecondaryButton
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.components.spacers.WeightedSpacer
import org.itsolutions.mydivelog.design.components.states.empty.DSEmptyStateContent
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme

@Composable
fun DSErrorState(
    error: DataError,
    buttonLabel: String = stringResource(R.string.try_again),
    onRetry: () -> Unit
) {
    DSErrorState(
        message = stringResource(error.toMessageResource()),
        buttonLabel = buttonLabel,
        onRetry = onRetry
    )
}

@Composable
fun DSErrorState(
    message: String,
    buttonLabel: String = stringResource(R.string.try_again),
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WeightedSpacer(0.5f)
        DSEmptyStateContent(message)
        VerticalSpacer(DesignSystem.spacing.sm)
        DSSecondaryButton(
            modifier = Modifier.padding(horizontal = 100.dp),
            text = buttonLabel,
            onClick = onRetry
        )
        WeightedSpacer()
    }
}

@Composable
@Preview
private fun DSErrorStatePreview() {
    MyDiveLogTheme {
        DSErrorState(
            error = DataError.Local.CERTIFICATE_ALREADY_EXISTS,
            onRetry = { }
        )
    }
}