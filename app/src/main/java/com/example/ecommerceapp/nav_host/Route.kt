package com.example.ecommerceapp.nav_host

sealed class Route(val route : String) {
    data object AuthNavigation : Route("authNavigation")
    data object SignInScreen : Route("signInScreen")
    data object SignUpScreen : Route("signUpScreen")

    data object EcommerceNavigation : Route("ecommerceNavigation")
    data object HomeScreen : Route("homeScreen")
    data object CategoriesScreen : Route("categoriesScreen")
    data object WishListScreen : Route("wishListScreen")
    data object AccountScreen : Route("accountScreen")
}