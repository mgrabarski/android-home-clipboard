package com.mg.homeclipboards.domain.data.factories

import com.mg.homeclipboards.components.time.TimeProvider
import com.mg.homeclipboards.domain.interactor.user.LoginUserHolder
import com.mg.homeclipboards.domain.model.Clipboard
import com.mg.homeclipboards.domain.model.CreateDate
import com.mg.homeclipboards.domain.model.Icon
import com.mg.homeclipboards.domain.model.types.Id

class ClipboardFactory(
    private val timeProvider: TimeProvider
) {

    fun create(name: String, icon: Icon): Clipboard {
        val now = timeProvider.now()
        return Clipboard(
            id = Id.randomUUID(),
            displayName = name,
            icon = icon,
            createDate = CreateDate(
                date = now.time,
                formattedDate = now.detailsFormat
            ),
            products = emptyList(),
            ownerId = LoginUserHolder.loginUser.id
        )
    }
}