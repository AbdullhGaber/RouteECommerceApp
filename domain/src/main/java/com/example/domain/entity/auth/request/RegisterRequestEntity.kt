package com.example.domain.entity.auth.request

data class RegisterRequestEntity(
    val name: String? = null,
    val email: String? = null,
    val password:String? = null,
    val rePassword:String? = null,
    val phone:String? = null
)
