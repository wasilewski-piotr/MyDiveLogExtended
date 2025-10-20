package org.itsolutions.mydivelog.design.components.states.empty

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.unit.dp
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.components.text.DSCardTitleWithTextCentered

@Composable
fun DSEmptyState(@StringRes description: Int) {
    DSEmptyState(stringResource(description))
}

@Composable
fun DSEmptyState(description: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DSEmptyStateContent(description)
    }
}

@Composable
internal fun DSEmptyStateContent(description: String) {
    Image(
        painter = painterResource(R.drawable.scuba_diving),
        contentDescription = null,
        modifier = Modifier.size(100.dp).rotate(40f).alpha(0.4f)
    )
    DSCardTitleWithTextCentered(
        modifier = Modifier.fillMaxWidth().alpha(0.4f),
        title = stringResource(R.string.empty_state_title),
        text = description,
    )
}

@Preview
@Composable
private fun DSEmptyStatePreview() {
    DSEmptyState(R.string.empty_state_no_organizations_found)
}