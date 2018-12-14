package p000a.p001a.p002a.p004b.p005a;

import android.support.p015v4.view.ViewCompat;
import com.shuame.rootgenius.sdk.C1468c;

/* renamed from: a.a.a.b.a.a */
public final class C0002a {
    /* renamed from: a */
    private C0003b f8a;
    /* renamed from: b */
    private C0004c f9b;

    public C0002a() {
        this.f8a = null;
        this.f9b = null;
    }

    public C0002a(C0003b c0003b) {
        this.f8a = c0003b;
        this.f9b = null;
    }

    /* renamed from: a */
    private static byte[] m16a(C0004c c0004c, byte[] bArr, int i, int i2) {
        Object bArr2;
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        int a = c0004c.mo10a();
        int i3 = 0;
        if (i2 % a > 0) {
            i3 = 1;
        }
        int i4 = (i2 / a) + i3;
        int i5 = i2 - ((i4 - 1) * a);
        Object obj = new byte[(i4 * a)];
        int i6 = 0;
        for (int i7 = 1; i7 <= i4; i7++) {
            int a2 = c0004c.mo10a();
            Object obj2 = new byte[a2];
            byte[] bArr3 = new byte[(bArr2.length + 4)];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            int length = bArr2.length;
            bArr3[length] = (byte) (i7 / ViewCompat.MEASURED_STATE_TOO_SMALL);
            bArr3[length + 1] = (byte) (i7 / 65536);
            bArr3[length + 2] = (byte) (i7 / 256);
            bArr3[length + 3] = (byte) i7;
            int i8 = 0;
            while (i8 < i) {
                byte[] b = c0004c.mo14b(bArr3);
                for (i3 = 0; i3 < obj2.length; i3++) {
                    obj2[i3] = (byte) (obj2[i3] ^ b[i3]);
                }
                i8++;
                bArr3 = b;
            }
            System.arraycopy(obj2, 0, obj, i6, a2);
            i6 += a;
        }
        if (i5 >= a) {
            return obj;
        }
        Object obj3 = new byte[i2];
        System.arraycopy(obj, 0, obj3, 0, i2);
        return obj3;
    }

    /* renamed from: a */
    public final byte[] mo6a(char[] cArr, int i) {
        if (cArr == null) {
            throw new NullPointerException();
        }
        byte[] a = C1468c.m4057a(cArr);
        if (this.f9b == null) {
            this.f9b = new C0004c(this.f8a.mo9c());
        }
        this.f9b.mo11a(a);
        if (i == 0) {
            i = this.f9b.mo10a();
        }
        return C0002a.m16a(this.f9b, this.f8a.mo8b(), this.f8a.mo7a(), i);
    }
}
