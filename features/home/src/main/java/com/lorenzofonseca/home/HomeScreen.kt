package com.lorenzofonseca.home

import android.content.Context
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

import com.lorenzofonseca.navigation.ActivityNavigation
import com.lorenzofonseca.navigation.ActivityNavigation.startLoginActivity


@Composable
fun ShowUserDashBoard(userId: String) {
    Text(text = userId)
}

@Composable
fun ShowLoginActivity(context: Context) {
    CircularProgressIndicator()
    startLoginActivity(context)
}
