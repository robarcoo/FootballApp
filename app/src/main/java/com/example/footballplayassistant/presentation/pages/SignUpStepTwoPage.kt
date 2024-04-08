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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.BlockRules
import com.example.footballplayassistant.presentation.customviews.BottomQuestion
import com.example.footballplayassistant.presentation.customviews.CommonButton
import com.example.footballplayassistant.presentation.customviews.CommonTextField
import com.example.footballplayassistant.presentation.customviews.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.HeaderSignUpStep
import com.example.footballplayassistant.ui.theme.GrayAccounts

@Composable
@Preview
fun SignUpStepTwoPage(){
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        HeaderAuthentication { HeaderSignUpStep(numStep = 2) }
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.1f), horizontalArrangement = Arrangement.Center){
            Text(text = context.getString(R.string.createRepeatPass), textAlign = TextAlign.Center, modifier = Modifier.padding(horizontal = 16.dp).align(Alignment.CenterVertically))
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.2f)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                ){
                Text(text = addStar(id = R.string.createPass), modifier = Modifier.padding(horizontal = 16.dp).align(Alignment.CenterVertically))
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                ){
                CommonTextField(placeholder = "", keyBoard =  KeyboardType.Text, color = GrayAccounts, image = R.drawable.ic_eye_slash_24, isPassword = true)
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                ){
                Text(text = addStar(id = R.string.repeatPass), modifier = Modifier.padding(horizontal = 16.dp).align(Alignment.CenterVertically))
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                ){
                CommonTextField(placeholder = "", keyBoard =  KeyboardType.Text, color = GrayAccounts, image = R.drawable.ic_eye_slash_24, isPassword = true)
            }
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.1f)){
            CommonButton(text = context.getString(R.string.signup), modifier = Modifier.padding(horizontal = 16.dp))
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.2f)){
            BlockRules()
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .weight(0.1f)){
            BottomQuestion(question = context.getString(R.string.questionAcc), buttonText = context.getString(
                R.string.signin), modifier = Modifier.align(Alignment.Bottom))
        }
    }
}
