package com.example.alarmdemo.receiver

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.alarmdemo.R

class AutoReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.i("test1", "onReceive: ")
        val notify = NotificationCompat.Builder(context, "xxm")
            .setSmallIcon(R.mipmap.ic_launcher_round)
     //       .setTicker("TickerText: 有信息，有信息！！")
            .setContentTitle("标题")
            .setContentText("看通知，看通知哦！").build()
        val manager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(1, notify)
    }
}

