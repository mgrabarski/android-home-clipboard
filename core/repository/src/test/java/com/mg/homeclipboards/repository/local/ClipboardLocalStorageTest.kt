package com.mg.homeclipboards.repository.local

import com.mg.clipboards.test.coroutine.testBlocking
import com.mg.homeclipboard.database.dao.ClipboardDao
import com.mg.homeclipboards.repository.factories.anyClipboardEntity
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import org.junit.jupiter.api.Test

internal class ClipboardLocalStorageTest {

    private val clipboardDao: ClipboardDao = mockk()
    private val sut = ClipboardLocalStorage(clipboardDao)

    @Test
    internal fun `Use dao to insert clipboard`() = testBlocking {
        val entity = anyClipboardEntity()
        coEvery { clipboardDao.insert(entity) } returns 1

        sut.insert(entity)

        coVerify(exactly = 1) { clipboardDao.insert(entity) }
    }
}