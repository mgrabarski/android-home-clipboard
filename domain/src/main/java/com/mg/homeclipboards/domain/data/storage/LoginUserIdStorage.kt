package com.mg.homeclipboards.domain.data.storage

import com.mg.homeclipboards.domain.model.types.Id
import kotlinx.coroutines.flow.Flow

interface LoginUserIdStorage {
    suspend fun storeLoginUserId(id: Id)
    suspend fun getLoginUserId(): Flow<Id>
}