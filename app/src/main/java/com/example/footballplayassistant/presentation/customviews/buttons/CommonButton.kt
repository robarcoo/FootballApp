package com.example.footballplayassistant.presentation.customviews.buttons

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.ui.theme.GrayButtonContainer
import com.example.footballplayassistant.presentation.ui.theme.Green

@Composable
fun CommonButton(
    text: String,
    containerColor: Color = Green,//MaterialTheme.colorScheme.secondary,
    contentColor: Color = GrayButtonContainer,//MaterialTheme.colorScheme.primary,
    fontSize: TextUnit = 18.sp,
    fontWeight: FontWeight = FontWeight.W600,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Button(modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            contentColor = contentColor,
            containerColor = containerColor
        ),
        onClick = { /*TODO*/ }) {
        Text(
            text = text,
            fontWeight = fontWeight,
            fontSize = fontSize,
            fontFamily = FontFamily(
                Font(R.font.inter))
        )
    }
}