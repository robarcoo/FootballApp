package com.example.footballplayassistant.presentation.ui.screens.search_tab

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.DropDownMenu
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
@Preview
fun CreateFieldScreen() {
    Column(modifier = Modifier
        .background(MaterialTheme.colorScheme.primaryContainer)
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween) {
        HeaderWithBackButton(stringResource(id = R.string.addField), onClickBack = { TODO() })
        Text(text = stringResource(id = R.string.fieldInfoTitle),
            modifier = Modifier.padding(vertical = MaterialTheme.spacing.medium),
            style = MaterialTheme.typography.displayMedium.copy(color = MaterialTheme.colorScheme.onPrimaryContainer))
        NecessaryTextField(label = stringResource(id = R.string.fieldName), true, leadingIcon = R.drawable.ic_field)
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.small))
        DropDownMenu(placeholder = "Укажите город", values = listOf())
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.small))
        NecessaryTextField(label = stringResource(id = R.string.fieldName), true, leadingIcon = R.drawable.ic_location)
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.small))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {
            NecessaryTextField(label = "Открытие", true, trailingIcon = R.drawable.ic_time_black_24, modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(end = MaterialTheme.spacing.extraSmall))
            NecessaryTextField(label = "Закрытие", true, trailingIcon = R.drawable.ic_time_black_24,  modifier = Modifier.padding(start = MaterialTheme.spacing.extraSmall))
        }
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.small))
        NecessaryTextField(label = "Контактный телефон", isNecessary = true, leadingIcon = R.drawable.ic_call)
        DropDownMenu(placeholder = "Ближайшее метро", values = listOf(), imStart = R.drawable.ic_metro)
        NecessaryTextField(label = "Сайт", leadingIcon = R.drawable.ic_world)
        NecessaryTextField(label = "Сайт", leadingIcon = R.drawable.ic_world)
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.large))
        Row(verticalAlignment = Alignment.CenterVertically) {
            AddAsterisk(text = "Вместимость игроков", style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontWeight = FontWeight.W400,
                isNecessary = true,
                modifier = Modifier.padding(end = MaterialTheme.spacing.small))
            DropDownMenu(placeholder = "чел.", values = listOf())
        }
        Row(modifier = Modifier.fillMaxWidth().padding(top = MaterialTheme.spacing.large,
            bottom = MaterialTheme.spacing.medium),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = Modifier.weight(1f, fill = false).padding(vertical = MaterialTheme.spacing.extraSmall)) {
                Text("Загрузить изображения", style = MaterialTheme.typography.displayMedium.copy(color = MaterialTheme.colorScheme.onPrimaryContainer))
                Spacer(modifier = Modifier.size(MaterialTheme.spacing.extraSmall))
                Text("JPEG, PNG. 15 Мбайт. Не более 10 изображений", style = MaterialTheme.typography.displaySmall
                    .copy(color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.W400))
            }
            OutlinedButton(onClick = { /*TODO*/ },
                shape = CircleShape,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(48.dp)
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_download), contentDescription = "Download",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer)
                
            }
        }

        Column(modifier = Modifier.padding(top = MaterialTheme.spacing.medium, bottom = MaterialTheme.spacing.large)) {
            Text(
                text = "Размеры поля",
                style = MaterialTheme.typography.displayMedium.copy(color = MaterialTheme.colorScheme.onPrimaryContainer)
            )
            Spacer(modifier = Modifier.size(MaterialTheme.spacing.medium))
            FilterRangeSlider(
                text = "Длина (м)",
                MaterialTheme.typography.labelMedium.copy(
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.W400
                ),
                activeRangeStart = 0f,
                activeRangeEnd = 1000.0f
            )
            FilterRangeSlider(
                text = "Ширина (м)",
                MaterialTheme.typography.labelMedium.copy(
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.W400
                ),
                activeRangeStart = 0f,
                activeRangeEnd = 1000.0f
            )
        }
        CustomRadioButtons("Тип площадки", true, listOf("Открытый", "Закрытый"))
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), thickness = 1.dp, color = MaterialTheme.colorScheme.tertiaryContainer)
        CustomRadioButtons("Освещение", true, listOf("Искусственное", "Естественное"))
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), thickness = 1.dp, color = MaterialTheme.colorScheme.tertiaryContainer)
        CustomRadioButtons("Душ", false, listOf("Есть", "Нет"))
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), thickness = 1.dp, color = MaterialTheme.colorScheme.tertiaryContainer)
        CustomRadioButtons("Раздевалки", false, listOf("Есть", "Нет"))
        Column(modifier = Modifier.padding(vertical = MaterialTheme.spacing.medium),
            horizontalAlignment = Alignment.CenterHorizontally) {
            CommonButton("Добавить поле")
            Spacer(modifier = Modifier.size(MaterialTheme.spacing.medium))
            ClickableText(text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W600)) {
                    append("Отмена")
                }
            },
                style = MaterialTheme.typography.bodySmall,
                onClick = {})

        }

    }
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CustomRadioButtons(title : String, isNecessary : Boolean, items : List<String>) {
    val state = remember { mutableIntStateOf(-1) }
    Column(modifier = Modifier.fillMaxWidth()) {
        AddAsterisk(
            text = title,
            style = MaterialTheme.typography.displayMedium,
            isNecessary = isNecessary,
            modifier = Modifier.padding(top = MaterialTheme.spacing.small)
        )
        FlowRow(
            modifier = Modifier.fillMaxWidth().padding(vertical = MaterialTheme.spacing.medium)
        ) {
            items.forEachIndexed { index, name ->
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(end = MaterialTheme.spacing.medium)) {
                    IconToggleButton(
                        modifier = Modifier.size(24.dp),
                        checked = index == state.intValue,
                        onCheckedChange = { state.intValue = index },
                    ) {
                        if (state.intValue == index) {
                            Icon(
                                painterResource(R.drawable.ic_radio_checked),
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.secondary
                            )
                        } else {
                            Icon(
                                painterResource(R.drawable.ic_radio_unchecked),
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.secondary
                            )
                        }
                    }
                    Text(
                        name,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.W400),
                        modifier = Modifier.padding(horizontal = MaterialTheme.spacing.small)
                    )
                }
            }
        }
    }
}


@Composable
fun NecessaryTextField(label : String,
                       isNecessary : Boolean = false,
                       trailingIcon : Int = 0,
                        leadingIcon : Int = 0,
                       @SuppressLint("ModifierParameter") modifier: Modifier = Modifier) {
    var value by remember { mutableStateOf(TextFieldValue(""))}
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()
    val visible by remember { derivedStateOf { (isFocused || value.text.isNotEmpty()) } }
    Column (){
        AnimatedVisibility(
            visible = visible,
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            AddAsterisk(text = label, style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.W400,
                isNecessary = isNecessary,
                modifier = Modifier.padding( MaterialTheme.spacing.small ))
        }
        BasicTextField(modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(60.dp))
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(horizontal = 16.dp, vertical = 8.dp),
            value = value,
            onValueChange = { value = it },
            interactionSource = interactionSource,
            maxLines = 1,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        ) { innerTextField ->
            Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Row(Modifier.weight(1f, fill = false), verticalAlignment = Alignment.CenterVertically) {
                if (leadingIcon != 0) {
                    Icon(painter = painterResource(id = leadingIcon), contentDescription = "",
                        modifier = Modifier.padding(end = MaterialTheme.spacing.small),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer)
                }
                if (!isFocused && value.text.isEmpty()) {
                    AddAsterisk(text = label, style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        fontWeight = FontWeight.W400,
                        isNecessary = isNecessary,
                        modifier = Modifier.padding( MaterialTheme.spacing.small))
                }

                    innerTextField()
                }
                if (trailingIcon != 0) {
                    Icon(painter = painterResource(id = trailingIcon), contentDescription = "",
                        modifier = Modifier.padding(start = MaterialTheme.spacing.small),
                        tint = MaterialTheme.colorScheme.onPrimaryContainer)
                }
            }
        }
    }


}

@Composable
fun AddAsterisk(text : String,
                style : TextStyle,
                color : Color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontWeight: FontWeight = FontWeight.W500,
                isNecessary: Boolean = false,
                maxLines : Int = 1,
                overflow: TextOverflow = TextOverflow.Ellipsis,
                @SuppressLint("ModifierParameter") modifier: Modifier = Modifier) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = color,
                    fontWeight = fontWeight
                )
            ) {
                append(text)
            }
            if (isNecessary) {
                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                    append("*")
                }
            }
        }, style = style,
        modifier = modifier,
        maxLines = maxLines,
        overflow = overflow
    )


}