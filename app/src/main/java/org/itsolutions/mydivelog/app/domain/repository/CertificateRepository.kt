package org.itsolutions.mydivelog.app.domain.repository

import org.itsolutions.mydivelog.app.domain.model.Certificate
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import org.itsolutions.mydivelog.app.domain.model.results.DataError
import org.itsolutions.mydivelog.app.domain.model.results.Result

interface CertificateRepository {
    suspend fun getDistinctOrganizations(): Result<List<DiveOrganization>, DataError>
    suspend fun getAllCertificates(): Result<List<Certificate>, DataError>
    suspend fun getCertificatesForOrganization(diveOrganization: DiveOrganization): Result<List<Certificate>, DataError>
    suspend fun createCertificate(certificate: Certificate): Result<Unit, DataError>
    suspend fun deleteCertificate(certificate: Certificate): Result<Unit, DataError>
    suspend fun checkCertificateExistsByNumber(certificateNumber: String): Boolean
}