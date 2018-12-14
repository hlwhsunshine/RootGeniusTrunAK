package com.baidu.mobads.p021j;

import android.content.SharedPreferences;
import android.os.Build.VERSION;

/* renamed from: com.baidu.mobads.j.o */
class C0340o implements Runnable {
    /* renamed from: a */
    final /* synthetic */ SharedPreferences f708a;
    /* renamed from: b */
    final /* synthetic */ String f709b;
    /* renamed from: c */
    final /* synthetic */ C0339n f710c;

    C0340o(C0339n c0339n, SharedPreferences sharedPreferences, String str) {
        this.f710c = c0339n;
        this.f708a = sharedPreferences;
        this.f709b = str;
    }

    public void run() {
        if (VERSION.SDK_INT >= 9) {
            this.f708a.edit().putString("imei", this.f709b).apply();
        } else {
            this.f708a.edit().putString("imei", this.f709b).commit();
        }
    }
}
