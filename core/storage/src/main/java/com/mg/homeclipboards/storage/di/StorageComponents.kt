package com.mg.homeclipboards.storage.di

import com.mg.homeclipboards.domain.data.storage.LoginUserIdStorage
import com.mg.homeclipboards.storage.impl.LoginUserIdDataStorage
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val storageModule = module {
    single<LoginUserIdStorage> { LoginUserIdDataStorage(androidContext()) }
}