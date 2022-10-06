package com.example.toast

import android.content.Context
import android.widget.Toast
import es.dmoral.toasty.Toasty

/**
 * @author May 2022.07.23
 */
object Toast {
    /**
     * 短时间输出Toast
     * @param msg 输出的信息
     */
    @JvmStatic
    fun ptShort(context: Context, msg: CharSequence){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * 长间输出Toast
     * @param msg 输出的信息
     */
    @JvmStatic
    fun ptLong(context: Context, msg: CharSequence){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

    /**
     * 成功Toast
     * @param msg 输出的信息
     */
    @JvmStatic
    fun success(context: Context, msg: CharSequence) {
        Toasty.success(context, msg).show()
    }

    /**
     * 提示信息Toast
     * @param msg 输出的信息
     */
    @JvmStatic
    fun info(context: Context, msg: CharSequence) {
        Toasty.info(context, msg).show()
    }

    /**
     * 错误信息Toast
     * @param msg 输出的信息
     */
    @JvmStatic
    fun error(context: Context, msg: CharSequence) {
        Toasty.error(context, msg).show()
    }

    /**
     * 警告信息Toast
     * @param msg 输出的信息
     */
    @JvmStatic
    fun warning(context: Context, msg: CharSequence) {
        Toasty.warning(context, msg).show()
    }
}