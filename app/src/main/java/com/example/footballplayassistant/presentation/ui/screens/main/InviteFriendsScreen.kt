package com.example.footballplayassistant.presentation.ui.screens.main

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.checkboxes.CheckBoxFriend
import com.example.footballplayassistant.presentation.customviews.dialogwindows.DialogScreen
import com.example.footballplayassistant.presentation.customviews.dropdownmenus.CommonActionsMenu
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import kotlinx.coroutines.launch

@Composable
@Preview
fun InviteFriendsScreen() {
    val navController = LocalNavController.current!!

    val showDialog = remember { mutableStateOf(false) }
    val isFriends = true
    val expanded = remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val snackBarScope = rememberCoroutineScope()

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

    Scaffold(containerColor = MaterialTheme.colorScheme.onPrimary,
        bottomBar = {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                CommonButton(
                    text = stringResource(
                        id = if (isFriends) R.string.invite
                        else R.string.copyInvitation
                    ),
                    style = MaterialTheme.typography.bodyLarge,
                    onClick = { showDialog.value = true },
                    modifier = Modifier
                )
                TextButton(modifier = Modifier.fillMaxWidth(),
                    onClick = { navController.navigate(Route.MainScreen.path) }) {
                    Text(
                        text = stringResource(id = R.string.cancel),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
            ) {
                Snackbar(
                    snackbarData = it,
                    containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    shape = RoundedCornerShape(12.dp)
                )
            }
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 12.dp)
                .padding(it),
        ) {
            val str = stringResource(
                id = R.string.refCopied
            )
            HeaderWithBackButton(
                text = stringResource(id = R.string.inviteFriend),
                imageButton = R.drawable.ic_arrow_share_25,
                onClickBack = { navController.navigate(Route.MatchScreen.path) },
                onClickOther = { expanded.value = true },
                actionsMenu = {
                    CommonActionsMenu(
                        expand = expanded,
                        actions = listOf(R.string.whatsapp, R.string.copyInvitation),
                        onClicks = listOf(
                            { Log.d("MyLog", "click menu 1") },
                            {
                                snackBarScope.launch {
                                    snackbarHostState.showSnackbar(
                                        message = str
                                    )
                                }
                            })
                    )
                },
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .padding(horizontal = 16.dp)
            )

            if (isFriends) {
                //есть друзья
                LazyColumn {
                    item {
                        CheckBoxFriend(
                            text = "text",
                            name = "name name",
                            foto = R.drawable.user_foto
                        )
                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            thickness = 1.dp, color = MaterialTheme.colorScheme.background
                        )
                    }
                    item {
                        CheckBoxFriend(
                            text = "text",
                            name = "name name",
                            foto = R.drawable.user_foto
                        )
                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            thickness = 1.dp, color = MaterialTheme.colorScheme.background
                        )
                    }
                    item {
                        CheckBoxFriend(
                            text = "text",
                            name = "name name",
                            foto = R.drawable.user_foto
                        )
                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            thickness = 1.dp, color = MaterialTheme.colorScheme.background
                        )
                    }
                    item {
                        CheckBoxFriend(
                            text = "text",
                            name = "name name",
                            foto = R.drawable.user_foto
                        )
                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            thickness = 1.dp, color = MaterialTheme.colorScheme.background
                        )
                    }
                }
            } else {
                //нет друзей
                NoFriends()
            }
        }
    }
}

@Composable
private fun NoFriends() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.noFriends),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W600),
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )
        Text(
            text = stringResource(id = R.string.youCanCopy),
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.W400),
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}