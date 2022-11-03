package com.lorenzofonseca.navigation

sealed class ComposeNavigation(val route: String) {
    object Login : ComposeNavigation("login")
    object Repositories : ComposeNavigation("repositoriesList")
    object Home : ComposeNavigation("home")
    object UserProfile : ComposeNavigation("userProfile")

}