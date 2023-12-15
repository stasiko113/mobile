package com.example.newapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtils {

    private static final String PREFERENCES_USER_NAME = "user";

    public static void saveString(Context context, String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_USER_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getString(Context context, String key, String defaultValue) {
        SharedPreferences preferences = context.getSharedPreferences(PREFERENCES_USER_NAME, Context.MODE_PRIVATE);
        return preferences.getString(key, defaultValue);
    }

    public static void saveInt(Context context, String key ,int value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_USER_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getInt(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_USER_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, 0);
    }
}