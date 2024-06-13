package com.example.footballplayassistant.presentation.ui.screens.authentication

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.constants.PhoneEmail
import com.example.footballplayassistant.presentation.customviews.buttons.BottomQuestion
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.buttons.SignInWithAccounts
import com.example.footballplayassistant.presentation.customviews.headers.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.headers.HeaderSignUp
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route

@Composable
@Preview
fun SignUpEnterPhoneScreen() {
    val navController = LocalNavController.current!!
    val buttonEnable = remember { mutableStateOf(false) }
    val unique = remember { mutableStateOf(false) }
    val phone = remember { mutableStateOf("") }
    val phoneMask = MaskVisualTransformation("+7 (###) ### ## ##")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .verticalScroll(ScrollState(0)),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        HeaderAuthentication { HeaderSignUp() }

        Column(
            modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = stringResource(R.string.choosenPhone),
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W400),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.padding(top = 24.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
            )
            CommonTextField(
                placeholder = stringResource(R.string.enterPhone),
                keyBoard = KeyboardType.Phone,
                color = MaterialTheme.colorScheme.primaryContainer,
                mask = phoneMask,
                maxLength = 10,
                onClick = {
                    if (it.length == 10){
                        //проверка не зарегистрирован ли на этот номер аккаунт
                        phone.value=it
                        unique.value=true
                    }
                    else
                        unique.value=false
                },
                modifier = Modifier.padding(bottom = 10.dp, start = 16.dp, end = 16.dp)
            )

            AnimatedVisibility(visible = !unique.value && phone.value.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 26.dp, bottom = 10.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_warning_12),
                        contentDescription = "Warning",
                        tint = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(end = 2.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.userHasBeenRegistered),
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.W400),
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }

            LaunchedEffect(unique.value, phone.value) {
                if(unique.value && phone.value.isNotEmpty())
                    buttonEnable.value=true
            }

            val animatedContainerColor: Color by animateColorAsState(
                targetValue = if (buttonEnable.value) MaterialTheme.colorScheme.secondary
                else MaterialTheme.colorScheme.tertiary,
                animationSpec = tween(500, 0, LinearEasing)
            )
            val animatedContentColor: Color by animateColorAsState(
                targetValue = if (buttonEnable.value) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.onSecondaryContainer,
                animationSpec = tween(500, 0, LinearEasing)
            )
            CommonButton(
                text = stringResource(R.string.sendCode),
                containerColor = animatedContainerColor,
                contentColor = animatedContentColor,
                enable = buttonEnable.value,
                onClick = { navController.navigate(Route.SignUpCodeScreen.withArgs(PhoneEmail.PHONE)) },
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        Spacer(modifier = Modifier.weight(0.1f))
        Column(verticalArrangement = Arrangement.Bottom) {
            SignInWithAccounts()
            BottomQuestion(
                question = stringResource(R.string.questionAcc),
                buttonText = stringResource(R.string.signin),
                onClick = { navController.navigate(Route.SignInScreen.path) }
            )
        }
    }
}