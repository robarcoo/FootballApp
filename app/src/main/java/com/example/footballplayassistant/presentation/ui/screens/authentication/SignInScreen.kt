package com.example.footballplayassistant.presentation.ui.screens.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.footballplayassistant.presentation.customviews.buttons.SignInWithAccounts
import com.example.footballplayassistant.presentation.customviews.headers.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.headers.HeaderSignIn
import com.example.footballplayassistant.presentation.customviews.rows.BlockRules
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField

@Composable
@Preview
fun SignInScreen() {
    Column {
        HeaderAuthentication { HeaderSignIn() }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.30f)
        ) {
            Card(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp)) {
                Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Text(
                        text = stringResource(R.string.signwith),
                        style = MaterialTheme.typography.labelLarge
                            .copy(fontWeight = FontWeight.W400),
                        maxLines = 2,
                        textAlign = TextAlign.Center
                    )
                }
                CommonTextField(placeholder = stringResource(R.string.enterEmailorPhone))
                CommonTextField(
                    placeholder = stringResource(R.string.enterPass),
                    imageTrail = R.drawable.ic_eye_slash_24,
                    isPassword = true
                )
            }
        }

        ForgotPassword(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.05f)
        )

        CommonButton(
            text = stringResource(R.string.signin),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.06f)
        )

        BlockRules(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.1f)
        )


        SignInWithAccounts(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.3f)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.1f)
        ) {
            BottomQuestion(
                question = stringResource(R.string.questionNoAcc),
                buttonText = stringResource(R.string.signup),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.Bottom)
            )
        }
    }
}