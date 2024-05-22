package com.example.footballplayassistant.presentation.ui.screens.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.dialogwindows.DialogScreen
import com.example.footballplayassistant.presentation.customviews.headers.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.headers.HeaderRecoveryPassword
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
fun RecoveryPasswordScreen() {
    val navController = LocalNavController.current!!
    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value)
        DialogScreen(
            header = stringResource(id = R.string.doneWithPoint),
            description = stringResource(id = R.string.newPassIsRecovery),
            greenButton = stringResource(id = R.string.onSignInScreen),
            image = R.drawable.ic_check_92,
            onClickGreen = { navController.navigate(Route.SignInScreen.path) },
            onDismissRequest = { showDialog.value = false }
        )

    Column(modifier = Modifier.fillMaxSize()) {
        HeaderAuthentication {
            HeaderRecoveryPassword(onClick = { navController.navigate(Route.ForgotPasswordScreen.path) })
        }

        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            item {
                Text(
                    text = stringResource(R.string.createRepeatPass),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W400),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier
                        .padding(horizontal = MaterialTheme.spacing.horizontal)
                        .padding(top = 24.dp, bottom = MaterialTheme.spacing.medium)
                        .fillMaxWidth()
                )
            }

            item {
                Text(
                    text = addStar(id = R.string.createPass),
                    style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(bottom = MaterialTheme.spacing.small)
                )

                CommonTextField(
                    placeholder = stringResource(id = R.string.enterNewPass),
                    keyBoard = KeyboardType.Text,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    imageTrail = R.drawable.ic_eye_slash_24,
                    tintIcon = MaterialTheme.colorScheme.secondary,
                    isPassword = true,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, bottom = 10.dp)
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_warning_12),
                        contentDescription = "Warning",
                        modifier = Modifier.padding(end = 2.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.passLength),
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.W400),
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                    )
                }
            }

            item {
                Text(
                    text = addStar(id = R.string.repeatPass),
                    style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .padding(bottom = MaterialTheme.spacing.small)
                )

                CommonTextField(
                    placeholder = stringResource(id = R.string.repeatNewPass),
                    keyBoard = KeyboardType.Text,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    imageTrail = R.drawable.ic_eye_slash_24,
                    tintIcon = MaterialTheme.colorScheme.secondary,
                    isPassword = true,
                    modifier = Modifier.padding(bottom = 36.dp)
                )
            }

            item {
                CommonButton(
                    text = stringResource(R.string.save),
                    onClick = { showDialog.value = true },
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

    }
}