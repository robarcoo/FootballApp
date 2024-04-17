package com.example.footballplayassistant.presentation.ui.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.CommonSwitch
import com.example.footballplayassistant.presentation.customviews.DropDownMenu
import com.example.footballplayassistant.presentation.customviews.RadioButtonGroup
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.checkboxes.CheckBoxInventory
import com.example.footballplayassistant.presentation.customviews.checkboxes.CommonCheckBoxAgree
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.ui.screens.authentication.addStar

@Composable
@Preview
fun CreateEventScreen() {
    val flag = remember {
        mutableStateOf(false)
    }

    Column {
        HeaderWithBackButton(
            text = stringResource(id = R.string.addGame),
            modifier = Modifier.padding(vertical = 8.dp)
        )
        LazyColumn {
            item { CommonSwitch(text = stringResource(id = R.string.closeGame), icon = true,
                textIcon = stringResource(id = R.string.closeGameToast)) }
            item { CommonSwitch(text = stringResource(id = R.string.iWill), icon = true,
                textIcon = stringResource(id = R.string.iWillToast)) }
            item {
                BoldText(id = R.string.field, modifier = Modifier.padding(top = 24.dp))

                DropDownMenu(
                    placeholder = "field",
                    values = listOf("Поле 1", "Поле 2"),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                BoldText(id = R.string.date, modifier = Modifier.padding(top = 24.dp))

                DropDownMenu(
                    placeholder = stringResource(id = R.string.date),
                    imStart = R.drawable.ic_calendar_22,
                    values = listOf("Поле 1", "Поле 2"),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            item {
                BoldText(id = R.string.time, modifier = Modifier.padding(top = 24.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {
                    CommonTextField(
                        placeholder = stringResource(id = R.string.start),
                        imageTrail = R.drawable.ic_time_black_24,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(end = 4.dp),
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
                    CommonTextField(
                        placeholder = stringResource(id = R.string.end),
                        imageTrail = R.drawable.ic_time_black_24,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(start = 4.dp),
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
                }
            }
            item {
                BoldText(
                    addStar = false,
                    id = R.string.details,
                    modifier = Modifier.padding(top = 24.dp)
                )
                CommonTextField(
                    placeholder = stringResource(id = R.string.title),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                CommonTextField(
                    placeholder = stringResource(id = R.string.otherInfo),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    singleLine = false,
                    cornerRadius = 20.dp,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp)
                )
            }
            item {
                Row {
                    BoldText(
                        id = R.string.countPlayers,
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .align(Alignment.CenterVertically)
                    )
                    DropDownMenu(
                        placeholder = "",
                        imStart = R.drawable.ic_people_24,
                        values = listOf(
                            "2",
                            "4",
                            "6",
                            "8",
                            "10",
                            "12",
                            "14",
                            "16",
                            "18",
                            "20",
                            "22"
                        ),
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            }
            item {
                Row {
                    BoldText(
                        id = R.string.minCountPlayers,
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .align(Alignment.CenterVertically)
                    )
                    DropDownMenu(
                        placeholder = "",
                        imStart = R.drawable.ic_people_24,
                        values = listOf(
                            "2",
                            "4",
                            "6",
                            "8",
                            "10",
                            "12",
                            "14",
                            "16",
                            "18",
                            "20",
                            "22"
                        ),
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            }
            item {
                BoldText(addStar = false, id = R.string.sexPlayers)
                Row {
                    RadioButtonGroup()
                }
            }
            item {
                BoldText(id = R.string.inventory, modifier = Modifier.padding(top = 24.dp))
                CheckBoxInventory()
            }
            item {
                BoldText(id = R.string.costEntry, modifier = Modifier.padding(top = 24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {
                    Text(
                        text = stringResource(id = R.string.cost),
                        style = MaterialTheme.typography.displaySmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .weight(0.55f),
                    )

                    Text(
                        text = stringResource(id = R.string.commission),
                        style = MaterialTheme.typography.displaySmall,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .weight(0.45f),
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {
                    CommonTextField(
                        placeholder = stringResource(id = R.string.cost),
                        imageTrail = R.drawable.ic_ruble_15,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(end = 16.dp),
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
                    CommonTextField(
                        placeholder = stringResource(id = R.string.commission),
                        imageTrail = R.drawable.ic_ruble_15,
                        color = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier
                            .weight(0.5f)
                            .padding(start = 16.dp),
                        readOnly = true
                    )
                }
            }
            item {
                CommonCheckBoxAgree()
            }
            item {
                if (flag.value)
                    CommonButton(
                        text = stringResource(id = R.string.addEvent),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                    )
                else
                    CommonButton(
                        text = stringResource(id = R.string.addEvent),
                        style = MaterialTheme.typography.bodyLarge,
                        containerColor = MaterialTheme.colorScheme.tertiary,
                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                    )
            }
            item {
                Row(modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)) {
                    Text(
                        text = stringResource(id = R.string.cantCancel),
                        style = MaterialTheme.typography.displaySmall,
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_question_14),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

@Composable
fun BoldText(
    id: Int,
    addStar: Boolean = true,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    if (addStar)
        Text(
            text = addStar(id = id),
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W500),
            modifier = modifier.padding(horizontal = 16.dp)
        )
    else
        Text(
            text = stringResource(id = id),
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W500),
            modifier = modifier.padding(horizontal = 16.dp)
        )
}