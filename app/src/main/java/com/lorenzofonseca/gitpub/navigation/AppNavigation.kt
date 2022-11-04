package com.lorenzofonseca.gitpub.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lorenzofonseca.navigation.ComposeNavigation
import com.lorenzofonseca.repositories.ui.RepositoriesList

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun navigationComponent(navHostController: NavHostController = rememberAnimatedNavController()) {
    AnimatedNavHost(
        navController = navHostController,
        startDestination = ComposeNavigation.Home.route
    ) {
        composable(ComposeNavigation.Repositories.route) { RepositoriesList() }
        composable(ComposeNavigation.UserProfile.route){}
    }
}