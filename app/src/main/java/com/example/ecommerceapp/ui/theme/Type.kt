package com.example.ecommerceapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ecommerceapp.R

// Set of Material typography styles to start with
val Poppins = FontFamily(
    fonts = listOf(
        Font(R.font.poppins_regular, FontWeight.Normal),
        Font(R.font.poppins_bold, FontWeight.Bold),
        Font(R.font.poppins_semibold, FontWeight.SemiBold)
    )
)
val Typography = Typography(
    labelLarge = TextStyle(
//        fontFamily = Poppins,
        fontWeight = FontWeight(600),
        fontSize = 20.sp,
        lineHeight = 18.sp,
        color = DarkBlue
    ),
    displaySmall = TextStyle(
//        fontFamily = Poppins,
        fontWeight = FontWeight(400),
        fontSize = 18.sp,
        lineHeight = 18.sp,
        color = Color.White
    ),
    labelMedium = TextStyle(
//        fontFamily = Poppins,
        fontWeight = FontWeight(300),
        fontSize = 18.sp,
        lineHeight = 18.sp,
        color = Color.Black.copy(alpha = 0.7f)
    ),
    labelSmall = TextStyle(
//        fontFamily = Poppins,
        fontWeight = FontWeight(500),
        fontSize = 18.sp,
        lineHeight = 18.sp,
        color = Color.White
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight(300),
        fontSize = 14.sp,
        lineHeight = 18.sp,
        color = Color.Black.copy(alpha = 0.7f)
    )

)