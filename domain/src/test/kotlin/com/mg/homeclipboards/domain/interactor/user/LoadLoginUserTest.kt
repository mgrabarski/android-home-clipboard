package com.mg.homeclipboards.domain.interactor.user

import com.mg.homeclipboards.domain.data.storage.LoginUserIdStorage
import com.mg.homeclipboards.domain.model.User
import com.mg.homeclipboards.domain.model.types.Id
import com.mg.homeclipboards.domain.repository.UserRepository
import com.mg.homeclipboards.domain.state.Failure
import com.mg.homeclipboards.domain.state.Success
import com.mg.homeclipboards.utils.testBlocking
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
internal class LoadLoginUserTest {

    private val repository: UserRepository = mockk()
    private val storage: LoginUserIdStorage = mockk()

    private val sut = LoadLoginUser(TestCoroutineDispatcher(), repository, storage)

    @Test
    internal fun `Load emit error when in storage are no login user id`() = testBlocking {
        coEvery { storage.getLoginUserId() } returns flow { emit(null) }

        sut.load().collect {
            it.shouldBeInstanceOf<Failure>()
            it.message shouldBe ERROR_NO_USER_LOGIN
        }
    }

    @Test
    internal fun `Load emit error when repository not find user`() = testBlocking {
        coEvery { storage.getLoginUserId() } returns flow { emit(Id.randomUUID()) }
        coEvery { repository.findUserById(any()) } returns null

        sut.load().collect {
            it.shouldBeInstanceOf<Failure>()
            it.message shouldBe ERROR_NO_USER_IN_DATABASE
        }
    }

    @Test
    internal fun `Loads emit success with user`() = testBlocking {
        val id = Id.randomUUID()
        val user = User(id)
        coEvery { storage.getLoginUserId() } returns flow { emit(id) }
        coEvery { repository.findUserById(id) } returns user

        sut.load().collect {
            it.shouldBeInstanceOf<Success<User>>()
            it.result shouldBeSameInstanceAs user
        }
    }

    @Test
    internal fun `Load user would set in on LoginUserHolder`() = testBlocking {
        val id = Id.randomUUID()
        val user = User(id)
        coEvery { storage.getLoginUserId() } returns flow { emit(id) }
        coEvery { repository.findUserById(id) } returns user

        sut.load().collect {
            LoginUserHolder.loginUser shouldBe user
        }
    }
}