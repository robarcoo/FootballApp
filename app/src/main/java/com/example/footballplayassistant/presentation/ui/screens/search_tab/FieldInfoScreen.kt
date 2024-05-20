package com.example.footballplayassistant.presentation.ui.screens.search_tab

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.ui.theme.spacing
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Preview
@Composable
fun FieldInfoScreen() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState())) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.medium)
        ) {
            HeaderWithBackButton(text = "Поле", imageButton = R.drawable.ic_arrow_share_25)
            Box(
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.medium)
                    .height(190.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(R.drawable.field_example_photo),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
                Row(
                    modifier = Modifier
                        .padding(
                            vertical = MaterialTheme.spacing.medium,
                            horizontal = MaterialTheme.spacing.medium
                        )
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = Color.Black.copy(alpha = 0.6f))
                ) {
                    Text(
                        "1\\10", style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.onPrimary, lineHeight = 20.sp
                        ),
                        modifier = Modifier.padding(
                            vertical = MaterialTheme.spacing.small,
                            horizontal = MaterialTheme.spacing.small
                        )
                    )
                }
            }
            Row(
                modifier = Modifier.padding(vertical = MaterialTheme.spacing.small),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Футбольный манеж 38х16 «Спорт Ангар» Теплый стан",
                    style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onPrimaryContainer),
                    modifier = Modifier
                        .weight(1f, fill = false)
                        .padding(end = MaterialTheme.spacing.medium),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                FavoriteButton()
            }
            FlowRow(
                modifier = Modifier
                    .padding(vertical = MaterialTheme.spacing.medium)
                    .fillMaxWidth()
            ) {
                Icon(
                    painterResource(id = R.drawable.ic_star),
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = MaterialTheme.spacing.small)
                )
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onPrimaryContainer)) {
                            append("5")
                        }
                        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onSecondaryContainer)) {
                            append(" (8 отзывов)")
                        }
                    },
                    style = MaterialTheme.typography.titleMedium
                )
            }
            FlowRow(modifier = Modifier.padding(bottom = MaterialTheme.spacing.small)) {
                TagField(text = "Удобное расположение", amount = 20)
                TagField(text = "Сервис", amount = 18)
                TagField(text = "Состояние поля", amount = 10)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = MaterialTheme.spacing.small)
            ) {
                InfoCard(
                    icon = R.drawable.ic_location, text = "Поречная улица, дом 3, к.1 строение 2",
                    Modifier
                        .fillMaxWidth(0.5f)
                        .padding(end = MaterialTheme.spacing.small)
                )
                InfoCard(
                    icon = R.drawable.ic_call, text = "+7 (495) 970- 31-29",
                    Modifier
                        .fillMaxWidth()
                )

            }
            Row(modifier = Modifier.fillMaxWidth()) {
                InfoCard(
                    icon = R.drawable.ic_time_black_24, text = "08:00 - 24:00",
                    Modifier
                        .fillMaxWidth(0.5f)
                        .padding(end = MaterialTheme.spacing.small)
                )
                AdditionalInfo(
                    Modifier
                        .fillMaxWidth()
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = MaterialTheme.spacing.large,
                        bottom = MaterialTheme.spacing.medium
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Ближайшие события", style =
                    MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.W600,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                    modifier = Modifier.weight(1f, fill = false)
                )
                Text(
                    "Все", style = MaterialTheme.typography.bodyMedium
                        .copy(color = MaterialTheme.colorScheme.onSecondaryContainer)
                )
            }
            val pagerState = rememberPagerState(pageCount = { 3 })
            val event = Event(
                "Арена Новый Футбол поле  Крылатское",
                listOf(
                    Player("Игорь", "Султанов", R.drawable.loadexample),
                    Player("Егор", "Дружин", R.drawable.player_example),
                    Player("Серявгей", "Сергеев", R.drawable.player_example_1),
                    Player("Игорь", "Султанов", R.drawable.loadexample),
                    Player("Игорь", "Султанов", R.drawable.loadexample),
                    Player("Игорь", "Султанов", R.drawable.loadexample),
                    Player("Игорь", "Султанов", R.drawable.loadexample),
                ),
                "27.07.2023",
                "10:00",
                500
            )
            val eventList = listOf(event, event, event)
            HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth()) { page ->
                EventCard(eventList[page])
            }
            Row(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(
                        top = MaterialTheme.spacing.medium,
                        end = MaterialTheme.spacing.extraSmall
                    ),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.tertiaryContainer
                    Box(
                        modifier = Modifier
                            .padding(end = MaterialTheme.spacing.extraSmall)
                            .size(8.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(color)
                    )
                }
            }

        }

        Column(
            modifier = Modifier.clip(RoundedCornerShape(32.dp)).fillMaxWidth().background(
                color = MaterialTheme.colorScheme.primaryContainer
            ).padding(MaterialTheme.spacing.medium)
        ) {
            Text("")
            FeedbackCard("", 0, 0, "", "")
            Button(onClick = {}) {

            }
        }

        Button(onClick = {}) {

        }
    }
}

data class Player(
    val name : String,
    val surname : String,
    val photo : Int
)

data class Event(
    val name: String,
    val participants: List<Player>,
    val date: String,
    val time: String,
    val price: Int
)
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EventCard(event : Event) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.outlineVariant
        ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimaryContainer)
    ) {
        Column(modifier = Modifier.padding(MaterialTheme.spacing.medium)) {
            Text(
                event.name, style = MaterialTheme.typography.displayMedium.copy(
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                modifier = Modifier.padding(bottom = MaterialTheme.spacing.small)
            )
            Row(modifier = Modifier.padding(vertical = MaterialTheme.spacing.medium)) {
                LazyVerticalGrid(
                    modifier = Modifier.size(62.dp),
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(MaterialTheme.spacing.extraSmall),
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    items(if (event.participants.size > 4) 4 else event.participants.size) { index ->
                        PhotoGrid(event, index)
                    }
                }

                FlowRow(modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small)
                    .weight(1f)) {
                    ListNames(event)
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(RoundedCornerShape(26.dp))
                        .background(MaterialTheme.colorScheme.secondary)
                        .width(62.dp)
                ) {
                    Text(
                        "8/10",
                        style = MaterialTheme.typography.labelSmall.copy(MaterialTheme.colorScheme.onPrimaryContainer),
                        modifier = Modifier
                            .padding(
                                horizontal = MaterialTheme.spacing.medium,
                                vertical = MaterialTheme.spacing.extraSmall
                            )
                    )
                }
            }
            HorizontalDivider(
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
            EventDetails(event)

        }
    }
}

@Composable
fun FeedbackCard(name : String, photo : Int, rating : Int, date : String, text: String) {

}

@Composable
fun EventDetails(event : Event) {
    Row(
        modifier = Modifier.padding(top = MaterialTheme.spacing.medium).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier.weight(1f, fill = false),
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painterResource(id = R.drawable.ic_calendar_gray_24),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Text(
                event.date, style = MaterialTheme.typography.displaySmall.
                copy(color = MaterialTheme.colorScheme.onPrimaryContainer),
                modifier = Modifier.padding(
                    start = MaterialTheme.spacing.extraSmall,
                    end = MaterialTheme.spacing.large
                )
            )
            Icon(
                painterResource(id = R.drawable.ic_time_24), contentDescription = null,
                modifier = Modifier.padding(end = MaterialTheme.spacing.extraSmall),
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Text(
                event.time, style = MaterialTheme.typography.displaySmall
                    .copy(color = MaterialTheme.colorScheme.onPrimaryContainer)
            )
        }
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W700)) {
                    append(event.price.toString())
                }

                append("₽/чел")
            },
            style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.onPrimaryContainer)
        )

    }
}
@Composable
fun PhotoGrid(event : Event, index : Int) {
    if (event.participants.size > 4 && index == 3) {
        Row(
            modifier = Modifier.border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                shape = RoundedCornerShape(8.dp)
            )
                .size(26.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "+${event.participants.size - 3}",
                style = MaterialTheme.typography.labelSmall.copy(
                    fontWeight = FontWeight.W400,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    } else {
        Image(
            painterResource(id = event.participants[index].photo),
            contentDescription = null,
            modifier = Modifier
                .size(26.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop

        )
    }
}
@Composable
fun ListNames(event : Event) {
    for (i in 0..2) {
        Text(
            "${event.participants[i].name} ",
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.W600,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
        Text(
            "${event.participants[i].surname}, ",
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.W600,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
    }
    if (event.participants.size == 5) {
        Text(
            "и еще один",
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.W400,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
    } else if (event.participants.size > 4) {
        Text(
            "и ${event.participants.size - 3} других",
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.W400,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
    } else
        Text(
            event.participants[3].name,
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.W600,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
}

@Composable
fun AdditionalInfo(@SuppressLint("ModifierParameter") modifier: Modifier = Modifier) {
    Button(onClick = {}, modifier = modifier.height(80.dp),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(MaterialTheme.spacing.small),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.outlineVariant
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onSecondaryContainer)
    ) {
            Text("Дополнительная информация",
                style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.onPrimaryContainer),
                modifier = Modifier.weight(1f, fill = false))
            Icon(
                painterResource(id = R.drawable.ic_white_arrows_18), contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onPrimaryContainer)
                    .padding(MaterialTheme.spacing.small)

            )

    }

}
@Composable
fun TagField(text : String, amount : Int) {
    Row(modifier = Modifier
        .padding(bottom = MaterialTheme.spacing.small, end = MaterialTheme.spacing.small)
        .border(1.dp, MaterialTheme.colorScheme.onSecondaryContainer, RoundedCornerShape(68.dp))
        .padding(MaterialTheme.spacing.small),
        verticalAlignment = Alignment.CenterVertically) {
        Text(text, style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onPrimaryContainer))
        Icon(painterResource(id = R.drawable.ic_indicator_6), contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small))
        Text(amount.toString(), style = MaterialTheme.typography.bodyMedium.copy(color = MaterialTheme.colorScheme.onPrimaryContainer))
    }
}

@Composable
fun InfoCard(icon : Int, text: String,
             @SuppressLint("ModifierParameter") modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.height(80.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(MaterialTheme.spacing.small)) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "ic_$text",
                modifier = Modifier.size(24.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier
                .size(MaterialTheme.spacing.small)
                .weight(1f))
            Text(
                text, style = MaterialTheme.typography.labelSmall.copy(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.W600
                ), maxLines = 2, overflow = TextOverflow.Ellipsis
            )
        }
    }
}