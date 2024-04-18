package com.example.footballplayassistant.presentation.customviews.headers

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R

@Composable
fun HeaderWithBackButton(
    text: String,
    imageButton: Int = 0,
    onClickBack: () -> Unit = {},
    onClickOther: () -> Unit = {},
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(modifier = Modifier.border(
            width = 1.dp,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            shape = CircleShape
        ),
            onClick = { onClickBack.invoke() }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_back_arrow_10_18),
                contentDescription = ""
            )
        }

        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W600),
            modifier = Modifier.align(Alignment.CenterVertically)
        )

        if (imageButton != 0)
            IconButton(modifier = Modifier.border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = CircleShape
            ),
                onClick = { onClickOther.invoke() }) {
                Icon(
                    imageVector = ImageVector.vectorResource(imageButton),
                    contentDescription = ""
                )
            }
        else
            IconButton(modifier = Modifier.border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant,
                shape = CircleShape
            ),
                onClick = { /*TODO*/ }) {
            }
    }
}