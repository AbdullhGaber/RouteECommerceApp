package com.example.data.repository

import com.example.domain.entity.auth.request.RegisterRequestEntity
import com.example.domain.entity.auth.response.AuthResponseEntity
import com.example.domain.repository.AuthOnlineDataSource
import com.example.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val onlineDataSource: AuthOnlineDataSource,
) : AuthRepository {
    override suspend fun signUp(requestEntity: RegisterRequestEntity) : AuthResponseEntity {
        return onlineDataSource.signUp(requestEntity)
    }
}