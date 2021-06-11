package com.mg.homeclipboard.database.dataset

import com.mg.homeclipboard.database.entities.ClipboardEntity
import com.mg.homeclipboards.domain.model.Icon
import com.mg.homeclipboards.domain.model.types.Id

fun anyHomeClipboardEntity() = ClipboardEntity(
    id = Id.randomUUID().toString(),
    name = "name",
    icon = Icon.Fridge.name,
    createDate = "create date"
)