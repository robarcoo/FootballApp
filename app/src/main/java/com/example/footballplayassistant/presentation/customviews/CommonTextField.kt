package com.example.footballplayassistant.presentation.customviews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.ui.theme.GrayText
import com.example.footballplayassistant.R


@Composable
fun CommonTextField(placeholder: String, image: Int = 0, keyBoard: KeyboardType = KeyboardType.Email, isPassword: Boolean = false, color: Color = Color.White){
    val textValue = remember{mutableStateOf("")}

    var icon by remember { mutableIntStateOf(image) }
    var isPass by remember { mutableStateOf(isPassword) }
    val trailingIconView = @Composable {
        IconButton(
            onClick = {
                 if(icon == R.drawable.ic_eye_slash_24) {
                     icon = R.drawable.ic_eye_24
                     isPass=false
                }
                else {
                     icon =R.drawable.ic_eye_slash_24
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
        value = textValue.value, onValueChange = {newText -> textValue.value = newText},
        placeholder = { Text(text = placeholder) },
        singleLine = true,
        shape = RoundedCornerShape(60.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = color,
            focusedContainerColor = color,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = Color.Black,
            unfocusedPlaceholderColor = GrayText,
            focusedPlaceholderColor = GrayText,
            unfocusedTextColor = Color.Black
        ),

        modifier = Modifier.fillMaxWidth().padding(10.dp),
        trailingIcon = { if(image!=0) trailingIconView()},
        visualTransformation = if (isPass) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = keyBoard)
    )
}

