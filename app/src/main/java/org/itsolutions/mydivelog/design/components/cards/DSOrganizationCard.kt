package org.itsolutions.mydivelog.design.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.design.components.spacers.HorizontalSpacer
import org.itsolutions.mydivelog.design.components.text.DSCardTitleWithText
import org.itsolutions.mydivelog.design.theme.DesignSystem

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
            with(organization) {
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
    OutlinedCard(
        modifier = modifier,
        shape = RoundedCornerShape(DesignSystem.radius.sm),
        colors = CardDefaults.outlinedCardColors().copy(containerColor = organization.backgroundColor),
        border = if (organization.backgroundColor == Color.White) {
            BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        } else BorderStroke(0.dp, Color.Transparent)
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(DesignSystem.spacing.xs)
        ) {
            Image(
                painter = painterResource(organization.logo),
                contentDescription = null,
                modifier = Modifier.size(DesignSystem.radius.xxxl)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DSOrganizationCardClickablePreview() {
    DSOrganizationCard(
        organization = DiveOrganization.SSI,
        onClick = { }
    )
}

@Preview(showBackground = true)
@Composable
private fun DSOrganizationCardPreview() {
    DSOrganizationCard(organization = DiveOrganization.SSI)
}

@Preview(showBackground = true)
@Composable
private fun DSOrganizationCardWithWhiteLogoBackgroundPreview() {
    DSOrganizationCard(organization = DiveOrganization.NAUI)
}