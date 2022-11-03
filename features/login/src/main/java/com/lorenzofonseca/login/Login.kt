package com.lorenzofonseca.login

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.lorenzofonseca.login.ui.Theme.GitPubTheme
import com.lorenzofonseca.navigation.ComposeNavigation
import com.lorenzofonseca.resources.theme.Color
import com.lorenzofonseca.resources.theme.Type


@Composable
fun Login(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Login", style = Type.Typography(Color.primaryColor).h6)
            Spacer(modifier = Modifier.height(20.dp))
            TextField(value = "", onValueChange = {}, label = { Text(text = "User") })

            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Button(
                modifier = Modifier.padding(24.dp),
                onClick = { navController.navigate(ComposeNavigation.Repositories.route) }
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
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    GitPubTheme {
        Login(navController = rememberNavController())
    }
}