package com.example.footballplayassistant.presentation.customviews.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import com.example.footballplayassistant.presentation.customviews.rows.UserFotoForList
import com.example.footballplayassistant.presentation.ui.theme.Gray75

@Composable
fun CurrentCommentCard(
    modifier: Modifier = Modifier,
    date: String,
    name: String,
    likes: Int,
    text: String
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                UserFotoForList(
                    text = date, name = name, foto = R.drawable.user_foto,
                    modifier = Modifier.weight(0.95f)
                )

                Row(
                    modifier = Modifier.weight(0.15f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "$likes",
                        style = MaterialTheme.typography.bodyMedium
                            .copy(fontWeight = FontWeight.W400),
                        color = Gray75,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_like_20),
                        contentDescription = "",
                        tint = Gray75
                    )
                }
            }

            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.W400),
                maxLines = 3
            )
        }
    }
}