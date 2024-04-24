package com.example.footballplayassistant.presentation.customviews.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun SelectionButton(
    modifier: Modifier = Modifier,
    textButton1: Int,
    textButton2: Int,
    currentValue: String = "val1"
): String {
    val filter = remember {
        mutableStateOf(currentValue)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        if (filter.value == "val1") {
            button(
                modifier = Modifier.align(Alignment.CenterStart),
                filter = filter,
                borderColor = MaterialTheme.colorScheme.secondary,
                containerColor = MaterialTheme.colorScheme.secondary,
                text = textButton1,
                zIndex = 1f,
                value = "val1"
            )

            button(
                modifier = Modifier.align(Alignment.CenterEnd),
                filter = filter,
                borderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                containerColor = MaterialTheme.colorScheme.onPrimary,
                text = textButton2,
                zIndex = 0f,
                value = "val2"
            )
        } else {
            button(
                modifier = Modifier.align(Alignment.CenterStart),
                filter = filter,
                borderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                containerColor = MaterialTheme.colorScheme.onPrimary,
                text = textButton1,
                zIndex = 0f,
                value = "val1"
            )

            button(
                modifier = Modifier.align(Alignment.CenterEnd),
                filter = filter,
                borderColor = MaterialTheme.colorScheme.secondary,
                containerColor = MaterialTheme.colorScheme.secondary,
                text = textButton2,
                zIndex = 1f,
                value = "val2"
            )
        }
    }
    return filter.value
}

@Composable
private fun button(
    modifier: Modifier = Modifier,
    filter: MutableState<String>,
    borderColor: Color,
    containerColor: Color,
    text: Int,
    zIndex: Float,
    value: String
) {
    Button(
        modifier = modifier
            .fillMaxWidth(0.55f)
            .background(
                color = containerColor, shape = RoundedCornerShape(80.dp)
            )
            .border(1.dp, borderColor, RoundedCornerShape(80.dp))
            .zIndex(zIndex),
        shape = RoundedCornerShape(80.dp),
        colors = ButtonDefaults.buttonColors(containerColor = containerColor),
        onClick = { filter.value = value }) {
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W500),
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}