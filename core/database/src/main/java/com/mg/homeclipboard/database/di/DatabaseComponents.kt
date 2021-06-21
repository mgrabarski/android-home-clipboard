package com.mg.homeclipboard.database.di

import com.mg.homeclipboard.database.ApplicationDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single { ApplicationDatabase.buildDatabase(androidContext()) }
    factory { (get() as ApplicationDatabase).clipboardDao() }
    factory { (get() as ApplicationDatabase).userDao() }
}