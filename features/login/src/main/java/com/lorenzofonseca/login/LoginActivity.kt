package com.lorenzofonseca.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.lorenzofonseca.datastorage.AuthInformationDataStorePreferences.storeAuthInformation
import com.lorenzofonseca.login.ui.Theme.GitPubTheme
import com.lorenzofonseca.navigation.IntentNavigation
import com.lorenzofonseca.networking.AuthenticationUrl
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : ComponentActivity() {
    val viewModel: LoginViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitPubTheme {
                Scaffold {
                    Surface {
                        Login {
                            startAuthentication()
                        }

                    }
                }
            }
        }
    }

    fun startAuthentication() {
        viewModel.updateUiState(LoginUiState.IsLoading)
        IntentNavigation.openWebIntent(
            this,
            AuthenticationUrl.generateAuthUrl()
        )
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val uri = intent?.data

        val code = uri?.getQueryParameter("code") ?: ""
        val state = uri?.getQueryParameter("state") ?: ""

        viewModel.updateUiState(LoginUiState.InProgress(code, state))

        lifecycleScope.launch {
            storeAuthInformation(code = code, state = state)
            viewModel.getAccessToken(code = code, state = state)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    GitPubTheme {

    }
}