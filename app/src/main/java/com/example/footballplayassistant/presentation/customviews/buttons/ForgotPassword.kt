package com.example.footballplayassistant.presentation.customviews.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.footballplayassistant.R

@Composable
@Preview
fun ForgotPassword(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
        Button(colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.outlineVariant,
            contentColor = MaterialTheme.colorScheme.primary
        ),
            onClick = { /*TODO*/ }) {
            Text(
                text = stringResource(id = R.string.forgotPassword),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500)
            )
        }
    }
}