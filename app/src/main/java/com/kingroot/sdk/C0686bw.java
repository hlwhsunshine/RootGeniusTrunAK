package com.kingroot.sdk;

import android.content.Context;
import com.kingroot.sdk.util.Cryptor;
import java.io.ByteArrayInputStream;

/* renamed from: com.kingroot.sdk.bw */
public abstract class C0686bw {
    /* renamed from: B */
    public ByteArrayInputStream mo5656B(String str) {
        Context context = C0741dg.m1804aL().f1805el;
        byte[] W = C0840gd.m2166W(str);
        if (W == null) {
            W = new byte[0];
        }
        return new ByteArrayInputStream(Cryptor.m2367d(context, W));
    }

    /* renamed from: a */
    public void mo5657a(String str, byte[] bArr) {
        Context context = C0741dg.m1804aL().f1805el;
        if (bArr == null) {
            bArr = new byte[0];
        }
        C0840gd.m2168a(Cryptor.m2363b(context, bArr), str);
    }
}
