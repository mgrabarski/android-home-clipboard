package com.mg.homeclipboard.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.mg.homeclipboard.database.dao.base.BaseDao
import com.mg.homeclipboard.database.entities.UserEntity
import com.mg.homeclipboards.constants.Entities.User.TABLE_USER
import com.mg.homeclipboards.constants.Entities.User.TABLE_USER_ID

@Dao
abstract class UserDao : BaseDao<UserEntity> {

    @Query("SELECT * FROM $TABLE_USER WHERE $TABLE_USER_ID = :id")
    abstract fun findById(id: String): UserEntity?
}