package com.example.footballplayassistant.presentation.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.BlockRules
import com.example.footballplayassistant.presentation.customviews.BottomQuestion
import com.example.footballplayassistant.presentation.customviews.CommonButton
import com.example.footballplayassistant.presentation.customviews.CommonTextField
import com.example.footballplayassistant.presentation.customviews.ForgotPassword
import com.example.footballplayassistant.presentation.customviews.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.HeaderSignIn
import com.example.footballplayassistant.presentation.customviews.HeaderSignUpCode
import com.example.footballplayassistant.presentation.customviews.SignInWithAccounts
import com.example.footballplayassistant.ui.theme.GrayText

@Composable
@Preview
fun SignInPage(){
    val context = LocalContext.current
    Column {
        HeaderAuthentication { HeaderSignIn() }

        Row (modifier = Modifier
                .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.35f)){
            Card(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp)) {
                Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Text(text = context.getString(R.string.signwith),
                        fontWeight = FontWeight.W400, fontSize = 16.sp, maxLines = 2, textAlign = TextAlign.Center)
                }
                CommonTextField(placeholder = context.getString(R.string.enterEmailorPhone))
                CommonTextField(placeholder = context.getString(R.string.enterPass), image = R.drawable.ic_eye_slash_24, isPassword = true)
            }
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.05f)){
            ForgotPassword()
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.1f)){
            CommonButton(text = context.getString(R.string.signin), modifier = Modifier.padding(horizontal = 16.dp))
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.1f)){
            BlockRules(modifier = Modifier.padding(horizontal = 16.dp))
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.3f)){
            SignInWithAccounts(modifier = Modifier.padding(horizontal = 16.dp))
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.1f)){
            BottomQuestion(question = context.getString(R.string.questionNoAcc), buttonText = context.getString(R.string.signup), modifier = Modifier.padding(horizontal = 16.dp).align(Alignment.Bottom))
        }
    }
}