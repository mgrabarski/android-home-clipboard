package com.mg.homeclipboards.domain.interactor.clipboard

import com.mg.homeclipboards.data.factories.ClipboardFactory
import com.mg.homeclipboards.data.fakes.nowTimeProvider
import com.mg.homeclipboards.domain.model.Clipboard
import com.mg.homeclipboards.domain.model.Icon.Fridge
import com.mg.homeclipboards.domain.repository.local.ClipboardRepository
import com.mg.homeclipboards.domain.state.Failure
import com.mg.homeclipboards.domain.state.Success
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
internal class CreateNewClipboardTest {

    private val clipboardRepository: ClipboardRepository = mockk<ClipboardRepository>()

    private val sut =
        CreateNewClipboard(
            factory = ClipboardFactory(nowTimeProvider()),
            clipboardRepository = clipboardRepository
        )

    @Test
    internal fun `Success creates new clipboard`() = runBlockingTest {
        coEvery { clipboardRepository.insertClipboard(any()) } returns 1

        sut.create(CORRECT_NAME, ICON).collect { result ->
            result.shouldBeInstanceOf<Success<Clipboard>>()

            coVerify(exactly = 1) { clipboardRepository.insertClipboard(any()) }
        }
    }

    @Test
    internal fun `Failure result when clipboard name is empty`() = runBlockingTest {
        coEvery { clipboardRepository.insertClipboard(any()) } returns 1

        sut.create(INCORRECT_NAME, ICON).collect { result ->
            result.shouldBeInstanceOf<Failure>()

            result.message shouldBe ERROR_CLIPBOARD_NAME_IS_EMPTY
            coVerify(exactly = 0) { clipboardRepository.insertClipboard(any()) }
        }
    }

    @Test
    internal fun `Failure result when clipboard repository return zero for insert clipboard`() =
        runBlockingTest {
            coEvery { clipboardRepository.insertClipboard(any()) } returns 0

            sut.create(CORRECT_NAME, ICON).collect { result ->
                result.shouldBeInstanceOf<Failure>()

                result.message shouldBe ERROR_SAVE_CLIPBOARD_NOT_PASS
                coVerify(exactly = 1) { clipboardRepository.insertClipboard(any()) }
            }
        }

    companion object {
        const val CORRECT_NAME = "name"
        const val INCORRECT_NAME = ""
        val ICON = Fridge
    }
}