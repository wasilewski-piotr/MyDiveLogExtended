package org.itsolutions.mydivelog.app.view.menu.certificates

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.app.presentation.menu.certificates.CertificatesViewModel

@Composable
fun CertificatesScreen(viewModel: CertificatesViewModel) {
    CertificatesScreenContent()
}

@Composable
private fun CertificatesScreenContent() {
    Text("Certificates")
}

@Preview
@Composable
private fun CertificatesScreenPreview() {
    CertificatesScreenContent()
}