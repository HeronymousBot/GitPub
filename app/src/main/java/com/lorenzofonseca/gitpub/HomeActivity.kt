package com.lorenzofonseca.gitpub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lorenzofonseca.gitpub.ui.Theme.GitPubTheme
import com.lorenzofonseca.login.Login
import com.lorenzofonseca.navigation.ComposeNavigation
import com.lorenzofonseca.repositories.ui.RepositoriesList


class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitPubTheme {
                Scaffold {
                    Surface(color = MaterialTheme.colors.background) {
                        navigationComponent()
                    }
                }
            }

        }
    }


}

@Composable
fun navigationComponent(navHostController: NavHostController = rememberNavController()) {
    NavHost(navController = navHostController, startDestination = ComposeNavigation.Home.route) {
        composable(ComposeNavigation.Home.route) { HomeScreen(navHostController = navHostController) }
        composable(ComposeNavigation.Login.route) { Login(navController = navHostController) }
        composable(ComposeNavigation.Repositories.route) { RepositoriesList() }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GitPubTheme {
        HomeScreen(navHostController = rememberNavController())
    }
}