package com.example.data.models.auth.request

import com.google.gson.annotations.SerializedName

data class LoginRequestModel(
    @field:SerializedName("email")
    val email : String? = null,

    @field:SerializedName("password")
    val password : String? = null
)
