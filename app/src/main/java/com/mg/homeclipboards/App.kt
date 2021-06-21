package com.mg.homeclipboards

import android.app.Application
import com.mg.homeclipboards.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        configureDi()
    }

    private fun configureDi() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            loadKoinModules(appModules)
        }
    }
}