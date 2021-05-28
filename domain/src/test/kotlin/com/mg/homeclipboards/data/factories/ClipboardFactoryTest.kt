package com.mg.homeclipboards.data.factories

import com.mg.homeclipboards.data.fakes.FakeTimeProvider
import com.mg.homeclipboards.domain.model.Icon.Fridge
import com.mg.homeclipboards.domain.model.types.Id
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import org.joda.time.DateTime
import org.junit.jupiter.api.Test

internal class ClipboardFactoryTest {

    private val fakeTimeProvider = FakeTimeProvider(DateTime.now())
    private val sut = ClipboardFactory(fakeTimeProvider)

    @Test
    fun `Creates new clipboard`() {
        val result = sut.create(ANY_NAME, ANY_ICON)

        result.displayName shouldBe ANY_NAME
        result.icon shouldBe ANY_ICON
        result.id.shouldBeInstanceOf<Id>()
        result.createDate.date shouldBe fakeTimeProvider.dateTime
    }

    companion object {
        private const val ANY_NAME = "name"
        private val ANY_ICON = Fridge
    }
}