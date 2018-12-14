package com.baidu.mobads.p034h;

import android.text.TextUtils;
import com.baidu.mobads.p021j.C0338m;
import com.baidu.mobads.p025c.C0265a;

/* renamed from: com.baidu.mobads.h.r */
class C0319r implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0318q f603a;

    C0319r(C0318q c0318q) {
        this.f603a = c0318q;
    }

    public void run() {
        try {
            String a = this.f603a.m478a("key_crash_trace");
            String a2 = this.f603a.m478a("key_crash_ad");
            if (!TextUtils.isEmpty(a)) {
                C0265a.m334a().mo4398a(this.f603a.m478a("key_crash_source"), a, a2);
                this.f603a.m484d();
            }
        } catch (Throwable e) {
            C0338m.m569a().mo5033f().mo4928e(e);
        }
    }
}
