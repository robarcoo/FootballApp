package com.example.footballplayassistant.presentation.customviews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.presentation.ui.theme.Green
import com.example.footballplayassistant.R

@Composable
@Preview
fun RadioButtonGroup() {
    val state = remember {
        mutableStateOf(1)
    }
    Row(modifier = Modifier.fillMaxWidth().padding(end = 16.dp), horizontalArrangement = Arrangement.SpaceAround) {
        Row {
            RadioButton(
                selected = if (state.value == 1) true else false, onClick = { state.value = 1 },
                colors = RadioButtonDefaults.colors(selectedColor = Green, unselectedColor = Green)
            )
            Text(text = stringResource(id = R.string.men),
                fontFamily = FontFamily(Font(R.font.inter)),
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.align(Alignment.CenterVertically))
        }
        Row {
            RadioButton(
                selected = if (state.value == 2) true else false, onClick = { state.value = 2 },
                colors = RadioButtonDefaults.colors(selectedColor = Green, unselectedColor = Green)
            )
            Text(text = stringResource(id = R.string.women),
                fontFamily = FontFamily(Font(R.font.inter)),
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.align(Alignment.CenterVertically))
        }
        Row {
            RadioButton(
                selected = if (state.value == 3) true else false, onClick = { state.value = 3 },
                colors = RadioButtonDefaults.colors(selectedColor = Green, unselectedColor = Green)
            )
            Text(text = stringResource(id = R.string.mw),
                fontFamily = FontFamily(Font(R.font.inter)),
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                modifier = Modifier.align(Alignment.CenterVertically))
        }
    }
}
