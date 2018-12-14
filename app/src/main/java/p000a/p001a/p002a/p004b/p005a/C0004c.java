package p000a.p001a.p002a.p004b.p005a;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: a.a.a.b.a.c */
public final class C0004c {
    /* renamed from: a */
    protected Mac f13a;
    /* renamed from: b */
    protected int f14b;
    /* renamed from: c */
    protected String f15c;

    public C0004c(String str) {
        this.f15c = str;
        try {
            this.f13a = Mac.getInstance(str);
            this.f14b = this.f13a.getMacLength();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public final int mo10a() {
        return this.f14b;
    }

    /* renamed from: a */
    public final void mo11a(byte[] bArr) {
        try {
            this.f13a.init(new SecretKeySpec(bArr, this.f15c));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public final void mo12a(byte[] bArr, int i, int i2) {
        try {
            this.f13a.update(bArr, i, i2);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    public final byte[] mo13b() {
        return this.f13a.doFinal();
    }

    /* renamed from: b */
    public final byte[] mo14b(byte[] bArr) {
        return this.f13a.doFinal(bArr);
    }
}
