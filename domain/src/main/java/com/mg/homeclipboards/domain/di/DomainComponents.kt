package com.mg.homeclipboards.domain.di

import com.mg.homeclipboards.domain.data.factories.ClipboardFactory
import com.mg.homeclipboards.domain.data.providers.LoginUserProvider
import com.mg.homeclipboards.domain.data.providers.impl.LoginUserProviderImpl
import com.mg.homeclipboards.domain.interactor.clipboard.CreateNewClipboard
import com.mg.homeclipboards.domain.interactor.clipboard.LoadUserClipboards
import com.mg.homeclipboards.domain.interactor.user.CreateAndLoginNewUser
import com.mg.homeclipboards.domain.interactor.user.LoadLoginUser
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {
    factory { ClipboardFactory(get()) }
    factory { CreateNewClipboard(get(), get()) }
    factory { CreateAndLoginNewUser(get(), get()) }
    factory { LoadLoginUser(Dispatchers.IO, get(), get()) }
    factory<LoginUserProvider> { LoginUserProviderImpl() }
    factory { LoadUserClipboards(get()) }
}