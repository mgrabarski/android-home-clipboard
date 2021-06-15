package com.mg.homeclipboards.domain.interactor.user

import com.mg.homeclipboards.domain.data.storage.LoginUserIdStorage
import com.mg.homeclipboards.domain.repository.UserRepository
import com.mg.homeclipboards.domain.state.Failure
import com.mg.homeclipboards.domain.state.Success
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

const val ERROR_NO_USER_LOGIN = "No login user"
const val ERROR_NO_USER_IN_DATABASE = "No user in database"

class LoadLoginUser(
    private val userRepository: UserRepository,
    private val loginUserIdStorage: LoginUserIdStorage
) {

    suspend fun load() = flow {
        loginUserIdStorage.getLoginUserId().collect { loginUserId ->
            if (loginUserId == null) {
                emit(Failure(ERROR_NO_USER_LOGIN))
            } else {
                val loginUser = userRepository.findUserById(loginUserId)
                if (loginUser == null) {
                    emit(Failure(ERROR_NO_USER_IN_DATABASE))
                } else {
                    LoginUserHolder.loginUser = loginUser
                    emit(Success(loginUser))
                }
            }
        }
    }
}