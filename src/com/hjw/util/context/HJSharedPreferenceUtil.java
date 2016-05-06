package com.hjw.util.context;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import com.hjw.core.HJLibrary;

/**
 * 默认的SharedPreference工具类
 * @author hjw
 * @date 2015年3月8日
 */
public class HJSharedPreferenceUtil {

    public static String getString(final String key, final String defaultValue)
    {
        final SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(HJLibrary.getContext());
        return sp.getString(key, defaultValue);
    }

    public static void setString(final String key, final String value)
    {
        final SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(HJLibrary.getContext());
        sp.edit().putString(key, value).commit();
    }

    public static boolean getBoolean(final String key,
            final boolean defaultValue)
    {
        final SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(HJLibrary.getContext());
        return sp.getBoolean(key, defaultValue);
    }

    public static void setBoolean(final String key, final boolean value)
    {
        final SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(HJLibrary.getContext());
        sp.edit().putBoolean(key, value).commit();
    }

    public static void setInt(final String key, final int value)
    {
        final SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(HJLibrary.getContext());
        sp.edit().putInt(key, value).commit();
    }

    public static int getInt(final String key, final int defaultValue)
    {
        final SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(HJLibrary.getContext());
        return sp.getInt(key, defaultValue);
    }

    public static void setFloat(final String key, final float value)
    {
        final SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(HJLibrary.getContext());
        sp.edit().putFloat(key, value).commit();
    }

    public static float getFloat(final String key, final float defaultValue)
    {
        final SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(HJLibrary.getContext());
        return sp.getFloat(key, defaultValue);
    }

    public static void setLong(final String key, final long value)
    {
        final SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(HJLibrary.getContext());
        sp.edit().putLong(key, value).commit();
    }

    public static long getLong(final String key, final long defaultValue)
    {
        final SharedPreferences sp = PreferenceManager
                .getDefaultSharedPreferences(HJLibrary.getContext());
        return sp.getLong(key, defaultValue);
    }

    // ====================SharedPreferences 管理========================
    public static void clearPreference(final SharedPreferences p)
    {
        final Editor editor = p.edit();
        editor.clear();
        editor.commit();
    }

    public static boolean hasKey(final String key)
    {
        return PreferenceManager.getDefaultSharedPreferences(
                HJLibrary.getContext()).contains(key);
    }

    public static void remove(final String key, final SharedPreferences p)
    {
        final Editor editor = p.edit();
        editor.remove(key);
        editor.commit();
    }
}
