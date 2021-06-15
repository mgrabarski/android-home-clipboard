package com.mg.homeclipboards.domain.interactor.user

import com.mg.homeclipboards.domain.data.storage.LoginUserIdStorage
import com.mg.homeclipboards.domain.repository.UserRepository
import com.mg.homeclipboards.domain.state.Failure
import com.mg.homeclipboards.utils.testBlocking
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import org.junit.jupiter.api.Test

internal class LoadLoginUserTest {

    private val repository: UserRepository = mockk()
    private val storage: LoginUserIdStorage = mockk()

    private val sut = LoadLoginUser(repository, storage)

    @Test
    internal fun `Load emit error when in storage are no login user id`() = testBlocking {
        coEvery { storage.getLoginUserId() } returns flow { null }

        sut.load().collect {
            it.shouldBeInstanceOf<Failure>()
            it.message shouldBe ERROR_NO_USER_LOGIN
        }
    }
}