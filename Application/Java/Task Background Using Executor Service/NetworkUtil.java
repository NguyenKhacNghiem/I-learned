package com.example.taskbackgroundusingexecutorservice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.net.URL;

public class NetworkUtil {
    public static Bitmap fetchImage(String url) {
        Bitmap bitmap = null;

        try {
            InputStream inputStream = new URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        }
        catch (Exception e) {
            Log.e("Error", "Error loading image from URL: " + e.getMessage());
        }

        return bitmap;
    }
}
