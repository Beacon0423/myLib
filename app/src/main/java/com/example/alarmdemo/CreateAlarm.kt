package com.example.alarmdemo

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * @author pjs 220718
 * */
object CreateAlarm {
    /**
     * 创建PendingIntent
     * @author pjs
     * */
    @SuppressLint("UnspecifiedImmutableFlag")
    fun createPending(context: Context, intent: Intent, requestCode: Int): PendingIntent {
        val i = Intent("toAlarmReceiver")
        Log.e("test1", "createPending: ${intent.getIntExtra("time", 0)}")
        i.putExtra("title", intent.getIntExtra("time", 0).toString())
        i.component =
            ComponentName(context.packageName, "${context.packageName}.receiver.AlarmReceiver")
        return PendingIntent.getBroadcast(
            context,
            requestCode,
            i,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }

}