package com.example.footballplayassistant.presentation.ui.screens.search_tab

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.CommonSwitch
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.spacing


@Composable
@Preview
fun FilterScreen() {
    val navController = LocalNavController.current!!
    Column (modifier = Modifier
        .padding(top = MaterialTheme.spacing.small)
        .fillMaxSize()) {
        HeaderWithBackButton(text = stringResource(id = R.string.filterHeader),
            onClickBack = { navController.navigate(Route.SearchScreen.path) })
        CommonSwitch(text = stringResource(id = R.string.filterByFavorites))
        CommonSwitch(text = stringResource(id = R.string.filterByDistance))
        Spacer(modifier = Modifier.height(32.dp))
        Column(modifier = Modifier.padding(start = MaterialTheme.spacing.medium, end = MaterialTheme.spacing.medium)) {
            FilterRangeSlider(stringResource(id = R.string.awayFromUser), 0f, 50f)
            FilterRangeSlider(stringResource(id = R.string.amountOfPlayers), 12f, 48f)
        }
        ToggleButton(stringResource(R.string.typesOfArena), stringArrayResource(id = R.array.typesOfArenaArray))
        ToggleButton(stringResource(id = R.string.coveringType), stringArrayResource(id = R.array.coveringTypeArray))
        Spacer(modifier = Modifier.weight(1f))
        FilterBottomBar {
            navController.navigate(Route.SearchScreen.path)
        }
    }
}

@Composable
fun FilterBottomBar(onClick : () -> Unit) {
    HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.tertiaryContainer)
    Row(modifier = Modifier
        .height(82.dp)
        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically) {

        FilterButton(stringResource(id = R.string.dropFilters),
            MaterialTheme.colorScheme.outlineVariant,
            MaterialTheme.colorScheme.onPrimaryContainer,
            onClick)
        FilterButton(stringResource(id = R.string.applyFilters),
            MaterialTheme.colorScheme.onPrimaryContainer,
            MaterialTheme.colorScheme.onPrimary,
            onClick)
    }
}

@Composable
fun FilterButton(text : String, containerColor : Color, contentColor: Color, onClick : () -> Unit) {
    Button(onClick = onClick,
        contentPadding = PaddingValues(
            start = MaterialTheme.spacing.large,
            end = MaterialTheme.spacing.large,
            top = MaterialTheme.spacing.medium,
            bottom = MaterialTheme.spacing.medium
        ),
        colors = ButtonDefaults.buttonColors(containerColor = containerColor,
            contentColor = contentColor)) {
        Text(text, style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.W500,
            fontFamily = FontFamily(Font(R.font.montserrat))))
    }

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ToggleButton(title: String, items: Array<String>) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    Column(modifier = Modifier.padding(bottom = MaterialTheme.spacing.large,
        start = MaterialTheme.spacing.medium,
        end = MaterialTheme.spacing.medium)) {
        Text(
            title, style = MaterialTheme.typography.labelLarge
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
        FlowRow(horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)) {
            items.forEachIndexed { index, item ->
                OutlinedButton(
                    contentPadding = PaddingValues(
                        top = MaterialTheme.spacing.extraSmall,
                        bottom = MaterialTheme.spacing.extraSmall,
                        start = MaterialTheme.spacing.small,
                        end = MaterialTheme.spacing.small
                    ),
                    onClick = { selectedIndex = index },
                    shape = RoundedCornerShape(8.dp),
                    border = if (selectedIndex == index) {
                        BorderStroke(1.dp, color =  MaterialTheme.colorScheme.secondary)
                    } else {
                        BorderStroke(1.dp, color =  MaterialTheme.colorScheme.tertiaryContainer)
                    },
                    colors = if (selectedIndex == index) {
                        ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.onPrimary) }
                    else {
                        ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.outlineVariant)
                    }
                ) {
                    Text(text = item, style = MaterialTheme.typography.labelMedium,  color = MaterialTheme.colorScheme.onPrimaryContainer)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterRangeSlider(text: String, activeRangeStart: Float, activeRangeEnd: Float) {
    Column(modifier = Modifier.padding(bottom = MaterialTheme.spacing.medium)) {
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text, style = MaterialTheme.typography.labelLarge
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .padding(horizontal = MaterialTheme.spacing.small, vertical = MaterialTheme.spacing.extraSmall)
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
                Image(painterResource(R.drawable.knob), contentDescription = stringResource(id = R.string.knobIconDescription))
            },
            endThumb = {
                Image(painterResource(R.drawable.knob), contentDescription = stringResource(id = R.string.knobIconDescription))
            },
            track = {
                SliderDefaults.Track(
                    modifier = Modifier.height(2.dp),
                    colors = SliderDefaults.colors(
                        activeTrackColor = MaterialTheme.colorScheme.secondary,
                        inactiveTrackColor = MaterialTheme.colorScheme.tertiaryContainer,
                        activeTickColor = MaterialTheme.colorScheme.outlineVariant,
                        inactiveTickColor = MaterialTheme.colorScheme.outlineVariant
                    ),
                    rangeSliderState = rangeSliderState
                )
            }
        )
    }
}