package com.example.footballplayassistant.presentation.customviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R

@Composable
fun BottomRowDateTimeMoney(
    date: String,
    time: String,
    price: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_calendar_gray_24),
                contentDescription = ""
            )
            Text(
                text = date,
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 4.dp)
            )
        }
        Row {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_time_24),
                contentDescription = ""
            )
            Text(
                text = time,
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 4.dp)
            )
        }

        Text(
            text = "$price ₽",
            fontWeight = FontWeight.W600,
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 4.dp)
        )
    }
}