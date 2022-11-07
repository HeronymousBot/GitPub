package com.lorenzofonseca.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lorenzofonseca.datastorage.AuthInformationDataStorePreferences.clearAuthRequestPreferences
import com.lorenzofonseca.datastorage.TokenDataStorePreferences.clearTokenPreferences
import com.lorenzofonseca.datastorage.UserDataStorePreferences.clearUserPreferences
import com.lorenzofonseca.navigation.ActivityNavigation
import com.lorenzofonseca.navigation.ComposeNavigation
import com.lorenzofonseca.repositories.ui.RepositoriesList
import com.lorenzofonseca.resources.ui.Theme.GitPubTheme
import com.lorenzofonseca.user.UserProfile
import kotlinx.coroutines.launch


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitPubTheme {

                Scaffold(floatingActionButtonPosition = FabPosition.Center, floatingActionButton = {
                    FloatingActionButton(
                        content = { Icon(Icons.Default.ExitToApp, "") },
                        onClick = { logout() })
                }) {
                    HomeScreen()
                }
            }
        }
    }

    fun logout() {
        lifecycleScope.launch {
            clearAuthRequestPreferences()
            clearTokenPreferences()
            clearUserPreferences()
        }
        finish()
        startActivity(ActivityNavigation.startLogin())

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