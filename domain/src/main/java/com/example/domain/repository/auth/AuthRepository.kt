package com.example.domain.repository.auth

import com.example.domain.entity.auth.request.LoginRequestEntity
import com.example.domain.entity.auth.request.RegisterRequestEntity
import com.example.domain.entity.auth.response.AuthResponseEntity

interface AuthRepository {
    suspend fun signUp(requestEntity : RegisterRequestEntity) : AuthResponseEntity
    suspend fun signIn(requestEntity : LoginRequestEntity) : AuthResponseEntity
}

interface AuthOnlineDataSource{
    suspend fun signUp(requestEntity : RegisterRequestEntity) : AuthResponseEntity
    suspend fun signIn(requestEntity : LoginRequestEntity) : AuthResponseEntity
}