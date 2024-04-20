package com.example.footballplayassistant.presentation.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.dialogwindows.DialogScreen
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.customviews.rows.BottomRowDateTimeMoney
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.GrayF1

@Composable
@Preview
fun PaymentScreen() {
    val navController = LocalNavController.current!!
    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value)
        DialogScreen(
            header = stringResource(id = R.string.payOK),
            description = stringResource(id = R.string.darkdontForget),
            greenButton = stringResource(id = R.string.onGamePage),
            whiteButton = stringResource(id = R.string.returnMain),
            bottomButton = stringResource(id = R.string.inviteFriendsAlso),
            image = R.drawable.ic_check_92,
            onClickGreen = { navController.navigate(Route.MatchScreen.path) },
            onClickWhite = { navController.navigate(Route.MainScreen.path) },
            onClickBottom = { navController.navigate(Route.InviteFriendsScreen.path) },
            onDismissRequest = { showDialog.value = false }
        )

    Scaffold(bottomBar = {
        Column {
            CommonButton(
                text = stringResource(id = R.string.pay),
                onClick = { showDialog.value = true },
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Text(
                text = stringResource(id = R.string.cancelWithoutLoss),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                modifier = Modifier.padding(16.dp)
            )
        }

    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayF1)
                .padding(it)
        ) {
            HeaderWithBackButton(
                text = stringResource(id = R.string.payment),
                onClickBack = { navController.navigate(Route.MatchScreen.path) },
                modifier = Modifier.padding(vertical = 12.dp)
            )

            LazyColumn {
                item { BalanceCard(price = "1000") }
                item {
                    EventCard(
                        place = "place",
                        date = "01.07.2024",
                        price = "1000₽/чел",
                        time = "12:00"
                    )
                }
                item {
                    Text(
                        text = stringResource(id = R.string.detailsOperation),
                        style = MaterialTheme.typography.labelLarge
                            .copy(fontWeight = FontWeight.W500),
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .padding(bottom = 12.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .background(
                                color = MaterialTheme.colorScheme.onPrimary,
                                shape = RoundedCornerShape(12.dp)
                            ),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(id = R.string.partInMatch),
                            style = MaterialTheme.typography.labelLarge
                                .copy(fontWeight = FontWeight.W400),
                            modifier = Modifier.padding(12.dp)
                        )
                        Text(
                            text = "800₽",
                            style = MaterialTheme.typography.labelLarge
                                .copy(fontWeight = FontWeight.W400),
                            modifier = Modifier
                                .padding(12.dp)
                                .align(Alignment.CenterVertically)
                        )
                    }
                }
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(id = R.string.total),
                            style = MaterialTheme.typography.labelLarge
                                .copy(fontWeight = FontWeight.W500),
                        )
                        Text(
                            text = "800₽",
                            style = MaterialTheme.typography.displayLarge
                                .copy(fontWeight = FontWeight.W600),
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun EventCard(place: String, date: String, time: String, price: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 20.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                shape = RoundedCornerShape(12.dp)
            ),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Text(
            text = place,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.padding(12.dp)
        )

        Divider(modifier = Modifier.padding(horizontal = 16.dp))

        BottomRowDateTimeMoney(
            date = date, time = time, price = price,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }
}

@Composable
private fun BalanceCard(price: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = stringResource(id = R.string.balance),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                style = MaterialTheme.typography.displayMedium,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Text(
                    text = price,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W600),
                )
                Text(
                    text = "₽",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W400),
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(start = 8.dp)
                )
            }

            Text(
                text = stringResource(id = R.string.replenish),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.align(Alignment.Bottom)
            )
        }
    }
}