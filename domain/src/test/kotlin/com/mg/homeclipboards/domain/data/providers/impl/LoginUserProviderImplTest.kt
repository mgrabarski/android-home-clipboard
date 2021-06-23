package com.mg.homeclipboards.domain.data.providers.impl

import com.mg.homeclipboards.domain.interactor.user.LoginUserHolder
import com.mg.homeclipboards.domain.model.User
import com.mg.homeclipboards.domain.model.types.Id
import io.kotest.matchers.types.shouldBeSameInstanceAs
import org.junit.jupiter.api.Test

internal class LoginUserProviderImplTest {

    private val sut = LoginUserProviderImpl()

    @Test
    internal fun `Provides user from login user holder`() {
        val user = User(Id.randomUUID())
        LoginUserHolder.loginUser = user

        val result = sut.get()

        result shouldBeSameInstanceAs user
    }
}