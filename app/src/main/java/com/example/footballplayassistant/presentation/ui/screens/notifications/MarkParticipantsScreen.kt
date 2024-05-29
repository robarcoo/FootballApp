package com.example.footballplayassistant.presentation.ui.screens.notifications

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.footballplayassistant.presentation.customviews.checkboxes.CheckBoxFriend
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.ui.screens.search_tab.Player

@Composable
fun MarkParticipantsScreen(date : String, players : List<Player>) {
    val state = remember { mutableStateOf(false) }
    Column {
        HeaderWithBackButton(text = "Участники $date")
        Row() {
            Checkbox(
                checked = state.value,
                onCheckedChange = { state.value = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = MaterialTheme.colorScheme.secondary,
                    uncheckedColor = MaterialTheme.colorScheme.secondary,
                ),
                modifier = Modifier.fillMaxWidth(0.2f)
            )
        }
        LazyColumn {
            items(players.size) {
                HorizontalDivider()
                CheckBoxFriend(text = "@tag", name = players[it].name, foto = players[it].photo)
                HorizontalDivider()
            }
        }
        Button()
        Text()
    }
}



