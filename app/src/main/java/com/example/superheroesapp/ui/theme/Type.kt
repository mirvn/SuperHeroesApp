package com.example.superheroesapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.superheroesapp.R

// Set of Material typography styles to start with
val Cabin = FontFamily(
    Font(R.font.cabin_regular, FontWeight.Normal),
    Font(R.font.cabin_bold, FontWeight.Bold)
)

val Typography = Typography(
    displaySmall = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = Cabin,
        fontSize = 20.sp
    ),
    displayMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontFamily = Cabin,
        fontSize = 20.sp
    ),
    displayLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = Cabin,
        fontSize = 30.sp
    ),
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal,
        fontFamily = Cabin,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)