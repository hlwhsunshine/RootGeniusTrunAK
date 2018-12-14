package com.shuame.rootgenius.sdk.proto;

/* renamed from: com.shuame.rootgenius.sdk.proto.a */
final class C1475a implements Runnable {
    /* renamed from: a */
    private /* synthetic */ String f4070a;
    /* renamed from: b */
    private /* synthetic */ ProtoBase f4071b;

    C1475a(ProtoBase protoBase, String str) {
        this.f4071b = protoBase;
        this.f4070a = str;
    }

    public final void run() {
        this.f4071b.postReq(this.f4070a);
    }
}
