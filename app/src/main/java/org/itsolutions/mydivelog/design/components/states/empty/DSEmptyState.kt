package org.itsolutions.mydivelog.design.components.states.empty

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.components.spacers.WeightedSpacer
import org.itsolutions.mydivelog.design.components.text.DSCardTitleWithTextCentered
import org.itsolutions.mydivelog.design.theme.DesignSystem

@Composable
fun DSEmptyState(@StringRes description: Int) {
    DSEmptyState(stringResource(description))
}

@Composable
fun DSEmptyState(description: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WeightedSpacer(0.5f)
        DSEmptyStateContent(description)
        WeightedSpacer()
    }
}

@Composable
internal fun DSEmptyStateContent(description: String) {
    Image(
        painter = painterResource(R.drawable.scuba_diving),
        contentDescription = null,
        modifier = Modifier
            .size(DesignSystem.size.main_icon_size)
            .rotate(40f)
            .alpha(0.4f)
    )
    DSCardTitleWithTextCentered(
        modifier = Modifier
            .fillMaxWidth()
            .alpha(0.4f),
        title = stringResource(R.string.empty_state_title),
        text = description,
    )
}

@Preview(showBackground = true)
@Composable
private fun DSEmptyStatePreview() {
    DSEmptyState(R.string.empty_state_no_organizations_found)
}