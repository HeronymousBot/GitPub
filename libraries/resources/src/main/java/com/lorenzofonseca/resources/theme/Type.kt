package com.lorenzofonseca.resources.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.lorenzofonseca.resources.R

object Type {
    private val nunitoFontFamily = FontFamily(
        Font(R.font.nunito_black, FontWeight.Black),
        Font(R.font.nunito_black, FontWeight.Black, FontStyle.Italic),
        Font(R.font.nunito_bold_italic, FontWeight.Bold, FontStyle.Italic),
        Font(R.font.nunito_bold, FontWeight.Bold),
        Font(R.font.nunito_extrabold, FontWeight.ExtraBold),
        Font(R.font.nunito_extrabold_italic, FontWeight.ExtraBold, FontStyle.Italic),
        Font(R.font.nunito_extralight, FontWeight.ExtraLight),
        Font(R.font.nunito_extralight_italic, FontWeight.ExtraLight, FontStyle.Italic),
        Font(R.font.nunito_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.nunito_light, FontWeight.Light),
        Font(R.font.nunito_light_italic, FontWeight.Light, FontStyle.Italic),
        Font(R.font.nunito_medium, FontWeight.Medium),
        Font(R.font.nunito_medium_italic, FontWeight.Medium, FontStyle.Italic),
        Font(R.font.nunito_regular, FontWeight.Normal),
        Font(R.font.nunito_semibold, FontWeight.SemiBold),
        Font(R.font.nunito_semibold_italic, FontWeight.SemiBold, FontStyle.Italic)
    )


    fun Typography(color : androidx.compose.ui.graphics.Color) = Typography(
        h6 = TextStyle(
            fontFamily = nunitoFontFamily,
            fontWeight = FontWeight.W500,
            fontSize = 20.sp,
            color = color
        ),
        body1 = TextStyle(
            fontFamily = nunitoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = color
        ),
        button = TextStyle(
            fontFamily = nunitoFontFamily,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp,
            color = color
        ),
        caption = TextStyle(
            fontFamily = nunitoFontFamily,
            fontWeight = FontWeight.Light,
            fontSize = 14.sp,
            color = color
        ),
        body2 = TextStyle(
            fontFamily = nunitoFontFamily,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp,
            color = color
        )

    )
}