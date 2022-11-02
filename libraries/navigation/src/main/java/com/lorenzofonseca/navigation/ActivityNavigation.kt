package com.lorenzofonseca.navigation

import android.content.Context

object ActivityNavigation {
    fun startLoginActivity(application: Context) {

        val packageManager = application.applicationContext.packageManager
        application.applicationContext.startActivity(packageManager.getLaunchIntentForPackage("com.lorenzofonseca.login"))

    }
}