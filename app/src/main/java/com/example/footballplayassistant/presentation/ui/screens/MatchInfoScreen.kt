package com.example.footballplayassistant.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.Green

@Composable
@Preview
fun MatchInfoScreen(/*type: String, name: String, description: String*/) {
    val navController = LocalNavController.current!!
    Column(modifier = Modifier.padding(top = 12.dp)) {
        HeaderWithBackButton(text = stringResource(id = R.string.matchInfo),
            onClickBack = { navController.navigate(Route.MatchScreen.path) })

        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            item {
                Text(
                    text = "game type",
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight.W600,
                    fontSize = 12.sp,
                    color = Green,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }

            item {
                Text(
                    text = "game Name",
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight.W600,
                    fontSize = 16.sp
                )
                Text(
                    text = "game description",
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight.W400,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }

            item {
                Text(
                    text = stringResource(id = R.string.matchPlace),
                    fontFamily = FontFamily(Font(R.font.inter)),
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                //карта
            }
        }
    }
}