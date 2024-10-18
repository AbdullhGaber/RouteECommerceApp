package com.example.ecommerceapp.screens.sign_in

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Utils.Resource
import com.example.domain.entity.auth.request.LoginRequestEntity
import com.example.domain.entity.auth.response.AuthResponseEntity
import com.example.domain.use_cases.auth.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : ViewModel(){
    private val _authResponseStateFlow = MutableStateFlow<Resource<AuthResponseEntity>>(Resource.Unspecified())
    val authResponseStateFlow = _authResponseStateFlow.asStateFlow()

    val emailAddressTextField = mutableStateOf(TextFieldValue(""))
    val passwordTextField = mutableStateOf(TextFieldValue(""))
    val errorLocation = mutableStateOf("")
    val passwordVisible = mutableStateOf(false)

    fun onEvent(event : SignInScreenEvents){
        when(event){
            is SignInScreenEvents.SignIn -> {
                signIn()
            }
            is SignInScreenEvents.ClearResource -> {
                clearResource()
            }
        }
    }

    private fun clearResource(){
        viewModelScope.launch {
            _authResponseStateFlow.emit(Resource.Unspecified())
        }
    }

    private fun signIn(){
        viewModelScope.launch {
            _authResponseStateFlow.emit(
                Resource.Loading()
            )
        }

        viewModelScope.launch {
            val loginRequestEntity = LoginRequestEntity(
                email = emailAddressTextField.value.text,
                password = passwordTextField.value.text
            )

            val authResponseEntity = authUseCases.loginUseCase(loginRequestEntity)

            if(authResponseEntity.message != "success"){
                authResponseEntity.statusMessage?.let{
                    if(it == "fail"){
                        _authResponseStateFlow.emit(Resource.Failure(message = it))
                        errorLocation.value = "Not Specified"
                        return@launch
                    }
                }
                _authResponseStateFlow.emit(Resource.Failure(message = authResponseEntity.error?.message.toString()))
                errorLocation.value = authResponseEntity.error?.parameter!!
                Log.e("API : Fail" , "auth response from viewModel $authResponseEntity")
            }else{
                _authResponseStateFlow.emit(Resource.Success(data = authResponseEntity))
                val token = authResponseEntity.token
                authUseCases.setTokenUseCase(token!!)
                Log.e("DataStore","token set successfully in datastore ==> token = ${authUseCases.getTokenUseCase()}")
                Log.e("API : Success" , "auth response from viewModel $authResponseEntity")
            }
        }
    }
}