package com.mg.homeclipboards.repository.domainimpl

import com.mg.clipboards.test.coroutine.testBlocking
import com.mg.homeclipboards.repository.factories.anyClipboard
import com.mg.homeclipboards.repository.local.ClipboardLocalStorage
import com.mg.homeclipboards.repository.remote.ClipboardRemoteStorage
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.spyk
import org.junit.jupiter.api.Test

internal class HomeClipboardRepositoryTest {

    private val localStorage: ClipboardLocalStorage = mockk()
    private val remoteStorage: ClipboardRemoteStorage = spyk()
    private val sut = HomeClipboardRepository(localStorage, remoteStorage)

    @Test
    internal fun `Saves clipboard in local storage should return number of inserts`() =
        testBlocking {
            coEvery { localStorage.insert(any()) } returns 1

            val result = sut.insertClipboard(anyClipboard())

            result shouldBe 1
            coVerify(exactly = 1) { remoteStorage.insert(any()) }
        }

    @Test
    internal fun `Save clipboard in local storage should return zero when local storage return zero inserts`() =
        testBlocking {
            coEvery { localStorage.insert(any()) } returns 0

            val result = sut.insertClipboard(anyClipboard())

            result shouldBe 0
            coVerify(exactly = 0) { remoteStorage.insert(any()) }
        }
}