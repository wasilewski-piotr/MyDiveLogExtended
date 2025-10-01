package org.itsolutions.mydivelog.app.view.menu.dives

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.app.presentation.menu.dives.DivesViewModel

@Composable
fun DivesScreen(viewModel: DivesViewModel) {
    DivesScreenContent()
}

@Composable
private fun DivesScreenContent() {
    Text("My Dives")
}

@Preview
@Composable
private fun DivesScreenPreview() {
    DivesScreenContent()
}