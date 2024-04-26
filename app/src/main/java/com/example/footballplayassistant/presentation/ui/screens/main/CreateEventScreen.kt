package com.example.footballplayassistant.presentation.ui.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.CommonSwitch
import com.example.footballplayassistant.presentation.customviews.dropdownmenus.DropDownMenu
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.checkboxes.CheckBoxInventory
import com.example.footballplayassistant.presentation.customviews.checkboxes.CommonCheckBoxAgree
import com.example.footballplayassistant.presentation.customviews.dialogwindows.DialogScreen
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.customviews.radiobuttons.RadioButtonGroup
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.screens.authentication.addStar
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
@Preview
fun CreateEventScreen() {
    val navController = LocalNavController.current!!

    val flag = remember {
        mutableStateOf(true)
    }
    val showDialog = remember {
        mutableStateOf(false)
    }

    if (showDialog.value)
        DialogScreen(
            header = stringResource(id = R.string.gameCreated),
            description = stringResource(id = R.string.youGetNotify),
            greenButton = stringResource(id = R.string.onGamePage),
            whiteButton = stringResource(id = R.string.inviteFriends),
            bottomButton = stringResource(id = R.string.copy),
            image = R.drawable.ic_check_92,
            onClickGreen = { navController.navigate(Route.MatchScreen.path) },
            onClickWhite = { navController.navigate(Route.InviteFriendsScreen.path) },
            onClickBottom = {/*copy invitation*/ navController.navigate(Route.MatchScreen.path) },
            onDismissRequest = { showDialog.value = false }
        )

    Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onPrimary)) {
        HeaderWithBackButton(
            text = stringResource(id = R.string.addGame),
            onClickBack = { navController.navigate(Route.MainScreen.path) },
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )
        LazyColumn {
            item {
                BoldText(
                    id = R.string.field,
                    modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
                )

                DropDownMenu(
                    placeholder = "field",
                    values = listOf("Поле 1", "Поле 2"),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                CommonSwitch(
                    text = stringResource(id = R.string.closeGame), icon = true,
                    textIcon = stringResource(id = R.string.closeGameToast),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 24.dp)
                )
            }
            item {
                CommonSwitch(
                    text = stringResource(id = R.string.iWill), icon = true,
                    textIcon = stringResource(id = R.string.iWillToast),
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(top = 24.dp)
                )
            }
            item {
                BoldText(id = R.string.date, modifier = Modifier.padding(top = 24.dp))

                DropDownMenu(
                    placeholder = stringResource(id = R.string.date),
                    imStart = R.drawable.ic_calendar_22,
                    values = listOf("Поле 1", "Поле 2"),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                BoldText(
                    id = R.string.time,
                    modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {
                    CommonTextField(
                        placeholder = stringResource(id = R.string.start),
                        imageTrail = R.drawable.ic_time_black_24,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(end = 4.dp),
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
                    CommonTextField(
                        placeholder = stringResource(id = R.string.end),
                        imageTrail = R.drawable.ic_time_black_24,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(start = 4.dp),
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
                }
            }
            item {
                BoldText(
                    addStar = false,
                    id = R.string.details,
                    modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
                )
                CommonTextField(
                    placeholder = stringResource(id = R.string.title),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                CommonTextField(
                    placeholder = stringResource(id = R.string.otherInfo),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    singleLine = false,
                    cornerRadius = 20.dp,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp)
                )
            }
            item {
                Row {
                    BoldText(
                        id = R.string.countPlayers,
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .align(Alignment.CenterVertically)
                    )
                    DropDownMenu(
                        placeholder = "",
                        imStart = R.drawable.ic_people_24,
                        values = listOf(
                            "2",
                            "4",
                            "6",
                            "8",
                            "10",
                            "12",
                            "14",
                            "16",
                            "18",
                            "20",
                            "22"
                        ),
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            }
            item {
                Row {
                    BoldText(
                        id = R.string.minCountPlayers,
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .align(Alignment.CenterVertically)
                    )
                    DropDownMenu(
                        placeholder = "",
                        imStart = R.drawable.ic_people_24,
                        values = listOf(
                            "2",
                            "4",
                            "6",
                            "8",
                            "10",
                            "12",
                            "14",
                            "16",
                            "18",
                            "20",
                            "22"
                        ),
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            }
            item {
                BoldText(addStar = false, id = R.string.sexPlayers)
                RadioButtonGroup()
            }
            item {
                BoldText(id = R.string.inventory, modifier = Modifier.padding(top = 24.dp))
                CheckBoxInventory()
            }
            item {
                BoldText(
                    id = R.string.costEntry,
                    modifier = Modifier.padding(top = 24.dp, bottom = 12.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = MaterialTheme.spacing.horizontal)
                        .padding(bottom = MaterialTheme.spacing.small),
                ) {
                    Text(
                        text = stringResource(id = R.string.cost),
                        style = MaterialTheme.typography.displaySmall.copy(
                            fontWeight = FontWeight.W500
                        ),
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .weight(0.55f),
                    )

                    Text(
                        text = stringResource(id = R.string.commission),
                        style = MaterialTheme.typography.displaySmall.copy(
                            fontWeight = FontWeight.W500
                        ),
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .weight(0.45f),
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = MaterialTheme.spacing.horizontal)
                        .padding(bottom = 24.dp),
                ) {
                    CommonTextField(
                        placeholder = stringResource(id = R.string.cost),
                        imageTrail = R.drawable.ic_ruble_15,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(end = 16.dp),
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
                    CommonTextField(
                        placeholder = stringResource(id = R.string.commission),
                        imageTrail = R.drawable.ic_ruble_15,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(start = 16.dp),
                        readOnly = true
                    )
                }
            }
            item {
                CommonCheckBoxAgree()
            }
            item {
                if (flag.value) {
                    CommonButton(
                        text = stringResource(id = R.string.addEvent),
                        onClick = { showDialog.value = true },
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(MaterialTheme.spacing.medium)
                    )
//                    TextButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
//                        Text(
//                            text = stringResource(id = R.string.cancel),
//                            style = MaterialTheme.typography.bodyMedium.copy(
//                                fontWeight = FontWeight.W600),
//                            color = MaterialTheme.colorScheme.onSecondaryContainer
//                        )
//                    }
                } else {
                    CommonButton(
                        text = stringResource(id = R.string.addEvent),
                        style = MaterialTheme.typography.bodyLarge,
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier.padding(MaterialTheme.spacing.medium)
                    )
//                    TextButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
//                        Text(
//                            text = stringResource(id = R.string.cancel),
//                            style = MaterialTheme.typography.bodyMedium.copy(
//                                fontWeight = FontWeight.W600),
//                            color = MaterialTheme.colorScheme.onSecondaryContainer
//                        )
//                    }
                }
                TextButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = stringResource(id = R.string.cancel),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.W600
                        ),
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
        }
    }
}

@Composable
fun BoldText(
    id: Int,
    addStar: Boolean = true,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    if (addStar)
        Text(
            text = addStar(
                id = id,
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
                color = MaterialTheme.colorScheme.primary
            ),
            modifier = modifier.padding(horizontal = MaterialTheme.spacing.horizontal)
        )
    else
        Text(
            text = stringResource(id = id),
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W600),
            color = MaterialTheme.colorScheme.primary,
            modifier = modifier.padding(horizontal = MaterialTheme.spacing.horizontal)
        )
}