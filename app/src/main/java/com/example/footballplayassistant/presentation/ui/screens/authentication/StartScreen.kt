package com.example.footballplayassistant.presentation.ui.screens.authentication

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.Black21


@Composable
@Preview
fun StartScreen() {
    val navController = LocalNavController.current!!
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.player),
            contentDescription = "",
            modifier = Modifier.wrapContentSize()
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(MaterialTheme.colorScheme.onBackground)
                .align(Alignment.BottomCenter)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 0.dp,
                        topStart = 12.dp,
                        topEnd = 12.dp,
                        bottomEnd = 0.dp
                    )
                ),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        ) {
            Box(
                modifier = Modifier.clip(
                    RoundedCornerShape(
                        bottomStart = 0.dp,
                        topStart = 12.dp,
                        topEnd = 12.dp,
                        bottomEnd = 0.dp
                    )
                )
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_ball_144_223),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(bottom = 260.dp)
                )

                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_ball_140_170),
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.BottomEnd)
                )

                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.Center)
                        .padding(top = 100.dp, start = 16.dp, end = 16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.takePart),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.labelLarge
                            .copy(fontWeight = FontWeight.W400),
                    )

                    CommonButton(
                        text = "Войти",
                        style = MaterialTheme.typography.bodyLarge,
                        onClick = {
                            navController.navigate(Route.SignInScreen.path)
                        }
                    )

                    Button(modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 10.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.outlineVariant),
                        onClick = {
                            navController.navigate(Route.SignUpEnterPhoneScreen.path)
                        }) {
                        Text(
                            text = "Зарегистрироваться",
                            style = MaterialTheme.typography.bodyMedium
                                .copy(fontWeight = FontWeight.W600)

                        )
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_arrows_18_14),
                            contentDescription = ""
                        )
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

