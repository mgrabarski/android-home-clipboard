package com.mg.homeclipboards.splash.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.mg.homeclipboards.components.dispatchers.DispatcherProvider
import com.mg.homeclipboards.domain.interactor.user.LoadLoginUser
import com.mg.homeclipboards.domain.state.Failure
import com.mg.homeclipboards.domain.state.Success
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class SplashScreenViewModel(
    private val loadLoginUser: LoadLoginUser,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {

    suspend fun tryLoadUser() = flow {
        withContext(dispatcherProvider.io()) {
            loadLoginUser.load().collect { result ->
                withContext(dispatcherProvider.main()) {
                    when (result) {
                        is Success -> emit(Home)
                        is Failure -> emit(FirstInfo)
                    }
                }
            }
        }
    }
}

sealed class NextView

object FirstInfo : NextView()

object Home : NextView()