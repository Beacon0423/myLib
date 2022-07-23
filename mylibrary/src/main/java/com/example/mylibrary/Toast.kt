package com.example.mylibrary

import android.content.Context
import android.widget.Toast
/**
 * @author Beacon0423 2022.07.23
 * */
object Toast {
    /**
     * 显示短时间的Toast
     * @param msg 输出的信息
     * */
    fun ptShort(context: Context, msg: CharSequence){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
    /**
     * 显示长时间的Toast
     * @param msg 输出的信息
     * */
    fun ptLong(context: Context, msg: CharSequence){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }
}