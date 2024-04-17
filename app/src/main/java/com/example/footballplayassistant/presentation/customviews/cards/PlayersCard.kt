package com.example.footballplayassistant.presentation.customviews.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.ui.theme.Gray75
import com.example.footballplayassistant.presentation.ui.theme.Green

@Composable
@Preview
fun PlayersCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(top = 32.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.players),
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W500),
                modifier = Modifier.padding(bottom = 16.dp),
            )

            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.weight(0.15f)) {
                    Image(
                        painter = painterResource(R.drawable.user_foto),
                        contentDescription = "",
                        modifier = Modifier.padding(2.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.user_foto),
                        contentDescription = "",
                        modifier = Modifier.padding(2.dp)
                    )
                }
                Column(modifier = Modifier.weight(0.15f)) {
                    Image(
                        painter = painterResource(R.drawable.user_foto),
                        contentDescription = "",
                        modifier = Modifier.padding(2.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.user_foto),
                        contentDescription = "",
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
                            text = "name",
                            style = MaterialTheme.typography.bodyMedium
                                .copy(fontWeight = FontWeight.W600)
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "name",
                                style = MaterialTheme.typography.displaySmall
                                    .copy(fontWeight = FontWeight.W500),
                                color = Gray75,
                                modifier = Modifier.padding(end = 2.dp)
                            )
                            Icon(
                                imageVector = ImageVector.vectorResource
                                    (R.drawable.ic_arrow_green_next_8_13),
                                contentDescription = "",
                                tint = Green
                            )
                        }

                    }
                    Divider(
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
                            text = "name",
                            style = MaterialTheme.typography.bodyMedium
                                .copy(fontWeight = FontWeight.W400),
                        )
                        IconButton(
                            onClick = { /*TODO*/ },
                            colors = IconButtonDefaults.iconButtonColors(containerColor = Green)
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource
                                    (R.drawable.ic_arrows_24),
                                contentDescription = "",
                            )
                        }
                    }
                }
            }
        }
    }
}