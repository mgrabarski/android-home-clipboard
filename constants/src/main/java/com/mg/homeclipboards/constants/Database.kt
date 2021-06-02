package com.mg.homeclipboards.constants

const val DATABASE_VERSION = 1
const val DATABASE_NAME = "HomeClipboardsDB.db"

object Entities {

    object Clipboard {
        const val TABLE_CLIPBOARD = "clipboard"
        const val TABLE_CLIPBOARD_ID = "id"
        const val TABLE_CLIPBOARD_NAME = "name"
        const val TABLE_CLIPBOARD_ICON = "icon"
        const val TABLE_CLIPBOARD_CREATE_DATE = "create_date"
    }
}