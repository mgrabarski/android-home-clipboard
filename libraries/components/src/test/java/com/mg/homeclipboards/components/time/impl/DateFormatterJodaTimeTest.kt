package com.mg.homeclipboards.components.time.impl

import io.kotest.matchers.shouldBe
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.junit.jupiter.api.Test

internal class DateFormatterJodaTimeTest {

    private val sut = DateFormatterJodaTime(
        DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss"),
        DateTimeFormat.forPattern("dd-MM-yyyy")
    )

    @Test
    fun `Formats date to pattern`() {
        val now = DateTime.parse("2010-06-30T01:20+02:00")

        sut.detailsFormat(now.millis) shouldBe "30-06-2010 01:20:00"
        sut.shorterFormat(now.millis) shouldBe "30-06-2010"
    }
}