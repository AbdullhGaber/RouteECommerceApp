package com.example.ecommerceapp.screens.sign_up

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.data.Utils.Resource
import com.example.ecommerceapp.R
import com.example.ecommerceapp.components.EcomTextField
import com.example.ecommerceapp.components.PrimaryButton
import com.example.ecommerceapp.ui.theme.DarkBlue
import com.example.ecommerceapp.ui.theme.EcommerceAppTheme

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    signUpScreenState: SignUpScreenState = SignUpScreenState(),
    signUpScreenEvents: (SignUpScreenEvents) -> Unit = {}
){
    val scrollState = rememberScrollState()

    val errorMessage = remember {
        mutableStateOf("")
    }

    if(signUpScreenState.authResponseEntity.value is Resource.Failure){
        errorMessage.value = signUpScreenState.authResponseEntity.value.message.toString()
        Log.e("API" , "errorMessage from screen : ${errorMessage.value}")
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(DarkBlue)
            .verticalScroll(scrollState)
    ){

        if(signUpScreenState.authResponseEntity.value is Resource.Loading){
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White
                )
        }

        Column{
            Spacer(modifier = Modifier.height(100.dp))

            Image(
                painter = painterResource(id = R.drawable.route_logo),
                contentDescription = "Route Logo",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "Full name",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            EcomTextField(
                modifier = Modifier.padding(horizontal = 16.dp),
                label = "full name",
                value = signUpScreenState.fullNameTextField.value,
                onValueChange = {
                    signUpScreenEvents(SignUpScreenEvents.ClearResource)
                    errorMessage.value = ""
                    signUpScreenState.fullNameTextField.value = it
                },
                error = if(signUpScreenState.errorLocation.value == "name") errorMessage.value else "",
            )

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "Email Address",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            EcomTextField(
                modifier = Modifier.padding(horizontal = 16.dp),
                label = "email address",
                value = signUpScreenState.emailAddressTextField.value,
                onValueChange = {
                    signUpScreenEvents(SignUpScreenEvents.ClearResource)
                    errorMessage.value = ""
                    signUpScreenState.emailAddressTextField.value = it
                },
                error = if(signUpScreenState.errorLocation.value == "email") errorMessage.value else "",
            )

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "Mobile Number",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(horizontal = 8.dp),
            )

            Spacer(modifier = Modifier.height(16.dp))

            EcomTextField(
                modifier = Modifier.padding(horizontal = 16.dp),
                label = "mobile number",
                value = signUpScreenState.mobileNumberTextField.value,
                onValueChange = {
                    signUpScreenEvents(SignUpScreenEvents.ClearResource)
                    errorMessage.value = ""
                    signUpScreenState.mobileNumberTextField.value = it
                },
                error = if(signUpScreenState.errorLocation.value == "phone") errorMessage.value else "",
            )

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "Password",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            EcomTextField(
                modifier = Modifier.padding(horizontal = 16.dp),
                label = "password",
                isPasswordField = true,
                value = signUpScreenState.passwordTextField.value,
                passwordVisible = signUpScreenState.passwordVisible.value,
                onValueChange = {
                    signUpScreenEvents(SignUpScreenEvents.ClearResource)
                    errorMessage.value = ""
                    signUpScreenState.passwordTextField.value = it
                },
                onPasswordVisibilityChange = {
                    signUpScreenState.passwordVisible.value = it
                },
                error = if(signUpScreenState.errorLocation.value == "password") errorMessage.value else "",
            )

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "Re Password",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            EcomTextField(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp),
                label = "password",
                isPasswordField = true,
                passwordVisible = signUpScreenState.passwordVisible.value,
                value = signUpScreenState.rePasswordTextField.value,
                onValueChange = {
                    signUpScreenEvents(SignUpScreenEvents.ClearResource)
                    errorMessage.value = ""
                    signUpScreenState.rePasswordTextField.value = it
                },
                onPasswordVisibilityChange = {
                    signUpScreenState.passwordVisible.value = it
                },
                error = if(signUpScreenState.errorLocation.value == "password") errorMessage.value else "",
            )

            PrimaryButton(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Sign Up",
                onClick = {
                    signUpScreenEvents(SignUpScreenEvents.SignUp)
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }


}

@Composable
@Preview
fun PreviewSignUpScreen(){
    EcommerceAppTheme {
        SignUpScreen()
    }
}