package com.mg.homeclipboards.data.fakes

import com.mg.homeclipboards.components.time.TimeProvider
import com.mg.homeclipboards.components.time.TimeProvider.AppDateTime
import org.joda.time.DateTime

class FakeTimeProvider(
    val dateTime: DateTime
) : TimeProvider {

    override fun now() = AppDateTime(
        time = dateTime,
        shortFormat = "",
        detailsFormat = ""
    )
}