package okhttp3;

import okhttp3.internal.C1910m;
import okio.C1937g;

/* renamed from: okhttp3.z */
public abstract class C1788z {
    /* renamed from: a */
    public static C1788z m4880a(C1925u c1925u, byte[] bArr) {
        int length = bArr.length;
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        C1910m.m5451a((long) bArr.length, (long) length);
        return new C1789aa(c1925u, length, bArr);
    }

    /* renamed from: a */
    public abstract C1925u mo8611a();

    /* renamed from: a */
    public abstract void mo8612a(C1937g c1937g);

    /* renamed from: b */
    public long mo8613b() {
        return -1;
    }
}
