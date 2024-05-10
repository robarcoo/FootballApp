package com.example.footballplayassistant.presentation.ui.screens.authentication

import android.content.Context
import android.icu.util.Calendar
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.ButtonCalendar
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.dropdownmenus.ButtonDropDownMenu
import com.example.footballplayassistant.presentation.customviews.dropdownmenus.DropDownMenu
import com.example.footballplayassistant.presentation.customviews.radiobuttons.RadioButtonGroupPositions
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.spacing
import java.util.Date

@Composable
@Preview
fun EnterInfoScreen() {
    val navController = LocalNavController.current!!

    Scaffold(bottomBar = {
        Column {
            HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.tertiary)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.primaryContainer)
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CommonButton(
                    text = stringResource(id = R.string.save),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.W500),
                    onClick = { navController.navigate(Route.MainScreen.path) },
                    modifier = Modifier
                        .weight(0.4f)
                        .padding(
                            start = MaterialTheme.spacing.medium,
                            end = MaterialTheme.spacing.small
                        )
                        .align(Alignment.CenterVertically)
                )
                CommonButton(
                    text = stringResource(id = R.string.skip),
                    onClick = { navController.navigate(Route.MainScreen.path) },
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.W500),
                    modifier = Modifier
                        .weight(0.4f)
                        .padding(end = MaterialTheme.spacing.medium)
                        .align(Alignment.CenterVertically)
                )
            }
        }
    }) {
        LazyColumn(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .padding(it)
                .padding(top = 12.dp)
                .fillMaxSize()
        ) {
            item {
                Text(
                    text = stringResource(id = R.string.enterInfoYourself),
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W600),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp)
                )
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = MaterialTheme.spacing.horizontal),
                    verticalArrangement = Arrangement.Top
                ) {
                    val context = LocalContext.current
                    val date = remember { mutableStateOf("") }

                    ButtonCalendar(
                        onCLick = { openCalendar(context, date) },
                        date = date.value,
                        placeholder = stringResource(id = R.string.birthday),
                        containerColor = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .heightIn(min = 48.dp)
                    )

                    ButtonDropDownMenu(
                        placeholder = stringResource(id = R.string.sex),
                        values = listOf("Мужчина", "Женщина"),
                        imStart = R.drawable.ic_sex_23,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .heightIn(min = 48.dp)
                    )
                    DropDownMenu(
                        placeholder = stringResource(id = R.string.city),
                        imTrail = R.drawable.ic_arrow_menu_18_10,
                        values = listOf("1", "2", "3"),
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .heightIn(min = 48.dp)
                    )
                    ButtonDropDownMenu(
                        placeholder = stringResource(id = R.string.levelPlay),
                        values = listOf("Новичок", "Любитель", "Опытный", "Профессионал"),
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .heightIn(min = 48.dp)
                    )
                    val textLength = remember { mutableStateOf(0) }
                    Box {
                        CommonTextField(
                            placeholder = stringResource(id = R.string.tellYourself),
                            singleLine = false,
                            cornerRadius = 20.dp,
                            maxLength = 300,
                            onClick = {textLength.value=it.length},
                            modifier = Modifier.fillMaxHeight()
                        )
                        Image(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_rezible_10),
                            contentDescription = "Rezible",
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(
                                    end = MaterialTheme.spacing.small,
                                    bottom = MaterialTheme.spacing.small
                                )
                        )
                    }

                    Text(
                        text = "${textLength.value}/300",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.W400),
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = MaterialTheme.spacing.extraSmall)
                    )
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = MaterialTheme.spacing.horizontal)
                        .padding(top = MaterialTheme.spacing.large)
                ) {
                    Text(
                        text = stringResource(id = R.string.position),
                        style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.W500),
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    RadioButtonGroupPositions()
                }
            }
        }
    }
}

private fun openCalendar(context: Context, date: MutableState<String>) {
    val m_context = context

    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()

    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)

    calendar.time = Date()

    val Date = date

    val mDatePickerDialog = android.app.DatePickerDialog(
        m_context,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            Date.value = "$mDayOfMonth.${mMonth + 1}.$mYear"
        }, year, month, day
    )

    mDatePickerDialog.show()
}




