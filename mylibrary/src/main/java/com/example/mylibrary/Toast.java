package com.example.mylibrary;

import android.content.Context;
/**
 * @author May 2022.7.23
 * */
public class Toast {
    /**
     * Toast 短时间输出
     * @param msg 输出的信息
     * */
    public static void ptShort(Context context, CharSequence msg){
        android.widget.Toast.makeText(context, msg, android.widget.Toast.LENGTH_SHORT).show();
    }
    /**
     * Toast 长时间输出
     * @param msg 输出的信息
     * */
    public static void ptLong(Context context, CharSequence msg){
        android.widget.Toast.makeText(context, msg, android.widget.Toast.LENGTH_LONG).show();
    }
}
