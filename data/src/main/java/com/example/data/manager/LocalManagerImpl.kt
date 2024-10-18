package com.example.data.manager

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesOf
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.data.manager.DataStoreKeys.TOKEN
import com.example.domain.manager.LocalManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalManagerImpl @Inject constructor(
    private val dataStore : DataStore<Preferences>
) : LocalManager {
    override suspend fun setToken(token: String) {
        dataStore.edit { preferences ->
            preferences[TOKEN] = token
        }
    }

    override suspend fun getToken(): String {
        return dataStore.data.map { preferences ->
            preferences[TOKEN] ?: ""
        }.first()
    }
}

object DataStoreKeys{
     val TOKEN = stringPreferencesKey("token")
}