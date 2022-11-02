package com.lorenzofonseca.home

import android.content.Context
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

import com.lorenzofonseca.navigation.ActivityNavigation


@Composable
fun ShowUserDashBoard(userId: String) {
    Text(text = userId)
}

@Composable
fun ShowLoginActivity(context: Context) {
    CircularProgressIndicator()
    ActivityNavigation.startLoginActivity(context)}
