package com.example.footballplayassistant.presentation.ui.screens.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.headers.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.headers.HeaderSignUpCode
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.spacing

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpCodeScreen(sendCode: String) {
    val navController = LocalNavController.current!!
    val (item1, item2, item3, item4) =
        remember { FocusRequester.createRefs() }
    val focusManager = LocalFocusManager.current
    val OK = remember { mutableStateOf(false) }

    if (OK.value)
        if (sendCode == stringResource(id = R.string.Phone))
            navController.navigate(Route.SignUpStepOneScreen.path)
        else
            navController.navigate(Route.RecoveryPasswordScreen.path)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
    ) {
        HeaderAuthentication {
            if (sendCode == stringResource(id = R.string.Phone))
                HeaderSignUpCode(textResource = R.string.enterCode)
            else
                HeaderSignUpCode(textResource = R.string.enterCodeFromEmail)
        }

        Text(
            text = stringResource(
                if (sendCode == stringResource(id = R.string.Phone)) R.string.phoneCode
                else R.string.emailCode),
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W400),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.horizontal)
                .padding(top = 24.dp, bottom = MaterialTheme.spacing.medium)
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.horizontal),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            squareTextField(itemStart = item1, itemNext = item2, focusManager = focusManager)
            squareTextField(itemStart = item2, itemNext = item3, focusManager = focusManager)
            squareTextField(itemStart = item3, itemNext = item4, focusManager = focusManager)
            OK.value =
                squareTextField(itemStart = item4, itemNext = item1, focusManager = focusManager)
        }

        Text(
            text = stringResource(R.string.repeatCode),
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.W400),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.horizontal)
                .padding(top = MaterialTheme.spacing.horizontal)
                .fillMaxWidth()
        )
    }
}

@Composable
fun squareTextField(
    itemStart: FocusRequester,
    itemNext: FocusRequester,
    focusManager: FocusManager
): Boolean {
    val textValue = remember { mutableStateOf("") }
    val maxChar = 1

    TextField(
        value = textValue.value, onValueChange = { newText ->
            if (newText.length == maxChar) {
                focusManager.moveFocus(FocusDirection.Next)
            }
            textValue.value = newText
        },
        shape = RoundedCornerShape(12.dp),
        textStyle = MaterialTheme.typography.headlineLarge.copy(
            fontWeight = FontWeight.W500,
            textAlign = TextAlign.Center
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.outlineVariant,
            focusedTextColor = MaterialTheme.colorScheme.primary
        ),
        singleLine = true,
        modifier = Modifier
            .widthIn(max = 80.dp)
            .heightIn(max = 80.dp)
            .padding(5.dp)
            .background(MaterialTheme.colorScheme.outlineVariant)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(12.dp)
            )
            .focusRequester(itemStart)
            .focusProperties {
                next = itemNext
                right = itemNext
            }
    )
    return textValue.value != ""
}