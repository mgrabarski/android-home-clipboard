package com.mg.homeclipboards.repository.factories

import com.mg.homeclipboard.database.entities.ClipboardEntity
import com.mg.homeclipboards.domain.model.Clipboard
import com.mg.homeclipboards.domain.model.CreateDate
import com.mg.homeclipboards.domain.model.Icon
import com.mg.homeclipboards.domain.model.Product
import com.mg.homeclipboards.domain.model.types.Id
import org.joda.time.DateTime

fun anyClipboard(
    id: Id = Id.randomUUID(),
    displayName: String = "name",
    icon: Icon = Icon.Fridge,
    createDate: CreateDate = CreateDate(DateTime.now(), ""),
    products: List<Product> = emptyList()
) = Clipboard(
    id = id,
    displayName = displayName,
    icon = icon,
    createDate = createDate,
    products = products
)

fun anyClipboardEntity(
    id: Id = Id.randomUUID(),
    name: String = "name",
    icon: String = "icon",
    createDate: String = "create"
) = ClipboardEntity(
    id = id.toString(),
    name = name,
    icon = icon,
    createDate = createDate
)