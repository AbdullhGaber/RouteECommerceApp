package com.example.data.repository

import com.example.data.data_source.auth.AuthOnlineDataSourceImpl
import com.example.data.data_source.auth.TokenOfflineDataSourceImpl
import com.example.data.manager.LocalManagerImpl
import com.example.data.repository.auth.AuthRepositoryImpl
import com.example.data.repository.auth.TokenRepositoryImpl
import com.example.domain.manager.LocalManager
import com.example.domain.repository.auth.AuthOnlineDataSource
import com.example.domain.repository.auth.AuthRepository
import com.example.domain.repository.auth.TokenOfflineDataSource
import com.example.domain.repository.auth.TokenRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun provideOnlineAuthDataSource(authOnlineDataSourceImpl: AuthOnlineDataSourceImpl) : AuthOnlineDataSource

    @Binds
    abstract fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl) : AuthRepository

    @Binds
    abstract fun provideDataStoreLocalManger(localManagerImpl : LocalManagerImpl) : LocalManager

    @Binds
    abstract fun provideTokenOfflineDataSource(tokenOfflineDataSourceImpl : TokenOfflineDataSourceImpl) : TokenOfflineDataSource

    @Binds
    abstract fun provideTokenRepository(tokenRepositoryImpl: TokenRepositoryImpl) : TokenRepository


}