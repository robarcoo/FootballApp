package com.example.footballplayassistant.presentation.customviews.radiobuttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R

@Composable
@Preview
fun RadioButtonGroup() {
    val state = remember {
        mutableStateOf(1)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Row {
            RadioButton(
                selected = if (state.value == 1) true else false, onClick = { state.value = 1 },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.secondary,
                    unselectedColor = MaterialTheme.colorScheme.secondary
                )
            )
            Text(
                text = stringResource(id = R.string.men),
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W400),
                modifier = Modifier.align(Alignment.CenterVertically),
                color = MaterialTheme.colorScheme.primary
            )
        }
        Row {
            RadioButton(
                selected = if (state.value == 2) true else false, onClick = { state.value = 2 },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.secondary,
                    unselectedColor = MaterialTheme.colorScheme.secondary
                )
            )
            Text(
                text = stringResource(id = R.string.women),
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W400),
                modifier = Modifier.align(Alignment.CenterVertically),
                color = MaterialTheme.colorScheme.primary
            )
        }
        Row {
            RadioButton(
                selected = if (state.value == 3) true else false, onClick = { state.value = 3 },
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.secondary,
                    unselectedColor = MaterialTheme.colorScheme.secondary
                )
            )
            Text(
                text = stringResource(id = R.string.mw),
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W400),
                modifier = Modifier.align(Alignment.CenterVertically),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
