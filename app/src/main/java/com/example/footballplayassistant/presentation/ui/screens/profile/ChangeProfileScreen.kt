package com.example.footballplayassistant.presentation.ui.screens.profile

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.footballplayassistant.BuildConfig
import com.example.footballplayassistant.R
import com.example.footballplayassistant.presentation.customviews.buttons.ButtonCalendar
import com.example.footballplayassistant.presentation.customviews.buttons.CommonButton
import com.example.footballplayassistant.presentation.customviews.dialogwindows.DialogScreen
import com.example.footballplayassistant.presentation.customviews.dropdownmenus.ButtonDropDownMenu
import com.example.footballplayassistant.presentation.customviews.dropdownmenus.CommonActionsMenu
import com.example.footballplayassistant.presentation.customviews.headers.HeaderUserProfile
import com.example.footballplayassistant.presentation.customviews.headers.HeaderWithBackButton
import com.example.footballplayassistant.presentation.customviews.textfields.CommonTextField
import com.example.footballplayassistant.presentation.enums.getGenders
import com.example.footballplayassistant.presentation.enums.getLevels
import com.example.footballplayassistant.presentation.enums.getPositions
import com.example.footballplayassistant.presentation.navigation.LocalNavController
import com.example.footballplayassistant.presentation.navigation.Route
import com.example.footballplayassistant.presentation.ui.screens.authentication.addStar
import com.example.footballplayassistant.presentation.ui.screens.authentication.openCalendar
import com.example.footballplayassistant.presentation.ui.theme.spacing

@Composable
fun ChangeProfileScreen() {
    val navController = LocalNavController.current!!
    val expanded = remember { mutableStateOf(false) }
    val buttonEnable = remember { mutableStateOf(false) }
    val showDialog = remember { mutableStateOf(false) }

    DialogScreen(
        header = stringResource(id = R.string.doneWithPoint),
        description = stringResource(id = R.string.changesSavedSuccess),
        greenButton = stringResource(id = R.string.returnToProfile),
        whiteButton = stringResource(id = R.string.toMain),
        image = R.drawable.ic_check_92,
        onClickGreen = { navController.navigate(Route.UserProfileScreen.withArgs("false")) },
        onClickWhite = { navController.navigate(Route.MainScreen.path) },
        onDismissRequest = { showDialog.value = false },
        showDialog = showDialog.value
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primaryContainer)
    ) {
        HeaderUserProfile(modifier = Modifier.align(Alignment.TopCenter))

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp)
        ) {
            HeaderWithBackButton(
                text = stringResource(id = R.string.myAccount),
                colorText = MaterialTheme.colorScheme.onPrimary,
                tint = MaterialTheme.colorScheme.onPrimary,
                onClickBack = { navController.navigate(Route.UserProfileScreen.withArgs("false")) },
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Box(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.outlineVariant
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user_foto),//unknown_user_foto
                    contentDescription = "User foto",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.sizeIn(108.dp)
                )
                IconButton(
                    onClick = { expanded.value = !expanded.value },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.onPrimary),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .border(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            width = 4.dp,
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_pencil_22),
                        contentDescription = "Pencil",
                        tint = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    CommonActionsMenu(
                        expand = expanded,
                        actions = listOf(
                            R.string.chooseFromLibrary,
                            R.string.takeFoto,
                            R.string.deleteCurrent
                        ),
                        icons = listOf(
                            R.drawable.ic_image_24,
                            R.drawable.ic_camera_24,
                            R.drawable.ic_delete_foto_24
                        ),
                        onClicks = listOf({}, {}, {}),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            LazyColumn(modifier = Modifier.padding(all = 16.dp)) {
                item {
                    Text(
                        text = addStar(id = R.string.nick),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )

                    CommonTextField(
                        placeholder = stringResource(id = R.string.enterNick),
                        keyBoard = KeyboardType.Text,
                        color = MaterialTheme.colorScheme.onPrimary,
                        onClick = { buttonEnable.value = true },
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                item {
                    Text(
                        text = addStar(id = R.string.name),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )

                    CommonTextField(
                        placeholder = stringResource(id = R.string.enterName),
                        keyBoard = KeyboardType.Text,
                        color = MaterialTheme.colorScheme.onPrimary,
                        onClick = { buttonEnable.value = true },
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                item {
                    Text(
                        text = addStar(id = R.string.surname),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )

                    CommonTextField(
                        placeholder = stringResource(id = R.string.enterSurname),
                        keyBoard = KeyboardType.Text,
                        color = MaterialTheme.colorScheme.onPrimary,
                        onClick = { buttonEnable.value = true },
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                item {
                    Text(
                        text = addStar(id = R.string.bigEmail),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )

                    CommonTextField(
                        placeholder = stringResource(id = R.string.enterBigEmail),
                        keyBoard = KeyboardType.Text,
                        color = MaterialTheme.colorScheme.onPrimary,
                        onClick = { buttonEnable.value = true },
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }
                item {
                    Text(
                        text = addStar(id = R.string.cityProfile),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )

                    ButtonDropDownMenu(
                        placeholder = stringResource(id = R.string.city),
                        values = listOf("moskva", "spb", "ekb"),
                        textColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        onClick = { },
                        onClickItem = { buttonEnable.value = true },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .heightIn(min = 48.dp)
                    )
                }
                item {
                    val context = LocalContext.current
                    val date = remember { mutableStateOf("") }

                    Text(
                        text = stringResource(id = R.string.birthday),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )
                    ButtonCalendar(
                        onCLick = { openCalendar(context, date) },
                        date = date.value,
                        placeholder = stringResource(id = R.string.birthday),
                        containerColor = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .heightIn(min = 48.dp)
                    )
                    LaunchedEffect(key1 = date.value.isNotEmpty()) {
                         Log.d("MyLog", BuildConfig.VERSION_CODE.toString())
                        buttonEnable.value = true
                    }
                }
                item {
                    Text(
                        text = stringResource(id = R.string.sexMatch),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )
                    ButtonDropDownMenu(
                        placeholder = stringResource(id = R.string.sex),
                        values = getGenders(),
                        imStart = R.drawable.ic_sex_23,
                        onClickItem = { buttonEnable.value = true },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .heightIn(min = 48.dp)
                    )
                }
                item {
                    Text(
                        text = stringResource(id = R.string.levelPlayProfile),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )
                    ButtonDropDownMenu(
                        placeholder = stringResource(id = R.string.levelPlay),
                        values = getLevels(),
                        onClickItem = { buttonEnable.value = true },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .heightIn(min = 48.dp)
                    )
                }
                item {
                    Text(
                        text = stringResource(id = R.string.preferredPosition),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )
                    ButtonDropDownMenu(
                        placeholder = stringResource(id = R.string.position),
                        values = getPositions(),
                        onClickItem = { buttonEnable.value = true },
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .heightIn(min = 48.dp)
                    )
                }
                item {
                    val textLength = remember { mutableStateOf(0) }
                    Text(
                        text = stringResource(id = R.string.infoYourself),
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.W500),
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(bottom = MaterialTheme.spacing.small)
                    )
                    Box {
                        CommonTextField(
                            placeholder = stringResource(id = R.string.tellYourself),
                            singleLine = false,
                            cornerRadius = 20.dp,
                            maxLength = 300,
                            onClick = {
                                textLength.value = it.length
                                buttonEnable.value = true
                            },
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
                item {
                    val animatedContainerColor: Color by animateColorAsState(
                        targetValue = if (buttonEnable.value) MaterialTheme.colorScheme.secondary
                        else MaterialTheme.colorScheme.tertiary,
                        animationSpec = tween(500, 0, LinearEasing)
                    )
                    val animatedContentColor: Color by animateColorAsState(
                        targetValue = if (buttonEnable.value) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.onSecondaryContainer,
                        animationSpec = tween(500, 0, LinearEasing)
                    )
                    CommonButton(
                        text = stringResource(id = R.string.saveChanges),
                        containerColor = animatedContainerColor,
                        contentColor = animatedContentColor,
                        enable = buttonEnable.value,
                        onClick = { showDialog.value = true },
                        modifier = Modifier.padding(vertical = 20.dp)
                    )
                }
            }
        }
    }
}