package com.mg.homeclipboards.splash.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mg.clipboards.test.coroutine.testBlocking
import com.mg.homeclipboards.domain.interactor.user.LoadLoginUser
import com.mg.homeclipboards.domain.model.User
import com.mg.homeclipboards.domain.model.types.Id
import com.mg.homeclipboards.domain.state.Failure
import com.mg.homeclipboards.domain.state.Success
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import org.junit.Rule
import org.junit.jupiter.api.Test

@ExperimentalCoroutinesApi
internal class SplashScreenViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val useCase: LoadLoginUser = mockk()
    private val viewModel = SplashScreenViewModel(useCase)

    @Test
    internal fun `Use case not login user should emit FirstInfo object`() = testBlocking {
        coEvery { useCase.load() } returns flow { Failure("") }

        viewModel.tryLoadUser().collect { result ->
            result shouldBeSameInstanceAs FirstInfo
        }
    }

    @Test
    internal fun `Use case success load login user should emit Home object`() = testBlocking {
        coEvery { useCase.load() } returns flow { Success(User(Id.randomUUID())) }

        viewModel.tryLoadUser().collect { result ->
            result shouldBeSameInstanceAs Home
        }
    }
}