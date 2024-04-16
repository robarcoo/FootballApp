package com.example.footballplayassistant.presentation.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.PlayerInTeam
import com.example.footballplayassistant.presentation.customviews.cards.CountOfPlayers
import com.example.footballplayassistant.presentation.ui.theme.Gray75
import com.example.footballplayassistant.presentation.ui.theme.GrayBB

@Composable
@Preview
fun ChooseTeamScreen() {
    Scaffold(bottomBar = {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                RoundButton(enable = true)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                RoundButton(enable = false)
            }
        }
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(top = 12.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderWithBackButton(text = "name")

            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        text = stringResource(id = R.string.teamsCanChanged),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W600,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        color = Gray75,
                        modifier = Modifier.padding(vertical = 14.dp)
                    )
                }

                item {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(
                            modifier = Modifier.weight(0.4f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(id = R.string.lightTeam),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W600,
                                fontFamily = FontFamily(Font(R.font.inter)),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            CountOfPlayers(
                                currentPlayers = 5,
                                maxPlayers = 10,
                                modifier = Modifier.width(60.dp)
                            )
                        }
                        Column(
                            modifier = Modifier.weight(0.4f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(id = R.string.darkTeam),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W600,
                                fontFamily = FontFamily(Font(R.font.inter)),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            CountOfPlayers(
                                currentPlayers = 10,
                                maxPlayers = 10,
                                modifier = Modifier.width(60.dp)
                            )
                        }
                    }
                }

                item {
                    Row(modifier = Modifier.padding(top = 24.dp)) {
                        Column(
                            modifier = Modifier.weight(0.5f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            for (i in 0..5)
                                PlayerInTeam(
                                    userTag = "@user1245",
                                    position = "вратарь",
                                    foto = R.drawable.user_foto
                                )
                        }
                        Column(
                            modifier = Modifier.weight(0.5f),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            for (i in 0..10)
                                PlayerInTeam(
                                    userTag = "@user12345",
                                    position = "вратарь",
                                    foto = R.drawable.user_foto
                                )
                        }
                    }

                }
            }
        }
    }
}

@Composable
private fun RoundButton(enable: Boolean) {
    IconButton(
        onClick = { /*TODO*/ },
        enabled = enable,
        modifier = Modifier.border(
            width = 1.dp,
            color = if (enable) Gray75 else GrayBB,
            shape = CircleShape
        )
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_plus_24),
            contentDescription = "",
            tint = if (enable) Gray75 else GrayBB
        )
    }
    Text(
        text = if (enable) stringResource(id = R.string.join) else stringResource(id = R.string.noEmpty),
        fontSize = 16.sp,
        fontWeight = FontWeight.W500,
        fontFamily = FontFamily(Font(R.font.inter)),
        modifier = Modifier.padding(top = 8.dp)
    )
}