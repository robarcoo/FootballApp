package com.example.footballplayassistant.presentation.customviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.ui.theme.GrayText
import com.example.footballplayassistant.ui.theme.Green

@Composable
fun MoneyCard(money: Int, modifier: Modifier = Modifier){
    Card(modifier = modifier
        .fillMaxSize()
        .border(width = 1.dp, color = GrayText, shape = RoundedCornerShape(12.dp))) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(text = stringResource(id = R.string.money), modifier = Modifier.padding(bottom = 8.dp), fontWeight = FontWeight.W500, fontSize = 12.sp, color = GrayText)
                Row {
                    Image(imageVector = ImageVector.vectorResource(R.drawable.ic_money_24), contentDescription = "", modifier = Modifier.padding(end = 8.dp))
                    Text(text = "$money ₽", fontWeight = FontWeight.W600, fontSize = 20.sp)
                }
            }
            IconButton(modifier = Modifier.align(Alignment.Bottom), colors = IconButtonDefaults.iconButtonColors(containerColor = Green),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_arrows_24), contentDescription = "")
            }
        }

    }
}