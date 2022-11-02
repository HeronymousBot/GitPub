package com.lorenzofonseca.login.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.lorenzofonseca.resources.theme.Color
import com.lorenzofonseca.resources.theme.Shape
import com.lorenzofonseca.resources.theme.Type

object Theme {
    private val DarkColorPalette = darkColors(
        primary = Color.primaryDarkerColor,
        primaryVariant = Color.primaryColor,
        secondary = Color.accentColor,
    )

    private val LightColorPalette = lightColors(
        primary = Color.white,
        primaryVariant = Color.grey,
        secondary = Color.accentColor,
    )

    @Composable
    fun GitPubTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
        val colors = if (darkTheme) {
            DarkColorPalette
        } else {
            LightColorPalette
        }

        val fontColor = if(isSystemInDarkTheme()) Color.grey else Color.primaryColor


        MaterialTheme(
            colors = colors,
            typography = Type.Typography(fontColor),
            shapes = Shape.Shapes,
            content = content
        )
    }
}