package com.example.footballplayassistant.presentation.navigation

sealed class Route(val path: String) {

    data object StartScreen : Route(path = "start_screen_route")

    data object SignInScreen : Route(path = "sign_in_screen")

    data object SignUpEnterPhoneScreen : Route(path = "sign_up_enter_phone_screen")

    data object SignUpCodeScreen : Route(path = "sign_up_code_screen")

    data object SignUpStepOneScreen : Route(path = "sign_up_step_one_screen")

    data object SignUpStepTwoScreen : Route(path = "sign_up_step_two_screen")

    data object EnterInfoScreen : Route(path = "enter_info_screen")

    data object MainScreen : Route(path = "main_screen")

    data object CreateEventScreen : Route(path = "create_event_screen")

    data object NewsScreen : Route(path = "news_screen")

    data object MatchScreen : Route(path = "match_screen")

    data object MatchInfoScreen : Route(path = "match_info_screen")

    data object ChooseTeamScreen : Route(path = "choose_team_screen")

    data object PaymentScreen : Route(path = "payment_screen")

    data object InviteFriendsScreen : Route(path = "invite_friends_screen")

    data object SearchScreen : Route(path = "search_screen")

    data object FilterScreen : Route(path = "filter_screen")

    data object CreateFieldScreen : Route(path = "create_field_screen")

    data object MatchParticipantsScreen : Route(path = "match_participants_screen")

    data object ManagingParticipantsScreen : Route(path = "managing_participants_screen")


    fun withArgs(vararg args: String): String {
        return buildString {
            append(path)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}