package com.mg.homeclipboards.domain.interactor.user

import com.mg.homeclipboards.domain.model.User
import com.mg.homeclipboards.domain.model.types.Id

class CreateAndLoginNewUser {

    fun create() {
        val user = User(id = Id.randomUUID())
        LoginUserHolder.loginUser = user
    }
}