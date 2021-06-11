package com.mg.homeclipboards.repository.local

import com.mg.homeclipboard.database.dao.ClipboardDao
import com.mg.homeclipboard.database.entities.ClipboardEntity

class ClipboardLocalStorage(
    private val clipboardDao: ClipboardDao
) {

    suspend fun insert(clipboardEntity: ClipboardEntity) = clipboardDao.insert(clipboardEntity)
}