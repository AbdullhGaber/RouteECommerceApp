package com.example.domain.use_cases.auth

import com.example.domain.entity.auth.request.LoginRequestEntity
import com.example.domain.entity.auth.response.AuthResponseEntity
import com.example.domain.repository.auth.AuthRepository

class LoginUseCase (
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(loginRequestEntity: LoginRequestEntity) : AuthResponseEntity{
        return authRepository.signIn(loginRequestEntity)
    }
}