package com.lorenzofonseca.login

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lorenzofonseca.resources.components.ButtonWithRightIcon
import com.lorenzofonseca.resources.components.FullScreenProgressIndicator
import com.lorenzofonseca.resources.components.ImageHolder
import com.lorenzofonseca.resources.ui.Color
import com.lorenzofonseca.resources.ui.Theme.GitPubTheme
import com.lorenzofonseca.resources.ui.Type
import org.koin.androidx.compose.koinViewModel


@Composable
fun Login(startAuthentication: () -> Unit) {
    val viewModel: LoginViewModel = koinViewModel()
    val uiState = viewModel.loginUiState.collectAsState().value
    val isLoading = when (uiState) {
        is LoginUiState.InProgress, LoginUiState.IsLoading -> true
        else -> false
    }

    Scaffold {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.app_name), style = Type.Typography(
                        Color.contrastColor(
                            isSystemInDarkTheme()
                        )
                    ).h2
                )
                ImageHolder(
                    resourceId = R.drawable.gitpub_logo,
                    imageSize = 160.dp,
                    padding = 16.dp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = stringResource(id = R.string.login_caption), style = Type.Typography(
                        Color.contrastColor(
                            isSystemInDarkTheme()
                        )
                    ).caption
                )

                Spacer(modifier = Modifier.height(60.dp))


                ButtonWithRightIcon(
                    text = R.string.signin_with_github,
                    rightIconId = R.drawable.github_classic_icon,
                    onClickAction = startAuthentication

                )
            }

            FullScreenProgressIndicator(
                modifier = Modifier
                    .background(Color.primaryColor.copy(alpha = if (isLoading) 0.7f else 0f))
                    .fillMaxSize()
                    .alpha(
                        if (isLoading) 1f else 0f
                    )
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    GitPubTheme {
        Login {}
    }
}