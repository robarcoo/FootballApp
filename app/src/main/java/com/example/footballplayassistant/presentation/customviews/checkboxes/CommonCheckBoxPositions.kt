package com.example.footballplayassistant.presentation.customviews.checkboxes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CommonCheckBoxPositions(
    text: String,
    isSelectedOption: Boolean,
    onSelectOption: (String) -> Unit
) {
    Row {
        Checkbox(
            checked = isSelectedOption,
            onCheckedChange = { onSelectOption(text) },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.secondary,
                uncheckedColor = MaterialTheme.colorScheme.secondary
            )
        )
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W400),
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.CenterVertically)
        )
    }
}