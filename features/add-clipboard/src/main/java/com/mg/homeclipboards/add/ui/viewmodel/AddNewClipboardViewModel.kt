package com.mg.homeclipboards.add.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mg.homeclipboards.domain.model.Icon
import com.mg.homeclipboards.domain.model.Icon.Fridge

class AddNewClipboardViewModel : ViewModel() {

    private val _selectedIcon = MutableLiveData<SelectedIcon>()
    val selectedIcon: LiveData<SelectedIcon>
        get() = _selectedIcon

    init {
        _selectedIcon.value = SelectedIcon(Fridge)
    }

    fun onSelectIconChange(icon: SelectedIcon) {
        _selectedIcon.value = icon
    }

    data class SelectedIcon(
        val icon: Icon
    )
}