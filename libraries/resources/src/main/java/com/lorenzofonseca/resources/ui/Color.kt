package com.lorenzofonseca.resources.ui

import androidx.compose.ui.graphics.Color

object Color {
    val primaryDarkerColor = Color(0xFF24292e)
    val primaryColor = Color(0xFF2b3137)
    val grey = Color(0xFFfafbfc)
    val white = Color(0xFFffffff)
    val accentColor = Color(0xFF2dba4e)
    fun contrastColor(isSystemDarkTheme: Boolean): Color =
        if (isSystemDarkTheme) grey else primaryColor
}