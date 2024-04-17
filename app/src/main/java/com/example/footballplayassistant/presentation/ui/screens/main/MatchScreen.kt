package com.example.footballplayassistant.presentation.ui.screens.main

import androidx.compose.foundation.background
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.customviews.rows.FieldNameRow
import com.example.footballplayassistant.presentation.ui.theme.GrayF1

@Composable
@Preview
fun MatchScreen() {
    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = GrayF1)
            ) {
                CommonButton(
                    text = stringResource(id = R.string.participate),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )
            }
        }) {
        Column(
            modifier = Modifier
                .padding(vertical = 12.dp)
                .padding(it)
        ) {
            HeaderWithBackButton(
                text = stringResource(id = R.string.match),
                imageButton = R.drawable.ic_arrow_share_25
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        GreenBorderCard(
                            text = stringResource(id = R.string.cost), value = "1500₽",
                        )
                        GreenBorderCard(
                            text = stringResource(id = R.string.sex), value = "M",
                        )
                        GreenBorderCard(
                            text = stringResource(id = R.string.type),
                            value = "открытый",
                        )
                    }
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 20.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CommonIconTextCard(
                            icon = R.drawable.ic_time_black_24,
                            text = "08:00 - 12:00",
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp)
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
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CommonIconTextInventoryCard(
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp)
                        )

                        CommonOtherInfoCard(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                                .align(Alignment.CenterVertically)
                        )
                    }
                }

                item { PlayersCard() }

                item { CommentsCard() }
            }
        }
    }
}

