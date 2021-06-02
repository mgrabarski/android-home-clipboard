package com.mg.homeclipboard.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mg.homeclipboards.constants.DATABASE_NAME
import com.mg.homeclipboards.constants.DATABASE_VERSION

@Database(
    entities = [
    ], version = DATABASE_VERSION
)
abstract class ApplicationDatabase : RoomDatabase() {

    companion object {
        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ApplicationDatabase::class.java,
                DATABASE_NAME
            ).build()
    }
}