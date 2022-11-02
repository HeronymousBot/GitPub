package com.lorenzofonseca.navigation

import android.app.Activity
import android.content.Intent
import android.net.Uri

object IntentNavigation {
    fun openWebIntent(activity: Activity, url : String){
        activity.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            addCategory(Intent.CATEGORY_BROWSABLE)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        })
    }
}