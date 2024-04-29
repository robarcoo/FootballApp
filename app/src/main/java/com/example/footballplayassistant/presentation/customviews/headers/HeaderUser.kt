package com.example.footballplayassistant.presentation.customviews.headers

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R

@Composable
fun HeaderUser(
    name: String, onClickPlus: () -> Unit = {}, onClickBell: () -> Unit = {}, @SuppressLint(
        "ModifierParameter"
    ) modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.user_foto), contentDescription = "",
            modifier = Modifier.fillMaxWidth(0.12f))

        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(start = 10.dp), verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Привет,",
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W600),
                color = MaterialTheme.colorScheme.primary
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f)
                .height(42.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    RoundedCornerShape(40.dp)
                )
        ) {
            IconButton(onClick = { onClickPlus.invoke() }) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_plus_24),
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.primary
                )
            }

            VerticalDivider(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 8.dp)
                    .width(1.dp),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                thickness = 1.dp
            )

            IconButton(onClick = { onClickBell.invoke() }) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_bell_24),
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}