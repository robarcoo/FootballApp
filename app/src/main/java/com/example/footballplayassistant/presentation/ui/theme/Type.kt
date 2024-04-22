package com.example.footballplayassistant.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.footballplayassistant.R

// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter)),
        fontSize = 36.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter)),
        fontSize = 32.sp,
    ),
    displayLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter)),
        fontSize = 28.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter)),
        fontSize = 20.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter)),
        fontWeight = FontWeight.W600,
        fontSize = 18.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter)),
        fontSize = 16.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto_flex)),
        fontSize = 16.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter)),
        fontSize = 14.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter)),
        fontSize = 12.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.inter)),
        fontSize = 10.sp,
    ),
)