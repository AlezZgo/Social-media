package com.alezzgo.socialmedia

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        val test = "test2"
        Log.d("MyNotification","remoteMessage: ${remoteMessage.notification?.title}")
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.e("MyNotification",token);
    }

    override fun handleIntent(intent: Intent) {
        try {
            if (intent.extras != null) {
                val builder = RemoteMessage.Builder("MessagingService")
                for (key in intent.extras!!.keySet()) {
                    builder.addData(key!!, intent.extras!![key].toString())
                }
                onMessageReceived(builder.build())
            } else {
                super.handleIntent(intent)
            }
        } catch (e: java.lang.Exception) {
            super.handleIntent(intent)
        }
    }
}