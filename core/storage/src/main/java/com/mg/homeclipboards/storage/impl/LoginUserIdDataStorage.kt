package com.mg.homeclipboards.storage.impl

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.mg.homeclipboards.constants.PREFERENCES_LOGIN_USER_ID
import com.mg.homeclipboards.constants.PREFERENCES_LOGIN_USER_NAME
import com.mg.homeclipboards.domain.data.storage.LoginUserIdStorage
import com.mg.homeclipboards.domain.model.types.Id
import com.mg.homeclipboards.storage.impl.LoginUserIdDataStorage.PreferencesKeys.loginUserId
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LoginUserIdDataStorage(
    private val context: Context
) : LoginUserIdStorage {

    private object PreferencesKeys {
        val loginUserId = stringPreferencesKey(PREFERENCES_LOGIN_USER_ID)
    }

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCES_LOGIN_USER_NAME)

    override suspend fun storeLoginUserId(id: Id) {
        context.dataStore.edit { settings ->
            settings[loginUserId] = id.toString()
        }
    }

    override suspend fun getLoginUserId(): Flow<Id?> = context.dataStore.data.map { preferences ->
        val id = preferences[loginUserId]
        when {
            id != null -> Id.fromString(id)
            else -> {
                null
            }
        }
    }
}
