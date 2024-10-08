package com.example.data.network

import android.util.Log
import com.example.data.network.api_services.auth.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiManager {
    @Singleton
    @Provides
    fun provideLoggingInterceptor() : Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor { message ->
            Log.e("API", message)
        }

        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(loggingInterceptor: Interceptor) : OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient : OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://ecommerce.routemisr.com/api/v1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideAuthService(retrofit : Retrofit) : AuthService{
        return retrofit.create(AuthService::class.java)
    }

}