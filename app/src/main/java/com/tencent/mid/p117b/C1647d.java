package com.tencent.mid.p117b;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mid.util.Util;

/* renamed from: com.tencent.mid.b.d */
public class C1647d extends C1645f {
    public C1647d(Context context) {
        super(context);
    }

    /* renamed from: a */
    public int mo7645a() {
        return 4;
    }

    /* renamed from: a */
    protected void mo7647a(C1643a c1643a) {
        synchronized (this) {
            Util.logInfo("write CheckEntity to sharedPreferences:" + c1643a.toString());
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f4694a).edit();
            edit.putString(C1645f.m4499h(), c1643a.toString());
            edit.commit();
        }
    }

    /* renamed from: a */
    protected void mo7648a(String str) {
        synchronized (this) {
            Util.logInfo("write mid to sharedPreferences");
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f4694a).edit();
            edit.putString(mo7659l(), str);
            edit.commit();
        }
    }

    /* renamed from: b */
    protected boolean mo7651b() {
        return true;
    }

    /* renamed from: c */
    protected String mo7652c() {
        String string;
        synchronized (this) {
            Util.logInfo("read mid from sharedPreferences");
            string = PreferenceManager.getDefaultSharedPreferences(this.f4694a).getString(mo7659l(), null);
        }
        return string;
    }

    /* renamed from: d */
    protected void mo7654d() {
        synchronized (this) {
            Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f4694a).edit();
            edit.putString(mo7659l(), "");
            edit.putString(C1645f.m4499h(), "");
            edit.commit();
        }
    }

    /* renamed from: e */
    protected C1643a mo7655e() {
        C1643a c1643a;
        synchronized (this) {
            c1643a = new C1643a(PreferenceManager.getDefaultSharedPreferences(this.f4694a).getString(C1645f.m4499h(), null));
            Util.logInfo("read CheckEntity from sharedPreferences:" + c1643a.toString());
        }
        return c1643a;
    }
}
