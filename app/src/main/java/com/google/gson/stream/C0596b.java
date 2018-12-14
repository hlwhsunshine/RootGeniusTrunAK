package com.google.gson.stream;

import com.google.gson.internal.C0581q;
import com.google.gson.internal.p053a.C0532g;

/* renamed from: com.google.gson.stream.b */
final class C0596b extends C0581q {
    C0596b() {
    }

    /* renamed from: a */
    public final void mo5538a(C0531a c0531a) {
        if (c0531a instanceof C0532g) {
            ((C0532g) c0531a).mo5502o();
            return;
        }
        int a = c0531a.f1311i;
        if (a == 0) {
            a = c0531a.mo5502o();
        }
        if (a == 13) {
            c0531a.f1311i = 9;
        } else if (a == 12) {
            c0531a.f1311i = 8;
        } else if (a == 14) {
            c0531a.f1311i = 10;
        } else {
            throw new IllegalStateException("Expected a name but was " + c0531a.mo5490f() + "  at line " + (c0531a.f1309g + 1) + " column " + c0531a.m1136u() + " path " + c0531a.mo5500q());
        }
    }
}
