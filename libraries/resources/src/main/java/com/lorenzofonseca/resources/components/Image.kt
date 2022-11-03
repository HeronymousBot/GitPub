package com.lorenzofonseca.resources.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun ImageHolder(resourceId: Int) {

    val painter = rememberAsyncImagePainter(resourceId)
    val state = painter.state
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(90.dp)
            .clip(CircleShape)
    )
}

@Composable
fun ImageHolder(urlPath: String) {
    val painter = rememberAsyncImagePainter(urlPath)
    val state = painter.state
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(128.dp)
            .clip(CircleShape)
    )
}