package com.example.toast

import android.content.Context
import android.widget.Toast

/**
 * @author May 2022.07.23
 */
class Toast {
    /**
     * 短时间输出Toast
     * @param msg 输出的信息
     */
    fun ptShort(content: Context, msg: CharSequence){
        Toast.makeText(content, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * 长间输出Toast
     * @param msg 输出的信息
     */
    fun ptLong(content: Context, msg: CharSequence){
        Toast.makeText(content, msg, Toast.LENGTH_LONG).show()
    }
}