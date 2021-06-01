package com.mg.homeclipboards.add.ui.adapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.mg.homeclipboards.add.R
import com.mg.homeclipboards.add.ui.viewmodel.AddNewClipboardViewModel.SelectedIcon
import com.mg.homeclipboards.domain.model.Icon.*

@BindingAdapter("handleToDisplaySelectedIcon")
fun handleToDisplaySelectedIcon(view: View, selectedIcon: SelectedIcon) {
    if (view is ImageView) {
        view.setBackgroundResource(android.R.color.transparent)

        when {
            view.id == R.id.image1 && selectedIcon.icon == Fridge -> {
                view.setBackgroundResource(R.drawable.background_black_frame)
            }
            view.id == R.id.image2 && selectedIcon.icon == Medics -> {
                view.setBackgroundResource(R.drawable.background_black_frame)
            }
            view.id == R.id.image3 && selectedIcon.icon == Cosmetics -> {
                view.setBackgroundResource(R.drawable.background_black_frame)
            }
            view.id == R.id.image4 && selectedIcon.icon == Other -> {
                view.setBackgroundResource(R.drawable.background_black_frame)
            }
        }
    }
}