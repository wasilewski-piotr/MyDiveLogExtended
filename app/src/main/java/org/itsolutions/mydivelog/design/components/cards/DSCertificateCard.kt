package org.itsolutions.mydivelog.design.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.design.components.buttons.DSCopyButton
import org.itsolutions.mydivelog.design.components.spacers.HorizontalSpacer
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.components.text.DSCardText
import org.itsolutions.mydivelog.design.components.text.DSCardTitle
import org.itsolutions.mydivelog.design.components.text.DSCardTitleWithText
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.extensions.extendOutsideParent
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

@Composable
fun DSCertificateCard(
    certificateName: String,
    certificateNumber: String,
    organization: DiveOrganization,
    allowCopy: Boolean = true,
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
) {
    DSCertificateCardContent(
        certificateName = certificateName,
        certificateNumber = certificateNumber,
        organization = organization,
        onClick = onClick,
        onLongClick = onLongClick,
        allowCopy = allowCopy
    )
}

@Composable
fun DSCertificateCard(
    issueDate: LocalDate?,
    issuerName: String,
    issuerId: String,
    certificateName: String,
    certificateNumber: String,
    organization: DiveOrganization
) {
    val date = issueDate?.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.UK))

    DSCertificateCardContent(
        certificateName = certificateName,
        certificateNumber = certificateNumber,
        organization = organization,
        colors = CardDefaults.cardColors().copy(containerColor = MaterialTheme.colorScheme.surfaceContainerHigh)
    ) {
        DSCardTitle(R.string.certificate_card_certificate_data_title)
        date?.let {
            DSCardText(stringResource(R.string.certificate_card_certificate_issue_date, date))
        }
        DSCardText(stringResource(R.string.certificate_card_certificate_issuer_name, issuerName))
        DSCardText(stringResource(R.string.certificate_card_certificate_issuer_id, issuerId))
        VerticalSpacer(DesignSystem.spacing.sm)
    }
}

@Composable
private fun DSCertificateCardContent(
    certificateName: String,
    certificateNumber: String,
    organization: DiveOrganization,
    onClick: (() -> Unit)? = null,
    onLongClick: (() -> Unit)? = null,
    allowCopy: Boolean = false,
    colors: CardColors = CardDefaults.cardColors(),
    certificateDataContent: @Composable ColumnScope.() -> Unit = { }
) {
    DSCard(onClick = onClick, onLongClick = onLongClick, colors = colors) {
        Row(
            modifier = Modifier.height(IntrinsicSize.Min),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(Modifier.weight(1f)) {
                DSOrganizationCardImage(
                    organization = organization,
                    modifier = Modifier.size(DesignSystem.size.xxxxl)
                )
                HorizontalSpacer(DesignSystem.spacing.sm)
                Column(Modifier.weight(1f)) {
                    DSCardTitleWithText(
                        title = certificateName,
                        text = organization.longName
                    )
                    VerticalSpacer(DesignSystem.spacing.sm)
                    certificateDataContent()
                    Row(
                        modifier = onClick?.let {
                            Modifier
                                .extendOutsideParent(end = DesignSystem.spacing.xl)
                                .fillMaxWidth()
                        } ?: Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        DSCardTitleWithText(
                            title = R.string.certificate_card_certificate_number_title,
                            text = certificateNumber
                        )
                        if (allowCopy) {
                            DSCopyButton(textToCopy = certificateNumber)
                        }
                    }
                }
            }
            onClick?.let {
                Icon(
                    painter = painterResource(R.drawable.chevron_right),
                    contentDescription = null,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DSCertificateCardPreview() {
    DSCertificateCard(
        organization = DiveOrganization.SSI,
        issueDate = LocalDate.now(),
        issuerName = "Bob budowniczy",
        issuerId = "696546",
        certificateName = "Open Water Diver",
        certificateNumber = "65465434N54654324-PL",
    )
}

@Preview(showBackground = true)
@Composable
private fun DSCertificateCardSmallPreview() {
    DSCertificateCard(
        organization = DiveOrganization.SSI,
        certificateName = "Open Water Diver",
        certificateNumber = "65465434N54654324-PL"
    )
}

@Preview(showBackground = true)
@Composable
private fun DSCertificateCardSmallClickablePreview() {
    DSCertificateCard(
        organization = DiveOrganization.SSI,
        certificateName = "Open Water Diver",
        certificateNumber = "65465434N54654324-PL",
        onClick = { }
    )
}