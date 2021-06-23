package com.mg.clipboards.test.data

import com.mg.homeclipboards.domain.data.providers.LoginUserProvider
import com.mg.homeclipboards.domain.model.User
import com.mg.homeclipboards.domain.model.types.Id

class TestLoginUserProvider : LoginUserProvider {
    override fun get(): User = User(Id.randomUUID())
}