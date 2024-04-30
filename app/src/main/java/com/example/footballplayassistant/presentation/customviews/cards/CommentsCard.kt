package com.example.footballplayassistant.presentation.customviews.cards

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun CommentsCard(modifier: Modifier = Modifier) {
//    val pagerState = rememberPagerState(pageCount = {
//        3
//    })
    Card(
        modifier = modifier.padding(top = 32.dp),
        shape = RoundedCornerShape(
            15.dp,
            15.dp,
            0.dp,
            0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.comments),
                        style = MaterialTheme.typography.titleMedium
                            .copy(fontWeight = FontWeight.W600),
                        modifier = Modifier.padding(end = 4.dp)
                    )
//                    Icon(
//                        imageVector = ImageVector.vectorResource(R.drawable.ic_indicator_6),
//                        contentDescription = "",
//                        modifier = Modifier.padding(end = 4.dp),
//                        tint = Green
//                    )
//                    Text(
//                        text = "10",
//                        style = MaterialTheme.typography.titleMedium
//                            .copy(fontWeight = FontWeight.W600)
//                    )
//                }

                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = stringResource(id = R.string.sendMessage),
                        style = MaterialTheme.typography.bodyMedium
                            .copy(fontWeight = FontWeight.W600),
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }

//            HorizontalPager(state = pagerState) { page ->
                CurrentCommentCard(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    date = "10 hours",
                    name = "NAme NAme",
                    likes = 15,
                    text = """Манишки есть, брать ничего не надо, все взял.
                        | Давайте пораньше придем минут на 15 чтоб подготовиться""".trimMargin()
                )
//            }
//            Row(
//                Modifier
//                    .wrapContentHeight()
//                    .fillMaxWidth()
//                    .align(Alignment.CenterHorizontally)
//                    .padding(bottom = 8.dp),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                repeat(pagerState.pageCount) { iteration ->
//                    val color =
//                        if (pagerState.currentPage == iteration) Color.Black else Color.LightGray
//                    Box(
//                        modifier = Modifier
//                            .padding(2.dp)
//                            .clip(RoundedCornerShape(2.dp))
//                            .background(color)
//                            .size(8.dp)
//                    )
//                }
//            }
        }
    }
}