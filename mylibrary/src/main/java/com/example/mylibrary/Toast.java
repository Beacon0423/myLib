package com.example.mylibrary;

import android.content.Context;

public class Toast {
    public static void pt(Context context, String msg){
        android.widget.Toast.makeText(context, msg, android.widget.Toast.LENGTH_SHORT).show();
    }
}
