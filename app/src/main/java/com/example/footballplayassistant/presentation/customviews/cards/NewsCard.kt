package com.example.footballplayassistant.presentation.customviews.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.rows.BottomRowDateTimeMoney
import com.example.footballplayassistant.presentation.customviews.rows.FotoAndNameForCard
import com.example.footballplayassistant.presentation.ui.theme.Gray75

@Composable
fun NewsCard(place: String, name: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(12.dp))
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row {
                FotoAndNameForCard(
                    text = "хост",
                    name = name,
                    foto = R.drawable.user_foto,
                    modifier = Modifier.weight(0.85f)
                )
                CountOfPlayers(
                    currentPlayers = 10, maxPlayers = 10, modifier = Modifier
                        .weight(0.15f)
                        .align(Alignment.CenterVertically)
                )
            }
            Row(modifier = Modifier.padding(vertical = 12.dp)) {
                Text(
                    text = place,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.W500),
                    maxLines = 2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.8f)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f)
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_location_24),
                        contentDescription = ""
                    )
                    Text(
                        text = "100км",
                        style = MaterialTheme.typography.bodyMedium
                            .copy(fontWeight = FontWeight.W500),
                        color = Gray75
                    )
                }
            }

            Divider(modifier = Modifier.padding(horizontal = 12.dp))

            BottomRowDateTimeMoney(date = "27.08.10", time = "12:00", price = "700")
        }
    }
}