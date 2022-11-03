package com.lorenzofonseca.resources.components

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable

@Composable
fun BaseTextField(value: String, label: String, onValueChanged: (String) -> Unit) {
    TextField(value = value, onValueChange = onValueChanged)
}