package com.example.footballplayassistant.presentation.ui.screens.search_tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
fun AdditionalFieldInfoScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier.padding(MaterialTheme.spacing.medium)) {
            HeaderWithBackButton(text = "Информация о поле")
            Text(
                "Футбольный манеж 38х16 «Спорт Ангар» Теплый стан ",
                style = MaterialTheme.typography.displayMedium.copy(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.W600
                ),
                modifier = Modifier.padding(bottom = MaterialTheme.spacing.medium,
                    top = MaterialTheme.spacing.small)
            )
            Text(
                "Крутое поле на базе Крылатское. Удобное расположение и транспортная развязка для удобства. Есть аренда инвентаря для всех видов спорта. Крутое поле на базе Крылатское. Удобное расположение и транспортная развязка для удобства. Есть аренда инвентаря для всех видов спорта.",
                style = MaterialTheme.typography.labelMedium.copy(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.W400
                ),
                modifier = Modifier.padding(bottom = MaterialTheme.spacing.extraLarge)
            )
        }
        Column(modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .padding(MaterialTheme.spacing.medium)) {
            FieldInfoDetail(icon = R.drawable.ic_ruler, title = "Размеры поля", value = "45х30")
            FieldInfoDetail(icon = R.drawable.ic_field, title = "Площадка", value = "Открытая")
            FieldInfoDetail(icon = R.drawable.ic_covering, title = "Покрытие", value = "Искусственная трава")
            FieldInfoDetail(icon = R.drawable.ic_shower, title = "Душ", value = "Да")
            FieldInfoDetail(icon = R.drawable.ic_lightbulb, title = "Освещение", value = "Искусственное")
            FieldInfoDetail(icon = R.drawable.ic_changing_room, title = "Раздевалки", value = "Закрытые")
            FieldInfoDetail(icon = R.drawable.ic_tribune, title = "Трибуны", value = "40 мест")
            FieldInfoDetail(icon = R.drawable.ic_people_24, title = "Кол-во игроков", value = "До 20")

        }

    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FieldInfoDetail(icon : Int, title : String, value : String) {
    Column {
        FlowRow(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = MaterialTheme.spacing.medium),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Row(modifier = Modifier.weight(1f, fill = false).align(Alignment.CenterVertically),
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
                verticalAlignment = Alignment.CenterVertically) {
                Icon(painterResource(id = icon), contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary)
                Text(title, style = MaterialTheme.typography.labelMedium.copy(
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.W400
                ))
            }
            Text(value, style = MaterialTheme.typography.displayMedium.copy(
                color = MaterialTheme.colorScheme.onPrimaryContainer
            ))
        }
        HorizontalDivider(color = MaterialTheme.colorScheme.tertiaryContainer, thickness = 1.dp,
            modifier = Modifier.padding(vertical = MaterialTheme.spacing.extraSmall))
    }
}