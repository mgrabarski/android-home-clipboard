package com.mg.homeclipboards.domain.interactor.clipboard

import com.mg.homeclipboards.data.factories.ClipboardFactory
import com.mg.homeclipboards.data.fakes.nowTimeProvider
import com.mg.homeclipboards.domain.model.Clipboard
import com.mg.homeclipboards.domain.model.Icon.Fridge
import com.mg.homeclipboards.domain.state.Failure
import com.mg.homeclipboards.domain.state.Success
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
internal class CreateNewClipboardTest {

    private val sut = CreateNewClipboard(ClipboardFactory(nowTimeProvider()))

    @Test
    internal fun `Success creates new clipboard`() = runBlockingTest {
        sut.create(CORRECT_NAME, ICON).collect { result ->
            result.shouldBeInstanceOf<Success<Clipboard>>()
        }
    }

    @Test
    internal fun `Failure result when clipboard name is empty`() = runBlockingTest {
        sut.create(INCORRECT_NAME, ICON).collect { result ->
            result.shouldBeInstanceOf<Failure>()
            result.message shouldBe ERROR_CLIPBOARD_NAME_IS_EMPTY
        }
    }

    companion object {
        const val CORRECT_NAME = "name"
        const val INCORRECT_NAME = ""
        val ICON = Fridge
    }
}