package com.example.ecommerceapp.screens.sign_in

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import com.example.data.Utils.Resource
import com.example.domain.entity.auth.response.AuthResponseEntity

data class SignInScreenState(
    val authResponseEntity: State<Resource<AuthResponseEntity>> = mutableStateOf(Resource.Unspecified()),
    val emailField : MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    val passwordField : MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    val passwordVisible : MutableState<Boolean> = mutableStateOf(false),
    val errorLocation : MutableState<String> = mutableStateOf(""),
    val errorMessage : MutableState<String> = mutableStateOf(""),
)