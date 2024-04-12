package com.example.footballplayassistant.presentation.customviews.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.rows.BottomRowDateTimeMoney
import com.example.footballplayassistant.presentation.customviews.rows.FotoAndNameForCard
import com.example.footballplayassistant.presentation.ui.theme.Gray75

@Composable
fun GameCard(place: String, host: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            if (host == "") {
                Text(
                    text = stringResource(id = R.string.youhost),
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Row(modifier = Modifier.padding(vertical = 8.dp)) {
                    Text(
                        text = place,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.85f)
                    )
                    CountOfPlayers(
                        currentPlayers = 10, maxPlayers = 10, modifier = Modifier
                            .weight(0.15f)
                            .align(Alignment.CenterVertically)
                    )
                }
                Divider(modifier = Modifier.padding(vertical = 8.dp))
            } else {
                Row {
                    Text(
                        text = place,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        fontWeight = FontWeight.W500,
                        fontSize = 16.sp,
                        maxLines = 2,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.75f)
                            .padding(vertical = 12.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.25f)
                            .padding(top = 12.dp), horizontalArrangement = Arrangement.End
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_location_24),
                            contentDescription = ""
                        )
                        Text(
                            text = "100км",
                            fontFamily = FontFamily(Font(R.font.inter)),
                            fontWeight = FontWeight.W500,
                            fontSize = 14.sp,
                            color = Gray75
                        )
                    }
                }
                Row {
                    FotoAndNameForCard(
                        text = host,
                        name = host,
                        foto = R.drawable.user_foto,
                        modifier = Modifier.weight(0.85f)
                    )
                    CountOfPlayers(
                        currentPlayers = 10, maxPlayers = 10, modifier = Modifier
                            .weight(0.15f)
                            .align(Alignment.CenterVertically)
                    )
                }
            }

            BottomRowDateTimeMoney(date = "27.08.10", time = "12:00", price = "700")
        }
    }
}