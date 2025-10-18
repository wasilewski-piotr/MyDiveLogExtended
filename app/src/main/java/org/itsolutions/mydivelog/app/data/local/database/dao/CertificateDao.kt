package org.itsolutions.mydivelog.app.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.itsolutions.mydivelog.app.data.local.database.entity.CertificateEntity
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization

@Dao
interface CertificateDao {

    @Query("SELECT organization FROM certificates GROUP BY organization ORDER BY COUNT(organization) DESC")
    suspend fun getDistinctOrganizations(): List<DiveOrganization>

    @Query("SELECT * FROM certificates")
    suspend fun getAllCertificates(): List<CertificateEntity>

    @Query("SELECT EXISTS(SELECT 1 FROM certificates WHERE certificateNumber = :certificateNumber LIMIT 1)")
    suspend fun checkCertificateExistsByNumber(certificateNumber: String): Boolean

    @Insert(onConflict = OnConflictStrategy.Companion.ABORT)
    suspend fun createCertificate(certificate: CertificateEntity)

    @Delete
    suspend fun deleteCertificate(certificate: CertificateEntity)
}