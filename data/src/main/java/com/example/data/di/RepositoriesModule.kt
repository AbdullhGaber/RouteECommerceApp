package com.example.data.di

import com.example.data.data_source.auth.AuthOnlineDataSourceImpl
import com.example.data.network.api_services.auth.AuthService
import com.example.domain.repository.AuthOnlineDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {
    @Singleton
    @Provides
    fun provideAuthOnlineDataSource(
        authService : AuthService
    ) : AuthOnlineDataSource{
        return AuthOnlineDataSourceImpl()
    }
}