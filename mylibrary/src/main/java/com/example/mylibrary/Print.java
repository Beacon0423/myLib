package com.example.mylibrary;

import android.content.Context;
import android.widget.Toast;

public class Print {
    public static void pt(Context context, String msg){
        Toast.makeText(context, msg, android.widget.Toast.LENGTH_SHORT).show();
    }
}
