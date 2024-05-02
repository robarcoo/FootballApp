package com.example.footballplayassistant.presentation.customviews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
fun CommonBottomBar(modifier: Modifier = Modifier) {
    val number = remember { mutableStateOf(1) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                vertical = MaterialTheme.spacing.small,
                horizontal = MaterialTheme.spacing.horizontal
            )
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(50.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxHeight(0.8f),
                colors =
                if (number.value == 1) ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                )
                else ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                contentPadding = PaddingValues(horizontal = 20.dp),
                onClick = { number.value = 1 }) {
                Row {
                    if (number.value == 1) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home_black_24),
                            contentDescription = null, tint = MaterialTheme.colorScheme.onTertiary,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.home),
                            style = MaterialTheme.typography.displaySmall
                                .copy(fontWeight = FontWeight.W600),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.align(Alignment.CenterVertically),
                            color = MaterialTheme.colorScheme.primary
                        )
                    } else
                        Icon(
                            painter = painterResource(id = R.drawable.ic_home_white_24),
                            contentDescription = null,
                        )

                }
            }
            Button(modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxHeight(0.8f),
                colors = if (number.value == 2) ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                )
                else ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                contentPadding = PaddingValues(horizontal = 20.dp),
                onClick = { number.value = 2 }) {
                Row {
                    if (number.value == 2) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search_black_25),
                            contentDescription = null, tint = MaterialTheme.colorScheme.onTertiary,
                            modifier = Modifier.padding(end = MaterialTheme.spacing.small)
                        )
                        Text(
                            text = stringResource(id = R.string.search),
                            style = MaterialTheme.typography.displaySmall
                                .copy(fontWeight = FontWeight.W600),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.align(Alignment.CenterVertically),
                            color = MaterialTheme.colorScheme.primary
                        )
                    } else
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search_white_25),
                            contentDescription = null,
                        )
                }
            }
            Button(modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxHeight(0.8f),
                colors =
                if (number.value == 3) ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                )
                else ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                contentPadding = PaddingValues(horizontal = 20.dp),
                onClick = { number.value = 3 }) {
                Row {
                    if (number.value == 3) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_calendar_22),
                            contentDescription = null, tint = MaterialTheme.colorScheme.onTertiary,
                            modifier = Modifier.padding(end = MaterialTheme.spacing.small)
                        )
                        Text(
                            text = stringResource(id = R.string.calendar),
                            style = MaterialTheme.typography.displaySmall
                                .copy(fontWeight = FontWeight.W600),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.align(Alignment.CenterVertically),
                            color = MaterialTheme.colorScheme.primary
                        )
                    } else
                        Icon(
                            painter = painterResource(id = R.drawable.ic_calendar_white_24),
                            contentDescription = null,
                        )
                }
            }
            Button(modifier = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxHeight(0.8f),
                colors =
                if (number.value == 4) ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary
                )
                else ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                contentPadding = PaddingValues(horizontal = 20.dp),
                onClick = { number.value = 4 }) {
                Row {
                    if (number.value == 4) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_profile_black_24),
                            contentDescription = null, tint = MaterialTheme.colorScheme.onTertiary,
                            modifier = Modifier.padding(end = MaterialTheme.spacing.small)
                        )
                        Text(
                            text = stringResource(id = R.string.profile),
                            style = MaterialTheme.typography.displaySmall
                                .copy(fontWeight = FontWeight.W600),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.align(Alignment.CenterVertically),
                            color = MaterialTheme.colorScheme.primary
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