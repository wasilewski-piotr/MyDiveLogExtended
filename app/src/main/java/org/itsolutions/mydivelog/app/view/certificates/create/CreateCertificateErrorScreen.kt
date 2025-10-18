package org.itsolutions.mydivelog.app.view.certificates.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.itsolutions.mydivelog.app.domain.model.results.DataError
import org.itsolutions.mydivelog.design.components.states.DSErrorState

@Composable
internal fun CreateCertificateErrorScreen(
    dataError: DataError,
    onRetry: () -> Unit,
) {
    Column(Modifier.fillMaxSize()) {
        DSErrorState(dataError, onRetry)
    }
}