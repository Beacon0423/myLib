package com.example.tools

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.util.Log
import java.lang.Exception
import java.util.*

/**
 * @author beacon0423
 * 2022.7.17
 * */
object TimeUtil {
    /**
     * 将数据库中的周期，转换为距离此刻的时间
     *
     * @param input 输入的周期的数字
     * @param num 选择的周期的单位对应的下标
     *
     * @return 返回Long型 单位秒
     * */
    @JvmStatic
    fun cycToTime(input: Int, num: Int): Long {
        return when (num) {
            0 -> input * 3600 * 24L
            1 -> input * 3600 * 24 * 7L
            2 -> input * 3600 * 24 * 30L
            3 -> input * 3600 * 24 * 365L
            else -> 0L
        }
    }
    @JvmStatic
    fun dateDisplay(date: String): String {
        if (date.length != 6) return ""
        return if (date[2] == '0') {
            if (date[4] == '0') {
                "20${date.substring(0, 2)}年${date.substring(3, 4)}月${date.substring(5, 6)}日"
            } else {
                "20${date.substring(0, 2)}年${date.substring(3, 4)}月${date.substring(4, 6)}日"
            }
        } else {
            if (date[4] == '0') {
                "20${date.substring(0, 2)}年${date.substring(2, 4)}月${date.substring(5, 6)}日"
            } else {
                "20${date.substring(0, 2)}年${date.substring(2, 4)}月${date.substring(4, 6)}日"
            }
        }
    }
    @JvmStatic
    fun cycToNumber(cyc: String): ArrayList<Int>? {
        val list = ArrayList<Int>()
        val num = cyc.substring(0, cyc.length - 1)
        list.add(Integer.parseInt(num))
        when (cyc[cyc.length - 1]) {
            '天' -> {
                list.add(0)
            }
            '周' -> {
                list.add(1)
            }
            '月' -> {
                list.add(2)
            }
            '年' -> {
                list.add(3)
            }
            else -> {
                return null
            }
        }
        return list
    }

    /**
     * 将HH:mm格式的时间转为Int数据类型
     * */
    @JvmStatic
    fun timeToNumber(time: String): Int {
        if (time.length != 5) return 0
        val res = time.substring(0, 2) + time.substring(3, 5)
        return res.toInt()
    }

    /**
     * 获取当前时间，格式为HH:mm
     * */
    @JvmStatic
    fun getNowTime(): String {
        val timeFormat = SimpleDateFormat("HH:mm", Locale.CHINA)
        return timeFormat.format(Calendar.getInstance().time)
    }

    /**
     * 获取当前日期，格式为ArrayList<Int>
     * */
    @JvmStatic
    fun getNowDate(): ArrayList<Int> {
        val list = ArrayList<Int>()
        val c = Calendar.getInstance()
        list.add(c.get(Calendar.YEAR))
        list.add(c.get(Calendar.MONTH))
        list.add(c.get(Calendar.DAY_OF_MONTH))
        return list
    }

    /**
     * 获取两个时间的间隔,返回天数
     * */
    @JvmStatic
    fun getSpacingDate(from: Date, to: Date): Int {
        val cFrom = Calendar.getInstance()
        cFrom.let {
            it.time = from
            it.set(Calendar.HOUR_OF_DAY, 0)
            it.set(Calendar.MINUTE, 0)
            it.set(Calendar.SECOND, 0)
            it.set(Calendar.MILLISECOND, 0)
        }
        val cTo = Calendar.getInstance()
        cTo.let {
            it.time = to
            it.set(Calendar.HOUR_OF_DAY, 0)
            it.set(Calendar.MINUTE, 0)
            it.set(Calendar.SECOND, 0)
            it.set(Calendar.MILLISECOND, 0)
        }
        Log.e("TAG", "cTo: ${cTo.time} cFrom: ${cFrom.time}")
        return ((cTo.time.time - cFrom.time.time) / (1000 * 3600 * 24)).toInt()
    }

    /**
     * 获取距离下一次提醒的时间,return 单位s,Long型
     * */
    @JvmStatic
    fun getNextTime(days: Int, hour: Int, min: Int, cycTime: Long): Long {
        val h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val m = Calendar.getInstance().get(Calendar.MINUTE)
        val addition = hour * 3600 + min * 60 - h * 3600 - m * 60
        Log.e("TAG", "getNextTime: addition $addition")
        return if (days > 0) {
            Log.e("TAG", "getNextTime: $days")
            days * 3600 * 24L + addition
        } else if (addition > 0) {
            addition.toLong()
        } else {
            cycTime + addition
        }
    }

    /**
     * @param date 格式为yyMMdd
     * */
    @JvmStatic
    fun stringToDate(date: String): Date {
        val yy = "20${date.substring(0, 2)}".toInt()
        val mm = date.substring(2, 4).toInt()
        val dd = date.substring(4, 6).toInt()
        Log.e("TAG", "stringToDate:yy:$yy mm:$mm dd:$dd")
        val calendar = Calendar.getInstance()
        calendar.let {
            it.set(Calendar.YEAR, yy)
            it.set(Calendar.MONTH, mm - 1)
            it.set(Calendar.DAY_OF_MONTH, dd)
        }
        Log.e("TAG", "stringToDate: ${calendar.time}")
        return calendar.time
    }

    /**
     * 日期格式切换,yyyy-MM-dd<-->yyMMdd
     * */
    @JvmStatic
    fun dateFormat(date: String): String {
        return when (date.length) {
            10 -> {
                date.substring(2, 4) + date.substring(5, 7) + date.substring(8, 10)
            }
            6 -> {
                "20${date.substring(0, 2)}-${date.substring(2, 4)}-${date.substring(4, 6)}"
            }
            else -> {
                throw Exception("The string is not allowed in TimeUtil.dateFormat")
            }
        }
    }
    /**
     * 从nextTime或者cycTime换算成下次提醒的日期
     * */
//    fun getNextDate(date: String, nextTime: Long): Date{
//        val calendar = stringToDate(date)
//
//    }

}