package com.example.footballplayassistant.presentation.ui.screens.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.presentation.customviews.headers.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.headers.HeaderForgotPassword
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.constants.PhoneEmail
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
fun ForgotPasswordScreen() {
    val navController = LocalNavController.current!!
    Column(modifier = Modifier.fillMaxSize()) {
        HeaderAuthentication {
            HeaderForgotPassword(onClick = { navController.navigate(Route.SignInScreen.path) })
        }

        LazyColumn {
            item {
                Text(
                    text = stringResource(id = R.string.instructionRecoveryPassword),
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W400),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier
                        .padding(horizontal = MaterialTheme.spacing.horizontal)
                        .padding(top = 24.dp, bottom = MaterialTheme.spacing.medium)
                        .fillMaxWidth()
                )
            }

            item {
                CommonTextField(
                    placeholder = stringResource(id = R.string.enterEmail),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            item {
                CommonButton(
                    text = stringResource(id = R.string.sendCode),
                    onClick = { navController.navigate(Route.SignUpCodeScreen.withArgs(PhoneEmail.EMAIL)) },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
                )
            }
        }
    }
}