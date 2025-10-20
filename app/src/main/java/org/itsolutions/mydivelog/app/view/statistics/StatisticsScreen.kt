package org.itsolutions.mydivelog.app.view.statistics

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.app.presentation.statistics.StatisticsViewModel
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme

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
    MyDiveLogTheme {
        StatisticsScreenContent()
    }
}