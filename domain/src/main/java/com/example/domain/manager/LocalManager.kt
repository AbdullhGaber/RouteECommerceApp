package com.example.domain.manager

interface LocalManager {
    suspend fun setToken(token : String) : Unit
    suspend fun getToken() : String
}