package org.itsolutions.mydivelog.app.view.certificates.create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.itsolutions.mydivelog.design.components.progress.DSCircularProgressIndicator

@Composable
internal fun CreateCertificateLoadingScreen() {
    Column(Modifier.fillMaxSize()) {
        DSCircularProgressIndicator()
    }
}