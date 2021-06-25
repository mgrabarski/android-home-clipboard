package com.mg.homeclipboards.domain.interactor.clipboard

import com.mg.homeclipboards.data.factories.anyClipboard
import com.mg.homeclipboards.domain.interactor.user.LoginUserHolder
import com.mg.homeclipboards.domain.model.Clipboard
import com.mg.homeclipboards.domain.model.User
import com.mg.homeclipboards.domain.model.types.Id
import com.mg.homeclipboards.domain.repository.ClipboardRepository
import com.mg.homeclipboards.domain.state.Success
import com.mg.homeclipboards.utils.testBlocking
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.collect
import org.junit.jupiter.api.Test

internal class LoadUserClipboardsTest {

    private val repository: ClipboardRepository = mockk()
    private val sut = LoadUserClipboards(repository)

    @Test
    internal fun `Loads and emit user clipboards`() = testBlocking {
        val clipboards = listOf(anyClipboard())
        LoginUserHolder.loginUser = User(Id.randomUUID())
        coEvery { repository.loadUserClipboards(any()) } returns clipboards

        sut.load().collect {
            it.shouldBeInstanceOf<Success<List<Clipboard>>>()
            it.result shouldContainAll clipboards
            it.result.size shouldBe clipboards.size
            coVerify(exactly = 1) { repository.loadUserClipboards(LoginUserHolder.loginUser.id) }
        }
    }
}