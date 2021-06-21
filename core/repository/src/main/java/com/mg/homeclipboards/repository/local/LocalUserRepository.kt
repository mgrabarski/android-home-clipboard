package com.mg.homeclipboards.repository.local

import com.mg.homeclipboards.domain.model.User
import com.mg.homeclipboards.domain.model.types.Id
import com.mg.homeclipboards.domain.model.types.NumberOfInserts
import com.mg.homeclipboards.domain.repository.UserRepository

class LocalUserRepository : UserRepository {

    override suspend fun insertUser(user: User): NumberOfInserts {
        return 1
    }

    override suspend fun findUserById(loginUserId: Id): User? {
        return null
    }
}