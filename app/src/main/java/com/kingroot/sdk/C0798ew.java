package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.ew */
public class C0798ew extends C0793et {
    /* renamed from: a */
    public boolean mo5804a(C0716ga c0716ga) {
        if (C0846gi.m2195I() < 14) {
            return true;
        }
        C0836fz K = c0716ga.mo5683K("ku.sud --ping");
        return K.success() && K.f2085cs.trim().equals("kinguser_su");
    }

    /* renamed from: b */
    public boolean mo5805b(C0716ga c0716ga) {
        C0825fq.m2099g("check_su_files", "start daemon");
        if (c0716ga.mo5684f(true)) {
            c0716ga.mo5683K("/system/xbin/ku.sud -d");
        }
        return true;
    }
}
