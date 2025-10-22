package org.itsolutions.mydivelog.app.view.buddies

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.app.presentation.buddies.BuddiesViewModel

@Composable
fun BuddiesScreen(viewModel: BuddiesViewModel) {
    BuddiesScreenContent()
}

@Composable
private fun BuddiesScreenContent() {
    Text("Buddies")
}

@Preview(showBackground = true)
@Composable
private fun BuddiesScreenPreview() {
    BuddiesScreenContent()
}