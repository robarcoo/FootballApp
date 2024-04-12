package com.example.footballplayassistant.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.ui.theme.Black21

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogScreen(
    image: Int = 0,
    header: String,
    description: String,
    greenButton: String = "",
    whiteButton: String = "",
    bottomButton: String = "",
    onDismissRequest: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        properties = DialogProperties(usePlatformDefaultWidth = false),
        modifier = Modifier.size(350.dp, 500.dp)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(12.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Black21)
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_ball_dialog_161_158),
                        contentDescription = ""
                    )
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (image != 0)
                        Image(
                            imageVector = ImageVector.vectorResource(image),
                            contentDescription = "",
                        )
                    Text(
                        text = header,
                        fontWeight = FontWeight.W600,
                        fontSize = 28.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 12.dp)
                    )
                    Text(
                        text = description,
                        fontWeight = FontWeight.W400,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.inter)),
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                    if (greenButton != "")
                        CommonButton(text = "green")
                    if (whiteButton != "")
                        CommonButton(
                            text = "white",
                            containerColor = Color.White,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )
                    if (bottomButton != "")
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(
                                text = "bottom",
                                fontWeight = FontWeight.W600,
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.inter)),
                                color = Color.White,
                                modifier = Modifier.padding(end = 4.dp)
                            )
                            Image(
                                imageVector = ImageVector.vectorResource(R.drawable.ic_arrows_18_14),
                                contentDescription = "",

                                )
                        }
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_ball_dialog_158_196),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}