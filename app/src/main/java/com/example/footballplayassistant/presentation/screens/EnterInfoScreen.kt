package com.example.footballplayassistant.presentation.screens

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.CommonButton
import com.example.footballplayassistant.presentation.customviews.CommonCheckBox
import com.example.footballplayassistant.presentation.customviews.CommonTextField
import com.example.footballplayassistant.presentation.customviews.DropDownMenu
import com.example.footballplayassistant.ui.theme.GrayAccounts

@Composable
@Preview
fun EnterInfoScreen() {
    Column(modifier = Modifier.background(GrayAccounts)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(0.1f), horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.enterInfoYourself),
                fontSize = 20.sp,
                fontWeight = FontWeight.W600,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .weight(0.4f)
        ) {
            DropDownMenu(
                placeholder = stringResource(id = R.string.birthday),
                imStart = R.drawable.ic_calendar_22,
                imTrail = R.drawable.ic_arrow_menu_18_10,
                values = listOf("one", "two")
            )
            DropDownMenu(
                placeholder = stringResource(id = R.string.sex),
                imStart = R.drawable.ic_sex_23,
                imTrail = R.drawable.ic_arrow_menu_18_10,
                values = listOf("М", "Ж")
            )
            DropDownMenu(
                placeholder = stringResource(id = R.string.levelPlay),
                imTrail = R.drawable.ic_arrow_menu_18_10,
                values = listOf("Низкий", "Средний", "Высокий")
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
                text = stringResource(id = R.string.position), fontSize = 16.sp,
                fontWeight = FontWeight.W500,
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
                modifier = Modifier
                    .weight(0.4f)
                    .padding(start = 16.dp, end = 8.dp)
                    .align(Alignment.CenterVertically)
            )
            CommonButton(
                text = "Пропустить", containerColor = Color.White,
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
            CommonCheckBox(
                text = text,
                isSelectedOption = (selectedOption == text),
                onSelectOption = onOptionSelected
            )
        }
    }
}



