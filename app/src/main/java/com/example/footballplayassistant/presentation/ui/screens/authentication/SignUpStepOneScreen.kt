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
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.BottomQuestion
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.headers.HeaderAuthentication
import com.example.footballplayassistant.presentation.customviews.headers.HeaderSignUpStep
import com.example.footballplayassistant.presentation.customviews.rows.BlockRules
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField

@Composable
@Preview
fun SignUpStepOneScreen() {
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        HeaderAuthentication { HeaderSignUpStep(numStep = 1) }

        Text(
            text = stringResource(R.string.writeInfo), textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W400),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.45f)
        ) {
            Text(
                text = addStar(id = R.string.nick),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            CommonTextField(
                placeholder = "",
                keyBoard = KeyboardType.Text,
                color = MaterialTheme.colorScheme.primaryContainer
            )

            Text(
                text = addStar(id = R.string.name),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            CommonTextField(
                placeholder = "",
                keyBoard = KeyboardType.Text,
                color = MaterialTheme.colorScheme.primaryContainer
            )

            Text(
                text = addStar(id = R.string.surname),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            CommonTextField(
                placeholder = "",
                keyBoard = KeyboardType.Text,
                color = MaterialTheme.colorScheme.primaryContainer
            )

            Text(
                text = addStar(id = R.string.email),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            CommonTextField(
                placeholder = "",
                keyBoard = KeyboardType.Email,
                color = MaterialTheme.colorScheme.primaryContainer
            )
        }

        CommonButton(
            text = context.getString(R.string.next),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxHeight()
                .weight(0.05f)
        )

        BlockRules(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.1f)
        )

        BottomQuestion(
            question = context.getString(R.string.questionAcc),
            buttonText = context.getString(
                R.string.signin
            ),
        )
    }
}

@Composable
fun addStar(id: Int): AnnotatedString {
    val text = buildAnnotatedString {
        append(stringResource(id))

        pushStringAnnotation(tag = "star", annotation = "star")
        withStyle(
            SpanStyle(
                color = MaterialTheme.colorScheme.onBackground,
                fontFamily = FontFamily(Font(R.font.inter)),
            )
        ) {
            append("*")
        }
        pop()
    }
    return text
}