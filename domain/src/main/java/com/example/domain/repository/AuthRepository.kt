package com.example.domain.repository

import com.example.domain.entity.auth.request.RegisterRequestEntity
import com.example.domain.entity.auth.response.AuthResponseEntity

interface AuthRepository {
    suspend fun signUp(requestEntity : RegisterRequestEntity) : AuthResponseEntity
}

interface AuthOnlineDataSource{
    suspend fun signUp(requestEntity : RegisterRequestEntity) : AuthResponseEntity
}