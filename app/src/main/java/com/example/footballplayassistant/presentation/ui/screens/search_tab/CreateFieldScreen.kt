package com.example.footballplayassistant.presentation.ui.screens.search_tab

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
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
import com.example.footballplayassistant.presentation.customviews.radiobuttons.RadioButtonGroup
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
@Preview
fun CreateFieldScreen() {
    Column(modifier = Modifier
        .background(MaterialTheme.colorScheme.primaryContainer)
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())) {
        HeaderWithBackButton(stringResource(id = R.string.addField), onClickBack = { TODO() })
        Text(text = stringResource(id = R.string.fieldInfoTitle), modifier = Modifier.padding(vertical = MaterialTheme.spacing.medium))
        NecessaryTextField(label = stringResource(id = R.string.fieldName), true, leadingIcon = R.drawable.ic_field, trailingIcon = R.drawable.ic_field)
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.small))
        NecessaryTextField(label = stringResource(id = R.string.fieldName), true)
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.small))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            NecessaryTextField(label = "Открытие", true, modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(end = MaterialTheme.spacing.extraSmall))
            NecessaryTextField(label = "Закрытие", true, modifier = Modifier.padding(start = MaterialTheme.spacing.extraSmall))
        }
        Spacer(modifier = Modifier.size(MaterialTheme.spacing.small))

        Spacer(modifier = Modifier.size(MaterialTheme.spacing.large))
        Row() {
            Text("Вместимость")
            DropDownMenu(placeholder = "чел.", values = listOf())
        }
    }

    

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NecessaryTextField(label : String,
                       isNecessary : Boolean,
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
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            fontWeight = FontWeight.W400
                        )
                    ) {
                        append(label)
                    }
                    if (isNecessary) {
                        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                            append("*")
                        }
                    }
                }, style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding( MaterialTheme.spacing.small )
            )
        }
        BasicTextField(modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(60.dp))
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(horizontal = 16.dp, vertical = 16.dp),
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
                        modifier = Modifier.padding(end = MaterialTheme.spacing.small))
                }
                if (!isFocused && value.text.isEmpty()) {
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                    fontWeight = FontWeight.W400
                                )
                            ) {
                                append(label)
                            }
                            if (isNecessary) {
                                withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onBackground)) {
                                    append("*")
                                }
                            }
                        },
                        style = MaterialTheme.typography.labelLarge,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis

                    )
                }

                    innerTextField()
                }
                if (trailingIcon != 0) {
                    Icon(painter = painterResource(id = trailingIcon), contentDescription = "",
                        modifier = Modifier.padding(start = MaterialTheme.spacing.small))
                }
            }
        }
    }


}