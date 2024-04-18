package com.example.footballplayassistant.presentation.customviews.headers

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R

@Composable
fun HeaderAuthentication(header: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_ball_full),
                contentDescription = "",
                modifier = Modifier.align(Alignment.TopStart)
            )

            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_ball_full_79_87),
                contentDescription = "",
                modifier = Modifier.align(Alignment.BottomEnd)
            )

            Column(modifier = Modifier.align(Alignment.Center)) {
                header()
            }
        }
    }
}

@Composable
@Preview
fun HeaderSignIn() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_header), contentDescription = "",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Button(colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.outlineVariant
            ),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Пропустить",
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W500)
                )
            }
        }

        Text(
            text = "Вход",
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.W500),
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
@Preview
fun HeaderSignUp() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_header), contentDescription = "",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Button(colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.outlineVariant
            ),
                onClick = { /*TODO*/ }) {
                Text(
                    text = "Пропустить",
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W500)
                )
            }
        }
        Text(
            text = "Регистрация",
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.W500),
            color = MaterialTheme.colorScheme.onPrimary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
@Preview
fun HeaderSignUpCode() {
    Text(
        text = "Введите код из письма",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.W500),
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun HeaderSignUpStep(numStep: Int) {
    Column {
        Text(
            text = "Регистрация",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.W500),
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Text(
            text = "Шаг $numStep из 2",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W400),
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}