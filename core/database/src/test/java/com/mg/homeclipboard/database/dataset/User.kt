package com.mg.homeclipboard.database.dataset

import com.mg.homeclipboard.database.entities.UserEntity
import com.mg.homeclipboards.domain.model.types.Id

fun anyUser(id: String = Id.randomUUID().toString()) = UserEntity(
    id = id
)