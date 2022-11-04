package com.lorenzofonseca.login

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lorenzofonseca.login.ui.Theme.GitPubTheme
import com.lorenzofonseca.resources.components.ActionButton
import com.lorenzofonseca.resources.components.ImageHolder
import com.lorenzofonseca.resources.theme.Color
import com.lorenzofonseca.resources.theme.Type


@Composable
fun Login() {
    Scaffold {
        Surface {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ImageHolder(resourceId = R.drawable.img)
                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(value = "", onValueChange = {}, label = { Text(text = "User", style = Type.Typography(Color.contrastColor(
                        isSystemInDarkTheme())).body1) })

                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(
                        value = "",
                        onValueChange = {},
                        label = { Text(text = "Password", style = Type.Typography(Color.contrastColor(
                            isSystemInDarkTheme())).body1) },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )

                    ActionButton(onClickAction = {  })
                }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    GitPubTheme {
        Login()
    }
}