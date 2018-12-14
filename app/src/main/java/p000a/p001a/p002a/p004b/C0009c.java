package p000a.p001a.p002a.p004b;

import p000a.p001a.p002a.p004b.p006b.C0008b;
import p000a.p001a.p002a.p007c.C0010a;
import p000a.p001a.p002a.p009e.C0020f;

/* renamed from: a.a.a.b.c */
public final class C0009c implements C0005b {
    /* renamed from: a */
    private C0020f f41a;
    /* renamed from: b */
    private byte[] f42b = new byte[4];
    /* renamed from: c */
    private C0008b f43c;

    public C0009c(C0020f c0020f, byte[] bArr) {
        if (c0020f == null) {
            throw new C0010a("one of more of the input parameters were null in StandardDecryptor");
        }
        this.f41a = c0020f;
        this.f43c = new C0008b();
        m41a(bArr);
    }

    /* renamed from: a */
    private void m41a(byte[] bArr) {
        byte[] q = this.f41a.mo89q();
        this.f42b[3] = (byte) q[3];
        this.f42b[2] = (byte) (q[3] >> 8);
        this.f42b[1] = (byte) (q[3] >> 16);
        this.f42b[0] = (byte) (q[3] >>> 24);
        if (this.f42b[2] > (byte) 0 || this.f42b[1] > (byte) 0 || this.f42b[0] > (byte) 0) {
            throw new IllegalStateException("Invalid CRC in File Header");
        } else if (this.f41a.mo88p() == null || this.f41a.mo88p().length <= 0) {
            throw new C0010a("Wrong password!", 5);
        } else {
            this.f43c.mo23a(this.f41a.mo88p());
            try {
                int i = bArr[0];
                for (int i2 = 0; i2 < 12; i2++) {
                    this.f43c.mo22a((byte) (this.f43c.mo21a() ^ i));
                    if (i2 + 1 != 12) {
                        i = bArr[i2 + 1];
                    }
                }
            } catch (Throwable e) {
                throw new C0010a(e);
            }
        }
    }

    /* renamed from: a */
    public final int mo15a(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new C0010a("one of the input parameters were null in standard decrpyt data");
        }
        int i3 = i;
        while (i3 < i + i2) {
            try {
                int a = ((bArr[i3] & 255) ^ this.f43c.mo21a()) & 255;
                this.f43c.mo22a((byte) a);
                bArr[i3] = (byte) a;
                i3++;
            } catch (Throwable e) {
                throw new C0010a(e);
            }
        }
        return i2;
    }
}
