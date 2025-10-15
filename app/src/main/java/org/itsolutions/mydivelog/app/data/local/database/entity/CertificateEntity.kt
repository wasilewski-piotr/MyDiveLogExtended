package org.itsolutions.mydivelog.app.data.local.database.entity

import androidx.room.Entity
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization
import java.time.LocalDate

@Entity(
    tableName = "certificates",
    primaryKeys = ["certificateNumber", "organization"]
)
data class CertificateEntity(
    val certificateName: String,
    val certificateNumber: String,
    val organization: DiveOrganization,
    val issueDate: LocalDate,
    val issuedBy: String,
    val issuerId: String,
)