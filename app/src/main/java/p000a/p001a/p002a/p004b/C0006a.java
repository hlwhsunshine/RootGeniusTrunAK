package p000a.p001a.p002a.p004b;

import com.shuame.rootgenius.sdk.C1468c;
import java.util.Arrays;
import p000a.p001a.p002a.p004b.p005a.C0002a;
import p000a.p001a.p002a.p004b.p005a.C0003b;
import p000a.p001a.p002a.p004b.p005a.C0004c;
import p000a.p001a.p002a.p004b.p006b.C0007a;
import p000a.p001a.p002a.p007c.C0010a;
import p000a.p001a.p002a.p009e.C0015a;
import p000a.p001a.p002a.p009e.C0021g;

/* renamed from: a.a.a.b.a */
public final class C0006a implements C0005b {
    /* renamed from: a */
    private C0021g f16a;
    /* renamed from: b */
    private C0007a f17b;
    /* renamed from: c */
    private C0004c f18c;
    /* renamed from: d */
    private int f19d;
    /* renamed from: e */
    private int f20e;
    /* renamed from: f */
    private int f21f;
    /* renamed from: g */
    private byte[] f22g;
    /* renamed from: h */
    private byte[] f23h;
    /* renamed from: i */
    private byte[] f24i;
    /* renamed from: j */
    private byte[] f25j;
    /* renamed from: k */
    private int f26k = 1;
    /* renamed from: l */
    private byte[] f27l;
    /* renamed from: m */
    private byte[] f28m;
    /* renamed from: n */
    private int f29n = 0;

    public C0006a(C0021g c0021g, byte[] bArr, byte[] bArr2) {
        if (c0021g == null) {
            throw new C0010a("one of the input parameters is null in AESDecryptor Constructor");
        }
        this.f16a = c0021g;
        this.f25j = null;
        this.f27l = new byte[16];
        this.f28m = new byte[16];
        if (this.f16a == null) {
            throw new C0010a("invalid file header in init method of AESDecryptor");
        }
        C0015a m = this.f16a.mo118m();
        if (m == null) {
            throw new C0010a("invalid aes extra data record - in init method of AESDecryptor");
        }
        switch (m.mo38a()) {
            case 1:
                this.f19d = 16;
                this.f20e = 16;
                this.f21f = 8;
                break;
            case 2:
                this.f19d = 24;
                this.f20e = 24;
                this.f21f = 12;
                break;
            case 3:
                this.f19d = 32;
                this.f20e = 32;
                this.f21f = 16;
                break;
            default:
                throw new C0010a(new StringBuffer("invalid aes key strength for file: ").append(this.f16a.mo111f()).toString());
        }
        if (this.f16a.mo116k() == null || this.f16a.mo116k().length <= 0) {
            throw new C0010a("empty or null password provided for AES Decryptor");
        }
        Object a = m27a(bArr, this.f16a.mo116k());
        if (a == null || a.length != (this.f19d + this.f20e) + 2) {
            throw new C0010a("invalid derived key");
        }
        this.f22g = new byte[this.f19d];
        this.f23h = new byte[this.f20e];
        this.f24i = new byte[2];
        System.arraycopy(a, 0, this.f22g, 0, this.f19d);
        System.arraycopy(a, this.f19d, this.f23h, 0, this.f20e);
        System.arraycopy(a, this.f19d + this.f20e, this.f24i, 0, 2);
        if (this.f24i == null) {
            throw new C0010a("invalid derived password verifier for AES");
        } else if (Arrays.equals(bArr2, this.f24i)) {
            this.f17b = new C0007a(this.f22g);
            this.f18c = new C0004c("HmacSHA1");
            this.f18c.mo11a(this.f23h);
        } else {
            throw new C0010a(new StringBuffer("Wrong Password for file: ").append(this.f16a.mo111f()).toString(), 5);
        }
    }

    /* renamed from: a */
    private byte[] m27a(byte[] bArr, char[] cArr) {
        try {
            return new C0002a(new C0003b("HmacSHA1", bArr)).mo6a(cArr, (this.f19d + this.f20e) + 2);
        } catch (Throwable e) {
            throw new C0010a(e);
        }
    }

    /* renamed from: a */
    public final int mo16a() {
        return this.f21f;
    }

    /* renamed from: a */
    public final int mo15a(byte[] bArr, int i, int i2) {
        if (this.f17b == null) {
            throw new C0010a("AES not initialized properly");
        }
        int i3 = i;
        while (i3 < i + i2) {
            try {
                this.f29n = i3 + 16 <= i + i2 ? 16 : (i + i2) - i3;
                this.f18c.mo12a(bArr, i3, this.f29n);
                C1468c.m4065e(this.f27l, this.f26k);
                this.f17b.mo20a(this.f27l, this.f28m);
                for (int i4 = 0; i4 < this.f29n; i4++) {
                    bArr[i3 + i4] = (byte) (bArr[i3 + i4] ^ this.f28m[i4]);
                }
                this.f26k++;
                i3 += 16;
            } catch (C0010a e) {
                throw e;
            } catch (Throwable e2) {
                throw new C0010a(e2);
            }
        }
        return i2;
    }

    /* renamed from: a */
    public final void mo17a(byte[] bArr) {
        this.f25j = bArr;
    }

    /* renamed from: b */
    public final byte[] mo18b() {
        return this.f18c.mo13b();
    }

    /* renamed from: c */
    public final byte[] mo19c() {
        return this.f25j;
    }
}
