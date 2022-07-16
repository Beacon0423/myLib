package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;

public class Utils {
    public static Uri getUriForFile(Context context, File file){
        Uri uri = null;
        String path = file.getAbsolutePath();
        Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{"_id"}, "_data=?", new String[]{path}, null);
        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getColumnIndex("_id");
            Uri baseUri = Uri.parse("content://media/external/image/media");
            uri = Uri.withAppendedPath(baseUri, ""+id);
        } else if (file.exists()) {
            ContentValues values = new ContentValues();
            values.put("_data", path);
            uri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        }
        return uri;
    }
}
