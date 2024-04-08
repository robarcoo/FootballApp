package com.example.footballplayassistant.presentation.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.BottomQuestion
import com.example.footballplayassistant.presentation.customviews.CommonButton
import com.example.footballplayassistant.presentation.customviews.CommonTextField
import com.example.footballplayassistant.presentation.customviews.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.HeaderSignUp
import com.example.footballplayassistant.presentation.customviews.HeaderSignUpCode
import com.example.footballplayassistant.presentation.customviews.SignInWithAccounts
import com.example.footballplayassistant.ui.theme.GrayText

@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview
fun SignUpCodePage() {
    val context = LocalContext.current
    val (item1, item2,item3,item4) = remember { FocusRequester.createRefs() }
    val focusManager = LocalFocusManager.current

    Column(modifier = Modifier.fillMaxSize()) {
        HeaderAuthentication { HeaderSignUpCode() }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = context.getString(R.string.phoneCode/*or emailCode*/),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            SquareTextField(item1, item2, focusManager)
            SquareTextField(item2, item3, focusManager)
            SquareTextField(item3, item4, focusManager)
            SquareTextField(item4, item1, focusManager)
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = context.getString(R.string.repeatCode),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun SquareTextField(itemStart: FocusRequester, itemNext: FocusRequester, focusManager: FocusManager) {
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
        textStyle = TextStyle(
            fontWeight = FontWeight.W500,
            fontSize = 36.sp,
            textAlign = TextAlign.Center
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = Color.Black
        ),
        singleLine = true,
        modifier = Modifier
            .widthIn(min = 64.dp, max = 80.dp)
            .padding(5.dp)
            .background(Color.Transparent)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(12.dp))
            .focusRequester(itemStart)
            .focusProperties {
                next = itemNext
                right = itemNext
            }
    )
}