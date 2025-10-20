package org.itsolutions.mydivelog.design.components.progress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme

@Composable
fun DSCircularProgressIndicator() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CircularProgressIndicator(
            modifier = Modifier.size(100.dp)
        )
    }
}

@Preview
@Composable
private fun DSCircularProgressIndicatorPreview() {
    MyDiveLogTheme {
        DSCircularProgressIndicator()
    }
}