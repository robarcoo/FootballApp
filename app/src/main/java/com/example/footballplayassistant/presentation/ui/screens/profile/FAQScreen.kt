package com.example.footballplayassistant.presentation.ui.screens.profile

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route

@Composable
fun FAQScreen() {
    val navController = LocalNavController.current!!

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        HeaderWithBackButton(
            text = stringResource(id = R.string.faq),
            onClickBack = { navController.navigate(Route.AboutAppScreen.path) },
            modifier = Modifier.padding(top = 12.dp, bottom = 16.dp)
        )

        LazyColumn {
            item {
                QuestionCard(
                    question = stringResource(id = R.string.question1),
                    answer = stringResource(id = R.string.answer1)
                )
            }
            item {
                QuestionCard(
                    question = stringResource(id = R.string.question2),
                    answer = stringResource(id = R.string.answer1)
                )
            }
        }

    }
}

@Composable
private fun QuestionCard(question: String, answer: String) {
    val expanded = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .animateContentSize()
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        onClick = { expanded.value = !expanded.value },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = question,
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.W400,
                    lineHeight = 24.sp),
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(
                        top = 12.dp,
                        bottom = if (expanded.value) 8.dp else 12.dp
                    )
            )
            Image(
                imageVector = ImageVector.vectorResource(id =
                if (expanded.value) R.drawable.ic_arrow_up_18_10
                else R.drawable.ic_arrow_menu_18_10),
                contentDescription = "Arrow",
                modifier = Modifier.fillMaxWidth(0.3f)
            )
        }

        AnimatedVisibility(visible = expanded.value) {
            Text(
                text = answer,
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.W400,
                    lineHeight = 20.sp),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
            )
        }
    }
}