package com.example.footballplayassistant.presentation.customviews.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.ui.theme.Gray75

@Composable
fun AllButton(text: String, onClick: () -> Unit = {}, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            text = text,
            modifier = Modifier.align(Alignment.CenterVertically),
            style = MaterialTheme.typography.titleMedium
        )

        Button(modifier = Modifier.align(Alignment.CenterVertically),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.outlineVariant,
                contentColor = Gray75
            ),
            onClick = { onClick.invoke() }) {
            Text(
                text = stringResource(id = R.string.all),
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.W600)
            )
        }
    }
}