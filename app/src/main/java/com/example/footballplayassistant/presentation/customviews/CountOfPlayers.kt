package com.example.footballplayassistant.presentation.customviews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.footballplayassistant.ui.theme.GrayC9
import com.example.footballplayassistant.ui.theme.Green

@Composable
fun CountOfPlayers(currentPlayers: Int, maxPlayers: Int, modifier: Modifier = Modifier) {
    var color = Green
    if (currentPlayers == maxPlayers)
        color = GrayC9

    Card(
        modifier = modifier
            .fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "$currentPlayers/$maxPlayers")
        }

    }
}