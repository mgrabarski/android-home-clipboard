package com.mg.homeclipboard.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mg.homeclipboard.database.converters.DateConverter
import com.mg.homeclipboard.database.dao.ClipboardDao
import com.mg.homeclipboard.database.dao.UserDao
import com.mg.homeclipboard.database.entities.ClipboardEntity
import com.mg.homeclipboard.database.entities.UserEntity
import com.mg.homeclipboards.constants.DATABASE_NAME
import com.mg.homeclipboards.constants.DATABASE_VERSION

@Database(
    entities = [
        UserEntity::class,
        ClipboardEntity::class
    ], version = DATABASE_VERSION
)
@TypeConverters(DateConverter::class)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun clipboardDao(): ClipboardDao

    abstract fun userDao(): UserDao

    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ApplicationDatabase::class.java,
                DATABASE_NAME
            ).build()
    }
}