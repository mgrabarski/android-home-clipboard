package com.mg.homeclipboards.add.di

import com.mg.homeclipboards.add.ui.viewmodel.AddNewClipboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val addNewClipboardModule = module {
    viewModel { AddNewClipboardViewModel(get()) }
}