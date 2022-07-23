package com.example.mylibrary;

import android.content.Context;

public class Toast {
    public static void ptShort(Context context, CharSequence msg){
        android.widget.Toast.makeText(context, msg, android.widget.Toast.LENGTH_SHORT).show();
    }
    public static void ptLong(Context context, CharSequence msg){
        android.widget.Toast.makeText(context, msg, android.widget.Toast.LENGTH_LONG).show();
    }
}
