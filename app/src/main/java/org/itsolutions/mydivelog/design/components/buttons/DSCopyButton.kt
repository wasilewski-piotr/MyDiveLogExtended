package org.itsolutions.mydivelog.design.components.buttons

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.delay
import org.itsolutions.mydivelog.R

@Composable
fun DSCopyButton(
    textToCopy: String,
    initialText: String = "Copy",
    copiedText: String = "Copied",
    resetDelay: Long = 3000L,
) {
    val context = LocalContext.current
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("Copied Text", textToCopy)
    var isCopied by remember { mutableStateOf(false) }

    val icon = if (isCopied) R.drawable.check else R.drawable.content_copy
    val label = if (isCopied) copiedText else initialText

    LaunchedEffect(isCopied) {
        if (isCopied) {
            delay(resetDelay)
            isCopied = false
        }
    }

    DSSecondaryButtonSmall(
        text = label,
        leadingIcon = icon
    ) {
        clipboard.setPrimaryClip(clip)
        isCopied = true
    }
}