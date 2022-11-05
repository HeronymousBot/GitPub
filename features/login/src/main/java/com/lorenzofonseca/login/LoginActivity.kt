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
import com.lorenzofonseca.login.ui.Theme.GitPubTheme
import com.lorenzofonseca.navigation.IntentNavigation
import com.lorenzofonseca.networking.AuthenticationUrl
import kotlinx.coroutines.launch
import com.lorenzofonseca.datastorage.AuthInformationDataStorePreferences.storeAuthInformation

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitPubTheme {
                Scaffold {
                    Surface {
                        Login {
                            IntentNavigation.openWebIntent(
                                this,
                                AuthenticationUrl.generateAuthUrl()
                            )
                        }

                    }
                }

            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val uri = intent?.data

        val code = uri?.getQueryParameter("code") ?: ""
        val state = uri?.getQueryParameter("state") ?: ""

        lifecycleScope.launch {
            storeAuthInformation(code = code, state = state)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    GitPubTheme {
        Login({})
    }
}