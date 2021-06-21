package com.mg.homeclipboards.repository.ext

import com.mg.homeclipboard.database.entities.UserEntity
import com.mg.homeclipboards.domain.model.User
import com.mg.homeclipboards.domain.model.types.Id

internal fun UserEntity.toUser() = User(
    id = Id.fromString(this.id)
)

internal fun User.toEntity() = UserEntity(
    id = this.id.toString()
)