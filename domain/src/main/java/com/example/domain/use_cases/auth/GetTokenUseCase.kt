package com.example.domain.use_cases.auth

import com.example.domain.repository.auth.TokenRepository
import javax.inject.Inject

class GetTokenUseCase @Inject constructor(
    private val tokenRepository: TokenRepository
) {
    suspend operator fun invoke() : String {
        return tokenRepository.getToken()
    }
}