package com.example.footballplayassistant.presentation.customviews.cards


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.ui.theme.Black04
import com.example.footballplayassistant.presentation.ui.theme.Gray75
import com.example.footballplayassistant.presentation.ui.theme.GrayF1

@Composable
fun CommonIconTextCard(modifier: Modifier = Modifier, icon: Int, text: String) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = GrayF1)
    ) {
        Column {
            Icon(
                imageVector = ImageVector.vectorResource(icon),
                contentDescription = "",
                modifier = Modifier
                    .padding(8.dp)
            )

            Text(
                text = text,
                fontWeight = FontWeight.W600,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun CommonIconTextInventoryCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = GrayF1)
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.inventory),
                fontWeight = FontWeight.W600,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                modifier = Modifier
                    .padding(8.dp)
            )
            Row {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_manish_18_22),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                )

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_ball_22),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }
    }
}

@Composable
@Preview
fun CommonOtherInfoCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .border(width = 1.dp, color = Gray75, shape = RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.otherInfo),
                maxLines = 2,
                fontWeight = FontWeight.W500,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.inter)),
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
                    .weight(0.75f)
            )

            IconButton(
                onClick = {}, colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Black04,
                    contentColor = Color.White
                ),
                modifier = Modifier.weight(0.25f)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_white_arrows_18),
                    contentDescription = "",
                )
            }
        }
    }
}