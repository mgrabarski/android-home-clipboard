package com.mg.homeclipboards.add.ui.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mg.homeclipboards.domain.interactor.clipboard.CreateNewClipboard
import com.mg.homeclipboards.domain.model.Icon
import com.mg.homeclipboards.domain.model.Icon.Fridge
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

    }

    data class SelectedIcon(
        val icon: Icon
    )
}