package com.example.ecommerceapp.screens.sign_in

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.Utils.Resource
import com.example.ecommerceapp.R
import com.example.ecommerceapp.components.EcomTextField
import com.example.ecommerceapp.components.PrimaryButton
import com.example.ecommerceapp.screens.sign_up.SignUpScreen
import com.example.ecommerceapp.ui.theme.DarkBlue
import com.example.ecommerceapp.ui.theme.EcommerceAppTheme

@Composable
fun SignInScreen(
    modifier : Modifier = Modifier,
    signInScreenState: SignInScreenState = SignInScreenState(),
    signInScreenEvents: (SignInScreenEvents) -> Unit = {}
){
    if(signInScreenState.authResponseEntity.value is Resource.Failure){
        signInScreenState.errorMessage.value = signInScreenState.authResponseEntity.value.message.toString()
        Log.e("API" , "errorMessage from screen : ${signInScreenState.errorMessage.value}")
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(DarkBlue)
    ){
        if(signInScreenState.authResponseEntity.value is Resource.Loading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.White
            )
        }

        Column {
            Spacer(modifier = Modifier.height(100.dp))

            Image(
                painter = painterResource(id = R.drawable.route_logo),
                contentDescription = "Route Logo",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Welcome Back To Route",
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(start = 16.dp),
                color = Color.White
            )

            Text(
                text = "Please sign in with your email",
                style = MaterialTheme.typography.labelMedium,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp),
                color = Color.White
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Email",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            EcomTextField(
                modifier = Modifier.padding(horizontal = 16.dp),
                label = "email",
                value = signInScreenState.emailField.value,
                onValueChange = {
                    signInScreenEvents(SignInScreenEvents.ClearResource)
                    signInScreenState.errorMessage.value = ""
                    signInScreenState.emailField.value = it
                },
                error = if(signInScreenState.errorLocation.value == "email") signInScreenState.errorMessage.value else "",
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
                value = signInScreenState.passwordField.value,
                onValueChange = {
                    signInScreenEvents(SignInScreenEvents.ClearResource)
                    signInScreenState.errorMessage.value = ""
                    signInScreenState.passwordField.value = it
                },
                passwordVisible = signInScreenState.passwordVisible.value,
                onPasswordVisibilityChange = {
                    signInScreenState.passwordVisible.value = it
                },
                isPasswordField = true,
                error = if(signInScreenState.errorLocation.value == "password") signInScreenState.errorMessage.value else "",
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Forgot Password",
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(end = 16.dp).align(Alignment.End)
            )

            Spacer(modifier = Modifier.height(32.dp))

            PrimaryButton(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Login",
                onClick = {
                    signInScreenEvents(SignInScreenEvents.SignIn)
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Don’t have an account? Create Account",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(end = 16.dp).align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
@Preview
fun PreviewSignInScreen(){
    EcommerceAppTheme {
        SignInScreen()
    }
}