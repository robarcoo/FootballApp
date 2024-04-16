package com.example.footballplayassistant.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.footballplayassistant.presentation.ui.screens.SignInScreen
import com.example.footballplayassistant.presentation.ui.screens.StartScreen

@Composable
fun MainNavigationController(
    navController: NavHostController,
){
    CompositionLocalProvider(
        LocalNavController provides navController
    ) {
        NavHost(
            navController = navController,
            startDestination = Route.SignInScreen.path,
            enterTransition = { fadeIn(animationSpec = tween(350)) },
            exitTransition = { fadeOut(animationSpec = tween(350)) },
        ) {
            composable(route = Route.StartScreen.path) {
                StartScreen()
            }

            composable(route = Route.SignInScreen.path) {
                SignInScreen()
            }
        }
    }
}
