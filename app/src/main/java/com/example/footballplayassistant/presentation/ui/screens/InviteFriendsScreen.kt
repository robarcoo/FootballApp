package com.example.footballplayassistant.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.checkboxes.CheckBoxFriend
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.Gray75

@Composable
@Preview
fun InviteFriendsScreen() {
    val navController = LocalNavController.current!!

    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value)
        DialogScreen(
            header = stringResource(id = R.string.done),
            description = stringResource(id = R.string.youGetNotify2),
            greenButton = stringResource(id = R.string.onGamePage),
            whiteButton = stringResource(id = R.string.inviteFriendsAlso),
            bottomButton = stringResource(id = R.string.copy),
            image = R.drawable.ic_check_92,
            onClickGreen = { navController.navigate(Route.MatchScreen.path) },
            onClickWhite = { navController.navigate(Route.InviteFriendsScreen.path) },
            onClickBottom = {
                showDialog.value = false
                navController.navigate(Route.MainScreen.path)
            },
            onDismissRequest = { showDialog.value = false }
        )

    Scaffold(bottomBar = {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            CommonButton(
                text = stringResource(id = R.string.invite),
                onClick = { showDialog.value = true },
                modifier = Modifier
            )
            TextButton(modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(Route.MainScreen.path) }) {
                Text(
                    text = stringResource(id = R.string.cancel),
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W600,
                    color = Gray75
                )
            }
        }
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 12.dp)
                .padding(it),
        ) {

            HeaderWithBackButton(
                text = stringResource(id = R.string.inviteFriend),
                imageButton = R.drawable.ic_arrow_share_25,
                onClickBack = { navController.navigate(Route.MatchScreen.path) },
                onClickOther = {},
                modifier = Modifier.padding(bottom = 24.dp)
            )

            LazyColumn {
                item {
                    CheckBoxFriend(text = "text", name = "name name", foto = R.drawable.user_foto)
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                }
                item {
                    CheckBoxFriend(text = "text", name = "name name", foto = R.drawable.user_foto)
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                }
                item {
                    CheckBoxFriend(text = "text", name = "name name", foto = R.drawable.user_foto)
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                }
                item {
                    CheckBoxFriend(text = "text", name = "name name", foto = R.drawable.user_foto)
                    Divider(modifier = Modifier.padding(horizontal = 16.dp))
                }
            }
        }
    }
}