package com.example.footballplayassistant.presentation.customviews.rows

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R

@Composable
@Preview
fun BlockRules(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        val text = buildAnnotatedString {
            append(stringResource(R.string.blockrulesstart))
            append(" ")

            pushStringAnnotation(tag = "click", annotation = "click")
            withStyle(
                SpanStyle(
                    color = MaterialTheme.colorScheme.secondary,
                )
            ) {
                append(stringResource(R.string.rules))
                append(" ")
            }
            pop()

            append(stringResource(id = R.string.and))
            append(" ")

            pushStringAnnotation(tag = "click", annotation = "click")
            withStyle(
                SpanStyle(
                    color = MaterialTheme.colorScheme.secondary,
                )
            )
            {
                append(stringResource(R.string.politic))
            }
            pop()

        }
        val context = LocalContext.current
        ClickableText(text = text,
            style = MaterialTheme.typography.displaySmall.copy(
                fontWeight = FontWeight.W500,
                textAlign = TextAlign.Center
            ),
            onClick = { offset ->
                text.getStringAnnotations(tag = "click", start = offset, end = offset).firstOrNull()
                    ?.let {
                        Toast.makeText(context, "hey", Toast.LENGTH_SHORT).show()
                    }
            })
    }
}