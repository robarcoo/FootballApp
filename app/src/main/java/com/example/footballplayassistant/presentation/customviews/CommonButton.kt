package com.example.footballplayassistant.presentation.customviews

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballplayassistant.ui.theme.Green

@Composable
fun CommonButton(text: String, containerColor: Color = Green, contentColor: Color = Color.Black, @SuppressLint("ModifierParameter") modifier: Modifier = Modifier){
    Button(modifier = modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(contentColor = contentColor, containerColor = containerColor),
        onClick = { /*TODO*/ }) {
        Text(text = text)
    }
}