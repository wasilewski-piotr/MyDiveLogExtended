package org.itsolutions.mydivelog.app.view.menu.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.app.presentation.menu.home.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    HomeScreenContent()
}

@Composable
private fun HomeScreenContent() {
    Text("Home")
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreenContent()
}