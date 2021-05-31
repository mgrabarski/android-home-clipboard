package com.mg.homeclipboards.di

import com.mg.homeclipboards.components.di.libComponentsModule
import com.mg.homeclipboards.domain.di.domainModule

val appModules = listOf(
    libComponentsModule,
    domainModule
)