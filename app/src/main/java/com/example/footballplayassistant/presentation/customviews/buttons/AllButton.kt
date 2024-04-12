package com.example.footballplayassistant.presentation.customviews.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.ui.theme.Gray75

@Composable
fun AllButton(text: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = text,
            fontFamily = FontFamily(Font(R.font.inter)),
            modifier = Modifier.align(Alignment.CenterVertically),
            fontWeight = FontWeight.W600,
            fontSize = 20.sp
        )

        Button(modifier = Modifier.align(Alignment.CenterVertically),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Gray75
            ),
            onClick = { /*TODO*/ }) {
            Text(
                text = stringResource(id = R.string.all),
                fontFamily = FontFamily(Font(R.font.inter)),
                fontWeight = FontWeight.W600,
                fontSize = 14.sp
            )
        }
    }
}