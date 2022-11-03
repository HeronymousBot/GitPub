package com.lorenzofonseca.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import com.lorenzofonseca.navigation.ComposeNavigation
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navHostController: NavHostController) {
    when (koinViewModel<HomeViewModel>().homeUiState.collectAsState().value) {
        is HomeUiState.LoggedIn -> navHostController.navigate(ComposeNavigation.Repositories.route)
        is HomeUiState.LoggedOut -> navHostController.navigate(ComposeNavigation.Login.route)

    }
}
