package com.example.footballplayassistant.presentation.customviews.textfields

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R


@Composable
fun CommonTextField(
    placeholder: String,
    imageTrail: Int = 0,
    imageStart: Int = 0,
    singleLine: Boolean = true,
    keyBoard: KeyboardType = KeyboardType.Email,
    isPassword: Boolean = false,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    cornerRadius: Dp = 60.dp,
    maxLength: Int = 40,
    value: String = "",
    readOnly: Boolean = false,
    isError: Boolean = false,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    val textValue = remember { mutableStateOf("") }

    var icon by remember { mutableIntStateOf(imageTrail) }
    var isPass by remember { mutableStateOf(isPassword) }
    val trailingIconView = @Composable {
        IconButton(
            onClick = {
                if (icon == R.drawable.ic_eye_slash_24) {
                    icon = R.drawable.ic_eye_24
                    isPass = false
                } else if (icon == R.drawable.ic_eye_24) {
                    icon = R.drawable.ic_eye_slash_24
                    isPass = true
                }
            },
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
            if (it.length <= maxLength) {
                textValue.value = it
            }
        },
        placeholder = {
            if (imageStart != 0)
                Row {
                    Icon(
                        painter = painterResource(id = imageStart),
                        contentDescription = "", modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W400)
                    )
                }
            else
                Text(
                    text = placeholder,
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W400)
                )
        },
        singleLine = singleLine,
        shape = RoundedCornerShape(cornerRadius),
        textStyle = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W400),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = color,
            focusedContainerColor = color,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.outlineVariant,
            focusedTextColor = MaterialTheme.colorScheme.primary,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSecondaryContainer,
            focusedPlaceholderColor = MaterialTheme.colorScheme.onSecondaryContainer,
            unfocusedTextColor = MaterialTheme.colorScheme.primary,
            focusedIndicatorColor = MaterialTheme.colorScheme.outlineVariant,

            errorContainerColor = MaterialTheme.colorScheme.error.copy(alpha = 0.15f),
            errorCursorColor = MaterialTheme.colorScheme.onPrimaryContainer,
            errorIndicatorColor = MaterialTheme.colorScheme.outlineVariant
        ),
        isError = isError,
        modifier = modifier
            .fillMaxWidth()
            .border(
                color = if (isError) MaterialTheme.colorScheme.error
                else MaterialTheme.colorScheme.onPrimary,
                width = 1.dp,
                shape = RoundedCornerShape(cornerRadius)
            ),
        trailingIcon = { if (imageTrail != 0) trailingIconView() },
        visualTransformation =
        if (isPass) PasswordVisualTransformation()
        else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = keyBoard),
        readOnly = readOnly
    )
}

