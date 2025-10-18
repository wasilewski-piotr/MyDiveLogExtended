package org.itsolutions.mydivelog.app.domain.validation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ValidationField<T>(
    initialValue: T,
    private vararg val validators: Validator<T>
) {
    var value by mutableStateOf(initialValue)
    var error by mutableStateOf<ValidationError?>(null)

    fun set(new: T) {
        value = new
        error = null
    }

    fun set(newError: ValidationError) {
        error = newError
    }

    fun validate(): Boolean {
        error = validators.firstNotNullOfOrNull { it(value) }
        return error == null
    }
}

fun validateAll(vararg fields: ValidationField<*>): Boolean =
    fields.fold(true) { acc, field -> field.validate() && acc }