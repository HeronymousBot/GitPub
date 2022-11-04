package com.lorenzofonseca.gitpub

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.rememberNavController
import com.lorenzofonseca.gitpub.ui.Theme.GitPubTheme
import com.lorenzofonseca.home.HomeScreen
import com.lorenzofonseca.home.HomeUiState
import com.lorenzofonseca.home.HomeViewModel
import com.lorenzofonseca.navigation.ActivityNavigation
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeActivity : ComponentActivity() {

    val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.homeUiState.collect { state ->
                    when (state) {
                        is HomeUiState.LoggedOut -> startLogin(ActivityNavigation.startLogin())
                        is HomeUiState.LoggedIn ->
                            setContent {
                            GitPubTheme {
                                HomeScreen(navHostController = rememberNavController())

                            }

                        }
                    }

                }
            }
        }
    }

    fun startLogin(intent: Intent) {
        startActivity(intent)
    }
}