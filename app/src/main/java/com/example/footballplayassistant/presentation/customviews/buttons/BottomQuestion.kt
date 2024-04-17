package com.example.footballplayassistant.presentation.customviews.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.presentation.ui.theme.Green

@Composable
fun BottomQuestion(question: String, buttonText: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = question,
            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.W500),
            textAlign = TextAlign.End,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Button(modifier = Modifier.wrapContentSize(),
            contentPadding = PaddingValues(5.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = { /*TODO*/ }) {
            Text(
                text = buttonText,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.W500),
                color = Green
            )
        }
    }
}