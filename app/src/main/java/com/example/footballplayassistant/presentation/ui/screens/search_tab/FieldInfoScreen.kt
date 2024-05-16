package com.example.footballplayassistant.presentation.ui.screens.search_tab

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Preview
@Composable
fun FieldInfoScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(MaterialTheme.spacing.medium)) {
        HeaderWithBackButton(text = "Поле", imageButton = R.drawable.ic_arrow_share_25)
        Box(modifier = Modifier.padding(top = MaterialTheme.spacing.medium).height(190.dp).fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd) {
            Image(painter = painterResource(R.drawable.field_example_photo), contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop)
            Row(modifier = Modifier
                .padding(vertical = MaterialTheme.spacing.medium, horizontal = MaterialTheme.spacing.small)
                .clip(RoundedCornerShape(8.dp))
                .background(color = Color.Black.copy(alpha = 0.6f))
                ) {
                Text("1\\10", style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onPrimary, lineHeight = 20.sp
                ),
                    modifier = Modifier.padding(vertical = MaterialTheme.spacing.small,
                    horizontal = MaterialTheme.spacing.medium))
            }
        }
        Row(modifier = Modifier.padding(vertical = MaterialTheme.spacing.small),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Футбольный манеж 38х16 «Спорт Ангар» Теплый стан",
                style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onPrimaryContainer),
                modifier = Modifier.weight(1f, fill = false).padding(end = MaterialTheme.spacing.medium),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)
            FavoriteButton()
        }
        FlowRow(modifier = Modifier.padding(vertical = MaterialTheme.spacing.medium).fillMaxWidth()) {
            Icon(painterResource(id = R.drawable.ic_star),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.size(24.dp).padding(end = MaterialTheme.spacing.small))
            Text(buildAnnotatedString {
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onPrimaryContainer)) {
                    append("5")
                }
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onSecondaryContainer)) {
                    append("(8 отзывов)")
                }
            },
                style = MaterialTheme.typography.titleMedium
                )
            }
        }
        Row() {
            InfoCard(icon = 0, text = "")
            InfoCard(icon = 0, text = "")
        }
        Row() {
            InfoCard(icon = 0, text = "")
            AdditionalInfo()
        }
        Row() {
            Text("")
            Text("")
        }
        //HorizontalPager()
        Column() {
            Text("")
            FeedbackCard("", 0,  0, "", "")
            Button(onClick = {}) {

            }
        }

        Button(onClick = {}) {

        }
    }


}

@Composable
fun FeedbackCard(name : String, photo : Int, rating : Int, date : String, text: String) {

}
@Composable
fun AdditionalInfo() {

}
@Composable
fun TagField(text : String, amount : Int) {

}

@Composable
fun InfoCard(icon : Int, text: String) {

}