package com.google.gson.internal.p053a;

import com.google.gson.C0477r;
import com.google.gson.stream.C0531a;
import com.google.gson.stream.C0534c;
import com.google.gson.stream.JsonToken;
import java.net.InetAddress;

/* renamed from: com.google.gson.internal.a.ah */
final class C0505ah extends C0477r<InetAddress> {
    C0505ah() {
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo5377a(C0531a c0531a) {
        if (c0531a.mo5490f() != JsonToken.NULL) {
            return InetAddress.getByName(c0531a.mo5492h());
        }
        c0531a.mo5494j();
        return null;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo5378a(C0534c c0534c, Object obj) {
        InetAddress inetAddress = (InetAddress) obj;
        c0534c.mo5510b(inetAddress == null ? null : inetAddress.getHostAddress());
    }
}
