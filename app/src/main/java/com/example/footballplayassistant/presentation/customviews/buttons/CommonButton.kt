package com.example.footballplayassistant.presentation.customviews.buttons

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.footballplayassistant.presentation.ui.theme.Green

@Composable
fun CommonButton(
    text: String,
    containerColor: Color = Green,//MaterialTheme.colorScheme.secondary,
    contentColor: Color = Color.Black,//MaterialTheme.colorScheme.primary,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
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
            style = style
        )
    }
}