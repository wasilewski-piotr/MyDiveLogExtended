package org.itsolutions.mydivelog.design.components.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme

@Composable
fun DSAlertDialog(
    title: String,
    description: String,
    confirmButtonText: String,
    dismissButtonText: String,
    onDismissDialog: () -> Unit,
    onConfirm: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismissDialog,
        title = { Text(title) },
        text = { Text(description) },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(confirmButtonText)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissDialog) {
                Text(dismissButtonText)
            }
        }
    )
}

@Preview
@Composable
private fun DSAlertDialogPreview() {
    MyDiveLogTheme {
        DSAlertDialog(
            title = "Dialog",
            description = "Dialog Description",
            dismissButtonText = "Dismiss",
            confirmButtonText = "Confirm",
            onDismissDialog = { },
            onConfirm = { }
        )
    }
}