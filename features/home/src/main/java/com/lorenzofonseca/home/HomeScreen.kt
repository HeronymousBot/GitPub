package com.lorenzofonseca.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.lorenzofonseca.resources.components.HomeBottomNavigation
import com.lorenzofonseca.resources.ui.Theme.GitPubTheme

@Composable
fun HomeScreen() {
    val navHostController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(bottomBar = { HomeBottomNavigation(navController = navHostController) })
        { paddingValues ->
            HomeNavigationGraph(
                modifier = Modifier.padding(bottom = paddingValues.calculateBottomPadding()),
                navController = navHostController
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    GitPubTheme {
        HomeScreen()
    }
}
