package com.example.footballplayassistant.presentation.customviews.checkboxes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.ui.theme.Green


@Composable
fun CommonCheckBoxAgree(){
    val state = remember { mutableStateOf(false) }
    Row(modifier = Modifier.padding(horizontal = 16.dp)) {
        Checkbox(
            checked = state.value,
            onCheckedChange = { state.value = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Green,
                uncheckedColor = Green
            )
        )
        Text(
            text = stringResource(id = R.string.agree),
            fontFamily = FontFamily(Font(R.font.inter)),
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.CenterVertically)
        )
    }
}