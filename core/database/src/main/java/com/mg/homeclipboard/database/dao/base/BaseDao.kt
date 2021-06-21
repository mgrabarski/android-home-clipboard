package com.mg.homeclipboard.database.dao.base

import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {

    @Insert
    suspend fun insert(obj: T): Long

    @Insert
    suspend fun insert(objc: List<T>)

    @Update
    suspend fun update(obj: T)
}