package com.example.footballplayassistant.presentation.customviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.ui.theme.GrayText

@Composable
fun HeaderUser(name: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 12.dp)) {
        Image(painter = painterResource(id = R.drawable.user_foto), contentDescription = "")

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f)
                .padding(start = 10.dp)
        ) {
            Text(text = "Привет,", fontWeight = FontWeight.W500, fontSize = 12.sp, color = GrayText)
            Text(text = name, fontWeight = FontWeight.W600, fontSize = 20.sp)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f)
                .height(42.dp)
                .border(width = 1.dp, color = GrayText, RoundedCornerShape(40.dp))
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_plus_24),
                    contentDescription = ""
                )
            }

            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 8.dp)
                    .width(1.dp),
                color = GrayText
            )

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_bell_24),
                    contentDescription = ""
                )
            }
        }
    }
}