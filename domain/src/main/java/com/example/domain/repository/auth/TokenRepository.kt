package com.example.domain.repository.auth

interface TokenRepository {
   suspend fun setToken(token : String)
   suspend fun getToken() : String
}

interface TokenOfflineDataSource{
   suspend fun setToken(token : String)
   suspend fun getToken() : String
}