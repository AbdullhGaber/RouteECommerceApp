package com.example.data.data_source.auth

import android.util.Log
import com.example.data.mappers.toEntity
import com.example.data.models.auth.response.AuthResponseModel
import com.example.data.network.api_services.auth.AuthService
import com.example.domain.entity.auth.request.LoginRequestEntity
import com.example.domain.entity.auth.request.RegisterRequestEntity
import com.example.domain.entity.auth.response.AuthResponseEntity
import com.example.domain.repository.auth.AuthOnlineDataSource
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthOnlineDataSourceImpl @Inject constructor(
    private val authService: AuthService
) : AuthOnlineDataSource {

    override suspend fun signUp(requestEntity: RegisterRequestEntity): AuthResponseEntity {
        return withContext(Dispatchers.IO) {
            try {
                // Synchronously execute the request
                val response = authService.signUp(requestEntity).execute()

                var authResponseBody: AuthResponseModel = AuthResponseModel()

                // Check if the response is successful and has a body
                if (response.isSuccessful && response.body() != null) {
                    authResponseBody = response.body()!!
                } else if (response.errorBody() != null) {
                    val jsonErrorBody = response.errorBody()!!.source().readUtf8()
                    authResponseBody = Gson().fromJson(jsonErrorBody, AuthResponseModel::class.java)
                }

                Log.e("API : auth response", "$authResponseBody")

                // Return the AuthResponseEntity after processing the response
                authResponseBody.toEntity()
            } catch (e: Exception) {
                Log.e("API Error", e.message.toString())
                // Return an empty or default AuthResponseEntity on failure
                AuthResponseModel().toEntity()
            }
        }
    }

    override suspend fun signIn(requestEntity: LoginRequestEntity): AuthResponseEntity {
        return withContext(Dispatchers.IO) {
            try {
                // Synchronously execute the request
                val response = authService.signIn(requestEntity).execute()

                var authResponseBody: AuthResponseModel = AuthResponseModel()

                // Check if the response is successful and has a body
                if (response.isSuccessful && response.body() != null) {
                    authResponseBody = response.body()!!
                } else if (response.errorBody() != null) {
                    val jsonErrorBody = response.errorBody()!!.source().readUtf8()
                    authResponseBody = Gson().fromJson(jsonErrorBody, AuthResponseModel::class.java)
                }

                Log.e("API : auth response", "$authResponseBody")

                // Return the AuthResponseEntity after processing the response
                authResponseBody.toEntity()
            } catch (e: Exception) {
                Log.e("API Error", e.message.toString())
                // Return an empty or default AuthResponseEntity on failure
                AuthResponseModel().toEntity()
            }
        }
    }
}