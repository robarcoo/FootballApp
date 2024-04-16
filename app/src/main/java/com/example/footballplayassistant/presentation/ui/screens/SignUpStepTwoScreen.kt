package com.example.footballplayassistant.presentation.ui.screens

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.rows.BlockRules
import com.example.footballplayassistant.presentation.customviews.buttons.BottomQuestion
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.customviews.headers.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.headers.HeaderSignUpStep
import com.example.footballplayassistant.presentation.ui.theme.GrayF1

@Composable
@Preview
fun SignUpStepTwoScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        HeaderAuthentication { HeaderSignUpStep(numStep = 2) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.1f), horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.createRepeatPass),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.inter)),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.2f)
        ) {
            Text(
                text = addStar(id = R.string.createPass),
                fontFamily = FontFamily(Font(R.font.inter)),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            CommonTextField(
                placeholder = "",
                keyBoard = KeyboardType.Text,
                color = GrayF1,
                imageTrail = R.drawable.ic_eye_slash_24,
                isPassword = true
            )

            Text(
                text = addStar(id = R.string.repeatPass),
                fontFamily = FontFamily(Font(R.font.inter)),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            CommonTextField(
                placeholder = "",
                keyBoard = KeyboardType.Text,
                color = GrayF1,
                imageTrail = R.drawable.ic_eye_slash_24,
                isPassword = true
            )
        }

        CommonButton(
            text = stringResource(R.string.signup),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxHeight()
                .weight(0.04f)
        )

        BlockRules(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.2f)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.1f)
        ) {
            BottomQuestion(
                question = stringResource(R.string.questionAcc), buttonText = stringResource(
                    R.string.signin
                ), modifier = Modifier.align(Alignment.Bottom)
            )
        }
    }
}
