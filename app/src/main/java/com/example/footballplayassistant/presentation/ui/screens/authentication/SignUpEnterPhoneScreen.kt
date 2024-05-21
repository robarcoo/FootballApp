package com.example.footballplayassistant.presentation.ui.screens.authentication

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.BottomQuestion
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.buttons.SignInWithAccounts
import com.example.footballplayassistant.presentation.customviews.headers.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.headers.HeaderSignUp
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
@Preview
fun SignUpEnterPhoneScreen() {
    val navController = LocalNavController.current!!
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
                modifier = Modifier
                    .padding(horizontal = MaterialTheme.spacing.horizontal)
                    .padding(top = 24.dp, bottom = MaterialTheme.spacing.medium)
            )
            CommonTextField(
                placeholder = stringResource(R.string.enterPhone),
                keyBoard = KeyboardType.Phone,
                color = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier
                    .padding(horizontal = MaterialTheme.spacing.horizontal)
                    .padding(bottom = 10.dp)
            )
            CommonButton(
                text = stringResource(R.string.sendCode),
                onClick = { navController.navigate(Route.SignUpCodeScreen.withArgs("phone")) },
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