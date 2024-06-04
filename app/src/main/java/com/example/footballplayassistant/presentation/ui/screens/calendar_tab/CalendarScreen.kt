package com.example.footballplayassistant.presentation.ui.screens.calendar_tab

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBarDefaults.ContentPadding
import androidx.compose.material3.ButtonDefaults.ContentPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Calendar
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun CalendarScreen() {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        CalendarHeader()
        Box(contentAlignment  = Alignment.CenterStart) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentWidth(
                        align = Alignment.Start,
                        unbounded = true
                    )
                    .width(600.dp)
                    .height(60.dp)
                    .border
                        (
                        1.dp,
                        MaterialTheme.colorScheme.onPrimaryContainer,
                        RoundedCornerShape(50.dp)
                    )

            ) {

            }

            CalendarPager()

        }
//        LazyColumn(modifier = Modifier.padding(MaterialTheme.spacing.medium)) {
//            item {
//                GameCard(host = "", place = "Арена Новый Футбол поле  Крылатское")
//                GameCard(host = "Игорь Султанов", place = "Арена Новый Футбол поле  Крылатское")
//
//            }
//        }

    }
}


fun getWeeksOfMonth(year: Int, month: Int, day: Int): Int {
    val calendar = Calendar.getInstance()
    calendar.set(year, month-1, day)
    return calendar.get(Calendar.WEEK_OF_MONTH)
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CalendarPager() {
    val selectedDate = LocalDate.now()
    val startDate = selectedDate.minusDays(3)
    val totalWeeks = getWeeksOfMonth(selectedDate.year, selectedDate.monthValue, selectedDate.month.maxLength())
    val selectedWeeks = getWeeksOfMonth(selectedDate.year, selectedDate.monthValue, selectedDate.dayOfMonth)
    val weekList = List<MutableList<LocalDate>>(totalWeeks + 1) { mutableListOf() }
    val dayList = mutableListOf<LocalDate>()
    for (i in 0..selectedDate.month.maxLength() + 3) {
        dayList.add(startDate.plusDays(i.toLong()))
    }

    val state = rememberLazyListState()
    CompositionLocalProvider(
        LocalOverscrollConfiguration provides null
    ) {
        LazyRow(
            state = state, modifier = Modifier.padding(start = 36.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items(dayList.size) {
                HorizontalCalendarItem(
                    index = it,
                    date = dayList[it],
                    selectedDate = selectedDate,
                    state = state,
                )
            }
        }
    }
}

fun LazyListState.animateScrollAndCentralizeItem(index: Int, scope: CoroutineScope) {
    val itemInfo = this.layoutInfo.visibleItemsInfo.firstOrNull { it.index == index }
    scope.launch {
        if (itemInfo != null) {
            val center = this@animateScrollAndCentralizeItem.layoutInfo.viewportEndOffset / 2
            val childCenter = itemInfo.offset + itemInfo.size / 2
            this@animateScrollAndCentralizeItem.animateScrollBy((childCenter - center).toFloat())
        } else {
            this@animateScrollAndCentralizeItem.animateScrollToItem(index)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HorizontalCalendarItem(index : Int, date: LocalDate, selectedDate: LocalDate, state : LazyListState) {
    var paddingElementSize by remember { mutableIntStateOf(15) }
    val boxColor by remember {
        derivedStateOf {

            val layoutInfo = state.layoutInfo
            val visibleItemsInfo = layoutInfo.visibleItemsInfo
            val itemInfo = visibleItemsInfo.firstOrNull { it.index == index}
            if (visibleItemsInfo.size <= 7 && paddingElementSize > 4) {
                paddingElementSize -= 2
            } else if (visibleItemsInfo.size > 8) {
                paddingElementSize += 2
            }
            itemInfo?.let {
//                val delta = it.size/2 //use your custom logic
//                val center = state.layoutInfo.viewportEndOffset / 2
//                val childCenter = it.offset + it.size / 2
//                val target = childCenter - center
                if (visibleItemsInfo.indexOf(itemInfo) == 3) return@derivedStateOf Color.Green
            }


            Color.Transparent
        }
    }
    val coroutineScope = rememberCoroutineScope()
    Box(modifier = Modifier.clickable(
        onClick = {
            coroutineScope.launch {
                state.animateScrollAndCentralizeItem(index , this)
            }
        },

    ),
        contentAlignment = Alignment.Center) {
        if (boxColor != Color.Transparent) {
            Box(
                modifier = Modifier.width(54.dp).height(76.dp).clip(
                    RoundedCornerShape(94.dp)
                ).background(boxColor),
            ) {

            }
        }
        val dayNumber = date.dayOfMonth.toString()
        Column(modifier = Modifier.padding(horizontal = paddingElementSize.dp), verticalArrangement = Arrangement.Center) {
            Text(
                date.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
            )
            Text(text =
            if (dayNumber.length == 1) {
                "0$dayNumber" 
            } else {
                dayNumber
                   },
                fontSize = 16.sp)
        }
    }
}

@Composable
fun CalendarHeader() {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        OutlinedIconButton(onClick = {}) {
            Icon(painter = painterResource(id = R.drawable.ic_icons_24), contentDescription = "Фильтр событий в календаре")
        }
        Text("Календарь")

        OutlinedIconButton(onClick = {}) {
            Icon(painterResource(id = R.drawable.ic_plus_24),
                contentDescription = "Добавить событие в календаре")

        }
    }
}