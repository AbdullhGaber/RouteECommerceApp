package com.example.domain.entity.auth.response

data class AuthResponseEntity(
    val message : String? = null,
    val userEntity : UserEntity? = null,
    val error : ErrorEntity? = null,
    val statusMessage : String? = null,
    val token : String? = null
)

data class UserEntity(
    val name : String? = null,
    val email : String? = null,
    val role : String? = null
)

data class ErrorEntity(
    val value : String? = null,
    val message : String? = null,
    val parameter : String? = null,
    val location : String? = null
)
