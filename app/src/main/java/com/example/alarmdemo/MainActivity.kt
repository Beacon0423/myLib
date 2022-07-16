package com.example.alarmdemo

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import com.example.alarmdemo.receiver.AutoReceiver
import com.example.alarmdemo.service.AlarmService

class MainActivity : AppCompatActivity() {
    @SuppressLint("ShortAlarm")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val channel = NotificationChannel("xxm", "通知", NotificationManager.IMPORTANCE_HIGH)
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)

        val receiver = AutoReceiver()
        val filter = IntentFilter()
        filter.addAction("toAlarmReceiver")
        registerReceiver(receiver, filter)

        val intent = Intent(this, AlarmService::class.java)
        intent.putExtra("time", 5)
        startService(intent)
    }
}