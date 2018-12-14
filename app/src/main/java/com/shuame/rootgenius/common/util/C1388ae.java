package com.shuame.rootgenius.common.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import com.shuame.rootgenius.common.C1325c;
import com.shuame.rootgenius.hook.C1450R;

/* renamed from: com.shuame.rootgenius.common.util.ae */
public final class C1388ae {
    /* renamed from: b */
    private static C1388ae f3859b = new C1388ae();
    /* renamed from: a */
    private AlarmManager f3860a = ((AlarmManager) C1325c.m3724a().getSystemService("alarm"));

    private C1388ae() {
    }

    /* renamed from: a */
    public static C1388ae m3880a() {
        return f3859b;
    }

    /* renamed from: c */
    private static PendingIntent m3881c(String str) {
        return PendingIntent.getBroadcast(C1325c.m3724a(), C1450R.string.app_name, new Intent(str), 134217728);
    }

    /* renamed from: a */
    public final void mo7114a(String str) {
        this.f3860a.setRepeating(0, System.currentTimeMillis() + 43210000, 43210000, C1388ae.m3881c(str));
    }

    /* renamed from: b */
    public final void mo7115b(String str) {
        this.f3860a.set(0, System.currentTimeMillis() + 172800000, C1388ae.m3881c(str));
    }
}
