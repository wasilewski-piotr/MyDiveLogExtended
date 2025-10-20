package org.itsolutions.mydivelog.design.components.cards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.design.components.spacers.HorizontalSpacer
import org.itsolutions.mydivelog.design.components.spacers.VerticalSpacer
import org.itsolutions.mydivelog.design.components.text.DSCardText
import org.itsolutions.mydivelog.design.components.text.DSCardTitle
import org.itsolutions.mydivelog.design.components.text.DSCardTitleWithText
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

@Composable
fun DSCertificateCard(
    issueDate: LocalDate?,
    issuerName: String,
    issuerId: String,
    certificateName: String,
    certificateNumber: String,
    organization: DiveOrganization,
    onClick: (() -> Unit)? = null
) {
    val date = issueDate?.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.UK))

    DSCard(onClick = onClick) {
        Row(Modifier.padding(DesignSystem.spacing.xs)) {
            DSOrganizationCardImage(
                organization = organization,
                modifier = Modifier.size(DesignSystem.radius.xxxxl)
            )
            HorizontalSpacer(DesignSystem.spacing.sm)
            Column(Modifier.weight(1f)) {
                DSCardTitleWithText(
                    title = certificateName,
                    text = organization.longName
                )
                VerticalSpacer(DesignSystem.spacing.sm)
                DSCardTitle(R.string.certificate_card_certificate_data_title)
                date?.let {
                    DSCardText(stringResource(R.string.certificate_card_certificate_issue_date,date))
                }
                DSCardText(stringResource(R.string.certificate_card_certificate_issuer_name, issuerName))
                DSCardText(stringResource(R.string.certificate_card_certificate_issuer_id, issuerId))
                VerticalSpacer(DesignSystem.spacing.sm)
                DSCardTitleWithText(
                    title = R.string.certificate_card_certificate_number_title,
                    text = certificateNumber
                )
            }
        }
    }
}

@Preview
@Composable
private fun DSCertificateCardPreview() {
    MyDiveLogTheme {
        DSCertificateCard(
            organization = DiveOrganization.SSI,
            issueDate = LocalDate.now(),
            issuerName = "Bob budowniczy",
            issuerId = "696546",
            certificateName = "Open Water Diver",
            certificateNumber = "65465434N54654324-PL",
        )
    }
}