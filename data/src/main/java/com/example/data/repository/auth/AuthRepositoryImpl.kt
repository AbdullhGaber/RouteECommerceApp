package com.example.data.repository.auth

import com.example.domain.entity.auth.request.LoginRequestEntity
import com.example.domain.entity.auth.request.RegisterRequestEntity
import com.example.domain.entity.auth.response.AuthResponseEntity
import com.example.domain.repository.auth.AuthOnlineDataSource
import com.example.domain.repository.auth.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val onlineDataSource: AuthOnlineDataSource,
) : AuthRepository {
    override suspend fun signUp(requestEntity: RegisterRequestEntity) : AuthResponseEntity {
        return onlineDataSource.signUp(requestEntity)
    }

    override suspend fun signIn(requestEntity: LoginRequestEntity) : AuthResponseEntity {
        return onlineDataSource.signIn(requestEntity)
    }
}