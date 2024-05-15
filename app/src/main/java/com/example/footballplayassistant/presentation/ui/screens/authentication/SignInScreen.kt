package com.example.footballplayassistant.presentation.ui.screens.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
@Preview
fun SignInScreen() {
    val navController = LocalNavController.current!!
    val filterButton = remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.onPrimary)) {
        HeaderAuthentication { HeaderSignIn() }

        LazyColumn {
            item {
                SelectionButtons(
                    valueList = listOf(
                        stringResource(id = R.string.byPhone),
                        stringResource(id = R.string.byEmail)
                    ),
                    selectedItemIndex = 0,
                    onSelected = { filterButton.value = it },
                    modifier = Modifier
                        .padding(top = 24.dp, bottom = 20.dp)
                        .padding(horizontal = 16.dp)
                )
            }

            item {
                Card(
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.horizontal),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {
                    if (filterButton.value == 0) {
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
                            modifier = Modifier
                                .padding(horizontal = MaterialTheme.spacing.horizontal)
                                .padding(bottom = 10.dp)
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
                            modifier = Modifier
                                .padding(horizontal = MaterialTheme.spacing.horizontal)
                                .padding(bottom = 10.dp)
                        )
                    }
                    CommonTextField(
                        placeholder = stringResource(R.string.enterPass),
                        imageTrail = R.drawable.ic_eye_slash_24,
                        isPassword = true,
                        modifier = Modifier
                            .padding(horizontal = MaterialTheme.spacing.horizontal)
                            .padding(bottom = 12.dp)
                    )
                }
            }

            item {
                ForgotPassword(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp, top = 12.dp, end = 16.dp)
                )
            }

            item {
                CommonButton(
                    text = stringResource(R.string.signin),
                    onClick = { navController.navigate(Route.MainScreen.path) },
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(horizontal = MaterialTheme.spacing.horizontal)
                        .padding(bottom = 20.dp)
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
                SignInWithAccounts(
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

            item {
                BottomQuestion(
                    question = stringResource(R.string.questionNoAcc),
                    buttonText = stringResource(R.string.signup),
                    onClick = { navController.navigate(Route.SignUpEnterPhoneScreen.path) },
                    modifier = Modifier
                        .padding(horizontal = MaterialTheme.spacing.horizontal)
                )
            }
        }
    }
}