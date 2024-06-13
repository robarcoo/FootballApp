package com.example.footballplayassistant.presentation.ui.screens.authentication

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import com.example.footballplayassistant.presentation.customviews.buttons.BottomQuestion
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.buttons.ForgotPassword
import com.example.footballplayassistant.presentation.customviews.buttons.SelectionButtons
import com.example.footballplayassistant.presentation.customviews.buttons.SignInWithAccounts
import com.example.footballplayassistant.presentation.customviews.headers.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.headers.HeaderSignIn
import com.example.footballplayassistant.presentation.customviews.rows.BlockRules
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.enums.FilterPhoneEmail
import com.example.footballplayassistant.presentation.enums.getFilters
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
@Preview
fun SignInScreen() {
    val navController = LocalNavController.current!!

    val filtersList = FilterPhoneEmail.entries.toList()
    val filterPhoneEmail = remember { mutableIntStateOf(filtersList[0].ordinal) }
    val error = remember{ mutableStateOf(false) }
    val phone = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val buttonEnable = remember { mutableStateOf(false) }

    val phoneMask = MaskVisualTransformation("+7 (###) ### ## ##")

    Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onPrimary)) {
        HeaderAuthentication { HeaderSignIn() }

        LazyColumn {
            item {
                SelectionButtons(
                    valueList = getFilters(),
                    selectedItemIndex = filterPhoneEmail.intValue,
                    onSelected = { filterPhoneEmail.intValue = it },
                    modifier = Modifier.padding(top = 24.dp, bottom = 20.dp, start = 16.dp, end = 16.dp)
                )
            }

            item {
                Card(
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.horizontal),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer)
                ) {
                    if (filterPhoneEmail.intValue == FilterPhoneEmail.Phone.ordinal) {
                        Text(
                            text = stringResource(R.string.enterPhoneText),
                            style = MaterialTheme.typography.labelLarge
                                .copy(fontWeight = FontWeight.W400),
                            maxLines = 2,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp)
                        )
                        CommonTextField(
                            placeholder = stringResource(R.string.enterPhone),
                            keyBoard = KeyboardType.Phone,
                            mask = phoneMask,
                            maxLength = 10,
                            onClick = { if (it.length == 10) phone.value = it },
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
                        )
                    } else {
                        Text(
                            text = stringResource(R.string.enterEmailText),
                            style = MaterialTheme.typography.labelLarge
                                .copy(fontWeight = FontWeight.W400),
                            maxLines = 2,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp)
                        )
                        CommonTextField(
                            placeholder = stringResource(R.string.enterEmail),
                            onClick = { email.value = it },
                            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
                        )
                    }
                    CommonTextField(
                        placeholder = stringResource(R.string.enterPass),
                        imageTrail = R.drawable.ic_eye_slash_24,
                        isPassword = true,
                        isError = error.value,
                        onClick = { password.value = it },
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
                    )
                    AnimatedVisibility(visible = error.value) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 22.dp, bottom = 10.dp)
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.ic_warning_12),
                                contentDescription = "Warning",
                                tint = MaterialTheme.colorScheme.error,
                                modifier = Modifier.padding(end = 2.dp)
                            )
                            Text(
                                text = stringResource(id = R.string.invalidPassword),
                                style = MaterialTheme.typography.headlineSmall.copy(
                                    fontWeight = FontWeight.W400),
                                color = MaterialTheme.colorScheme.error,
                                modifier = Modifier
                            )
                        }
                    }
                }
            }

            item {
                ForgotPassword(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp, top = 12.dp, end = 16.dp),
                    onClick = { navController.navigate(Route.ForgotPasswordScreen.path) }
                )
            }

            item {
                LaunchedEffect(phone.value, email.value, password.value) {
                    buttonEnable.value = ((phone.value.isNotEmpty() || email.value.isNotEmpty())
                            && password.value.isNotEmpty())
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
                    text = stringResource(R.string.signin),
                    containerColor = animatedContainerColor,
                    contentColor = animatedContentColor,
                    enable = buttonEnable.value,
                    onClick = { navController.navigate(Route.MainScreen.path) },
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 20.dp)
                        .fillMaxWidth()
                )
            }

            item {
                BlockRules(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = MaterialTheme.spacing.large)
                )
            }

            item {
                SignInWithAccounts(modifier = Modifier.fillMaxWidth())
            }

            item {
                BottomQuestion(
                    question = stringResource(R.string.questionNoAcc),
                    buttonText = stringResource(R.string.signup),
                    onClick = { navController.navigate(Route.SignUpEnterPhoneScreen.path) },
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.horizontal)
                )
            }
        }
    }
}