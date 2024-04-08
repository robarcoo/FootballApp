package com.example.footballplayassistant.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.CommonButton
import com.example.footballplayassistant.ui.theme.BlackBackground

@Composable
@Preview
fun StartPage() {
    Box(modifier = Modifier.fillMaxSize().background(BlackBackground)) {
        Image(painter = painterResource(id = R.drawable.player), contentDescription = "",modifier = Modifier.wrapContentSize())
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(BlackBackground)
                .align(Alignment.BottomCenter),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
            shape = RoundedCornerShape(12.dp)
        ) {
            Box(modifier = Modifier.background(BlackBackground),){
                Column(modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(bottom = 260.dp)) {
//                    BallLeft()
                    Image(imageVector = ImageVector.vectorResource(R.drawable.ic_ball_144_223), contentDescription = "")
                }
                Column(modifier = Modifier.align(Alignment.BottomEnd)){
//                    BallRight()
                    Image(imageVector = ImageVector.vectorResource(R.drawable.ic_ball_140_170), contentDescription = "")
                }
                Column(modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.Center)
                    .padding(top = 100.dp, start = 16.dp, end = 16.dp)) {
                    Text(text = "Принимайте участие в матчах, созданных другими игроками или создайте свои собственные события",
                        textAlign = TextAlign.Center)

                    CommonButton("Войти")

                    Button(modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        onClick = { /*TODO*/ }) {
                        Text(text = "Зарегистрироваться")
                        Image(imageVector = ImageVector.vectorResource(R.drawable.ic_arrows_18_14), contentDescription = "")
                    }
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 295.dp)
                .wrapContentSize()
        )
    }
}

