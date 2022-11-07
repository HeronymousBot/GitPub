package com.lorenzofonseca.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lorenzofonseca.navigation.ComposeNavigation
import com.lorenzofonseca.repositories.ui.RepositoriesList
import com.lorenzofonseca.resources.ui.Theme.GitPubTheme
import com.lorenzofonseca.user.UserProfile


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitPubTheme {

                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeNavigationGraph(
    modifier: Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = ComposeNavigation.Repositories.route,

        ) {
        composable(
            route = ComposeNavigation.Repositories.route
        ) { RepositoriesList() }
        composable(
            route = ComposeNavigation.UserProfile.route
        ) { UserProfile() }
    }
}