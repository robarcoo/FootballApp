package com.example.footballplayassistant.presentation.ui.screens.authentication

import android.content.Context
import android.icu.util.Calendar
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.DropDownMenu
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.checkboxes.CommonCheckBoxPositions
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.customviews.textfields.TextFieldWithLeadingIcon
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.theme.GrayF1
import java.util.Date

@Composable
@Preview
fun EnterInfoScreen() {
    val navController = LocalNavController.current!!
    Column(modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)) {
        Text(
            text = stringResource(id = R.string.enterInfoYourself),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.W600),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.4f)
        ) {
            val context = LocalContext.current
            val date = remember { mutableStateOf("") }

            TextFieldWithLeadingIcon(
                placeholder = stringResource(id = R.string.birthday),
                imageStart = R.drawable.ic_calendar_22,
                imageTrail = R.drawable.ic_arrow_menu_18_10,
                value = date.value,
                onTrailClick = {
                    openCalendar(context, date)
                }
            )
            DropDownMenu(
                placeholder = stringResource(id = R.string.sex),
                imStart = R.drawable.ic_sex_23,
                imTrail = R.drawable.ic_arrow_menu_18_10,
                values = listOf("Мужчина", "Женщина")
            )
            DropDownMenu(
                placeholder = stringResource(id = R.string.levelPlay),
                imTrail = R.drawable.ic_arrow_menu_18_10,
                values = listOf("Новичок", "Любитель", "Опытный", "Профессионал")
            )
            CommonTextField(
                placeholder = stringResource(id = R.string.tellYourself),
                singleLine = false,
                cornerRadius = 20.dp,
                maxLength = 300,
                modifier = Modifier.fillMaxHeight()
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .weight(0.3f)
        ) {
            Text(
                text = stringResource(id = R.string.position),
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W500),
            )
            CheckBoxGroup()
        }

        Divider(thickness = 1.dp)
        Row(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.1f), horizontalArrangement = Arrangement.SpaceAround
        ) {
            CommonButton(
                text = "Сохранить",
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.W500),
                onClick = { navController.navigate(Route.MainScreen.path) },
                modifier = Modifier
                    .weight(0.4f)
                    .padding(start = 16.dp, end = 8.dp)
                    .align(Alignment.CenterVertically)
            )
            CommonButton(
                text = "Пропустить",
                onClick = { navController.navigate(Route.MainScreen.path) },
                containerColor = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.W500),
                modifier = Modifier
                    .weight(0.4f)
                    .padding(end = 16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
private fun CheckBoxGroup() {
    val positions = stringArrayResource(id = R.array.positions_array)

    val (selectedOption: String, onOptionSelected: (String) -> Unit) = remember {
        mutableStateOf(
            ""
        )
    }

    Column(Modifier.selectableGroup()) {
        positions.forEach { text ->
            CommonCheckBoxPositions(
                text = text,
                isSelectedOption = (selectedOption == text),
                onSelectOption = onOptionSelected
            )
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



