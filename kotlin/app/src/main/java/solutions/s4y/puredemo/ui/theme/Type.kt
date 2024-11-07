package solutions.s4y.puredemo.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        color = WhiteBrightest,
        fontFamily = FontUbuntu,
        fontWeight = FontWeight.W400,
        fontSize = 24.sp,
        lineHeight = 21.sp,
    ),
    titleMedium = TextStyle(
        color = WhiteBrightest,
        fontFamily = FontUbuntu,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    ),
    bodyLarge = TextStyle(
        color = WhiteBrightest,
        fontFamily = FontUbuntu,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 12.sp,
    ),
    bodyMedium = TextStyle(
        color = WhiteBrightest,
        fontFamily = FontUbuntu,
        fontWeight = FontWeight.W300,
        fontSize = 14.sp,
        lineHeight = 21.sp,
    ),
    bodySmall = TextStyle(
        color = WhiteDarkest,
        fontFamily = FontUbuntu,
        fontWeight = FontWeight.Light,
        fontSize = 12.sp,
        lineHeight = 21.sp,
    ),
    displayMedium = TextStyle(
        color = WhiteDarkest,
        fontFamily = FontUbuntu,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 21.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = FontUbuntu,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 21.sp,
        color = WhiteBrightest,
    ),
    headlineSmall = TextStyle(
        fontFamily = FontUbuntu,
        fontWeight = FontWeight.W300,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        color = WhiteDark,
    ),
    labelMedium = TextStyle(
        fontFamily = FontUbuntu,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        color = WhiteBrightest,
    ),
    labelSmall = TextStyle(
        fontFamily = FontUbuntu,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color(0xFF422B2B)
    )
)