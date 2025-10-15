package org.itsolutions.mydivelog.app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.itsolutions.mydivelog.app.data.local.conventers.DateTimeConverter
import org.itsolutions.mydivelog.app.data.local.conventers.DiveOrganizationConverter
import org.itsolutions.mydivelog.app.data.local.database.dao.CertificateDao
import org.itsolutions.mydivelog.app.data.local.database.entity.CertificateEntity

@Database(
    entities = [CertificateEntity::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(DateTimeConverter::class, DiveOrganizationConverter::class)
abstract class MyDiveLogDatabase : RoomDatabase() {
    abstract fun certificateDao(): CertificateDao
}