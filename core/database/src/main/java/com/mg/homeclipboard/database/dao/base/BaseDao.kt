package com.mg.homeclipboard.database.dao.base

import androidx.room.Insert
import androidx.room.Update

abstract class BaseDao<T> {

    @Insert
    abstract suspend fun insert(obj: T): Long

    @Insert
    abstract suspend fun insert(objc: List<T>)

    @Update
    abstract suspend fun update(obj: T)
}