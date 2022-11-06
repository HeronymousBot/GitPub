package com.lorenzofonseca.login

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lorenzofonseca.login.ui.Theme.GitPubTheme
import com.lorenzofonseca.resources.components.ButtonWithRightIcon
import com.lorenzofonseca.resources.components.FullScreenProgressIndicator
import com.lorenzofonseca.resources.components.ImageHolder
import com.lorenzofonseca.resources.theme.Color
import com.lorenzofonseca.resources.theme.Type
import org.koin.androidx.compose.koinViewModel


@Composable
fun Login(startAuthentication: () -> Unit) {
    val viewModel: LoginViewModel = koinViewModel()
    val uiState = viewModel.loginUiState.collectAsState().value
    Scaffold {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageHolder(resourceId = R.drawable.gitpub_logo, 90.dp, 16.dp)
                Spacer(modifier = Modifier.height(20.dp))
                TextField(value = "", onValueChange = {}, label = {
                    Text(
                        text = "User", style = Type.Typography(
                            Color.contrastColor(
                                isSystemInDarkTheme()
                            )
                        ).body1
                    )
                })

                Spacer(modifier = Modifier.height(60.dp))


                ButtonWithRightIcon(
                    text = R.string.signin_with_github,
                    rightIconId = R.drawable.github_icon,
                    onClickAction = startAuthentication

                )
            }

            FullScreenProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(
                        when (uiState) {
                            is LoginUiState.Error -> 0f
                            is LoginUiState.InProgress -> 0.7f
                            LoginUiState.IsLoading -> 0.7f
                            is LoginUiState.SignedIn -> 0f
                            LoginUiState.SignedOut -> 0f
                        }
                    )
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    GitPubTheme {

    }
}