package com.example.data.models.auth.request

import com.google.gson.annotations.SerializedName

data class RegisterRequestModel(
    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("password")
    val password: String? = null,

    @field:SerializedName("rePassword")
    val rePassword: String? = null,
)
