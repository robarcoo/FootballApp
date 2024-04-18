package com.example.footballplayassistant.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.checkboxes.CommonCheckBoxAgree
import com.example.footballplayassistant.presentation.customviews.CommonSwitch
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.customviews.DropDownMenu
import com.example.footballplayassistant.presentation.customviews.RadioButtonGroup
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.checkboxes.CheckBoxInventory
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.GrayF1
import com.example.footballplayassistant.presentation.ui.theme.GrayBB
import com.example.footballplayassistant.presentation.ui.theme.Gray75
import com.example.footballplayassistant.presentation.ui.theme.Yellow00

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

    Column {
        HeaderWithBackButton(
            text = stringResource(id = R.string.addGame),
            modifier = Modifier.padding(vertical = 8.dp)
        )
        LazyColumn {
            item {
                CommonSwitch(
                    text = stringResource(id = R.string.closeGame), icon = true,
                    textIcon = stringResource(id = R.string.closeGameToast)
                )
            }
            item {
                CommonSwitch(
                    text = stringResource(id = R.string.iWill), icon = true,
                    textIcon = stringResource(id = R.string.iWillToast)
                )
            }
            item {
                BoldText(id = R.string.field, modifier = Modifier.padding(top = 24.dp))

                DropDownMenu(
                    placeholder = "field",
                    values = listOf("Поле 1", "Поле 2"),
                    color = GrayF1,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                BoldText(id = R.string.date, modifier = Modifier.padding(top = 24.dp))

                DropDownMenu(
                    placeholder = stringResource(id = R.string.date),
                    imStart = R.drawable.ic_calendar_22,
                    values = listOf("Поле 1", "Поле 2"),
                    color = GrayF1,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                BoldText(id = R.string.time, modifier = Modifier.padding(top = 24.dp))

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
                        color = GrayF1
                    )
                    CommonTextField(
                        placeholder = stringResource(id = R.string.end),
                        imageTrail = R.drawable.ic_time_black_24,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(start = 4.dp),
                        color = GrayF1
                    )
                }
            }
            item {
                BoldText(
                    addStar = false,
                    id = R.string.details,
                    modifier = Modifier.padding(top = 24.dp)
                )
                CommonTextField(
                    placeholder = stringResource(id = R.string.title),
                    color = GrayF1,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                CommonTextField(
                    placeholder = stringResource(id = R.string.otherInfo),
                    color = GrayF1,
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
                        color = GrayF1,
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
                        color = GrayF1,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            }
            item {
                BoldText(addStar = false, id = R.string.sexPlayers)
                Row {
                    RadioButtonGroup()
                }
            }
            item {
                BoldText(id = R.string.inventory, modifier = Modifier.padding(top = 24.dp))
                CheckBoxInventory()
            }
            item {
                BoldText(id = R.string.costEntry, modifier = Modifier.padding(top = 24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {
                    Text(
                        text = stringResource(id = R.string.cost),
                        color = Gray75,
                        modifier = Modifier
                            .weight(0.55f),
                    )

                    Text(
                        text = stringResource(id = R.string.commission),
                        color = Yellow00,
                        modifier = Modifier
                            .weight(0.45f),
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {
                    CommonTextField(
                        placeholder = stringResource(id = R.string.cost),
                        imageTrail = R.drawable.ic_ruble_15,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(end = 16.dp),
                        color = GrayF1
                    )
                    CommonTextField(
                        placeholder = stringResource(id = R.string.commission),
                        imageTrail = R.drawable.ic_ruble_15,
                        color = GrayF1,
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
                if (flag.value)
                    CommonButton(
                        text = stringResource(id = R.string.addEvent),
                        onClick = { showDialog.value = true },
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                    )
                else
                    CommonButton(
                        text = stringResource(id = R.string.addEvent),
                        containerColor = GrayBB,
                        contentColor = Gray75,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                    )
            }
            item {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.cantCancel),
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_question_14),
                        contentDescription = ""
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
            text = addStar(id = id),
            fontFamily = FontFamily(Font(R.font.inter)),
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
            modifier = modifier.padding(horizontal = 16.dp)
        )
    else
        Text(
            text = stringResource(id = id),
            fontFamily = FontFamily(Font(R.font.inter)),
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
            modifier = modifier.padding(horizontal = 16.dp)
        )
}