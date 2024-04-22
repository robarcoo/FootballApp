package com.example.footballplayassistant.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.footballplayassistant.presentation.ui.screens.main.ChooseTeamScreen
import com.example.footballplayassistant.presentation.ui.screens.main.CreateEventScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.EnterInfoScreen
import com.example.footballplayassistant.presentation.ui.screens.main.InviteFriendsScreen
import com.example.footballplayassistant.presentation.ui.screens.main.MainScreen
import com.example.footballplayassistant.presentation.ui.screens.main.MatchInfoScreen
import com.example.footballplayassistant.presentation.ui.screens.main.MatchScreen
import com.example.footballplayassistant.presentation.ui.screens.main.NewsScreen
import com.example.footballplayassistant.presentation.ui.screens.main.PaymentScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.SignInScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.SignUpCodeScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.SignUpEnterPhoneScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.SignUpStepOneScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.SignUpStepTwoScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.StartScreen

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
