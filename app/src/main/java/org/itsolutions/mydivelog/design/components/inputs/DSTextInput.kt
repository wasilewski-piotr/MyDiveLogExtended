package org.itsolutions.mydivelog.design.components.inputs

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.itsolutions.mydivelog.app.domain.validation.ValidationField

@Composable
fun DSTextInput(
    field: ValidationField<String>,
    modifier: Modifier = Modifier,
    label: String? = null,
    customError: ValidationOverrides = ValidationOverrides(),
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    DSInput(
        value = field.value,
        label = label,
        onValueChanged = { field.set(it) },
        errorText = errorTextFor(error = field.error, customError = customError),
        modifier = modifier,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        enabled = enabled,
        singleLine = singleLine,
        keyboardActions = keyboardActions,
        keyboardOptions = keyboardOptions,
    )
}