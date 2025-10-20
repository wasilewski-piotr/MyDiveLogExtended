package org.itsolutions.mydivelog.design.components.inputs

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.itsolutions.mydivelog.app.domain.validation.ValidationField
import org.itsolutions.mydivelog.design.components.pickers.DSDatePicker
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

@Composable
fun DSDateInput(
    field: ValidationField<LocalDate?>,
    modifier: Modifier = Modifier,
    label: String? = null,
    customError: ValidationOverrides = ValidationOverrides(),
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable () -> Unit = {
        Icon(Icons.Default.DateRange, contentDescription = null)
    },
    enabled: Boolean = true,
    singleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    val formatter = remember {
        DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.UK)
    }
    val displayText = remember(field.value) {
        field.value?.format(formatter) ?: ""
    }
    var pickerOpen by remember { mutableStateOf(false) }

    DSInput(
        value = displayText,
        label = label,
        onValueChanged = { },
        modifier = modifier,
        errorText = errorTextFor(error = field.error, customError = customError),
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        enabled = enabled,
        singleLine = singleLine,
        readOnly = true,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
        onClick = { pickerOpen = true }
    )

    if (pickerOpen) {
        DSDatePicker(
            onDismissPicker = { pickerOpen = false },
            onDateSelected = { field.set(it) }
        )
    }
}