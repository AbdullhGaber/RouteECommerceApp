package com.example.data.repository

import com.example.data.data_source.auth.AuthOnlineDataSourceImpl
import com.example.data.network.api_services.auth.AuthService
import com.example.domain.repository.AuthOnlineDataSource
import com.example.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun provideOnlineAuthDataSource(authOnlineDataSourceImpl: AuthOnlineDataSourceImpl) : AuthOnlineDataSource

    @Binds
    abstract fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl) : AuthRepository
}