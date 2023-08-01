package com.alezzgo.socialmedia.ui

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SocialMediaApp : Application(){

    override fun onCreate() {
        super.onCreate()

        //notifications

        FirebaseApp.initializeApp(this)
        FirebaseMessaging.getInstance().token.addOnCompleteListener {
            if(!it.isSuccessful){
                return@addOnCompleteListener
            }
            val token = it.result
            Log.e("MyNotification","Token -> $token")
        }
        FirebaseInstallations.getInstance().id.addOnCompleteListener {
            if(!it.isSuccessful){
                return@addOnCompleteListener
            }
            val id = it.result
            Log.e("MyNotification","FIID -> $id")
        }


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "channel_id",
                "Channel name",
                NotificationManager.IMPORTANCE_HIGH
            )
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        } else {
            TODO("VERSION.SDK_INT < O")
        }

    }

}