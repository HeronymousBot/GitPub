package com.lorenzofonseca.resources.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lorenzofonseca.resources.R
import com.lorenzofonseca.resources.ui.Color
import com.lorenzofonseca.resources.ui.Type

@Composable
fun ButtonWithRightIcon(text: Int, rightIconId: Int, onClickAction: () -> Unit) {
    Button(
        modifier = Modifier
            .padding(24.dp),
        onClick = onClickAction,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.accentColor)
    ) {
        Text(
            text = AnnotatedString(stringResource(id = text)),
            style = Type.Typography(
                (Color.contrastColor(isSystemInDarkTheme())
                        )
            ).button
        )
        Spacer(modifier = Modifier.width(8.dp))

        ImageHolder(resourceId = rightIconId, imageSize = 16.dp)
    }
}

@Preview
@Composable
fun CustomActionButton() {
    ButtonWithRightIcon(
        onClickAction = {},
        text = R.string.signin_with_github,
        rightIconId = R.drawable.github_classic_icon
    )
}