package com.example.footballplayassistant.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.BottomQuestion
import com.example.footballplayassistant.presentation.customviews.CommonButton
import com.example.footballplayassistant.presentation.customviews.CommonTextField
import com.example.footballplayassistant.presentation.customviews.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.HeaderSignUp
import com.example.footballplayassistant.presentation.customviews.SignInWithAccounts

@Composable
@Preview
fun SignUpEnterPhonePage(){
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        HeaderAuthentication { HeaderSignUp() }
        Text(text = context.getString(R.string.choosenPhone), textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 16.dp))
        CommonTextField(placeholder = context.getString(R.string.enterPhone), keyBoard =  KeyboardType.Phone)
        CommonButton(text = context.getString(R.string.sendCode), modifier = Modifier.padding(horizontal = 16.dp))
        SignInWithAccounts()
        BottomQuestion(question = context.getString(R.string.questionAcc), buttonText = context.getString(R.string.signin))
    }

}