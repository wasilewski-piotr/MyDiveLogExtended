package org.itsolutions.mydivelog.design.components.dialogs

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.design.theme.MyDiveLogTheme
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

@Composable
internal fun DSDatePicker(
    onDismissPicker: () -> Unit,
    onDateSelected: (LocalDate) -> Unit,
) {
    val datePickerState = rememberDatePickerState(selectableDates = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            return utcTimeMillis <= System.currentTimeMillis()
        }

        override fun isSelectableYear(year: Int): Boolean {
            return year <= LocalDate.now().year
        }
    })

    DatePickerDialog(onDismissRequest = onDismissPicker, confirmButton = {
        TextButton(onClick = {
            val millis = datePickerState.selectedDateMillis
            millis?.let {
                val localDate =
                    Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault()).toLocalDate()
                onDateSelected(localDate)
            }
            onDismissPicker()
        }) {
            Text(stringResource(R.string.ok))
        }
    }, dismissButton = {
        TextButton(onDismissPicker) {
            Text(stringResource(R.string.cancel))
        }
    }) {
        DatePicker(datePickerState)
    }
}

@Preview
@Composable
private fun DSDatePickerPreview() {
    MyDiveLogTheme {
        DSDatePicker(
            onDismissPicker = { },
            onDateSelected = { }
        )
    }
}