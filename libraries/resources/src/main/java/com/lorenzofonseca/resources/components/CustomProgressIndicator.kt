package com.lorenzofonseca.resources.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lorenzofonseca.resources.ui.Color

@Composable
fun FullScreenProgressIndicator(modifier: Modifier) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(modifier = Modifier.size(80.dp), color = Color.accentColor)
    }

}