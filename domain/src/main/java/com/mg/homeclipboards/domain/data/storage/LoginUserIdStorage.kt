package com.mg.homeclipboards.domain.data.storage

import com.mg.homeclipboards.domain.model.types.Id

interface LoginUserIdStorage {
    suspend fun storeLoginUserId(id: Id)
    suspend fun getLoginUserId(): Id
}