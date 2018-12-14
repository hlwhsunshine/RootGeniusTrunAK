package com.tencent.stat;

/* renamed from: com.tencent.stat.w */
final class C1765w implements StatDispatchCallback {
    C1765w() {
    }

    public final void onDispatchFailure() {
        StatServiceImpl.m4644d();
    }

    public final void onDispatchSuccess() {
        StatServiceImpl.m4643c();
    }
}
