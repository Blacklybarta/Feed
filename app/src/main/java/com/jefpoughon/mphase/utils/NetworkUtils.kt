package com.jefpoughon.mphase.utils

import android.content.Context
import android.net.ConnectivityManager
import org.koin.core.KoinComponent
import org.koin.core.inject


object NetworkUtils : KoinComponent {

    private val context: Context by inject()

    fun isNetworkConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo.isConnected
    }
}
