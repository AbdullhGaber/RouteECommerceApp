package com.example.data.repository.auth

import com.example.domain.repository.auth.TokenOfflineDataSource
import com.example.domain.repository.auth.TokenRepository
import javax.inject.Inject

class TokenRepositoryImpl @Inject constructor(
    private val tokenOfflineDataSource: TokenOfflineDataSource
) : TokenRepository {
    override suspend fun setToken(token: String) {
        tokenOfflineDataSource.setToken(token)
    }

    override suspend fun getToken(): String {
        return tokenOfflineDataSource.getToken()
    }
}