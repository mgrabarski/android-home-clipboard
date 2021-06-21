package com.mg.homeclipboards.repository.factories

import com.mg.homeclipboards.domain.model.User
import com.mg.homeclipboards.domain.model.types.Id

fun anyUser(id: Id = Id.randomUUID()) = User(
    id = id
)