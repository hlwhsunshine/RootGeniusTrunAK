package com.shuame.rootgenius.sdk.p114a;

import com.shuame.rootgenius.sdk.C1473h;
import com.shuame.rootgenius.sdk.CommUtils;

/* renamed from: com.shuame.rootgenius.sdk.a.c */
public final class C1465c extends C1464b {
    /* renamed from: d */
    private String f4033d = null;

    public C1465c(String str) {
        super(str);
    }

    /* renamed from: h */
    public final boolean mo7265h() {
        return super.mo7264a(mo7257a() + "Data/res/KingUser.zip", null);
    }

    /* renamed from: i */
    public final String mo7266i() {
        if (this.f4033d == null) {
            this.f4033d = CommUtils.calcFileMd5(mo7257a() + "Data/res/KingUser.zip");
        }
        C1473h.m4103b("SuperuserBuildIn", "build in ku md5:" + this.f4033d);
        return this.f4033d;
    }
}
