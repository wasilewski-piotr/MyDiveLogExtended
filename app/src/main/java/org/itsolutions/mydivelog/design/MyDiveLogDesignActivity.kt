package org.itsolutions.mydivelog.design

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity

class MyDiveLogDesignActivity : MyDiveLogThemedActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun TopBar() {
        TopAppBar(title = {Text("My Dive Log Design System")})
    }

    @Composable
    override fun Content() {

    }
}