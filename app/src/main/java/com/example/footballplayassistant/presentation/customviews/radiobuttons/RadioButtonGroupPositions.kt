package com.example.footballplayassistant.presentation.customviews.radiobuttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R

@Composable
@Preview
fun RadioButtonGroupPositions() {
    val state = remember {
        mutableStateOf(1)
    }
    val positions = stringArrayResource(id = R.array.positions_array)

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        for (i in positions.indices) {
            Row {
                RadioButton(
                    selected = state.value == i + 1,
                    onClick = { state.value = i + 1 },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colorScheme.secondary,
                        unselectedColor = MaterialTheme.colorScheme.secondary
                    )
                )
                Text(
                    text = positions[i],
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.W400
                    ),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }
    }
}