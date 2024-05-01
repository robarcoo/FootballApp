package com.example.footballplayassistant.presentation.customviews.dialogwindows

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
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogScreen(
    image: Int = 0,
    header: String,
    description: String,
    greenButton: String = "",
    whiteButton: String = "",
    bottomButton: String = "",
    onClickGreen: () -> Unit = {},
    onClickWhite: () -> Unit = {},
    onClickBottom: () -> Unit = {},
    onDismissRequest: () -> Unit,
) {
    BasicAlertDialog(
        onDismissRequest = { onDismissRequest() },
        modifier = Modifier.size(350.dp, 500.dp),
        properties = DialogProperties(usePlatformDefaultWidth = false)
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
                    .background(color = MaterialTheme.colorScheme.primary)
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_ball_dialog_161_158),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.TopStart)
                )

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
                        style = MaterialTheme.typography.displayLarge
                            .copy(fontWeight = FontWeight.W600),
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 12.dp)
                    )
                    Text(
                        text = description,
                        style = MaterialTheme.typography.labelLarge
                            .copy(fontWeight = FontWeight.W400),
                        color = MaterialTheme.colorScheme.onPrimary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
                    )
                    if (greenButton != "")
                        CommonButton(
                            text = greenButton,
                            style = MaterialTheme.typography.bodyLarge,
                            onClick = { onClickGreen.invoke() },
                            modifier = Modifier.padding(bottom = 12.dp)
                        )
                    if (whiteButton != "")
                        CommonButton(
                            text = whiteButton,
                            onClick = { onClickWhite.invoke() },
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )
                    if (bottomButton != "")
                        TextButton(onClick = { onClickBottom.invoke() }) {
                            Text(
                                text = bottomButton,
                                style = MaterialTheme.typography.bodyMedium
                                    .copy(fontWeight = FontWeight.W600),
                                color = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier.padding(end = 4.dp)
                            )
                            Image(
                                imageVector = ImageVector.vectorResource(R.drawable.ic_arrows_18_14),
                                contentDescription = "",

                                )
                        }
                }

                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_ball_dialog_158_196),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                )
            }
        }
    }
}