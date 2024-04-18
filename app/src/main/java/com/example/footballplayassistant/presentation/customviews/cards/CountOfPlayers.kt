package com.example.footballplayassistant.presentation.customviews.cards

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun CountOfPlayers(currentPlayers: Int, maxPlayers: Int, modifier: Modifier = Modifier) {
    var color = MaterialTheme.colorScheme.secondary
    if (currentPlayers == maxPlayers)
        color = MaterialTheme.colorScheme.tertiaryContainer

    Card(
        modifier = modifier
            .fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Text(
            text = "$currentPlayers/$maxPlayers",
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W700),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}