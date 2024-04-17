package com.example.footballplayassistant.presentation.customviews.rows

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.presentation.ui.theme.Gray75

@Composable
fun FotoAndNameForCard(text: String, name: String, foto: Int, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        Image(painter = painterResource(id = foto), contentDescription = "")

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f)
                .padding(start = 10.dp)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                color = Gray75
            )
            Text(
                text = name,
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W600),
            )
        }
    }
}