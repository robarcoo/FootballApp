package com.example.footballplayassistant.presentation.customviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.ui.theme.GrayC9

@Composable
fun PlayerInTeam(userTag: String, position: String, foto: Int){
    Column( modifier = Modifier.padding(bottom = 12.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = foto), contentDescription = "")
        Text(text = userTag,
            fontSize = 16.sp,
            fontWeight = FontWeight.W500,
            fontFamily = FontFamily(Font(R.font.inter)),
            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp))
        Text(text = position,
            fontSize = 12.sp,
            fontWeight = FontWeight.W500,
            fontFamily = FontFamily(Font(R.font.inter)),
            color = GrayC9)
    }
}