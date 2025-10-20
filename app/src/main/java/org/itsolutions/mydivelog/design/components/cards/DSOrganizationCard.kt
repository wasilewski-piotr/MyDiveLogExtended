package org.itsolutions.mydivelog.design.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.design.components.spacers.HorizontalSpacer
import org.itsolutions.mydivelog.design.components.text.DSCardTitleWithText
import org.itsolutions.mydivelog.design.theme.DesignSystem
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme

@Composable
fun DSOrganizationCard(
    organization: DiveOrganization,
    onClick: (() -> Unit)? = null
) {
    DSCard(onClick = onClick) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            with (organization) {
                DSOrganizationCardImage(
                    organization = organization,
                    modifier = Modifier.size(DesignSystem.radius.xxxxl)
                )
                HorizontalSpacer(DesignSystem.spacing.sm)
                Column(modifier = Modifier.weight(1f)) {
                    DSCardTitleWithText(
                        title = name,
                        text = stringResource(longName)
                    )
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
}

@Composable
internal fun DSOrganizationCardImage(
    organization: DiveOrganization,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(DesignSystem.radius.md))
            .background(organization.backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(organization.logo),
            contentDescription = null,
            modifier = Modifier.size(DesignSystem.radius.xxxl)
        )
    }
}

@Preview
@Composable
private fun DSOrganizationCardClickablePreview() {
    MyDiveLogTheme {
        DSOrganizationCard(
            organization = DiveOrganization.SSI,
            onClick = { }
        )
    }
}

@Preview
@Composable
private fun DSOrganizationCardPreview() {
    MyDiveLogTheme {
        DSOrganizationCard(organization = DiveOrganization.SSI)
    }
}