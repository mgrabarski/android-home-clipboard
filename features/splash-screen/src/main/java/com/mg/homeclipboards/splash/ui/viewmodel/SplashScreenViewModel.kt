package com.mg.homeclipboards.splash.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.mg.homeclipboards.components.dispatchers.DispatcherProvider
import com.mg.homeclipboards.domain.interactor.user.LoadLoginUser
import com.mg.homeclipboards.domain.state.Failure
import com.mg.homeclipboards.domain.state.Success
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class SplashScreenViewModel(
    private val loadLoginUser: LoadLoginUser
) : ViewModel() {

    suspend fun tryLoadUser() = flow {
        loadLoginUser.load().collect { result ->
            when (result) {
                is Success -> emit(Home)
                is Failure -> emit(FirstInfo)
            }
        }
    }
}

sealed class NextView

object FirstInfo : NextView()

object Home : NextView()