package com.example.data.mappers

import com.example.data.models.auth.response.AuthResponseModel
import com.example.data.models.auth.response.UserModel
import com.example.domain.entity.auth.response.AuthResponseEntity
import com.example.domain.entity.auth.response.UserEntity

fun AuthResponseModel.toEntity() : AuthResponseEntity{
    return AuthResponseEntity(
        message = message,
        userEntity = userModel?.toEntity(),
        statusMessage = statusMessage,
        token = token
    )
}

fun UserModel.toEntity() : UserEntity{
    return UserEntity(
        name = name,
        email = email,
        role = role
    )
}