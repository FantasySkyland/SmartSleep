package com.example.zhengdengyao.smartsleep;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zhengdengyao on 2018/2/5.
 */

public class SpUtil {

    /**
     * sharepreference`s file name.
     */
    public static final String FILE_NAME = "dayima_data";
    private static SharedPreferences sp;

    public static void putBoolean(Context context, String key, boolean defValue ){
        if (sp == null){
            sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putBoolean(key,defValue).apply();

    }
    public static boolean getBoolean(Context context, String key, boolean defValue ){
        if (sp == null){
            sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        }
        return sp.getBoolean(key,defValue);
    }
    public static void putString(Context context, String key, String defValue ){
        if (sp == null){
            sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putString(key,defValue).apply();
    }
    public static String getString(Context context, String key, String defValue ){
        if (sp == null){
            sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        }
        return sp.getString(key,defValue);
    }
    public static void putInt(Context context, String key, int defValue ){
        if (sp == null){
            sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putInt(key,defValue).apply();
    }
    public static int getInt(Context context, String key, int defValue ) {
        if (sp == null) {
             sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        }
        return sp.getInt(key, defValue);
    }
    public static void putLong(Context context, String key, long defValue ){
        if (sp == null){
            sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        }
        sp.edit().putLong(key,defValue).apply();
    }
    public static long getLong(Context context, String key, long defValue ) {
        if (sp == null) {
            sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        }
        return sp.getLong(key, defValue);
    }
}
