package com.mg.homeclipboards.components.time.impl

import com.mg.homeclipboards.constants.FORMAT_DETAILED_DATE
import com.mg.homeclipboards.constants.FORMAT_SHORTER_DATE
import io.kotest.matchers.comparables.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class TimeProviderImplTest {

    private val formatter = DateFormatterJodaTime(FORMAT_DETAILED_DATE, FORMAT_SHORTER_DATE)
    private val sut = TimeProviderImpl(formatter)

    @Test
    fun `Result should contains date greater then zero`() {
        val result = sut.now()

        result.time.millis shouldBeGreaterThan 0L
        result.detailsFormat.isNotEmpty() shouldBe true
        result.shortFormat.isNotEmpty() shouldBe true
    }
}