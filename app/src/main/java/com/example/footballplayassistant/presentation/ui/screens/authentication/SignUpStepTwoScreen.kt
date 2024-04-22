package com.example.footballplayassistant.presentation.ui.screens.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.BottomQuestion
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.headers.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.headers.HeaderSignUpStep
import com.example.footballplayassistant.presentation.customviews.rows.BlockRules
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.GrayF1

@Composable
@Preview
fun SignUpStepTwoScreen() {
    val navController = LocalNavController.current!!
    Column(modifier = Modifier.fillMaxSize()) {
        HeaderAuthentication { HeaderSignUpStep(numStep = 2) }

        Text(
            text = stringResource(R.string.createRepeatPass),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W400),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.2f)
        ) {
            Text(
                text = addStar(id = R.string.createPass),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            CommonTextField(
                placeholder = "",
                keyBoard = KeyboardType.Text,
                color = MaterialTheme.colorScheme.primaryContainer,
                imageTrail = R.drawable.ic_eye_slash_24,
                isPassword = true
            )

            Text(
                text = addStar(id = R.string.repeatPass),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            CommonTextField(
                placeholder = "",
                keyBoard = KeyboardType.Text,
                color = MaterialTheme.colorScheme.primaryContainer,
                imageTrail = R.drawable.ic_eye_slash_24,
                isPassword = true
            )
        }

        CommonButton(
            text = stringResource(R.string.signup),
            onClick = {
                navController.navigate(Route.EnterInfoScreen.path)
            },
            style = MaterialTheme.typography.bodyLarge,
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

        BottomQuestion(
            question = stringResource(R.string.questionAcc),
            buttonText = stringResource(
                R.string.signin
            ),
            onClick = { navController.navigate(Route.SignInScreen.path) }
        )
    }
}
