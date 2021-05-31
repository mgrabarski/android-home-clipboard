package com.mg.homeclipboards

import android.app.Application
import com.mg.homeclipboards.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        configureDi()
    }

    private fun configureDi() {
        startKoin {
            androidContext(this@App)
            loadKoinModules(appModules)
        }
    }
}