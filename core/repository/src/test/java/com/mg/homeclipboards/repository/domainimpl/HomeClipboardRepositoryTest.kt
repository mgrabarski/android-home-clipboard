package com.mg.homeclipboards.repository.domainimpl

import com.mg.clipboards.test.coroutine.testBlocking
import com.mg.homeclipboards.repository.factories.anyClipboard
import com.mg.homeclipboards.repository.local.ClipboardLocalStorage
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.jupiter.api.Test

internal class HomeClipboardRepositoryTest {

    private val localStorage: ClipboardLocalStorage = mockk()
    private val sut = HomeClipboardRepository(localStorage)

    @Test
    internal fun `Saves clipboard in local storage should return number of inserts`() =
        testBlocking {
            coEvery { localStorage.insert(any()) } returns 1

            val result = sut.insertClipboard(anyClipboard())

            result shouldBe 1
        }

    @Test
    internal fun `Save clipboard in local storage should return zero when local storage return zero inserts`() =
        testBlocking {
            coEvery { localStorage.insert(any()) } returns 0

            val result = sut.insertClipboard(anyClipboard())

            result shouldBe 0
        }
}