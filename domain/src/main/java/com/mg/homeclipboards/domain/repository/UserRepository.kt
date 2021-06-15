package com.mg.homeclipboards.domain.repository

import com.mg.homeclipboards.domain.model.User
import com.mg.homeclipboards.domain.model.types.Id
import com.mg.homeclipboards.domain.model.types.NumberOfInserts

interface UserRepository {
    suspend fun insertUser(user: User): NumberOfInserts
    suspend fun findUserById(loginUserId: Id): User?
}