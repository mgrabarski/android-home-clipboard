package com.mg.homeclipboards.domain.data.providers.impl

import com.mg.homeclipboards.domain.data.providers.LoginUserProvider
import com.mg.homeclipboards.domain.interactor.user.LoginUserHolder
import com.mg.homeclipboards.domain.model.User

class LoginUserProviderImpl : LoginUserProvider {

    override fun get(): User = LoginUserHolder.loginUser
}