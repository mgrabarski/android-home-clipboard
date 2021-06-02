package com.mg.homeclipboard.database.dao

import androidx.room.Dao
import com.mg.homeclipboard.database.dao.base.BaseDao
import com.mg.homeclipboard.database.entities.ClipboardEntity

@Dao
abstract class ClipboardDao : BaseDao<ClipboardEntity>()