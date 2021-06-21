package com.mg.homeclipboards.repository.local

import com.mg.homeclipboard.database.dao.UserDao
import com.mg.homeclipboards.domain.model.User
import com.mg.homeclipboards.domain.model.types.Id
import com.mg.homeclipboards.domain.model.types.NumberOfInserts
import com.mg.homeclipboards.domain.repository.UserRepository
import com.mg.homeclipboards.repository.ext.toEntity
import com.mg.homeclipboards.repository.ext.toUser

class LocalUserRepository(
    private val userDao: UserDao
) : UserRepository {

    override suspend fun insertUser(user: User): NumberOfInserts = userDao.insert(user.toEntity())

    override suspend fun findUserById(loginUserId: Id): User? {
        val userEntity = userDao.findById(loginUserId.toString()) ?: return null
        return userEntity.toUser()
    }
}