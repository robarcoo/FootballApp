package com.example.footballplayassistant.presentation.customviews.cards

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.ui.theme.Black04
import com.example.footballplayassistant.presentation.ui.theme.Gray75
import com.example.footballplayassistant.presentation.ui.theme.Green

@Composable
fun GreenBorderCard(modifier: Modifier = Modifier, text: String, value: String) {
    Card(
        modifier = modifier
            .border(width = 1.dp, color = Green, shape = RoundedCornerShape(12.dp))
            .width(105.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 16.dp, horizontal = 8.dp),
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                color = Gray75,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = value,
                fontWeight = FontWeight.W600,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                color = Black04,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}