package com.shuame.rootgenius.common.event;

/* renamed from: com.shuame.rootgenius.common.event.g */
public class C1342g {
    /* renamed from: a */
    private static final String f3660a = C1342g.class.getSimpleName();
    /* renamed from: b */
    private static volatile C1342g f3661b;

    private C1342g() {
    }

    /* renamed from: a */
    public static C1342g m3746a() {
        if (f3661b == null) {
            synchronized (C1342g.class) {
                if (f3661b == null) {
                    f3661b = new C1342g();
                }
            }
        }
        return f3661b;
    }

    /* renamed from: a */
    public final void mo7012a(C1341f c1341f) {
        new C1343h(this, c1341f).start();
    }
}
