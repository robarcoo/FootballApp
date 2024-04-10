package com.example.footballplayassistant.presentation.customviews.rows

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.ui.theme.GrayText

@Composable
fun FotoAndName(text: String, name: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        Image(painter = painterResource(id = R.drawable.user_foto), contentDescription = "")

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f)
                .padding(start = 10.dp)
        ) {
            Text(
                text = text,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                color = GrayText
            )
            Text(
                text = name,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight.W600,
                fontSize = 16.sp
            )
        }
    }
}