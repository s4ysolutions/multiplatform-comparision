package solutions.s4y.puredemo.ui.theme

import androidx.compose.material3.Typography
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
    headlineLarge = TextStyle(
        fontFamily = FontUbuntu,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 21.sp,
        color = WhiteBrightest,
        // letterSpacing = 0.15.sp
    ),

    /* Other default text styles to override
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)