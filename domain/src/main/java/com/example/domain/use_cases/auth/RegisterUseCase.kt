package com.example.domain.use_cases.auth

import com.example.domain.entity.auth.request.RegisterRequestEntity
import com.example.domain.entity.auth.response.AuthResponseEntity
import com.example.domain.repository.AuthRepository

class RegisterUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(registerRequestEntity: RegisterRequestEntity) : AuthResponseEntity{
        return authRepository.signUp(registerRequestEntity)
    }
}