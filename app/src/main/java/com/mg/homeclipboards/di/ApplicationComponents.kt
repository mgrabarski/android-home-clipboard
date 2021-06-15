package com.mg.homeclipboards.di

import com.mg.homeclipboard.database.di.databaseModule
import com.mg.homeclipboards.add.di.addNewClipboardModule
import com.mg.homeclipboards.components.di.libComponentsModule
import com.mg.homeclipboards.domain.di.domainModule
import com.mg.homeclipboards.repository.di.repositoryModule
import com.mg.homeclipboards.splash.di.splashScreenModule
import com.mg.homeclipboards.storage.di.storageModule

val appModules = listOf(
    libComponentsModule,
    domainModule,
    addNewClipboardModule,
    databaseModule,
    repositoryModule,
    storageModule,
    splashScreenModule
)