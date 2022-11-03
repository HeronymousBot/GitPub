package com.lorenzofonseca.gitpub

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import com.lorenzofonseca.navigation.ComposeNavigation
import org.koin.androidx.compose.koinViewModel

@Composable
fun ShowUserDashBoard(userId: String) {

    Text(text = userId)


}

@Composable
fun ShowLoginPage(navController: NavHostController) {
    Text(text = "show login")
    navController.navigate(ComposeNavigation.Login.route)

}

@Composable
fun HomeScreen(navHostController: NavHostController) {
    when (val state = koinViewModel<HomeViewModel>().homeUiState.collectAsState().value) {
        is HomeUiState.LoggedIn -> Column {
            ShowUserDashBoard(userId = state.userId)
        }
        is HomeUiState.LoggedOut -> ShowLoginPage(navController = navHostController)

    }
}
