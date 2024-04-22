package com.example.footballplayassistant.presentation.customviews.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R

@Composable
@Preview
fun SignInWithAccounts(modifier: Modifier = Modifier) {
    Column(modifier = modifier.wrapContentSize()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Divider(
                color = MaterialTheme.colorScheme.outline, thickness = 1.dp, modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f)
                    .align(Alignment.CenterVertically)
                    .padding(start = 16.dp)
            )
            Text(
                text = "Или", textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.W400),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f)
            )
            Divider(
                color = MaterialTheme.colorScheme.outline, thickness = 1.dp, modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f)
                    .align(Alignment.CenterVertically)
                    .padding(end = 16.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 35.dp, vertical = 50.dp)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            SquareButton(text = "Google", image = R.drawable.ic_google_25)
            SquareButton(text = "VK", image = R.drawable.ic_vk_29_16)
            SquareButton(text = "Яндекс", image = R.drawable.ic_yandex_13_24)
        }
    }
}

@Composable
fun SquareButton(text: String, image: Int) {
    Button(modifier = Modifier.size(66.dp),
        contentPadding = PaddingValues(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 10.dp),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer),
        onClick = { /*TODO*/ }) {
        Column(modifier = Modifier) {
            Image(
                modifier = Modifier
                    .height(25.dp)
                    .align(Alignment.CenterHorizontally),
                imageVector = ImageVector.vectorResource(image),
                contentDescription = ""
            )
            Text(
                text = text,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.W400),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}