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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.CommonBottomBar
import com.example.footballplayassistant.presentation.customviews.buttons.AllButton
import com.example.footballplayassistant.presentation.customviews.cards.GameCard
import com.example.footballplayassistant.presentation.customviews.cards.MoneyCard
import com.example.footballplayassistant.presentation.customviews.cards.NewsCard
import com.example.footballplayassistant.presentation.customviews.headers.HeaderUser
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.spacing

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun MainScreen() {
    val navController = LocalNavController.current!!
    val pagerState = rememberPagerState(pageCount = {
        3
    })
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onPrimary)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .padding(horizontal = MaterialTheme.spacing.horizontal)
        ) {
            item {
                HeaderUser(
                    name = "Alex",
                    onClickPlus = { navController.navigate(Route.CreateEventScreen.path) },
                    onClickBell = {},
                    modifier = Modifier
                )
            }

            item { MoneyCard(money = 1500, modifier = Modifier) }

            item { AllButton(text = stringResource(id = R.string.mygames), modifier = Modifier) }

            item {
                GameCard(
                    place = "Арена Новый Футбол поле  Крылатское ",
                    host = "Игорь Султанов"
                )
            }
            item { GameCard(place = "Арена Новый Футбол поле  Крылатское ", host = "") }

            item {
                AllButton(
                    text = stringResource(id = R.string.news),
                    onClick = { navController.navigate(Route.NewsScreen.path) },
                    modifier = Modifier
                )
            }

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
                            if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.background
                        Box(
                            modifier = Modifier
                                .padding(2.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(color)
                                .size(8.dp)
                        )
                    }
                }
            }
        }
        CommonBottomBar()
    }
}
