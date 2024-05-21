package com.example.footballplayassistant.presentation.customviews.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R

@Composable
fun PlayersCard(modifier: Modifier = Modifier, name: String, participants: List<String>) {
    Card(
        modifier = modifier.padding(top = 32.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.players),
                style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.W500),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 16.dp),
            )

            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(0.15f)) {
                    Image(
                        painter = painterResource(R.drawable.user_foto),
                        contentDescription = "User foto",
                        modifier = Modifier.padding(2.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.user_foto),
                        contentDescription = "User foto",
                        modifier = Modifier.padding(2.dp)
                    )
                }
                Column(modifier = Modifier.weight(0.15f)) {
                    Image(
                        painter = painterResource(R.drawable.user_foto),
                        contentDescription = "User foto",
                        modifier = Modifier.padding(2.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.user_foto),
                        contentDescription = "User foto",
                        modifier = Modifier.padding(2.dp)
                    )
                }

                Column(modifier = Modifier.weight(0.7f)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = name,
                            style = MaterialTheme.typography.bodySmall
                                .copy(fontWeight = FontWeight.W600),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = stringResource(id = R.string.host),
                                style = MaterialTheme.typography.displaySmall
                                    .copy(fontWeight = FontWeight.W500),
                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(end = 2.dp)
                            )
                            Icon(
                                imageVector = ImageVector.vectorResource
                                    (R.drawable.ic_arrow_green_next_8_13),
                                contentDescription = "Arrow next",
                                tint = MaterialTheme.colorScheme.secondary
                            )
                        }

                    }
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = participants.joinToString(separator = ", "),
                            style = MaterialTheme.typography.labelMedium
                                .copy(fontWeight = FontWeight.W400),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = MaterialTheme.colorScheme.primary
                        )
                        IconButton(
                            onClick = { /*TODO*/ },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = MaterialTheme.colorScheme.primary
                            ),
                            modifier = Modifier.align(Alignment.Bottom)
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource
                                    (R.drawable.ic_arrows_24),
                                contentDescription = "Arrows",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                }
            }
        }
    }
}