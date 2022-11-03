package com.lorenzofonseca.resources.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.lorenzofonseca.resources.R
import com.lorenzofonseca.resources.theme.Color
import com.lorenzofonseca.resources.theme.Type

@Composable
fun ActionButton(onClickAction: () -> Unit){
    Button(
        modifier = Modifier.padding(24.dp),
        onClick = { onClickAction }
    ) {
        Text(
            text = AnnotatedString(stringResource(id = R.string.log_in).uppercase()),
            style = Type.Typography(
                (Color.contrastColor(isSystemInDarkTheme())
                        )
            ).button
        )
    }
}