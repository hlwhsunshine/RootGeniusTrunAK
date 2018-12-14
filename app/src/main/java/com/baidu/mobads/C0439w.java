package com.baidu.mobads;

/* renamed from: com.baidu.mobads.w */
class C0439w implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f1115a;
    /* renamed from: b */
    final /* synthetic */ C0432v f1116b;

    C0439w(C0432v c0432v, String str) {
        this.f1116b = c0432v;
        this.f1115a = str;
    }

    public void run() {
        this.f1116b.f990d.onUrl(this.f1115a);
    }
}
