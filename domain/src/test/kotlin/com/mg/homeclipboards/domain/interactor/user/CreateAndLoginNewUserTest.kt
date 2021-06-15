package com.mg.homeclipboards.domain.interactor.user

import com.mg.homeclipboards.domain.repository.UserRepository
import com.mg.homeclipboards.utils.testBlocking
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
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

        sut.create()

        coVerify(exactly = 1) { repository.insertUser(any()) }
    }
}