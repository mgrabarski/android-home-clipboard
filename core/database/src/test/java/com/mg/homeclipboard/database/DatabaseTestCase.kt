package com.mg.homeclipboard.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.test.core.app.ApplicationProvider
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

abstract class DatabaseTestCase {

    private val context: Context = ApplicationProvider.getApplicationContext()

    protected lateinit var database: ApplicationDatabase

    @BeforeEach
    internal open fun setUp() {
        database = Room
            .inMemoryDatabaseBuilder(context, ApplicationDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    @AfterEach
    open fun tearDown() {
        database.close()
    }
}