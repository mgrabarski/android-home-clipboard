package com.mg.homeclipboards.domain.interactor.user

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class CreateAndLoginNewUserTest {

    private val sut = CreateAndLoginNewUser()

    @Test
    internal fun `Creates and set login user in holder`() {
        sut.create()

        assertNotNull(LoginUserHolder.loginUser)
    }
}