package com.kingroot.sdk;

import java.io.Serializable;

/* renamed from: com.kingroot.sdk.gy */
public abstract class C0597gy implements Serializable {
    /* renamed from: a */
    public abstract void mo5569a(C0863gw c0863gw);

    /* renamed from: a */
    public abstract void mo5570a(C0864gx c0864gx);

    /* renamed from: a */
    public void mo5571a(StringBuilder stringBuilder, int i) {
    }

    public byte[] toByteArray() {
        C0864gx c0864gx = new C0864gx();
        mo5570a(c0864gx);
        return c0864gx.toByteArray();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        mo5571a(stringBuilder, 0);
        return stringBuilder.toString();
    }
}
