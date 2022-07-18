package com.example.alarmdemo.receiver

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.alarmdemo.MainActivity
import com.example.alarmdemo.R

class AlarmReceiver : BroadcastReceiver() {
    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onReceive(context: Context, intent: Intent) {
        Log.e("test1", "onReceive: ${intent.getStringExtra("title")}")
        val title = intent.getStringExtra("title")
        val notify = NotificationCompat.Builder(context, "xxm")
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .setContentTitle(title)
            .setContentIntent(
                PendingIntent.getActivity(
                    context,
                    1,
                    Intent(context, MainActivity::class.java),
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
            )
            .setAutoCancel(true)
            .setContentText("看通知，看通知哦！").build()
        val manager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(Integer.parseInt(title!!), notify)
    }
}

