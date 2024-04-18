package com.example.footballplayassistant.presentation.ui.screens.search_tab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton

@Composable
@Preview
fun NoResultsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center) {
            Text(
                text = "Поля не найдены", style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.W600
            )
            Spacer(modifier = Modifier.size(12.dp))
            Text(
                text = "По заданным фильтрам не было найдено игр или площадок, попробуйте изменить параметры поиска или создать собственное событие",
                textAlign = TextAlign.Center, style = MaterialTheme.typography.bodyMedium
            )
        }
        CommonButton(text = "Добавить поле")

    }

    //Spacer(modifier = Modifier.weight(1f))
}