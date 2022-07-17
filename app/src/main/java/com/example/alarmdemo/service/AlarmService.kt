package com.example.alarmdemo.service

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log


class AlarmService : Service() {
    private lateinit var manager: AlarmManager
    private lateinit var pendingIntent: PendingIntent
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        manager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val i = Intent("toAlarmReceiver")
        i.putExtra("title", intent.getIntExtra("time", 0).toString())
        Log.i("test1", "onStartCommand: $packageName, $packageName.receiver.AlarmReceiver")
        i.component = ComponentName(packageName, "$packageName.receiver.AlarmReceiver")
        pendingIntent =
            PendingIntent.getBroadcast(this, 0, i, PendingIntent.FLAG_CANCEL_CURRENT)
        val time = intent.getIntExtra("time", 0)
        manager.setAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis() + time * 1000L,
            pendingIntent
        )
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        val list: ArrayList<PendingIntent> = arrayListOf()

        manager.cancel(pendingIntent)
        Log.i("test1", "onDestroy: ")
    }
}