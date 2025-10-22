package org.itsolutions.mydivelog.app.domain.model.results

import org.itsolutions.mydivelog.R

fun DataError.toMessageResource(): Int {
    return when (this) {
        DataError.Local.DISK_FULL -> TODO()
        DataError.Local.ELEMENT_ALREADY_EXISTS -> TODO()
        DataError.Local.CERTIFICATE_ALREADY_EXISTS -> R.string.error_certificate_already_exists
        DataError.Local.UNKNOWN -> TODO()
        DataError.Network.REQUEST_TIMEOUT -> TODO()
        DataError.Network.NO_INTERNET -> TODO()
        DataError.Network.UNKNOWN -> TODO()
        DataError.Local.MISSING_CERTIFICATE_ISSUE_DATE -> R.string.error_certificate_is_missing_date
        DataError.Local.NO_CERTIFICATES_FOUND_FOR_ORGANIZATION -> R.string.empty_state_no_certificates_found_for_this_organization
    }
}