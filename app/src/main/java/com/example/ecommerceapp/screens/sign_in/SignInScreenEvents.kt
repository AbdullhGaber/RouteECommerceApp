package com.example.ecommerceapp.screens.sign_in

sealed class SignInScreenEvents {
    data object SignIn : SignInScreenEvents()
    data object ClearResource : SignInScreenEvents()
}