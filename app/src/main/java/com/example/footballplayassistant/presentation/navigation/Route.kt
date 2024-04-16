package com.example.footballplayassistant.presentation.navigation

sealed class Route(val path: String) {

    data object StartScreen : Route(path = "start_screen_route")

    data object SignInScreen : Route(path = "sign_in_screen")

}