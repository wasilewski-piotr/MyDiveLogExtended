package org.itsolutions.mydivelog.app.view.certificates.create

import kotlinx.serialization.Serializable

sealed interface CreateCertificateRoutes {

    @Serializable
    data object SelectOrganization : CreateCertificateRoutes

    @Serializable
    data object InputCertificateName : CreateCertificateRoutes

    @Serializable
    data object InputCertificateIssuer : CreateCertificateRoutes

    @Serializable
    data object ConfirmCertificateData : CreateCertificateRoutes

    @Serializable
    data object CreateCertificate : CreateCertificateRoutes
}