package com.example.footballplayassistant.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.footballplayassistant.presentation.constants.PhoneEmail
import com.example.footballplayassistant.presentation.constants.RulesPolitic
import com.example.footballplayassistant.presentation.enums.FilterCurrentArchive
import com.example.footballplayassistant.presentation.ui.screens.authentication.EnterInfoScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.ForgotPasswordScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.RecoveryPasswordScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.RulesAndPoliticScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.SignInScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.SignUpCodeScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.SignUpEnterPhoneScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.SignUpStepOneScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.SignUpStepTwoScreen
import com.example.footballplayassistant.presentation.ui.screens.authentication.StartScreen
import com.example.footballplayassistant.presentation.ui.screens.main.ChooseTeamScreen
import com.example.footballplayassistant.presentation.ui.screens.main.CreateEventScreen
import com.example.footballplayassistant.presentation.ui.screens.main.EditGameScreen
import com.example.footballplayassistant.presentation.ui.screens.main.InviteFriendsScreen
import com.example.footballplayassistant.presentation.ui.screens.main.MainScreen
import com.example.footballplayassistant.presentation.ui.screens.main.ManagingParticipantsScreen
import com.example.footballplayassistant.presentation.ui.screens.main.MatchInfoScreen
import com.example.footballplayassistant.presentation.ui.screens.main.MatchParticipantsScreen
import com.example.footballplayassistant.presentation.ui.screens.main.MatchScreen
import com.example.footballplayassistant.presentation.ui.screens.main.MyGamesScreen
import com.example.footballplayassistant.presentation.ui.screens.main.NewsScreen
import com.example.footballplayassistant.presentation.ui.screens.main.PaymentScreen
import com.example.footballplayassistant.presentation.ui.screens.main.WalletScreen
import com.example.footballplayassistant.presentation.ui.screens.search_tab.AdditionalFieldInfoScreen
import com.example.footballplayassistant.presentation.ui.screens.search_tab.ComingEventsScreen
import com.example.footballplayassistant.presentation.ui.screens.search_tab.CreateFieldScreen
import com.example.footballplayassistant.presentation.ui.screens.search_tab.FieldInfoScreen
import com.example.footballplayassistant.presentation.ui.screens.search_tab.FilterScreen
import com.example.footballplayassistant.presentation.ui.screens.search_tab.SearchScreen
import com.example.footballplayassistant.presentation.ui.screens.search_tab.AdditionalFieldInfoScreen
import com.example.footballplayassistant.presentation.ui.screens.search_tab.ComingEventsScreen
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.ui.screens.main.MyGamesScreen
import com.example.footballplayassistant.presentation.ui.screens.profile.UserProfileScreen



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainNavigationController(
    navController: NavHostController,
) {
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

            composable(
                route = Route.SignUpCodeScreen.path + "/{type}",
                arguments = listOf(navArgument("type") {
                    type = NavType.StringType
                    defaultValue = PhoneEmail.PHONE
                    nullable = false
                })
            ) { entry ->
                entry.arguments?.getString("type").let { type ->
                    if (type != null) {
                        SignUpCodeScreen(sendCode = type)
                    }
                }

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

            composable(route = Route.SearchScreen.path) {
                SearchScreen()
            }

            composable(route = Route.FilterScreen.path) {
                FilterScreen()
            }

            composable(route = Route.CreateFieldScreen.path) {
                CreateFieldScreen()
            }

            composable(route = Route.FieldInfoScreen.path) {
                FieldInfoScreen()
            }

            composable(route = Route.AdditionalFieldInfoScreen.path) {
                AdditionalFieldInfoScreen()
            }

            composable(route = Route.ComingEventsScreen.path) {
                ComingEventsScreen()
            }

            composable(route = Route.MatchParticipantsScreen.path){
                MatchParticipantsScreen()
            }

            composable(route = Route.ManagingParticipantsScreen.path) {
                ManagingParticipantsScreen()
            }

            composable(
                route = Route.RulesAndPoliticScreen.path + "/{type}",
                arguments = listOf(navArgument("type") {
                    type = NavType.StringType
                    defaultValue = RulesPolitic.RULES
                    nullable = false
                })
            ) { entry ->
                entry.arguments?.getString("type").let { type ->
                    if (type != null) {
                        RulesAndPoliticScreen(header = type)
                    }
                }
            }

            composable(route = Route.ForgotPasswordScreen.path) {
                ForgotPasswordScreen()
            }

            composable(route = Route.RecoveryPasswordScreen.path) {
                RecoveryPasswordScreen()
            }

            composable(route = Route.EditGameScreen.path) {
                EditGameScreen()
            }

            composable(route = Route.MyGamesScreen.path + "/{filter}",
                arguments = listOf(navArgument("filter"){
                    type = NavType.IntType
                    defaultValue = FilterCurrentArchive.Current.ordinal
                    nullable = false
                })
            ){entry ->
                entry.arguments?.getInt("filter").let { filter ->
                    if (filter != null) {
                        MyGamesScreen(filter = filter)
                    }
                }
            }

            composable(route = Route.WalletScreen.path){
                WalletScreen()
            }

            composable(route = Route.UserProfileScreen.path + "/{button}",
                arguments = listOf(navArgument("button") {
                    type = NavType.BoolType
                    defaultValue = false
                    nullable = false
                })) { entry ->
                entry.arguments?.getBoolean("button").let { button ->
                    if (button != null) {
                        UserProfileScreen(isBackButton = button)
                    }
                }
            }
        }
    }
}
