package com.kingroot.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/* renamed from: com.kingroot.sdk.de */
public class C0739de {
    /* renamed from: a */
    public static void m1794a(Context context, String str, long j) {
        context.getSharedPreferences("kingrootsdk", 0).edit().putLong(str, j).commit();
    }

    /* renamed from: a */
    public static void m1795a(Context context, String str, String str2) {
        context.getSharedPreferences("kingrootsdk", 0).edit().putString(str, str2).commit();
    }

    /* renamed from: a */
    public static void m1796a(Context context, String str, String str2, String str3) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("kingrootsdk", 0);
        String string = sharedPreferences.getString(str, "");
        if (string.length() > 0) {
            string = string + str3;
        }
        string = string + str2;
        Editor edit = sharedPreferences.edit();
        edit.putString(str, string);
        edit.commit();
    }

    /* renamed from: a */
    public static void m1797a(Context context, String str, String... strArr) {
        int i = 0;
        SharedPreferences sharedPreferences = context.getSharedPreferences("kingrootsdk", 0);
        String str2 = "__separator__";
        StringBuilder stringBuilder = new StringBuilder();
        int length = strArr.length;
        while (i < length) {
            stringBuilder.append(strArr[i]);
            stringBuilder.append(str2);
            i++;
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.delete(stringBuilder.length() - str2.length(), stringBuilder.length());
        }
        sharedPreferences.edit().putString(str, stringBuilder.toString()).commit();
    }

    /* renamed from: b */
    public static void m1798b(Context context, String str, int i) {
        context.getSharedPreferences("kingrootsdk", 0).edit().putInt(str, i).commit();
    }

    /* renamed from: c */
    public static int m1799c(Context context, String str) {
        return context.getSharedPreferences("kingrootsdk", 0).getInt(str, 0);
    }

    /* renamed from: d */
    public static long m1800d(Context context, String str) {
        return context.getSharedPreferences("kingrootsdk", 0).getLong(str, 0);
    }

    /* renamed from: o */
    public static void m1801o(Context context, String str) {
        context.getSharedPreferences("kingrootsdk", 0).edit().remove(str).commit();
    }

    /* renamed from: p */
    public static String m1802p(Context context, String str) {
        return context.getSharedPreferences("kingrootsdk", 0).getString(str, null);
    }

    /* renamed from: q */
    public static String[] m1803q(Context context, String str) {
        String str2 = "__separator__";
        String string = context.getSharedPreferences("kingrootsdk", 0).getString(str, null);
        return string != null ? string.split(str2) : new String[0];
    }
}
