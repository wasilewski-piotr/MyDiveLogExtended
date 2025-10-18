package org.itsolutions.mydivelog.app.domain.validation

typealias Validator<T> = (T) -> ValidationError?

sealed interface ValidationError {
    data object Required : ValidationError
    data object ExistsInDatabase : ValidationError
    data object IsAfterToday : ValidationError
}