package org.itsolutions.mydivelog.app.data.local.conventers

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import org.itsolutions.mydivelog.app.domain.model.DiveOrganization

@ProvidedTypeConverter
class DiveOrganizationConverter {
    @TypeConverter
    fun fromDiveOrganization(organization: DiveOrganization?): String? = organization?.name

    @TypeConverter
    fun toDiveOrganization(organization: String?): DiveOrganization? =
        organization?.let { DiveOrganization.valueOf(it) }
}