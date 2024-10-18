package com.example.domain.use_cases.auth

import com.example.domain.repository.auth.TokenRepository
import javax.inject.Inject

class SetTokenUseCase @Inject constructor(
    private val tokenRepository: TokenRepository
) {
    suspend operator fun invoke(token : String){
        tokenRepository.setToken(token)
    }
}