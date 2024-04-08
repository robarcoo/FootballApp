package com.example.footballplayassistant.presentation.customviews

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.ui.theme.Green

@Composable
@Preview
fun BlockRules(modifier: Modifier = Modifier){
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        val text = buildAnnotatedString {
            append(LocalContext.current.getString(R.string.blockrulesstart))

            pushStringAnnotation(tag = "click", annotation = "click")
            withStyle(
                SpanStyle(
                    color = Green
                )
            ) {
                append(LocalContext.current.getString(R.string.rules))
            }
            pop()

            append("и")

            pushStringAnnotation(tag = "click", annotation = "click")
            withStyle(
                SpanStyle(
                    color = Green
                )
            ) {
                append(LocalContext.current.getString(R.string.politic))
            }
            pop()

        }
        val context = LocalContext.current
        ClickableText(text = text, style = TextStyle(
            textAlign = TextAlign.Center), onClick = { offset ->
            text.getStringAnnotations(tag = "click", start = offset, end = offset).firstOrNull()
                ?.let {
                    Toast.makeText(context, "hey", Toast.LENGTH_SHORT).show()
                }
        })
    }
}