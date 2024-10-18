package com.example.data.use_cases

import com.example.domain.repository.auth.AuthRepository
import com.example.domain.repository.auth.TokenRepository
import com.example.domain.use_cases.auth.AuthUseCases
import com.example.domain.use_cases.auth.GetTokenUseCase
import com.example.domain.use_cases.auth.LoginUseCase
import com.example.domain.use_cases.auth.RegisterUseCase
import com.example.domain.use_cases.auth.SetTokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesManager {
    @Provides
    fun providesAuthUseCases(
        authRepository: AuthRepository,
        tokenRepository: TokenRepository
    ) : AuthUseCases {
        return AuthUseCases(
            registerUseCase = RegisterUseCase(authRepository),
            loginUseCase = LoginUseCase(authRepository),
            setTokenUseCase = SetTokenUseCase(tokenRepository),
            getTokenUseCase = GetTokenUseCase(tokenRepository),
        )
    }
}