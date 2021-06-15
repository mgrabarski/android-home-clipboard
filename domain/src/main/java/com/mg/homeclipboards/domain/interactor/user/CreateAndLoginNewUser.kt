package com.mg.homeclipboards.domain.interactor.user

import com.mg.homeclipboards.domain.data.storage.LoginUserIdStorage
import com.mg.homeclipboards.domain.model.User
import com.mg.homeclipboards.domain.model.types.Id
import com.mg.homeclipboards.domain.repository.UserRepository
import com.mg.homeclipboards.domain.state.Failure
import com.mg.homeclipboards.domain.state.Success
import kotlinx.coroutines.flow.flow

const val ERROR_INSERT_NEW_USER = "Problem with insert new user"

class CreateAndLoginNewUser(
    private val repository: UserRepository,
    private val loginUserIdStorage: LoginUserIdStorage
) {

    suspend fun create() = flow {
        val user = User(id = Id.randomUUID())

        val numberOfInserts = repository.insertUser(user)

        if (numberOfInserts > 0) {
            LoginUserHolder.loginUser = user
            loginUserIdStorage.storeLoginUserId(user.id)
            emit(Success(user))
        } else {
            emit(Failure(ERROR_INSERT_NEW_USER))
        }
    }
}