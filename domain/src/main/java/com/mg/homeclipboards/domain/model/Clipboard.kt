package com.mg.homeclipboards.domain.model

import com.mg.homeclipboards.domain.model.types.Name

data class Clipboard(
    val displayName: Name,
    val icon: Icon,
    val createDate: CreateDate,
    val products: List<Product>
)

enum class Icon {
    Fridge,
    Medics,
    Cosmetics
}