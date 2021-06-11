package com.mg.homeclipboards.add.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mg.clipboards.test.data.getOrAwaitValue
import com.mg.clipboards.test.extensions.InstantExecutorExtension
import com.mg.homeclipboards.add.ui.viewmodel.AddNewClipboardViewModel.SelectedIcon
import com.mg.homeclipboards.domain.interactor.clipboard.CreateNewClipboard
import com.mg.homeclipboards.domain.model.Icon.Cosmetics
import com.mg.homeclipboards.domain.model.Icon.Fridge
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import org.junit.Rule
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
internal class AddNewClipboardViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val useCase: CreateNewClipboard = mockk()
    private lateinit var viewModel: AddNewClipboardViewModel

    @BeforeEach
    internal fun setUp() {
        viewModel = AddNewClipboardViewModel(useCase)
    }

    @Test
    internal fun `By default use fridge icon as selected`() {
        val result = viewModel.selectedIcon.getOrAwaitValue()

        result.icon shouldBe Fridge
    }

    @Test
    internal fun `Change select icon should update live data`() {
        viewModel.onSelectIconChange(SelectedIcon(Cosmetics))

        val result = viewModel.selectedIcon.getOrAwaitValue()

        result.icon shouldBe Cosmetics
    }
}