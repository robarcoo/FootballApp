package com.example.footballplayassistant.presentation.ui.screens.notifications

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.ui.screens.search_tab.Event
import com.example.footballplayassistant.presentation.ui.screens.search_tab.NecessaryTextField
import com.example.footballplayassistant.presentation.ui.screens.search_tab.PhotoGrid
import com.example.footballplayassistant.presentation.ui.screens.search_tab.Player
import com.example.footballplayassistant.presentation.ui.screens.search_tab.ToggleButton
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
@Preview
fun EvaluateEventScreen() {
    val event = Event(
        "Арена Новый Футбол поле  Крылатское",
        listOf(
            Player("Игорь", "Султанов", R.drawable.loadexample),
            Player("Егор", "Дружин", R.drawable.player_example),
            Player("Серявгей", "Сергеев", R.drawable.player_example_1),
            Player("Игорь", "Султанов", R.drawable.loadexample),
            Player("Игорь", "Султанов", R.drawable.loadexample),
            Player("Игорь", "Султанов", R.drawable.loadexample),
            Player("Игорь", "Султанов", R.drawable.loadexample),
        ),
        "27.07.2023",
        "10:00",
        500
    )
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(MaterialTheme.spacing.medium)
            .verticalScroll(rememberScrollState())){
        HeaderWithBackButton(text = "Оцените событие")
        Text("Ваш отзыв поможет сервису улучшить качество услуг, а другим игрокам получить позитивные эмоции от событий",
            style = MaterialTheme.typography.labelMedium.copy(
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontWeight = FontWeight.W400,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.padding(vertical = MaterialTheme.spacing.medium))
        Card(modifier = Modifier.fillMaxWidth(), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)) {
            Row(Modifier.padding(MaterialTheme.spacing.extraSmall), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)) {
                PhotoGrid(event = event, addBorder = true)
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text("Выбрать лучшего игрока",
                        modifier = Modifier.weight(1f, fill = false),
                        style = MaterialTheme.typography.displayMedium.copy(
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ))
                    Icon(
                        painterResource(id = R.drawable.ic_arrow_next_24),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
        EvaluationCard("Оцените хоста", arrayOf("Опоздание хоста", "Невежливый", "Хамит", "Недействительная информация"))
        EvaluationCard("Оцените поле", arrayOf("Расположение поля", "Состояние поля", "Часы работы", "Освещение", "Доп услуги"))
        Text("Оставьте комментарий о поле",
            style = MaterialTheme.typography.displaySmall.copy(
                color = MaterialTheme.colorScheme.onSecondaryContainer
            ),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(vertical = MaterialTheme.spacing.extraSmall))
        NecessaryTextField(label = "Комментарий", modifier = Modifier.defaultMinSize(minHeight = MaterialTheme.spacing.extraLarge),
            isSingleLine = false, shape = RoundedCornerShape(20.dp), toCountWords = true)
        Spacer(modifier = Modifier.weight(1f))
        Column(verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium), 
            horizontalAlignment = Alignment.CenterHorizontally) {
            CommonButton("Подтвердить")
            Text("Пропустить", style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.W600
            ))
        }
    }
}

@Composable
fun EvaluationCard(title : String, items : Array<String>) {
    var rating by remember { mutableIntStateOf(0) }
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(vertical = MaterialTheme.spacing.small)
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(vertical = MaterialTheme.spacing.medium)) {
        Text(title, style = MaterialTheme.typography.displayMedium)
        Row(modifier = Modifier.padding(top = MaterialTheme.spacing.medium)) {
            repeat(rating) {
                IconButton(onClick = { rating = it + 1 }) {
                    Icon(painterResource(id = R.drawable.ic_star), contentDescription = "",
                        tint = MaterialTheme.colorScheme.onBackground)
                }
            }
            repeat(5 - rating) {
                IconButton(onClick = { rating = (rating + (it + 1)) }) {
                    Icon(painterResource(id = R.drawable.ic_star), contentDescription = "",
                        tint = MaterialTheme.colorScheme.tertiaryContainer)
                }
            }
        }
    }
    ToggleButton(items = items, selectAll = false)

}

