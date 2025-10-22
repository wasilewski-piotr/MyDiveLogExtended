package org.itsolutions.mydivelog.app.view.certificates.create

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.components.states.success.DSSuccessStateFullScreen

@Composable
internal fun CreateCertificateSuccessScreen(
    seeCertificate: () -> Unit,
    onClose: () -> Unit
) {
    DSSuccessStateFullScreen(
        title = R.string.create_certificate_success_title,
        subtitle = R.string.create_certificate_success_subtitle,
        primaryButtonText = R.string.create_certificate_success_button_label,
        primaryButtonAction = seeCertificate,
        secondaryButtonText = R.string.close,
        secondaryButtonAction = onClose
    )
}

@Preview(showBackground = true)
@Composable
private fun CreateCertificateSuccessScreenPreview() {
        CreateCertificateSuccessScreen(
            seeCertificate = { },
            onClose = { }
        )
}