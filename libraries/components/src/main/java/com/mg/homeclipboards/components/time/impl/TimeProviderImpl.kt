package com.mg.homeclipboards.components.time.impl

import com.mg.homeclipboards.components.time.DateFormatter
import com.mg.homeclipboards.components.time.TimeProvider
import com.mg.homeclipboards.components.time.TimeProvider.AppDateTime
import org.joda.time.DateTime

class TimeProviderImpl(
    private val formatter: DateFormatter
) : TimeProvider {

    override fun now(): AppDateTime {
        val now = DateTime.now()
        return AppDateTime(
            time = now,
            detailsFormat = formatter.detailsFormat(now.millis),
            shortFormat = formatter.shorterFormat(now.millis)
        )
    }
}