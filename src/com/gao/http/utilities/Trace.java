package com.gao.http.utilities;

import android.util.Log;

public class Trace {

    private static final String TAG = "HttpFrame";

    public static void d(String msg) {
        Log.d(TAG, msg);
    }
    
    public static void e(String msg) {
        Log.e(TAG, msg);
    }
}
