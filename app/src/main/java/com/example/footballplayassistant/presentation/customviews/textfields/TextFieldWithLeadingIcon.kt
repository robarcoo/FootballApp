package com.example.footballplayassistant.presentation.customviews.textfields

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.ui.theme.Gray75

@Composable
fun TextFieldWithLeadingIcon(
    placeholder: String,
    imageTrail: Int = 0,
    imageStart: Int = 0,
    keyBoard: KeyboardType = KeyboardType.Email,
    value: String = "",
    color: Color = Color.White,
    onTrailClick: () -> Unit = {},
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    val textValue = remember { mutableStateOf("") }

    val icon by remember { mutableIntStateOf(imageTrail) }
    val trailingIconView = @Composable {
        IconButton(
            onClick = { onTrailClick() },
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = ""
            )
        }
    }

    TextField(
        value = if (value == "") textValue.value else value,
        onValueChange = {
            textValue.value = it
        },
        placeholder = {
            Text(text = placeholder, fontFamily = FontFamily(Font(R.font.inter)))
        },
        singleLine = true,
        shape = RoundedCornerShape(60.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = color,
            focusedContainerColor = color,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = Color.Black,
            unfocusedPlaceholderColor = Gray75,
            focusedPlaceholderColor = Gray75,
            unfocusedTextColor = Color.Black,
            focusedIndicatorColor = Color.Transparent
        ),

        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        trailingIcon = { if (imageTrail != 0) trailingIconView() },
        leadingIcon = {
            Icon(
                painter = painterResource(id = imageStart),
                contentDescription = ""
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyBoard),
    )
}