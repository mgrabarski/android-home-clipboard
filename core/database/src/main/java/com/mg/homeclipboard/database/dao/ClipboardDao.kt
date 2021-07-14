package com.mg.homeclipboard.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.mg.homeclipboard.database.dao.base.BaseDao
import com.mg.homeclipboard.database.entities.ClipboardEntity
import com.mg.homeclipboard.database.types.LocalDatabaseId
import com.mg.homeclipboards.constants.Entities.Clipboard.TABLE_CLIPBOARD
import com.mg.homeclipboards.constants.Entities.Clipboard.TABLE_CLIPBOARD_ID
import com.mg.homeclipboards.constants.Entities.Clipboard.TABLE_CLIPBOARD_USER_ID

@Dao
abstract class ClipboardDao : BaseDao<ClipboardEntity> {

    @Query("SELECT * FROM $TABLE_CLIPBOARD WHERE $TABLE_CLIPBOARD_ID = :id")
    abstract suspend fun findById(id: LocalDatabaseId): ClipboardEntity?

    @Query("SELECT * FROM $TABLE_CLIPBOARD WHERE $TABLE_CLIPBOARD_USER_ID = :userId")
    abstract suspend fun getUserClipboards(userId: LocalDatabaseId): List<ClipboardEntity>
}