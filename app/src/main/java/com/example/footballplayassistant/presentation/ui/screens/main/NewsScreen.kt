package com.example.footballplayassistant.presentation.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.CommonBottomBar
import com.example.footballplayassistant.presentation.customviews.buttons.SelectionButtons
import com.example.footballplayassistant.presentation.customviews.cards.GameCard
import com.example.footballplayassistant.presentation.customviews.cards.NewsCard
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
@Preview
fun NewsScreen() {
    val navController = LocalNavController.current!!

    val filterButton = remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onPrimary)
    ) {
        Column(modifier = Modifier.fillMaxHeight(0.25f)) {
            HeaderWithBackButton(
                text = stringResource(id = R.string.news),
                imageButton = R.drawable.ic_plus_24,
                onClickBack = { navController.navigate(Route.MainScreen.path) },
                onClickOther = { navController.navigate(Route.CreateEventScreen.path) },
                modifier = Modifier.padding(top = 12.dp)
            )

            SelectionButtons(
                valueList = listOf(
                    stringResource(id = R.string.friends),
                    stringResource(id = R.string.places)
                ),
                selectedItemIndex = 0,
                onSelected = { filterButton.value = it },
                modifier = Modifier.padding(vertical = 24.dp)
            )
        }

        LazyColumn(
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.horizontal)
                .fillMaxHeight(0.865f)
        ) {
            if (filterButton.value == 0) {
                item { NewsCard(place = "place", name = "name") }
                item { NewsCard(place = "place", name = "name") }
            } else {
                item { GameCard(place = "place", host = "name") }
            }
        }

        CommonBottomBar()
    }
}