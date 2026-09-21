package com.example.gamebooster

import android.app.ActivityManager
import android.content.Context

object GameBoosterManager {
    fun boostMemory(context: Context) {
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val packages = context.packageManager.getInstalledPackages(0)
        for (pkg in packages) {
            if (pkg.packageName != context.packageName) {
                activityManager.killBackgroundProcesses(pkg.packageName)
            }
        }
    }
}
