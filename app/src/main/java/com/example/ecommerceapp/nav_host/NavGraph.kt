package com.example.ecommerceapp.nav_host

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.ecommerceapp.screens.sign_in.SignInScreen
import com.example.ecommerceapp.screens.sign_in.SignInScreenState
import com.example.ecommerceapp.screens.sign_in.SignInViewModel
import com.example.ecommerceapp.screens.sign_up.SignUpScreen
import com.example.ecommerceapp.screens.sign_up.SignUpScreenState
import com.example.ecommerceapp.screens.sign_up.SignUpViewModel

@Composable
fun NavGraph(
    startDestination : String
){
    val navController = rememberNavController()

    NavHost(navController = navController , startDestination = startDestination ){
        navigation(
            route = Route.AuthNavigation.route,
            startDestination = Route.SignInScreen.route
        ){
            composable(
                route = Route.SignInScreen.route
            ){
                val signInViewModel : SignInViewModel = hiltViewModel()

                val signInScreenState = SignInScreenState(
                    authResponseEntity = signInViewModel.authResponseStateFlow.collectAsState(),
                    emailField = signInViewModel.emailAddressTextField,
                    passwordField = signInViewModel.passwordTextField,
                    passwordVisible = signInViewModel.passwordVisible,
                    errorLocation = signInViewModel.errorLocation,
                )

                SignInScreen(
                    signInScreenState = signInScreenState,
                    signInScreenEvents = signInViewModel::onEvent,
                    navigateToSignUp = {
                        navigateToTab(navController,Route.SignUpScreen.route)
                    }
                )
            }

            composable(
                route = Route.SignUpScreen.route
            ){
                val signUpViewModel : SignUpViewModel = hiltViewModel()

                val signUpScreenState = SignUpScreenState(
                    authResponseEntity = signUpViewModel.authResponseStateFlow.collectAsState(),
                    fullNameTextField = signUpViewModel.fullNameTextField,
                    emailAddressTextField = signUpViewModel.emailAddressTextField,
                    mobileNumberTextField = signUpViewModel.mobileNumberTextField,
                    passwordTextField = signUpViewModel.passwordTextField,
                    rePasswordTextField = signUpViewModel.rePasswordTextField,
                    passwordVisible = signUpViewModel.passwordVisible,
                    errorLocation = signUpViewModel.errorLocation,
                )

                SignUpScreen(
                    signUpScreenState = signUpScreenState,
                    signUpScreenEvents = signUpViewModel::onEvent,
                    navigateToSignIn = {
                        navigateToTab(navController,Route.SignInScreen.route)
                    }
                )
            }
        }
    }
}

fun navigateToTab(navController : NavHostController , route : String){
    navController.navigate(route){
        navController.graph.startDestinationRoute?.let { homeScreen ->
            val authNav = listOf(Route.SignInScreen.route, Route.SignUpScreen.route)

            if(route !in authNav){
                popUpTo(homeScreen){
                    saveState = true
                }
            }

            restoreState = true

            launchSingleTop = true

        }
    }
}