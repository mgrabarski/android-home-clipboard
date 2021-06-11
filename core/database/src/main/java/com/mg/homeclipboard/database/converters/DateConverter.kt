package com.mg.homeclipboard.database.converters

import androidx.room.TypeConverter
import com.mg.homeclipboards.constants.FORMAT_DETAILED_DATE
import org.joda.time.DateTime

class DateConverter {

    @TypeConverter
    fun fromStringToDateTime(dateTime: String): DateTime =
        DateTime.parse(dateTime, FORMAT_DETAILED_DATE)

    @TypeConverter
    fun fromDateTimeToString(dateTime: DateTime): String =
        FORMAT_DETAILED_DATE.print(dateTime)
}