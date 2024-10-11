package com.example.ecommerceapp.screens.sign_up

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Utils.Resource
import com.example.domain.entity.auth.request.RegisterRequestEntity
import com.example.domain.entity.auth.response.AuthResponseEntity
import com.example.domain.use_cases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : ViewModel(){
    private val _authResponseStateFlow = MutableStateFlow<Resource<AuthResponseEntity>>(Resource.Unspecified())
    val authResponseStateFlow = _authResponseStateFlow.asStateFlow()
    val errorLocation = mutableStateOf("")
    val fullNameTextField = mutableStateOf(TextFieldValue(""))
    val mobileNumberTextField = mutableStateOf(TextFieldValue(""))
    val emailAddressTextField = mutableStateOf(TextFieldValue(""))
    val passwordTextField = mutableStateOf(TextFieldValue(""))
    val rePasswordTextField = mutableStateOf(TextFieldValue(""))
    val passwordVisible = mutableStateOf(false)

    fun onEvent(event : SignUpScreenEvents){
        when(event){
            is SignUpScreenEvents.SignUp -> {
                signUp()
            }
            is SignUpScreenEvents.ClearResource -> {
                clearResource()
            }
        }
    }

    private fun clearResource(){
        viewModelScope.launch {
            _authResponseStateFlow.emit(
                Resource.Unspecified()
            )
        }
    }
    private fun signUp() {
        viewModelScope.launch {
            _authResponseStateFlow.emit(
                Resource.Loading()
            )
        }

        val registerRequestEntity = RegisterRequestEntity(
            name = fullNameTextField.value.text,
            phone = mobileNumberTextField.value.text,
            email = emailAddressTextField.value.text,
            password = passwordTextField.value.text,
            rePassword = rePasswordTextField.value.text
        )

        viewModelScope.launch(Dispatchers.IO) {
            val registerResponse = authUseCases.registerUseCase(registerRequestEntity)
            Log.e("API" , "registerResponse from view model : $registerResponse")
            if (registerResponse.message != "success") {
                _authResponseStateFlow.emit(
                    Resource.Failure(message = registerResponse.error?.message.toString())
                )
                errorLocation.value = registerResponse.error?.parameter!!
                Log.e("API" , "errorMessage from view model : ${registerResponse.error?.message.toString()}")
            }else{
                _authResponseStateFlow.emit(
                    Resource.Success(data = registerResponse)
                )
            }
        }
    }
}