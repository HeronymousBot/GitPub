package com.lorenzofonseca.navigation

import android.content.Intent

object ActivityNavigation {
    fun startLogin() = Intent("action.login.open")
    fun startHome() = Intent("action.home.open")
}