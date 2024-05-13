package com.example.footballplayassistant.presentation.customviews.buttons

import android.util.Log
import androidx.compose.animation.animateColor
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.footballplayassistant.presentation.ui.theme.Green

@Composable
fun SelectionButtons(
    modifier: Modifier = Modifier,
    valueList: List<String>,
    selectedItemIndex: Int,
    onSelected: (Int) -> Unit
) {
    val indexItem = remember { mutableStateOf(selectedItemIndex) }
    val selected = remember { mutableStateOf(true) }

    val animatedButtonColor: Color by animateColorAsState(
        targetValue = if(selected.value) MaterialTheme.colorScheme.secondary
        else MaterialTheme.colorScheme.onPrimary,
        animationSpec = tween(500, 0, LinearEasing)
    )
    val animatedBorderColor: Color by animateColorAsState(
        targetValue = if(selected.value) MaterialTheme.colorScheme.secondary
        else MaterialTheme.colorScheme.onPrimaryContainer,
        animationSpec = tween(500, 0, LinearEasing)
    )
    val animatedButtonColor2: Color by animateColorAsState(
        targetValue = if(!selected.value) MaterialTheme.colorScheme.secondary
        else MaterialTheme.colorScheme.onPrimary,
        animationSpec = tween(500, 0, LinearEasing)
    )
    val animatedBorderColor2: Color by animateColorAsState(
        targetValue = if(!selected.value) MaterialTheme.colorScheme.secondary
        else MaterialTheme.colorScheme.onPrimaryContainer,
        animationSpec = tween(500, 0, LinearEasing)
    )

    Box(modifier = modifier.fillMaxWidth()) {
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
                    borderColor = animatedBorderColor,
                    containerColor = animatedButtonColor,
                    text = text,
                    zIndex = 1f,
                    value = index,
                    onSelected = { onSelected.invoke(indexItem.value) },
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
                    borderColor = animatedBorderColor2,//MaterialTheme.colorScheme.onPrimaryContainer,
                    containerColor = animatedButtonColor2,//MaterialTheme.colorScheme.onPrimary,
                    text = text,
                    zIndex = when (index) {
                        0 -> 0f
                        valueList.size - 1 -> 0f
                        else -> 0.5f
                    },
                    value = index,
                    onSelected = { onSelected.invoke(indexItem.value) },
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
    onSelected: (Int) -> Unit,
) {

//    val animatedButtonColor: Color by animateColorAsState(
//        targetValue = if(filter.value==value && value==0) MaterialTheme.colorScheme.secondary
//        else MaterialTheme.colorScheme.onPrimary,
//        animationSpec = tween(500, 0, LinearEasing)
//    )
//
//    val animatedBorderColor: Color by animateColorAsState(
//        targetValue = if(filter.value==0) MaterialTheme.colorScheme.secondary
//        else MaterialTheme.colorScheme.onPrimaryContainer,
//        animationSpec = tween(500, 0, LinearEasing)
//    )
//Log.d("MyLog", "${filter.value} $value")
    Box(
        modifier = modifier
            .fillMaxWidth(0.55f)
            .background(color = containerColor, shape = RoundedCornerShape(80.dp))
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
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.W500),
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.padding(vertical = 10.dp)
        )
    }
}