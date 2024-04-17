package com.example.footballplayassistant.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.BottomQuestion
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.customviews.headers.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.headers.HeaderSignUp
import com.example.footballplayassistant.presentation.customviews.buttons.SignInWithAccounts
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route

@Composable
@Preview
fun SignUpEnterPhoneScreen() {
    val navController = LocalNavController.current!!
    Column(modifier = Modifier.fillMaxSize()) {
        HeaderAuthentication { HeaderSignUp() }
        Text(
            text = stringResource(R.string.choosenPhone),
            fontFamily = FontFamily(Font(R.font.inter)),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        CommonTextField(
            placeholder = stringResource(R.string.enterPhone),
            keyBoard = KeyboardType.Phone
        )
        CommonButton(
            text = stringResource(R.string.sendCode),
            onClick = {
                navController.navigate(Route.SignUpCodeScreen.path)
            },
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        SignInWithAccounts()
        BottomQuestion(
            question = stringResource(R.string.questionAcc),
            buttonText = stringResource(R.string.signin),
            onClick = { navController.navigate(Route.SignInScreen.path) }
        )
    }
}