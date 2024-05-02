package com.example.footballplayassistant.presentation.ui.screens.main

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.MatchFotoBox
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.cards.CommentsCard
import com.example.footballplayassistant.presentation.customviews.cards.CommonIconTextCard
import com.example.footballplayassistant.presentation.customviews.cards.CommonIconTextInventoryCard
import com.example.footballplayassistant.presentation.customviews.cards.CommonOtherInfoCard
import com.example.footballplayassistant.presentation.customviews.cards.GreenBorderCard
import com.example.footballplayassistant.presentation.customviews.cards.PlayersCard
import com.example.footballplayassistant.presentation.customviews.dialogwindows.DialogScreen
import com.example.footballplayassistant.presentation.customviews.dropdownmenus.CommonActionsMenu
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.customviews.rows.FieldNameRow
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import kotlinx.coroutines.launch

@Composable
@Preview
fun MatchScreen() {
    val navController = LocalNavController.current!!
    val showDialog = remember { mutableStateOf(false) }
    val expanded = remember { mutableStateOf(false) }

    val snackBarScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    if (showDialog.value)
        DialogScreen(
            header = stringResource(id = R.string.whoPlays),
            description = stringResource(id = R.string.youGetNotify2),
            greenButton = stringResource(id = R.string.playYourself),
            whiteButton = stringResource(id = R.string.callFriends),
            bottomButton = stringResource(id = R.string.cancel),
            onClickGreen = { navController.navigate(Route.ChooseTeamScreen.path) },
            onClickWhite = { navController.navigate(Route.InviteFriendsScreen.path) },
            onClickBottom = { showDialog.value = false },
            onDismissRequest = { showDialog.value = false }
        )

    Scaffold(containerColor = MaterialTheme.colorScheme.onPrimary,
        bottomBar = {
//            BottomButtonsEventEnd()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                CommonButton(
                    text = stringResource(id = R.string.participate),
                    style = MaterialTheme.typography.bodyLarge,
                    onClick = { showDialog.value = true },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )
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
                .padding(top = 12.dp)
                .padding(it)
        ) {
            val str = stringResource(
                id = R.string.refCopied
            )
            HeaderWithBackButton(
                text = stringResource(id = R.string.match),
                imageButton = R.drawable.ic_arrow_share_25,
                onClickBack = { navController.navigate(Route.MainScreen.path) },
                onClickOther = { expanded.value = true },
                actionsMenu = {
                    CommonActionsMenu(
                        expand = expanded,
                        actions = listOf(R.string.whatsapp, R.string.copyInvitation),
                        onClicks = listOf(
                            { Log.d("MyLog", "click menu 1") },
                            { snackBarScope.launch {
                                snackbarHostState.showSnackbar(
                                    message = str
                                )
                            } })
                    )
                },
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            LazyColumn {
                item {
                    MatchFotoBox(
                        currentPlayers = 5, maxPlayers = 10,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                            .padding(horizontal = 16.dp, vertical = 12.dp)
                    )
                }

                item { FieldNameRow(fieldName = "Футбольный манеж 38х16 «Спорт Ангар» Теплый стан ") }

                item {
                    Text(
                        text = "Москва, ул. Ленинский проспект, строение 2 корпус 3 ул. Ленинский проспект, строение 2",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.displaySmall.copy(
                            fontWeight = FontWeight.W500,
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        ),
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 22.dp)
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth(0.9f)
                    )
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        GreenBorderCard(
                            text = stringResource(id = R.string.cost), value = "1500₽",
                            modifier = Modifier
                                .weight(0.3f)
                        )
                        GreenBorderCard(
                            text = stringResource(id = R.string.sexMatch), value = "M",
                            modifier = Modifier
                                .weight(0.3f)
                        )
                        GreenBorderCard(
                            text = stringResource(id = R.string.type),
                            value = "открытый",
                            modifier = Modifier
                                .weight(0.3f)
                        )
                    }
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .padding(top = 32.dp, bottom = 11.dp),
                        horizontalArrangement = Arrangement.spacedBy(11.dp)
                    ) {
                        CommonIconTextCard(
                            icon = R.drawable.ic_time_black_24,
                            text = "08:00 - 12:00",
                            modifier = Modifier
                                .weight(1f)
                        )

                        CommonIconTextCard(
                            icon = R.drawable.ic_calendar_22,
                            text = "01.01.2021",
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .height(intrinsicSize = IntrinsicSize.Max),
                        horizontalArrangement = Arrangement.spacedBy(11.dp)
                    ) {
                        CommonIconTextInventoryCard(
                            modifier = Modifier
                                .weight(1f)
                        )

                        CommonOtherInfoCard(
                            onClick = { navController.navigate(Route.MatchInfoScreen.path) },
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .align(Alignment.CenterVertically)
                        )
                    }
                }

                item { PlayersCard() }

                item { CommentsCard(commentsList = listOf()) }
            }
        }
    }
}

@Composable
private fun BottomButtonsCancel() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier.border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    shape = RoundedCornerShape(12.dp)
                )
            ) {
                Column {
                    Text(
                        text = "Депозит",
                        style = MaterialTheme.typography.displaySmall.copy(
                            fontWeight = FontWeight.W500,
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        ),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                    Text(
                        text = "1500p",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.W600,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        textAlign = TextAlign.Center
                    )
                }
            }
            CommonButton(
                text = stringResource(id = R.string.cancelParticipate),
                containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        }
        Text(
            text = stringResource(id = R.string.autoReturn),
            style = MaterialTheme.typography.displaySmall.copy(
                fontWeight = FontWeight.W500,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 12.dp)
        )
    }
}

@Composable
private fun BottomButtonsEventEnd() {
    Column(
        modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CommonButton(text = stringResource(id = R.string.rateGame))
        Text(
            text = stringResource(id = R.string.eventEnd),
            style = MaterialTheme.typography.displaySmall.copy(
                fontWeight = FontWeight.W500,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            ),
            textAlign = TextAlign.Center
        )
    }
}