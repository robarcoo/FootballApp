package com.example.footballplayassistant.presentation.ui.screens.authentication

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.dialogwindows.DialogScreen
import com.example.footballplayassistant.presentation.customviews.headers.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.headers.HeaderRecoveryPassword
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route

@Composable
fun RecoveryPasswordScreen() {
    val navController = LocalNavController.current!!
    val showDialog = remember { mutableStateOf(false) }
    val buttonEnable = remember { mutableStateOf(false) }
    val newPasswordFirst = remember { mutableStateOf("") }
    val newPasswordSecond = remember { mutableStateOf("") }

    DialogScreen(
        header = stringResource(id = R.string.doneWithPoint),
        description = stringResource(id = R.string.newPassIsRecovery),
        greenButton = stringResource(id = R.string.onSignInScreen),
        image = R.drawable.ic_check_92,
        onClickGreen = { navController.navigate(Route.SignInScreen.path) },
        onDismissRequest = { showDialog.value = false },
        showDialog = showDialog.value
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
                        .padding(top = 24.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                )
            }

            item {
                Text(
                    text = addStar(id = R.string.createPass),
                    style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                    modifier = Modifier.padding(bottom = 8.dp, start = 10.dp, end = 10.dp)
                )

                CommonTextField(
                    placeholder = stringResource(id = R.string.enterNewPass),
                    keyBoard = KeyboardType.Text,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    imageTrail = R.drawable.ic_eye_slash_24,
                    tintIcon = MaterialTheme.colorScheme.secondary,
                    isPassword = true,
                    onClick = { newPasswordFirst.value = it },
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }

            item {
                AnimatedVisibility(
                    visible = newPasswordFirst.value.isNotEmpty()
                            && (newPasswordFirst.value.length < 8
                            || !newPasswordFirst.value.contains("[A-Z]".toRegex())
                            || !newPasswordFirst.value.contains("[a-z]".toRegex())
                            || !newPasswordFirst.value.contains("[0-9]".toRegex()))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, bottom = 10.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_warning_12),
                            contentDescription = "Warning",
                            tint = MaterialTheme.colorScheme.errorContainer,
                            modifier = Modifier.padding(end = 2.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.symbolsNumbers),
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.W400),
                            color = MaterialTheme.colorScheme.errorContainer
                        )
                    }
                }
                AnimatedVisibility(visible = newPasswordFirst.value.isEmpty()) {
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
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.W400),
                            color = MaterialTheme.colorScheme.onBackground,
                        )
                    }
                }
            }

            item {
                Text(
                    text = addStar(id = R.string.repeatPass),
                    style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 8.dp)
                )

                CommonTextField(
                    placeholder = stringResource(id = R.string.repeatNewPass),
                    keyBoard = KeyboardType.Text,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    imageTrail = R.drawable.ic_eye_slash_24,
                    tintIcon = MaterialTheme.colorScheme.secondary,
                    isPassword = true,
                    onClick = { newPasswordSecond.value = it }
                )
                AnimatedVisibility(visible = newPasswordFirst.value != newPasswordSecond.value
                            && newPasswordSecond.value.isNotEmpty()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, bottom = 10.dp, top = 8.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_warning_12),
                            contentDescription = "Warning",
                            tint = MaterialTheme.colorScheme.errorContainer,
                            modifier = Modifier.padding(end = 2.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.passwordsDifferent),
                            style = MaterialTheme.typography.headlineSmall.copy(
                                fontWeight = FontWeight.W400),
                            color = MaterialTheme.colorScheme.errorContainer
                        )
                    }
                }
            }

            item {
                LaunchedEffect(key1 = newPasswordFirst.value, key2 = newPasswordSecond.value){
                    buttonEnable.value = (newPasswordFirst.value == newPasswordSecond.value
                            && newPasswordFirst.value.isNotEmpty())
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
                    text = stringResource(R.string.save),
                    containerColor = animatedContainerColor,
                    contentColor = animatedContentColor,
                    enable = buttonEnable.value,
                    onClick = { showDialog.value = true },
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 36.dp)
                )
            }
        }
    }
}