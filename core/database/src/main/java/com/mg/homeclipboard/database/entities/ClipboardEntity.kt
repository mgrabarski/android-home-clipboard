package com.mg.homeclipboard.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.mg.homeclipboard.database.types.LocalDatabaseId
import com.mg.homeclipboards.constants.Entities.Clipboard.TABLE_CLIPBOARD
import com.mg.homeclipboards.constants.Entities.Clipboard.TABLE_CLIPBOARD_CREATE_DATE
import com.mg.homeclipboards.constants.Entities.Clipboard.TABLE_CLIPBOARD_ICON
import com.mg.homeclipboards.constants.Entities.Clipboard.TABLE_CLIPBOARD_ID
import com.mg.homeclipboards.constants.Entities.Clipboard.TABLE_CLIPBOARD_NAME
import com.mg.homeclipboards.constants.Entities.Clipboard.TABLE_CLIPBOARD_USER_ID
import com.mg.homeclipboards.constants.Entities.User.TABLE_USER_ID
import org.joda.time.DateTime

@Entity(
    tableName = TABLE_CLIPBOARD, foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = [TABLE_USER_ID],
        childColumns = [TABLE_CLIPBOARD_USER_ID],
        onDelete = ForeignKey.CASCADE
    )]
)
class ClipboardEntity(
    @PrimaryKey
    @ColumnInfo(name = TABLE_CLIPBOARD_ID)
    val id: LocalDatabaseId,
    @ColumnInfo(name = TABLE_CLIPBOARD_NAME)
    var name: String,
    @ColumnInfo(name = TABLE_CLIPBOARD_ICON)
    var icon: String,
    @ColumnInfo(name = TABLE_CLIPBOARD_CREATE_DATE)
    var createDate: DateTime,
    @ColumnInfo(name = TABLE_CLIPBOARD_USER_ID)
    val userId: String
)