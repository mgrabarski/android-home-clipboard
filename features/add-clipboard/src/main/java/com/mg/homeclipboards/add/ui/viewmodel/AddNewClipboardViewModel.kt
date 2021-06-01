package com.mg.homeclipboards.add.ui.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mg.homeclipboards.add.R
import com.mg.homeclipboards.add.ui.viewmodel.AddNewClipboardViewModel.SelectedIcon
import com.mg.homeclipboards.domain.model.Icon
import com.mg.homeclipboards.domain.model.Icon.*

class AddNewClipboardViewModel : ViewModel() {

    private val _selectedIcon = MutableLiveData<SelectedIcon>().apply {
        postValue(SelectedIcon(Fridge))
    }
    val selectedIcon: LiveData<SelectedIcon>
        get() = _selectedIcon

    fun onSelectIconChange(icon: SelectedIcon) {
        _selectedIcon.value = icon
    }

    data class SelectedIcon(
        val icon: Icon
    )
}