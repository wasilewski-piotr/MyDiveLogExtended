package org.itsolutions.mydivelog.app.data.mappers

import org.itsolutions.mydivelog.app.data.local.database.entity.CertificateEntity
import org.itsolutions.mydivelog.app.domain.model.Certificate

fun CertificateEntity.toDomain() = Certificate(
    certificateName = certificateName,
    certificateNumber = certificateNumber,
    organization = organization,
    issueDate = issueDate,
    issuedBy = issuedBy,
    issuerId = issuerId
)

fun Certificate.toEntity() = CertificateEntity(
    certificateName = certificateName,
    certificateNumber = certificateNumber,
    organization = organization,
    issueDate = issueDate,
    issuedBy = issuedBy,
    issuerId = issuerId
)