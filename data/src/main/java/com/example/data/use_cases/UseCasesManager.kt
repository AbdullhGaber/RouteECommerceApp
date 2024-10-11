package com.example.data.use_cases

import com.example.domain.repository.AuthRepository
import com.example.domain.use_cases.auth.AuthUseCases
import com.example.domain.use_cases.auth.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesManager {
    @Provides
    fun providesAuthUseCases(authRepository: AuthRepository) : AuthUseCases {
        return AuthUseCases(
            registerUseCase = RegisterUseCase(authRepository)
        )
    }
}