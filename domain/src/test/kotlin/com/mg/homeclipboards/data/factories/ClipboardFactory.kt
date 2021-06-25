package com.mg.homeclipboards.data.factories

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
    products = products,
    ownerId = Id.randomUUID()
)