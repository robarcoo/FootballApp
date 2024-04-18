package com.example.footballplayassistant.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.footballplayassistant.presentation.ui.screens.ChooseTeamScreen
import com.example.footballplayassistant.presentation.ui.screens.CreateEventScreen
import com.example.footballplayassistant.presentation.ui.screens.EnterInfoScreen
import com.example.footballplayassistant.presentation.ui.screens.InviteFriendsScreen
import com.example.footballplayassistant.presentation.ui.screens.MainScreen
import com.example.footballplayassistant.presentation.ui.screens.MatchInfoScreen
import com.example.footballplayassistant.presentation.ui.screens.MatchScreen
import com.example.footballplayassistant.presentation.ui.screens.NewsScreen
import com.example.footballplayassistant.presentation.ui.screens.PaymentScreen
import com.example.footballplayassistant.presentation.ui.screens.SignInScreen
import com.example.footballplayassistant.presentation.ui.screens.SignUpCodeScreen
import com.example.footballplayassistant.presentation.ui.screens.SignUpEnterPhoneScreen
import com.example.footballplayassistant.presentation.ui.screens.SignUpStepOneScreen
import com.example.footballplayassistant.presentation.ui.screens.SignUpStepTwoScreen
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
            startDestination = Route.StartScreen.path,
            enterTransition = { fadeIn(animationSpec = tween(350)) },
            exitTransition = { fadeOut(animationSpec = tween(350)) },
        ) {
            composable(route = Route.StartScreen.path) {
                StartScreen()
            }

            composable(route = Route.SignInScreen.path) {
                SignInScreen()
            }

            composable(route = Route.SignUpEnterPhoneScreen.path) {
                SignUpEnterPhoneScreen()
            }

            composable(route = Route.SignUpCodeScreen.path) {
                SignUpCodeScreen()
            }

            composable(route = Route.SignUpStepOneScreen.path) {
                SignUpStepOneScreen()
            }

            composable(route = Route.SignUpStepTwoScreen.path) {
                SignUpStepTwoScreen()
            }

            composable(route = Route.EnterInfoScreen.path) {
                EnterInfoScreen()
            }

            composable(route = Route.MainScreen.path) {
                MainScreen()
            }

            composable(route = Route.CreateEventScreen.path) {
                CreateEventScreen()
            }

            composable(route = Route.NewsScreen.path) {
                NewsScreen()
            }

            composable(route = Route.MatchScreen.path) {
                MatchScreen()
            }

            composable(route = Route.MatchInfoScreen.path) {
                MatchInfoScreen()
            }

            composable(route = Route.ChooseTeamScreen.path) {
                ChooseTeamScreen()
            }

            composable(route = Route.PaymentScreen.path) {
                PaymentScreen()
            }

            composable(route = Route.InviteFriendsScreen.path) {
                InviteFriendsScreen()
            }
        }
    }
}
