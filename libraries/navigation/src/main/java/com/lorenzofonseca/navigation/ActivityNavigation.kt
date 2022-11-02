package com.lorenzofonseca.navigation

import android.content.Context
import android.content.Intent

object ActivityNavigation {
    fun startLoginActivity(context: Context)
        {
            var intent = Intent().apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK}
            intent = context.packageManager.getLaunchIntentForPackage("com.lorenzofonseca.login")!!

            context.startActivity(intent)
        }
}