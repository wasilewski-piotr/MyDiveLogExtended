package org.itsolutions.mydivelog.app

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.itsolutions.mydivelog.design.theme.MyDiveLogThemedActivity

class MyDiveLogActivity : MyDiveLogThemedActivity() {
    @Composable
    override fun Content() {
        Text("HELLO")
    }
}