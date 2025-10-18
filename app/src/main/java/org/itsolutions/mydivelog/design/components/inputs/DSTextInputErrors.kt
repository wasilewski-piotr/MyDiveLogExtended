package org.itsolutions.mydivelog.design.components.inputs

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import org.itsolutions.mydivelog.R
import org.itsolutions.mydivelog.app.domain.validation.ValidationError

@Composable
internal fun errorTextFor(
    error: ValidationError?,
    defaultError: ValidationStrings = defaultValidationStrings(),
    customError: ValidationOverrides = ValidationOverrides()
) = when (error) {
    ValidationError.Required -> stringResource(customError.required ?: defaultError.required)
    ValidationError.ExistsInDatabase -> stringResource(customError.existsInDatabase ?: defaultError.existsInDatabase)
    ValidationError.IsAfterToday -> stringResource(customError.dateAfterToday ?: defaultError.dateAfterToday)
    null -> null
}

data class ValidationStrings(
    @StringRes val required: Int,
    @StringRes val existsInDatabase: Int,
    @StringRes val dateAfterToday: Int,
)

data class ValidationOverrides(
    @StringRes val required: Int? = null,
    @StringRes val existsInDatabase: Int? = null,
    @StringRes val dateAfterToday: Int? = null,
)

@Composable
fun defaultValidationStrings() = ValidationStrings(
    required = R.string.empty_field_error_text,
    existsInDatabase = R.string.exists_in_database,
    dateAfterToday = R.string.selected_date_after_today
)