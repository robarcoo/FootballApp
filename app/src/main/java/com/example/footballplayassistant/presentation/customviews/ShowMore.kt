package com.example.footballplayassistant.presentation.customviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R

@Composable
fun ShowMore(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            onClick = { /*TODO*/ }) {
            Text(
                text = stringResource(id = R.string.showmore),
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.W600
            )
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_arrows_down_24),
                contentDescription = ""
            )
        }
    }
}