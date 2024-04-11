package com.example.footballplayassistant.presentation.customviews

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.ui.theme.GrayAccounts
import com.example.footballplayassistant.presentation.ui.theme.GrayC9
import com.example.footballplayassistant.presentation.ui.theme.Green

@Composable
fun CommonSwitch(text: String, icon: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.align(Alignment.CenterVertically)) {
            Text(
                text = text,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontSize = 16.sp,
                fontWeight = FontWeight.W600,
            )

            if (icon)
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_question_14),
                    contentDescription = ""
                )
        }

        CustomSwitchButton(
            switchPadding = 0.dp,
            buttonWidth = 34.dp,
            buttonHeight = 24.dp,
            value = false
        )
    }
}


@Composable
fun CustomSwitchButton(
    switchPadding: Dp,
    buttonWidth: Dp,
    buttonHeight: Dp,
    value: Boolean
) {

    val switchSize by remember {
        mutableStateOf(buttonHeight / 2 - switchPadding * 2)
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

    var switchClicked by remember {
        mutableStateOf(value)
    }

    var padding by remember {
        mutableStateOf(0.dp)
    }

    padding = if (switchClicked) buttonWidth - switchSize - switchPadding * 2 else 0.dp


    val animateSize by animateDpAsState(
        targetValue = if (switchClicked) padding else 0.dp,
        tween(
            durationMillis = 700,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    Box(
        modifier = Modifier
            .width(56.dp)
            .height(22.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(GrayAccounts)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {

                switchClicked = !switchClicked

            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(switchPadding)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(animateSize)
                    .background(Color.Transparent)
            )

            Box(
                modifier = Modifier
                    .size(width = 34.dp, height = 24.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (switchClicked) Green else GrayC9)
            )
        }
    }
}
