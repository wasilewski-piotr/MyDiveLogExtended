package org.itsolutions.mydivelog.app.view.menu.statistics

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.app.presentation.menu.statistics.StatisticsViewModel

@Composable
fun StatisticsScreen(viewModel: StatisticsViewModel) {
    StatisticsScreenContent()
}

@Composable
fun StatisticsScreenContent() {
    Text("Statistics")
}

@Preview
@Composable
private fun StatisticsScreenPreview() {
    StatisticsScreenContent()
}