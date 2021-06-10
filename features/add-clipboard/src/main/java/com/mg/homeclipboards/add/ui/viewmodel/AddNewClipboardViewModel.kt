package com.mg.homeclipboards.add.ui.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mg.homeclipboards.domain.interactor.clipboard.CreateNewClipboard
import com.mg.homeclipboards.domain.interactor.clipboard.ERROR_CLIPBOARD_NAME_IS_EMPTY
import com.mg.homeclipboards.domain.interactor.clipboard.ERROR_SAVE_CLIPBOARD_NOT_PASS
import com.mg.homeclipboards.domain.model.Icon
import com.mg.homeclipboards.domain.model.Icon.Fridge
import com.mg.homeclipboards.domain.state.Failure
import com.mg.homeclipboards.domain.state.Success
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AddNewClipboardViewModel(
    private val createNewClipboard: CreateNewClipboard
) : ViewModel() {

    private val _selectedIcon = MutableLiveData<SelectedIcon>()
    val selectedIcon: LiveData<SelectedIcon>
        get() = _selectedIcon

    var clipboardName = ObservableField<String>().apply {
        set("")
    }

    init {
        _selectedIcon.value = SelectedIcon(Fridge)
    }

    fun onSelectIconChange(icon: SelectedIcon) {
        _selectedIcon.value = icon
    }

    fun saveClipboard() {
        viewModelScope.launch {
            createNewClipboard.create(
                name = clipboardName.get().orEmpty(),
                icon = _selectedIcon.value!!.icon
            ).collect {
                when (it) {
                    is Success -> handleSuccessSaveClipboard()
                    is Failure -> handleFailureSaveClipboard(it)
                }
            }
        }
    }

    private fun handleSuccessSaveClipboard() {

    }

    private fun handleFailureSaveClipboard(useCaseResult: Failure) {
        when (useCaseResult.message) {
            ERROR_CLIPBOARD_NAME_IS_EMPTY -> {

            }
            ERROR_SAVE_CLIPBOARD_NOT_PASS -> {

            }
        }
    }

    data class SelectedIcon(
        val icon: Icon
    )
}