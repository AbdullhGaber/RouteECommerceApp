package com.example.ecommerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecommerceapp.screens.sign_in.SignInScreen
import com.example.ecommerceapp.screens.sign_in.SignInScreenState
import com.example.ecommerceapp.screens.sign_in.SignInViewModel
import com.example.ecommerceapp.screens.sign_up.SignUpScreen
import com.example.ecommerceapp.screens.sign_up.SignUpScreenState
import com.example.ecommerceapp.screens.sign_up.SignUpViewModel
import com.example.ecommerceapp.ui.theme.EcommerceAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.sign

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcommerceAppTheme {

            }
        }
    }
}

