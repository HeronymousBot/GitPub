package com.lorenzofonseca.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ComposeNavigation(val route: String) {
    object Login : ComposeNavigation("login")
    object Repositories : ComposeNavigation("repositoriesList")
    object Home : ComposeNavigation("home")
    object UserProfile : ComposeNavigation("userProfile")

}

object NavigationItemsList {
    val bottomNavigationItems: List<BottomNavigationItem> = listOf(
        BottomNavigationItem(
            title = "Repos",
            image = Icons.Filled.Home,
            route = ComposeNavigation.Repositories.route
        ),
        BottomNavigationItem(
            title = "User",
            image = Icons.Filled.Person,
            route = ComposeNavigation.UserProfile.route
        )
    )
}

data class BottomNavigationItem(val title: String, val image: ImageVector, val route: String)