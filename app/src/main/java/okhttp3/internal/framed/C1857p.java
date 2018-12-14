package okhttp3.internal.framed;

import okhttp3.internal.C1910m;
import okio.ByteString;

/* renamed from: okhttp3.internal.framed.p */
public final class C1857p {
    /* renamed from: a */
    public static final ByteString f5481a = ByteString.encodeUtf8(":status");
    /* renamed from: b */
    public static final ByteString f5482b = ByteString.encodeUtf8(":method");
    /* renamed from: c */
    public static final ByteString f5483c = ByteString.encodeUtf8(":path");
    /* renamed from: d */
    public static final ByteString f5484d = ByteString.encodeUtf8(":scheme");
    /* renamed from: e */
    public static final ByteString f5485e = ByteString.encodeUtf8(":authority");
    /* renamed from: f */
    public static final ByteString f5486f = ByteString.encodeUtf8(":host");
    /* renamed from: g */
    public static final ByteString f5487g = ByteString.encodeUtf8(":version");
    /* renamed from: h */
    public final ByteString f5488h;
    /* renamed from: i */
    public final ByteString f5489i;
    /* renamed from: j */
    final int f5490j;

    public C1857p(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public C1857p(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public C1857p(ByteString byteString, ByteString byteString2) {
        this.f5488h = byteString;
        this.f5489i = byteString2;
        this.f5490j = (byteString.size() + 32) + byteString2.size();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1857p)) {
            return false;
        }
        C1857p c1857p = (C1857p) obj;
        return this.f5488h.equals(c1857p.f5488h) && this.f5489i.equals(c1857p.f5489i);
    }

    public final int hashCode() {
        return ((this.f5488h.hashCode() + 527) * 31) + this.f5489i.hashCode();
    }

    public final String toString() {
        return C1910m.m5445a("%s: %s", this.f5488h.utf8(), this.f5489i.utf8());
    }
}
