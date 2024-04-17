package com.example.footballplayassistant.presentation.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.AllButton
import com.example.footballplayassistant.presentation.customviews.buttons.ShowMore
import com.example.footballplayassistant.presentation.customviews.cards.GameCard
import com.example.footballplayassistant.presentation.customviews.cards.MoneyCard
import com.example.footballplayassistant.presentation.customviews.cards.NewsCard
import com.example.footballplayassistant.presentation.customviews.headers.HeaderUser

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun MainScreen() {
    val pagerState = rememberPagerState(pageCount = {
        3
    })
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.9f)
        ) {
            item { HeaderUser(name = "Alex", modifier = Modifier) }

            item { MoneyCard(money = 1500, modifier = Modifier) }

            item { AllButton(text = stringResource(id = R.string.mygames), modifier = Modifier) }

            item {
                GameCard(
                    place = "Арена Новый Футбол поле  Крылатское ",
                    host = "Игорь Султанов"
                )
            }
            item { GameCard(place = "Арена Новый Футбол поле  Крылатское ", host = "") }


            item { ShowMore() }
            item { AllButton(text = stringResource(id = R.string.news), modifier = Modifier) }

            item {
                HorizontalPager(state = pagerState) { page ->
                    NewsCard(place = "Арена Новый Футбол поле  Крылатское", name = "Игорь Султанов")
                }
                Row(
                    Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pagerState.pageCount) { iteration ->
                        val color =
                            if (pagerState.currentPage == iteration) Color.Black else Color.LightGray
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .clip(RectangleShape)
                                .background(color)
                                .size(8.dp)
                        )
                    }
                }
            }
        }
        BottomBar()
    }
}

@Composable
@Preview
private fun BottomBar() {
    val number = remember { mutableStateOf(-1) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .background(color = Color.Black, shape = RoundedCornerShape(50.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(
                modifier = Modifier.align(Alignment.CenterVertically),
                colors =
                if (number.value == 1) ButtonDefaults.buttonColors(containerColor = Color.White)
                else ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                onClick = { number.value = 1 }) {
                Row {
                    if (number.value == 1) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home_black_24),
                            contentDescription = null, tint = Color.Unspecified
                        )
                        Text(
                            text = stringResource(id = R.string.home),
                            style = MaterialTheme.typography.displaySmall
                                .copy(fontWeight = FontWeight.W600),
                            modifier = Modifier.align(Alignment.CenterVertically),
                            color = Color.Black
                        )
                    } else
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home_white_24),
                            contentDescription = null,
                        )

                }
            }
            Button(modifier = Modifier.align(Alignment.CenterVertically),
                colors = if (number.value == 2) ButtonDefaults.buttonColors(containerColor = Color.White) else ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                onClick = { number.value = 2 }) {
                Row {
                    if (number.value == 2) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search_black_25),
                            contentDescription = null, tint = Color.Unspecified
                        )
                        Text(
                            text = stringResource(id = R.string.search),
                            style = MaterialTheme.typography.displaySmall
                                .copy(fontWeight = FontWeight.W600),
                            modifier = Modifier.align(Alignment.CenterVertically),
                            color = Color.Black
                        )
                    } else
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search_white_25),
                            contentDescription = null,
                        )
                }
            }
            Button(modifier = Modifier.align(Alignment.CenterVertically),
                colors =
                if (number.value == 3) ButtonDefaults.buttonColors(containerColor = Color.White)
                else ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                onClick = { number.value = 3 }) {
                Row {
                    if (number.value == 3) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_calendar_22),
                            contentDescription = null, tint = Color.Unspecified
                        )
                        Text(
                            text = stringResource(id = R.string.calendar),
                            style = MaterialTheme.typography.displaySmall
                                .copy(fontWeight = FontWeight.W600),
                            modifier = Modifier.align(Alignment.CenterVertically),
                            color = Color.Black
                        )
                    } else
                        Icon(
                            painter = painterResource(id = R.drawable.ic_calendar_white_24),
                            contentDescription = null,
                        )
                }
            }
            Button(modifier = Modifier.align(Alignment.CenterVertically),
                colors =
                if (number.value == 4) ButtonDefaults.buttonColors(containerColor = Color.White)
                else ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                onClick = { number.value = 4 }) {
                Row {
                    if (number.value == 4) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_profile_black_24),
                            contentDescription = null, tint = Color.Unspecified
                        )
                        Text(
                            text = stringResource(id = R.string.profile),
                            style = MaterialTheme.typography.displaySmall
                                .copy(fontWeight = FontWeight.W600),
                            modifier = Modifier.align(Alignment.CenterVertically),
                            color = Color.Black
                        )
                    } else
                        Icon(
                            painter = painterResource(id = R.drawable.ic_profile_white_24),
                            contentDescription = null,
                        )
                }
            }
        }
    }
}
