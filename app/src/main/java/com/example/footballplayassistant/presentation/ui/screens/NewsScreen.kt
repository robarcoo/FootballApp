package com.example.footballplayassistant.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.cards.GameCard
import com.example.footballplayassistant.presentation.customviews.cards.NewsCard
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.Black04
import com.example.footballplayassistant.presentation.ui.theme.Green

@Composable
@Preview
fun NewsScreen() {
    val navController = LocalNavController.current!!

    val filter = remember {
        mutableStateOf("friends")
    }
    Column(modifier = Modifier.padding(top = 12.dp)) {
        HeaderWithBackButton(
            text = stringResource(id = R.string.news),
            imageButton = R.drawable.ic_plus_24,
            onClickBack = { navController.navigate(Route.MainScreen.path) },
            onClickOther = { navController.navigate(Route.CreateEventScreen.path) }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {
            if (filter.value == "friends"){
                button(
                    modifier = Modifier.align(Alignment.CenterStart),
                    filter = filter,
                    borderColor = Green,
                    containerColor = Green,
                    text = R.string.friends,
                    zIndex = 1f,
                    value = "friends"
                )

                button(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    filter = filter,
                    borderColor = Black04,
                    containerColor = Color.White,
                    text = R.string.places,
                    zIndex = 0f,
                    value = "places"
                )
            }else{
                button(
                    modifier = Modifier.align(Alignment.CenterStart),
                    filter = filter,
                    borderColor = Black04,
                    containerColor = Color.White,
                    text = R.string.friends,
                    zIndex = 0f,
                    value = "friends"
                )

                button(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    filter = filter,
                    borderColor = Green,
                    containerColor = Green,
                    text = R.string.places,
                    zIndex = 1f,
                    value = "places"
                )
            }
        }

        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)){
            if(filter.value=="friends"){
                item { NewsCard(place = "place", name = "name") }
                item { NewsCard(place = "place", name = "name") }
            }else{
                item { GameCard(place = "place", host = "name") }
            }
        }
    }
}

@Composable
private fun button(
    modifier: Modifier = Modifier,
    filter: MutableState<String>,
    borderColor: Color,
    containerColor: Color,
    text: Int,
    zIndex: Float,
    value: String
) {
    Button(
        modifier = modifier
            .fillMaxWidth(0.55f)
            .background(
                color = containerColor, shape = RoundedCornerShape(80.dp)
            )
            .border(1.dp, borderColor, RoundedCornerShape(80.dp))
            .zIndex(zIndex),
        shape = RoundedCornerShape(80.dp),
        colors = ButtonDefaults.buttonColors(containerColor = containerColor),
        onClick = { filter.value = value }) {
        Text(
            text = stringResource(id = text),
            fontWeight = FontWeight.W500,
            fontSize = 16.sp,
            fontFamily = FontFamily(
                Font(R.font.inter)
            ),
            color = Black04
        )
    }
}