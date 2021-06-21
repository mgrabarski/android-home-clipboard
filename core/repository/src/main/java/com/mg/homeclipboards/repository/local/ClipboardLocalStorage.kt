package com.mg.homeclipboards.repository.local

import com.mg.homeclipboard.database.dao.ClipboardDao
import com.mg.homeclipboard.database.entities.ClipboardEntity
import com.mg.homeclipboards.domain.model.types.NumberOfInserts

class ClipboardLocalStorage(
    private val clipboardDao: ClipboardDao
) {

    suspend fun insert(clipboardEntity: ClipboardEntity): NumberOfInserts =
        clipboardDao.insert(clipboardEntity)
}