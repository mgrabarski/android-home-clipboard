package com.mg.homeclipboards.domain.interactor.user

import com.mg.homeclipboards.domain.model.User
import com.mg.homeclipboards.domain.repository.UserRepository
import com.mg.homeclipboards.domain.state.Failure
import com.mg.homeclipboards.domain.state.Success
import com.mg.homeclipboards.utils.testBlocking
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.collect
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class CreateAndLoginNewUserTest {

    private val repository: UserRepository = mockk()
    private val sut = CreateAndLoginNewUser(repository)

    @Test
    internal fun `Creates and set login user in holder`() = testBlocking {
        coEvery { repository.insertUser(any()) } returns 1

        sut.create()

        assertNotNull(LoginUserHolder.loginUser)
    }

    @Test
    internal fun `Creates user in repository`() = testBlocking {
        coEvery { repository.insertUser(any()) } returns 1

        sut.create().collect()

        coVerify(exactly = 1) { repository.insertUser(any()) }
    }

    @Test
    internal fun `Create user emit failure when repository return 0 inserts`() = testBlocking {
        coEvery { repository.insertUser(any()) } returns 0

        sut.create().collect { result ->
            result.shouldBeInstanceOf<Failure>()
        }
    }

    @Test
    internal fun `Creates user emit success result`() = testBlocking {
        coEvery { repository.insertUser(any()) } returns 1

        sut.create().collect { result ->
            result.shouldBeInstanceOf<Success<User>>()
        }
    }
}