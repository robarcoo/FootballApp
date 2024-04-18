package com.example.footballplayassistant.presentation.ui.screens.search_tab

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.CommonSwitch
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.ui.theme.Black04
import com.example.footballplayassistant.presentation.ui.theme.Black21
import com.example.footballplayassistant.presentation.ui.theme.GrayC9
import com.example.footballplayassistant.presentation.ui.theme.Green


@Composable
@Preview
fun FilterScreen() {
    Column (modifier = Modifier.padding(top = 11.dp).fillMaxSize()){
        HeaderWithBackButton(text = "Фильтры")
        CommonSwitch(text = "По избранным площадкам")
        CommonSwitch(text = "Фильтрация по удаленности")
        Spacer(modifier = Modifier.height(32.dp))
        FilterRangeSlider("Удаленность от вас (км)", 0f, 50f)
        FilterRangeSlider("Количество игроков (чел)", 12f, 48f)
        ToggleButton("Тип площадки", listOf("Открытый", "Закрытый"))
        ToggleButton("Покрытие", listOf("Искуственная трава", "Гибридный газон", "Натуральная трава", "Другое покрытие"))
        Spacer(modifier = Modifier.weight(1f))
        FilterBottomBar()
    }
}

@Composable
fun FilterBottomBar() {
    HorizontalDivider(thickness = 1.dp, color = GrayC9)
    Row(modifier = Modifier
        .height(82.dp)
        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically) {

        FilterButton("Сбросить", Color.Transparent, Black04) {
            TODO()
        }
        FilterButton("Применить",  Black04, Color.White) {
            TODO()
        }
    }
}

@Composable
fun FilterButton(text : String, containerColor : Color, contentColor: Color, onClick : () -> Unit) {
    Button(onClick = onClick,
        contentPadding = PaddingValues(
            start = 40.dp,
            end = 40.dp,
            top = 16.dp,
            bottom = 16.dp
        ),
        colors = ButtonDefaults.buttonColors(containerColor = containerColor,
            contentColor = contentColor)) {
        Text(text, style = MaterialTheme.typography.labelMedium)
    }

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ToggleButton(title : String, items : List<String>) {
    var selectedIndex by remember { mutableStateOf(0) }
    Column(modifier = Modifier.padding(bottom = 32.dp, start = 16.dp, end = 16.dp)) {
        Text(
            title, style = MaterialTheme.typography.labelLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        FlowRow(horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items.forEachIndexed { index, item ->
                OutlinedButton(
                    contentPadding = PaddingValues(
                        top = 4.dp,
                        bottom = 4.dp,
                        start = 12.dp,
                        end = 12.dp
                    ),
                    onClick = { selectedIndex = index },
                    shape = RoundedCornerShape(8.dp),
                    border = if (selectedIndex == index) {
                        BorderStroke(1.dp, color = Green)
                    } else {
                        BorderStroke(1.dp, color = GrayC9)
                    },
                    colors = if (selectedIndex == index) {
                        ButtonDefaults.outlinedButtonColors(containerColor = Color.White) }
                    else {
                        ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent)
                    }
                ) {
                    Text(text = item, style = MaterialTheme.typography.labelMedium,  color = Black04)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterRangeSlider(text: String, activeRangeStart: Float, activeRangeEnd: Float) {
    Column(modifier = Modifier.padding(bottom = 16.dp, start = 16.dp, end = 16.dp)) {
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text, style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .padding(horizontal = 8.dp, vertical = 3.dp)
            ) {
                Text("${activeRangeStart.toInt()}-${activeRangeEnd.toInt()}",
                    style = MaterialTheme.typography.bodyMedium)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        val rangeSliderState = remember {
            RangeSliderState(
                activeRangeStart,
                activeRangeEnd,
                valueRange = activeRangeStart..activeRangeEnd,
                onValueChangeFinished = {
                    // add business logic
                },
                steps = (activeRangeEnd - activeRangeStart).toInt()
            )
        }
        RangeSlider(state = rangeSliderState,
            startThumb = {
                Image(painterResource(R.drawable.knob), contentDescription = "Knob")
            },
            endThumb = {
                Image(painterResource(R.drawable.knob), contentDescription = "Knob")
            },
            track = {
                SliderDefaults.Track(
                    modifier = Modifier.height(2.dp),
                    colors = SliderDefaults.colors(
                        activeTrackColor = Green,
                        inactiveTrackColor = GrayC9,
                        activeTickColor = Color.Transparent,
                        inactiveTickColor = Color.Transparent
                    ),
                    rangeSliderState = rangeSliderState
                )
            }
        )
    }
}