package com.mg.homeclipboards.repository.di

import com.mg.homeclipboards.domain.repository.ClipboardRepository
import com.mg.homeclipboards.domain.repository.UserRepository
import com.mg.homeclipboards.repository.domainimpl.HomeClipboardRepository
import com.mg.homeclipboards.repository.local.ClipboardLocalStorage
import com.mg.homeclipboards.repository.local.LocalUserRepository
import com.mg.homeclipboards.repository.remote.ClipboardRemoteStorage
import org.koin.dsl.module

val repositoryModule = module {
    factory { ClipboardLocalStorage(get()) }
    factory { ClipboardRemoteStorage() }
    factory<ClipboardRepository> { HomeClipboardRepository(get(), get(), get()) }
    factory<UserRepository> { LocalUserRepository(get()) }
}