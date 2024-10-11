package com.example.data.network.api_services.auth

import com.example.data.models.auth.response.AuthResponseModel
import com.example.domain.entity.auth.request.RegisterRequestEntity
import com.example.domain.entity.auth.response.AuthResponseEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/signup")
    fun signUp(@Body requestEntity : RegisterRequestEntity) : Call<AuthResponseModel>
}