package com.mg.homeclipboards.domain.model

import com.mg.homeclipboards.domain.model.types.Id
import com.mg.homeclipboards.domain.model.types.Name

data class Clipboard(
    val id: Id,
    val displayName: Name,
    val icon: Icon,
    val createDate: CreateDate,
    val products: List<Product>,
    val ownerId: Id
)

enum class Icon {
    Fridge,
    Medics,
    Cosmetics,
    Other
}