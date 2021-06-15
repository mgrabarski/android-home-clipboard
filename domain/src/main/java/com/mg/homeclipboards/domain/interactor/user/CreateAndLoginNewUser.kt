package com.mg.homeclipboards.domain.interactor.user

import com.mg.homeclipboards.domain.model.User
import com.mg.homeclipboards.domain.model.types.Id
import com.mg.homeclipboards.domain.repository.UserRepository

class CreateAndLoginNewUser(
    private val repository: UserRepository
) {

    suspend fun create() {
        val user = User(id = Id.randomUUID())

        val numberOfInserts = repository.insertUser(user)

        LoginUserHolder.loginUser = user
    }
}