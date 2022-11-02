package com.lorenzofonseca.gitpub

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.lorenzofonseca.login.LoginActivity
import com.lorenzofonseca.navigation.ActivityNavigation.startLoginActivity

@Composable
fun ShowUserDashBoard(userId: String) {

    Text(text = userId)


}

@Composable
fun ShowLoginActivity(navController : NavHostController) {
    Text(text = "show login")

}
