package com.example.footballplayassistant.presentation.customviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.ui.theme.BlackBackground

@Composable
fun HeaderAuthentication(header: @Composable () -> Unit){
    Card(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        ,
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(BlackBackground)
        ){
            Column(modifier = Modifier.align(Alignment.TopStart)) {
                Image(imageVector = ImageVector.vectorResource(R.drawable.ic_ball_full), contentDescription = "")
            }
            Column(modifier = Modifier.align(Alignment.BottomEnd)) {
                Image(imageVector = ImageVector.vectorResource(R.drawable.ic_ball_full_79_87), contentDescription = "")
            }
            Column(modifier = Modifier.align(Alignment.Center)) {
                header()
            }
        }
    }
}

@Composable
@Preview
fun HeaderSignIn(){
    Column {
        Row(modifier = Modifier.fillMaxWidth().padding(start = 16.dp), horizontalArrangement = Arrangement.SpaceBetween){
            Image(painter = painterResource(id = R.drawable.logo_header), contentDescription = "",
                modifier = Modifier.align(Alignment.CenterVertically))
            Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                onClick = { /*TODO*/ }) {
                Text(text = "Пропустить", fontSize = 16.sp, fontWeight = FontWeight.W500)
            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Text(text = "Вход", fontSize = 36.sp, fontWeight = FontWeight.W500, color = Color.White)
        }
    }
}

@Composable
@Preview
fun HeaderSignUp(){
    Column {
        Row(modifier = Modifier.fillMaxWidth().padding(start = 16.dp), horizontalArrangement = Arrangement.SpaceBetween){
            Image(painter = painterResource(id = R.drawable.logo_header), contentDescription = "",
                modifier = Modifier.align(Alignment.CenterVertically))
            Button(colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                onClick = { /*TODO*/ }) {
                Text(text = "Пропустить", fontSize = 16.sp, fontWeight = FontWeight.W500)
            }
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Text(text = "Регистрация", fontSize = 36.sp, fontWeight = FontWeight.W500, color = Color.White)
        }
    }
}

@Composable
@Preview
fun HeaderSignUpCode(){
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Text(text = "Введите код из письма", textAlign = TextAlign.Center, fontSize = 36.sp, fontWeight = FontWeight.W500, color = Color.White)
        }
}

@Composable
@Preview
fun HeaderSignUpStep(numStep: Int){
    Column {
        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp), horizontalArrangement = Arrangement.Center){
            Text(text = "Регистрация", textAlign = TextAlign.Center, fontSize = 36.sp, fontWeight = FontWeight.W500, color = Color.White)
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
            Text(text = "Шаг $numStep из 2", textAlign = TextAlign.Center, fontSize = 16.sp, fontWeight = FontWeight.W400, color = Color.White)
        }
    }
}