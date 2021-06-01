package com.mg.homeclipboards.add.ui.handlers

import android.view.View
import com.mg.homeclipboards.add.R
import com.mg.homeclipboards.add.ui.viewmodel.AddNewClipboardViewModel
import com.mg.homeclipboards.add.ui.viewmodel.AddNewClipboardViewModel.SelectedIcon
import com.mg.homeclipboards.domain.model.Icon.*

class OnIconClickHandler {

    fun onIconClick(view: View, viewModel: AddNewClipboardViewModel) {
        when (view.id) {
            R.id.image1 -> viewModel.onSelectIconChange(SelectedIcon(Fridge))
            R.id.image2 -> viewModel.onSelectIconChange(SelectedIcon(Medics))
            R.id.image3 -> viewModel.onSelectIconChange(SelectedIcon(Cosmetics))
            R.id.image4 -> viewModel.onSelectIconChange(SelectedIcon(Other))
        }
    }
}