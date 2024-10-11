package com.example.ecommerceapp.screens.sign_up

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import com.example.data.Utils.Resource
import com.example.domain.entity.auth.response.AuthResponseEntity

data class SignUpScreenState(
    val authResponseEntity: State<Resource<AuthResponseEntity>> = mutableStateOf(Resource.Unspecified()),
    val errorLocation : MutableState<String> = mutableStateOf(""),
    val fullNameTextField : MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    val mobileNumberTextField : MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    val emailAddressTextField : MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    val passwordTextField : MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    val rePasswordTextField : MutableState<TextFieldValue> = mutableStateOf(TextFieldValue("")),
    val passwordVisible : MutableState<Boolean> = mutableStateOf(false)
)
