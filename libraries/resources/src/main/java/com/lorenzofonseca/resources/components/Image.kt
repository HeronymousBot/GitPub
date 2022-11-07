package com.lorenzofonseca.resources.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun ImageHolder(resourceId: Int, imageSize: Dp, padding : Dp = 0.dp) {

    val painter = rememberAsyncImagePainter(resourceId)
    val state = painter.state
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(imageSize)
            .padding(padding)
            .clip(CircleShape)
    )
}

@Composable
fun ImageHolder(urlPath: String, imageSize: Dp) {
    val painter = rememberAsyncImagePainter(urlPath)
    val state = painter.state
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(imageSize)
            .clip(CircleShape)
    )
}