package com.shuame.rootgenius.sdk;

/* renamed from: com.shuame.rootgenius.sdk.b */
final class C1467b implements Runnable {
    /* renamed from: a */
    private /* synthetic */ String f4034a;
    /* renamed from: b */
    private /* synthetic */ String f4035b;

    C1467b(String str, String str2) {
        this.f4034a = str;
        this.f4035b = str2;
    }

    public final void run() {
        JniHelper.postData(this.f4034a, this.f4035b);
    }
}
