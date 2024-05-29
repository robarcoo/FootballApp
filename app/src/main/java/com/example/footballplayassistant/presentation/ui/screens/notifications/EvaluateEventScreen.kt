package com.example.footballplayassistant.presentation.ui.screens.notifications

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.ui.screens.search_tab.NecessaryTextField
import com.example.footballplayassistant.presentation.ui.screens.search_tab.ToggleButton
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
fun EvaluateEventScreen() {
    Column {
        HeaderWithBackButton(text =)
        Text()
        Card() {
            Row() {
                OutlinedPhotoGrid()
                Text()
                Icon()
            }
        }
        EvaluationCard("Оценте хоста")
        EvaluationCard("Оцените поле")
        Text("Оставьте комментарий о поле")
        NecessaryTextField(label = "Комментарий", modifier = Modifier.defaultMinSize(minHeight = MaterialTheme.spacing.extraLarge),
            isSingleLine = false, shape = RoundedCornerShape(20.dp), toCountWords = true)
        Column() {
            CommonButton("Подтвердить")
            Text("Пропустить")
        }
    }
}

@Composable
fun EvaluationCard(title : String) {
    var rating by remember { mutableIntStateOf(0) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(title, style = MaterialTheme.typography.displayMedium)
        Row() {
            repeat(rating) {
                IconButton(onClick = { rating = it }) {
                    Icon(painterResource(id = R.drawable.ic_star), contentDescription = "",
                        tint = MaterialTheme.colorScheme.onBackground)
                }
            }
            repeat(5 - rating) {
                IconButton(onClick = { rating = it }) {
                    Icon(painterResource(id = R.drawable.ic_star), contentDescription = "",
                        tint = MaterialTheme.colorScheme.tertiaryContainer)
                }
            }
        }
        ToggleButton(title = "", items = arrayOf(""))
    }
}

@Composable
fun OutlinedPhotoGrid() {

}