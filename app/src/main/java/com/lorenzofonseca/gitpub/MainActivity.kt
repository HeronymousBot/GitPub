package com.lorenzofonseca.gitpub

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.lorenzofonseca.navigation.ActivityNavigation
import com.lorenzofonseca.resources.components.FullScreenProgressIndicator
import com.lorenzofonseca.resources.ui.Color
import com.lorenzofonseca.resources.ui.Theme.GitPubTheme
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GitPubTheme {
                Scaffold {
                    Surface {
                        FullScreenProgressIndicator(
                            modifier = Modifier
                                .background(Color.primaryColor.copy(alpha = 0.7f))
                                .fillMaxSize()
                        )

                    }
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.mainUiState.collect { state ->
                    when (state) {
                        MainUiState.LoggedIn -> startNextScreen(ActivityNavigation.startHome())
                        MainUiState.LoggedOut -> startNextScreen(ActivityNavigation.startLogin())
                        else -> {}
                    }

                }
            }
        }
    }

    private fun startNextScreen(intent: Intent) {
        finish()
        startActivity(intent)
    }
}