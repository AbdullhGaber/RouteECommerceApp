package com.example.data.data_source.auth

import com.example.domain.manager.LocalManager
import com.example.domain.repository.auth.TokenOfflineDataSource
import javax.inject.Inject

class TokenOfflineDataSourceImpl @Inject constructor(
    private val localManger : LocalManager
) : TokenOfflineDataSource {
    override suspend fun setToken(token: String) {
        localManger.setToken(token)
    }

    override suspend fun getToken(): String {
        return localManger.getToken()
    }
}