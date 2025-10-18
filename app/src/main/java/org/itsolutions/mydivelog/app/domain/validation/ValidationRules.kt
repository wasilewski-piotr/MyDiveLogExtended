package org.itsolutions.mydivelog.app.domain.validation

import java.time.LocalDate

object Rules {
    fun notEmpty(): Validator<String> = { if (it.trim().isBlank()) ValidationError.Required else null }
    fun afterToday(): Validator<LocalDate?> = {
        val today = LocalDate.now()
        if (it == null) {
            ValidationError.Required
        } else {
            if (it.isAfter(today)) ValidationError.IsAfterToday else null
        }
    }
}