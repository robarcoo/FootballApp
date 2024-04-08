package com.example.footballplayassistant.presentation.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.BlockRules
import com.example.footballplayassistant.presentation.customviews.BottomQuestion
import com.example.footballplayassistant.presentation.customviews.CommonButton
import com.example.footballplayassistant.presentation.customviews.CommonTextField
import com.example.footballplayassistant.presentation.customviews.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.HeaderSignUp
import com.example.footballplayassistant.presentation.customviews.HeaderSignUpStep
import com.example.footballplayassistant.presentation.customviews.SignInWithAccounts
import com.example.footballplayassistant.ui.theme.GrayAccounts
import com.example.footballplayassistant.ui.theme.GrayText
import com.example.footballplayassistant.ui.theme.Green

@Composable
@Preview
fun SignUpStepOnePage(){
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        HeaderAuthentication { HeaderSignUpStep(numStep = 1) }
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.05f),
            horizontalArrangement = Arrangement.Center) {
            Text(text = context.getString(R.string.writeInfo), textAlign = TextAlign.Center,
                color = GrayText, fontWeight = FontWeight.W400, fontSize = 16.sp,
                modifier = Modifier.padding(horizontal = 16.dp).align(Alignment.CenterVertically))
        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.5f)) {
            Row(modifier = Modifier
                .fillMaxWidth()) {
                Text(text = addStar(id = R.string.nick), modifier = Modifier.padding(horizontal = 16.dp))
            }
            Row(modifier = Modifier
                .fillMaxWidth()) {
                CommonTextField(placeholder = "", keyBoard =  KeyboardType.Text, color = GrayAccounts)
            }
            Row (modifier = Modifier
                .fillMaxWidth()){
                Text(text = addStar(id = R.string.name), modifier = Modifier.padding(horizontal = 16.dp))
            }
            Row (modifier = Modifier
                .fillMaxWidth()){
                CommonTextField(placeholder = "", keyBoard =  KeyboardType.Text, color = GrayAccounts)
            }
            Row(modifier = Modifier
                .fillMaxWidth()) {
                Text(text = addStar(id = R.string.surname), modifier = Modifier.padding(horizontal = 16.dp))
            }
            Row (modifier = Modifier
                .fillMaxWidth()){
                CommonTextField(placeholder = "", keyBoard =  KeyboardType.Text, color = GrayAccounts)
            }
            Row(modifier = Modifier
                .fillMaxWidth()) {
                Text(text = addStar(id = R.string.email), modifier = Modifier.padding(horizontal = 16.dp))
            }
            Row (modifier = Modifier
                .fillMaxWidth()){
                CommonTextField(placeholder = "", keyBoard =  KeyboardType.Email, color = GrayAccounts)
            }
        }

        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.1f)){
            CommonButton(text = context.getString(R.string.next), modifier = Modifier.padding(horizontal = 16.dp))
        }

        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.07f)){
            BlockRules()
        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.1f)){
            BottomQuestion(question = context.getString(R.string.questionAcc), buttonText = context.getString(
                R.string.signin), modifier = Modifier.align(Alignment.Bottom))
        }
    }
}

@Composable
fun addStar(id: Int): AnnotatedString{
    val text = buildAnnotatedString {
        append(LocalContext.current.getString(id))

        pushStringAnnotation(tag = "star", annotation = "star")
        withStyle(
            SpanStyle(
                color = Color.Yellow
            )
        ) {
            append("*")
        }
        pop()
    }
    return text
}