package com.tencent.mid.p117b;

import android.content.Context;
import android.provider.Settings.System;
import com.tencent.mid.util.Util;

/* renamed from: com.tencent.mid.b.e */
public class C1648e extends C1645f {
    public C1648e(Context context) {
        super(context);
    }

    /* renamed from: a */
    public int mo7645a() {
        return 1;
    }

    /* renamed from: a */
    protected void mo7647a(C1643a c1643a) {
        synchronized (this) {
            Util.logInfo("write CheckEntity to Settings.System:" + c1643a.toString());
            System.putString(this.f4694a.getContentResolver(), C1645f.m4499h(), c1643a.toString());
        }
    }

    /* renamed from: a */
    protected void mo7648a(String str) {
        synchronized (this) {
            Util.logInfo("write mid to Settings.System");
            System.putString(this.f4694a.getContentResolver(), mo7659l(), str);
        }
    }

    /* renamed from: b */
    protected boolean mo7651b() {
        return Util.checkPermission(this.f4694a, "android.permission.WRITE_SETTINGS");
    }

    /* renamed from: c */
    protected String mo7652c() {
        String string;
        synchronized (this) {
            Util.logInfo("read mid from Settings.System");
            string = System.getString(this.f4694a.getContentResolver(), mo7659l());
        }
        return string;
    }

    /* renamed from: d */
    protected void mo7654d() {
        synchronized (this) {
            System.putString(this.f4694a.getContentResolver(), mo7659l(), "");
            System.putString(this.f4694a.getContentResolver(), C1645f.m4499h(), "");
        }
    }

    /* renamed from: e */
    protected C1643a mo7655e() {
        C1643a c1643a;
        synchronized (this) {
            c1643a = new C1643a(System.getString(this.f4694a.getContentResolver(), C1645f.m4499h()));
            Util.logInfo("read readCheckEntity from Settings.System:" + c1643a.toString());
        }
        return c1643a;
    }
}
