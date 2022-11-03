package com.lorenzofonseca.navigation

import android.content.Context
import android.content.Intent

object ActivityNavigation {
    fun Context.startLoginActivity()
        {
            val intent = this.packageManager.getLaunchIntentForPackage("com.lorenzofonseca.login")!!
            intent.apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK }
            this.startActivity(intent)
        }
}