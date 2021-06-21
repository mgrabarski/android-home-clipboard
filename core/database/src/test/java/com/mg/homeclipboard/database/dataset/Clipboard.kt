package com.mg.homeclipboard.database.dataset

import com.mg.homeclipboard.database.entities.ClipboardEntity
import com.mg.homeclipboards.domain.model.Icon
import com.mg.homeclipboards.domain.model.types.Id
import org.joda.time.DateTime

fun anyHomeClipboardEntity(userId: String = Id.randomUUID().toString()) = ClipboardEntity(
    id = Id.randomUUID().toString(),
    name = "name",
    icon = Icon.Fridge.name,
    createDate = DateTime.now(),
    userId = userId
)