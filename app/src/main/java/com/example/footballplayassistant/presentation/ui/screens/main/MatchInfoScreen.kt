package com.example.footballplayassistant.presentation.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.ui.theme.Green

@Composable
@Preview
fun MatchInfoScreen(/*type: String, name: String, description: String*/) {
    Column(modifier = Modifier.padding(top = 12.dp)) {
        HeaderWithBackButton(text = stringResource(id = R.string.matchInfo))

        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            item {
                Text(
                    text = "game type",
                    style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W600),
                    color = Green,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }

            item {
                Text(
                    text = "game Name",
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W600)
                )
                Text(
                    text = "game description",
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.W400),
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }

            item {
                Text(
                    text = stringResource(id = R.string.matchPlace),
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W500),
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                //карта
            }
        }
    }
}