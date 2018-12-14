package com.nostra13.universalimageloader.p057a.p058a.p059a.p060a;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.nostra13.universalimageloader.a.a.a.a.f */
final class C0982f extends ByteArrayOutputStream {
    /* renamed from: a */
    final /* synthetic */ C0981e f2464a;

    C0982f(C0981e c0981e, int i) {
        this.f2464a = c0981e;
        super(i);
    }

    public final String toString() {
        int i = (this.count <= 0 || this.buf[this.count - 1] != (byte) 13) ? this.count : this.count - 1;
        try {
            return new String(this.buf, 0, i, this.f2464a.f2460b.name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
