package com.tencent.stat.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.stat.StatConfig;
import java.util.Map;

public class StatPreferences {
    /* renamed from: a */
    private static SharedPreferences f5039a = null;

    /* renamed from: a */
    static synchronized SharedPreferences m4731a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (StatPreferences.class) {
            if (f5039a == null) {
                try {
                    if (StatConfig.getMTAPreferencesFileName() == null || StatConfig.getMTAPreferencesFileName().trim().length() == 0) {
                        f5039a = PreferenceManager.getDefaultSharedPreferences(context);
                    } else {
                        f5039a = context.getSharedPreferences(StatConfig.getMTAPreferencesFileName(), 0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            sharedPreferences = f5039a;
        }
        return sharedPreferences;
    }

    public static boolean contains(Context context, String str) {
        return m4731a(context).contains(StatCommonHelper.getTagForConcurrentProcess(context, str));
    }

    public static Map<String, ?> getAll(Context context) {
        return m4731a(context).getAll();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return m4731a(context).getBoolean(StatCommonHelper.getTagForConcurrentProcess(context, str), z);
    }

    public static float getFloat(Context context, String str, float f) {
        return m4731a(context).getFloat(StatCommonHelper.getTagForConcurrentProcess(context, str), f);
    }

    public static int getInt(Context context, String str, int i) {
        return m4731a(context).getInt(StatCommonHelper.getTagForConcurrentProcess(context, str), i);
    }

    public static long getLong(Context context, String str, long j) {
        return m4731a(context).getLong(StatCommonHelper.getTagForConcurrentProcess(context, str), j);
    }

    public static String getString(Context context, String str, String str2) {
        return m4731a(context).getString(StatCommonHelper.getTagForConcurrentProcess(context, str), str2);
    }

    public static void putBoolean(Context context, String str, boolean z) {
        String tagForConcurrentProcess = StatCommonHelper.getTagForConcurrentProcess(context, str);
        Editor edit = m4731a(context).edit();
        edit.putBoolean(tagForConcurrentProcess, z);
        edit.commit();
    }

    public static void putFloat(Context context, String str, float f) {
        String tagForConcurrentProcess = StatCommonHelper.getTagForConcurrentProcess(context, str);
        Editor edit = m4731a(context).edit();
        edit.putFloat(tagForConcurrentProcess, f);
        edit.commit();
    }

    public static void putInt(Context context, String str, int i) {
        String tagForConcurrentProcess = StatCommonHelper.getTagForConcurrentProcess(context, str);
        Editor edit = m4731a(context).edit();
        edit.putInt(tagForConcurrentProcess, i);
        edit.commit();
    }

    public static void putLong(Context context, String str, long j) {
        String tagForConcurrentProcess = StatCommonHelper.getTagForConcurrentProcess(context, str);
        Editor edit = m4731a(context).edit();
        edit.putLong(tagForConcurrentProcess, j);
        edit.commit();
    }

    public static void putString(Context context, String str, String str2) {
        String tagForConcurrentProcess = StatCommonHelper.getTagForConcurrentProcess(context, str);
        Editor edit = m4731a(context).edit();
        edit.putString(tagForConcurrentProcess, str2);
        edit.commit();
    }
}
