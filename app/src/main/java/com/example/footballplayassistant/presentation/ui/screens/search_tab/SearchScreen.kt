package com.example.footballplayassistant.presentation.ui.screens.search_tab

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R


@Composable
@Preview
fun SearchScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        SearchBar()
        LazyColumn {
            item {
                SearchCard("Тест", "Тест", "4,2км")
                SearchCard("Тест", "Тест", "4,2км")
                SearchCard("Тест", "Тест", "4,2км")
            }
        }

    }
}

@Composable
fun SearchCard(title : String, address : String, distance : String) {
    Card(modifier = Modifier
        .padding(vertical = 5.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)) {
            Row {
                Text(
                    text = title, style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.W600
                )
                Spacer(modifier = Modifier
                    .size(12.dp)
                    .weight(1f))
                Icon(
                    painterResource(id = R.drawable.ic_arrow_green_search_map),
                    contentDescription = stringResource(id = R.string.mapLinkIconDescription),
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(
                    text = address, color = MaterialTheme.colorScheme.onSecondaryContainer, style = MaterialTheme.typography.displaySmall.copy(fontSize = 12.sp,
                        lineHeight = 12.sp)
                )
                Spacer(modifier = Modifier
                    .width(26.dp)
                    .weight(1f))
                Text(
                    text = distance, color = MaterialTheme.colorScheme.onSecondaryContainer, style = MaterialTheme.typography.displaySmall.copy(fontSize = 12.sp,
                        lineHeight = 12.sp)
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var value by remember { mutableStateOf(TextFieldValue(""))}
    Row (verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp)) {
    BasicTextField(
        value = value,
        modifier = Modifier
            .height(48.dp)
            .weight(1f),
        onValueChange = { value = it },
    ) { innerTextField ->
        TextFieldDefaults.DecorationBox(
            value = value.toString(),
            innerTextField = innerTextField,
            singleLine = true,
            enabled = true,
            interactionSource = remember { MutableInteractionSource() },
            visualTransformation = VisualTransformation.None,
            trailingIcon = {
                Icon(painterResource(id = R.drawable.ic_search_black_25),
                    tint = MaterialTheme.colorScheme.onSecondaryContainer,
                    contentDescription = stringResource(id = R.string.searchIconDescription),
                    modifier = Modifier.size(24.dp))
            },
            shape = RoundedCornerShape(60.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = MaterialTheme.colorScheme.outlineVariant,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.outlineVariant,
                disabledIndicatorColor = MaterialTheme.colorScheme.outlineVariant,
                focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                focusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                unfocusedTextColor = MaterialTheme.colorScheme.onPrimaryContainer,
                cursorColor = MaterialTheme.colorScheme.onPrimaryContainer

            ),

            )
    }
        Spacer(modifier = Modifier
            .size(6.dp))
        OutlinedIconButton(onClick = {}, modifier = Modifier.size(48.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSecondaryContainer)
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_icons_24),
                contentDescription = stringResource(id = R.string.filterIconDescription), tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(10.dp))
        }
    }
}