package com.example.footballplayassistant.presentation.customviews.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun SelectionButtons(
    modifier: Modifier = Modifier,
    valueList: List<String>,
    selectedItemIndex: Int,
    onSelected: (Int) -> Unit
) {
    val indexItem = remember {
        mutableStateOf(selectedItemIndex)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {

        valueList.forEachIndexed { index, text ->
            if (indexItem.value == index) {
                CurrentButton(
                    modifier = Modifier.align(
                        when (index) {
                            0 -> Alignment.CenterStart
                            valueList.size - 1 -> Alignment.CenterEnd
                            else -> {
                                Alignment.Center
                            }
                        }
                    ),
                    filter = indexItem,
                    borderColor = MaterialTheme.colorScheme.secondary,
                    containerColor = MaterialTheme.colorScheme.secondary,
                    text = text,
                    zIndex = 1f,
                    value = index,
                    onSelected = { onSelected.invoke(indexItem.value) }
                )
            } else {
                CurrentButton(
                    modifier = Modifier.align(
                        when (index) {
                            0 -> Alignment.CenterStart
                            valueList.size - 1 -> Alignment.CenterEnd
                            else -> {
                                Alignment.Center
                            }
                        }
                    ),
                    filter = indexItem,
                    borderColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    text = text,
                    zIndex = when (index) {
                        0 -> 0f
                        valueList.size - 1 -> 0f
                        else -> 0.5f
                    },
                    value = index,
                    onSelected = { onSelected.invoke(indexItem.value) }
                )
            }
        }
    }
}

@Composable
private fun CurrentButton(
    modifier: Modifier = Modifier,
    filter: MutableState<Int>,
    borderColor: Color,
    containerColor: Color,
    text: String,
    zIndex: Float,
    value: Int,
    onSelected: (Int) -> Unit
) {

    Box(
        modifier = modifier
            .fillMaxWidth(0.55f)
            .background(
                color = containerColor, shape = RoundedCornerShape(80.dp)
            )
            .border(1.dp, borderColor, RoundedCornerShape(80.dp))
            .zIndex(zIndex)
            .clickable {
                filter.value = value
                onSelected.invoke(filter.value)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W500),
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.padding(vertical = 10.dp)
        )
    }
}