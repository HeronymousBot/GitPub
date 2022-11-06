package com.lorenzofonseca.resources.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FullScreenProgressIndicator(modifier : Modifier){
        Box(
            modifier =modifier,
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator(modifier = Modifier.size(80.dp))
        }
}