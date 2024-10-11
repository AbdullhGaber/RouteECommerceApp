package com.example.ecommerceapp.screens.sign_up

sealed class SignUpScreenEvents {
    data object SignUp : SignUpScreenEvents()
    data object ClearResource : SignUpScreenEvents()
}