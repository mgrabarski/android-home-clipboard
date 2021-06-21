package com.mg.homeclipboard.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mg.homeclipboards.constants.Entities.User.TABLE_USER
import com.mg.homeclipboards.constants.Entities.User.TABLE_USER_ID

@Entity(tableName = TABLE_USER)
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = TABLE_USER_ID)
    val id: String
)