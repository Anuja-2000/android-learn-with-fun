package com.example.learnwithfun.util;

import android.util.Log;

public class LogUtil {

    public static void error(String tag , String error){
        Log.e(tag,error);
    }

    public static void debug(String tag , String error){
        Log.d(tag,error);
    }

    public static void warning(String tag , String error){
        Log.w(tag,error);
    }

}
