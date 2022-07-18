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
import com.example.alarmdemo.CreateAlarm


class AlarmService : Service() {
    private var manager: AlarmManager? = null
    private var pendingIntent: PendingIntent? = null
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        if (intent != null) {
            Log.i("test1", "startID: $startId")
            val manager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
//            if (startId > 1) {
//                manager.cancel(CreateAlarm.createPending(this, intent, startId-1))
//            }
            pendingIntent = CreateAlarm.createPending(this, intent, startId)
            val time = intent.getIntExtra("time", 0)
            manager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + time * 1000L,
                60*1000L,
                pendingIntent
            )
        }
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.e("test1", "onDestroy: ")
        super.onDestroy()

    }
}