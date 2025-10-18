package org.itsolutions.mydivelog.app.view.certificates.create

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.components.buttons.DSCombinedButtonsHorizontally
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.components.spacers.WeightedSpacer
import org.itsolutions.mydivelog.design.components.text.DSSubtitle
import org.itsolutions.mydivelog.design.components.text.DSTitle
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.extensions.verticalPadding

@Composable
internal fun CreateCertificateSuccessScreen(
    seeCertificate: () -> Unit,
    onClose: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().verticalPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WeightedSpacer(0.3f)
        Image(
            painter = painterResource(R.drawable.check_icon),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )
        VerticalSpacer(DesignSystem.spacing.xl)
        DSTitle(text = R.string.create_certificate_success_title, textAlign = TextAlign.Center)
        DSSubtitle(text = R.string.create_certificate_success_subtitle, textAlign = TextAlign.Center)
        WeightedSpacer()
        DSCombinedButtonsHorizontally(
            primaryText = stringResource(R.string.create_certificate_success_button_label),
            onPrimaryClick = seeCertificate,
            secondaryText = stringResource(R.string.close),
            onSecondaryClick = onClose
        )
    }
}