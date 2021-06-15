package com.mg.homeclipboards.domain.di

import com.mg.homeclipboards.domain.data.factories.ClipboardFactory
import com.mg.homeclipboards.domain.interactor.clipboard.CreateNewClipboard
import com.mg.homeclipboards.domain.interactor.user.CreateAndLoginNewUser
import org.koin.dsl.module

val domainModule = module {
    factory { ClipboardFactory(get()) }
    factory { CreateNewClipboard(get(), get()) }
    factory { CreateAndLoginNewUser(get(), get()) }
}