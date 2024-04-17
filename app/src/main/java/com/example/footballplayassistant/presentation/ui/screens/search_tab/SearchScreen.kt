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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.ui.theme.Black04
import com.example.footballplayassistant.presentation.ui.theme.Gray75
import com.example.footballplayassistant.presentation.ui.theme.GrayF1
import com.example.footballplayassistant.presentation.ui.theme.Green


@Composable
@Preview
fun SearchScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Row (verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)) {
            SearchBar(
                Modifier
                    .height(48.dp)
                    .weight(1f))
            Spacer(modifier = Modifier
                .size(6.dp))
            OutlinedIconButton(onClick = {}, modifier = Modifier.size(48.dp),
                border = BorderStroke(1.dp, Gray75)
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_icons_24),
                    contentDescription = "Filter", tint = Black04,
                    modifier = Modifier.padding(10.dp))
            }
        }
        LazyColumn() {
            item {
                SearchCard()
                SearchCard()
                SearchCard()
            }
        }

    }
}

@Composable
fun SearchCard() {
    Card(modifier = Modifier
        .padding(vertical = 5.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = GrayF1)
    ) {
        Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp)) {
            Row() {
                Text(
                    text = "Тест", fontSize = 16.sp, fontWeight = FontWeight.W600,
                    fontFamily = FontFamily(Font(R.font.inter))
                )
                Spacer(modifier = Modifier.size(12.dp).weight(1f))
                Icon(
                    painterResource(id = R.drawable.ic_arrow_green_search_map),
                    contentDescription = "Map Link",
                    tint = Green
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row() {
                Text(
                    text = "Тест", fontSize = 12.sp, fontWeight = FontWeight.W500,
                    color = Gray75, fontFamily = FontFamily(Font(R.font.inter))
                )
                Spacer(modifier = Modifier.width(26.dp).weight(1f))
                Text(
                    text = "4,2км", fontSize = 12.sp, fontWeight = FontWeight.W500,
                    color = Gray75, fontFamily = FontFamily(Font(R.font.inter))
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier : Modifier) {
    var value by remember { mutableStateOf(TextFieldValue(""))}
    BasicTextField(
        value = value,
        modifier = modifier,
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
                    tint = Gray75,
                    contentDescription = "Search",
                    modifier = Modifier.size(24.dp))
            },
            shape = RoundedCornerShape(60.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedContainerColor = GrayF1,
                unfocusedContainerColor = GrayF1,
                focusedTextColor = Black04,
                unfocusedTextColor = Black04,
                cursorColor = Black04

            ),

            )
    }
}