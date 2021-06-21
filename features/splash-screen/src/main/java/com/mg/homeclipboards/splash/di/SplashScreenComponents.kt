package com.mg.homeclipboards.splash.di

import com.mg.homeclipboards.splash.ui.viewmodel.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashScreenModule = module {
    viewModel { SplashScreenViewModel(get()) }
}