package com.example.footballplayassistant.presentation.ui.screens.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.headers.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.headers.HeaderSignUpStep
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
@Preview
fun SignUpStepOneScreen() {
    val context = LocalContext.current
    val navController = LocalNavController.current!!

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.onPrimary)
    ) {
        HeaderAuthentication { HeaderSignUpStep(numStep = 1) }

        LazyColumn {
            item {
                Text(
                    text = stringResource(R.string.writeInfo), textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W400),
                    modifier = Modifier
                        .padding(horizontal = MaterialTheme.spacing.horizontal)
                        .padding(top = 24.dp, bottom = MaterialTheme.spacing.medium)
                        .fillMaxWidth()
                )
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 36.dp)
                        .padding(horizontal = MaterialTheme.spacing.horizontal)
                ) {
                    Text(
                        text = addStar(id = R.string.nick),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )

                    CommonTextField(
                        placeholder = stringResource(id = R.string.enterNick),
                        keyBoard = KeyboardType.Text,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                    Text(
                        text = addStar(id = R.string.name),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )

                    CommonTextField(
                        placeholder = stringResource(id = R.string.enterName),
                        keyBoard = KeyboardType.Text,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                    Text(
                        text = addStar(id = R.string.surname),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )

                    CommonTextField(
                        placeholder = stringResource(id = R.string.enterSurname),
                        keyBoard = KeyboardType.Text,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                    Text(
                        text = addStar(id = R.string.email),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )

                    CommonTextField(
                        placeholder = stringResource(id = R.string.enterEmail),
                        keyBoard = KeyboardType.Email,
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
                }
            }

            item {
                CommonButton(
                    text = context.getString(R.string.next),
                    onClick = {
                        navController.navigate(Route.SignUpStepTwoScreen.path)
                    },
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(horizontal = MaterialTheme.spacing.horizontal)
                )
            }
        }
    }
}

@Composable
fun addStar(id: Int): AnnotatedString {
    val text = buildAnnotatedString {
        withStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 12.sp,
                fontWeight = FontWeight.W500,
                fontFamily = FontFamily(Font(R.font.inter))
            )
        ) {
            append(stringResource(id))
        }

        pushStringAnnotation(tag = "star", annotation = "star")
        withStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontFamily = FontFamily(Font(R.font.inter)),
                fontSize = 12.sp,
                fontWeight = FontWeight.W500
            )
        ) {
            append("*")
        }
        pop()
    }
    return text
}