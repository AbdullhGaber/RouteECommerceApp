package com.example.data.models.auth.response

import com.example.domain.entity.auth.response.ErrorEntity
import com.google.gson.annotations.SerializedName

data class AuthResponseModel(
    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("statusMsg")
    val statusMessage : String? = null,

    @field:SerializedName("errors")
    val error : ErrorModel? = null,

    @field:SerializedName("token")
    val token: String? = null,

    @field:SerializedName("user")
    val userModel: UserModel? = null
)

data class UserModel(
    @field:SerializedName("role")
    val role: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("email")
    val email: String? = null
)

data class ErrorModel(
    @field:SerializedName("value")
    val value : String? = null,

    @field:SerializedName("msg")
    val message : String? = null,

    @field:SerializedName("param")
    val parameter : String? = null,

    @field:SerializedName("location")
    val location : String? = null
)