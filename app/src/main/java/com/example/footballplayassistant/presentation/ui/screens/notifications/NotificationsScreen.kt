package com.example.footballplayassistant.presentation.ui.screens.notifications

import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.DraggableAnchors
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.anchoredDraggable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.ShowMore
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.ui.screens.search_tab.Event
import com.example.footballplayassistant.presentation.ui.screens.search_tab.EventDetails
import com.example.footballplayassistant.presentation.ui.screens.search_tab.Player
import com.example.footballplayassistant.presentation.ui.screens.search_tab.ShowMoreButton
import com.example.footballplayassistant.presentation.ui.theme.spacing
import kotlin.math.roundToInt


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotificationsScreen() {
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
    )  // Заглушка
    Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.primaryContainer)) {
        HeaderWithBackButton(
            text = "Уведомления", modifier = Modifier.padding(
                start = MaterialTheme.spacing.medium,
                end = MaterialTheme.spacing.medium,
                top = MaterialTheme.spacing.medium,
                bottom = MaterialTheme.spacing.small
            )
        )
        val hasNotifications = true
        if (hasNotifications) {
            LazyColumn() {
                item {
                    Text(
                        "Новые", style = MaterialTheme.typography.displayMedium.copy(
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier.padding(MaterialTheme.spacing.medium)
                    )
                }
                items(2) {
                    NotificationCard {
                        EventFinishedNotification(
                            isHost = true,
                            event = event,
                            time = "1 ч 50 мин",
                            isUnread = true
                        )
                    }
                    NotificationCard {
                        PersonSubscribedToYouNotification(
                            image = R.drawable.player_avatar,
                            name = "Сергей Савельев",
                            time = "1 ч 40 мин",
                            isUnread = true
                        )
                    }
                }
                item {
                    Text(
                        "Просмотренные", style = MaterialTheme.typography.displayMedium.copy(
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        modifier = Modifier.padding(MaterialTheme.spacing.medium)
                    )
                }
                items(2) {
                    NotificationCard {
                        EventFinishedNotification(
                            isHost = false,
                            event = event,
                            time = "1 ч 50 мин",
                            isUnread = false
                        )
                    }
                    NotificationCard {
                        PersonSubscribedToYouNotification(
                            image = R.drawable.player_avatar,
                            name = "Сергей Савельев",
                            time = "1 ч 40 мин",
                            isUnread = false
                        )
                    }
                }
                item {
                    ShowMoreButton()
                }
            }

        } else {
            NoNotifications()
        }


    }
}

@Composable
fun NoNotifications() {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text("Уведомлений нет", style = MaterialTheme.typography.titleMedium.copy(
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontWeight = FontWeight.W600
        ))
        Text("На данный момент у вас нет\nуведомлений", style = MaterialTheme.typography.labelMedium.copy(
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontWeight = FontWeight.W400
        ),
             modifier = Modifier.padding(vertical = MaterialTheme.spacing.small),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center)
    }
}
enum class DragAnchors {
    Center,
    End,
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotificationCard(content: @Composable () -> Unit) {
    val density = LocalDensity.current
    val defaultActionSize = 60.dp
    val endActionSizePx = with(density) { defaultActionSize.toPx() }

    val state = remember {
        AnchoredDraggableState(
            initialValue = DragAnchors.Center,
            anchors = DraggableAnchors {
                DragAnchors.Center at 0f
                DragAnchors.End at endActionSizePx
            },
            positionalThreshold = { distance: Float -> distance * 0.5f },
            velocityThreshold = { with(density) { 100.dp.toPx() } },
            animationSpec = tween(),
        )
    }
    Box(modifier = Modifier
        .padding(
            horizontal = MaterialTheme.spacing.medium,
            vertical = MaterialTheme.spacing.extraSmall
        )
        .fillMaxWidth()
        .height(IntrinsicSize.Max), contentAlignment = Alignment.CenterEnd) {
        IconButton(
            onClick = {}, modifier = Modifier
                .width(44.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.onPrimary)

        ) {
            Icon(
                painterResource(R.drawable.ic_delete), contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        Row(modifier = Modifier
            .offset {
                IntOffset(
                    x = -state
                        .requireOffset()
                        .roundToInt(),
                    y = 0,
                )
            }
            .anchoredDraggable(state, Orientation.Horizontal, reverseDirection = true),
        ) {
            content()
        }
    }
}




@Composable
fun EventFinishedNotification(isHost : Boolean, event : Event, time: String, isUnread : Boolean) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(12.dp))
        .background(color = MaterialTheme.colorScheme.onPrimary)
        .padding(MaterialTheme.spacing.medium)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,) {
                Text(if (isHost) {
                    "Матч в котором вы были хостом завершен"
                } else {
                    "Матч в котором вы принимали участие завершен"
                       },
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        fontWeight = FontWeight.W400
                    ),
                    modifier = Modifier.weight(1f, fill = false))
            TimeAndIsUnread(time = time, isUnread = isUnread)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = MaterialTheme.spacing.small),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                if (isHost) {
                    "Подведите итоги, отметьте участников"
                } else {
                    "Оцените как прошло ваше событие"
                       },
                style = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.W600
                ),
                modifier = Modifier.weight(1f, fill = false))
            IconButton(onClick = {}, modifier = Modifier
                .size(24.dp)) {
                Icon(painterResource(id = R.drawable.ic_arrow_next_24), contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer)
            }
        }
        Card(shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onPrimaryContainer),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.outlineVariant
            )
        ) {
            Column (modifier = Modifier.padding(MaterialTheme.spacing.medium)) {
                Text(event.name, style = MaterialTheme.typography.displayMedium.copy(
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis)
                HorizontalDivider(thickness = 1.dp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.padding(top = MaterialTheme.spacing.medium))
                EventDetails(event = event, isHost = isHost)
            }
        }
    }
}

@Composable
fun TimeAndIsUnread(time : String, isUnread: Boolean) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.extraSmall)) {
        if (isUnread) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onBackground)
            )
        }
        Text(
            time, style = MaterialTheme.typography.labelMedium.copy(
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.W400
            )
        )
    }
}

@Composable
fun PersonSubscribedToYouNotification(image : Int, name : String, time: String, isUnread: Boolean) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onPrimary)) {
        Row(modifier = Modifier.padding(MaterialTheme.spacing.medium),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small)) {
            Image(
                painterResource(id = image), contentDescription = null,
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(name, modifier = Modifier.weight(1f, fill = false),
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.W600,
                        color = MaterialTheme.colorScheme.onPrimaryContainer)
                    TimeAndIsUnread(time = time, isUnread = isUnread)

                }
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom) {
                    Text(
                        "Подписался на ваши уведомления",
                        modifier = Modifier
                            .padding(end = MaterialTheme.spacing.large)
                            .weight(1f, fill = false),
                        style = MaterialTheme.typography.displaySmall.copy(
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        ),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    IconButton(onClick = { /*TODO*/ },
                        modifier = Modifier.size(24.dp)) {
                        Icon(
                            painterResource(id = R.drawable.ic_profile_add),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.secondary
                        )

                    }

                }
            }

        }
    }

}