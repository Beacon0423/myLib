package com.example.alarmdemo

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.alarmdemo.databinding.ActivityMainBinding
import com.example.alarmdemo.receiver.AlarmReceiver
import com.example.alarmdemo.service.AlarmService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ShortAlarm")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //注册NotificationChannel，Android8之后需要，可根据自己选择
        val channel = NotificationChannel("xxm", "通知", NotificationManager.IMPORTANCE_HIGH)
        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
        //动态注册BroadcastReceiver
        val receiver = AlarmReceiver()
        val filter = IntentFilter()
        filter.addAction("toAlarmReceiver")
        registerReceiver(receiver, filter)
        //点击函数
        click()
    }

    private fun click() {
        binding.btn.setOnClickListener {
            val input = binding.edt.text.toString().trim()
            if (input.isNotEmpty()) {
                val intent = Intent(this, AlarmService::class.java)
                intent.putExtra("time", input.toInt())
                startService(intent)
            }
        }

    }
}