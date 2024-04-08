package com.example.footballplayassistant.presentation.customviews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R

@Composable
@Preview
fun ForgotPassword(modifier: Modifier = Modifier){
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent, contentColor = Color.Black),
            onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.forgotPassword), fontSize = 12.sp, fontWeight = FontWeight.W500)
        }
    }
}