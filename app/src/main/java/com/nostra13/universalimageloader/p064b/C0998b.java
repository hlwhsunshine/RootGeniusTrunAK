package com.nostra13.universalimageloader.p064b;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.nostra13.universalimageloader.b.b */
public final class C0998b {

    /* renamed from: com.nostra13.universalimageloader.b.b$a */
    public interface C0997a {
        /* renamed from: a */
        boolean mo6153a(int i, int i2);
    }

    /* renamed from: a */
    public static void m2827a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private static boolean m2828a(C0997a c0997a, int i, int i2) {
        return (c0997a == null || c0997a.mo6153a(i, i2) || (i * 100) / i2 >= 75) ? false : true;
    }

    /* renamed from: a */
    public static boolean m2829a(InputStream inputStream, OutputStream outputStream, C0997a c0997a, int i) {
        int available = inputStream.available();
        if (available <= 0) {
            available = 512000;
        }
        byte[] bArr = new byte[i];
        if (C0998b.m2828a(c0997a, 0, available)) {
            return false;
        }
        int i2 = 0;
        do {
            int read = inputStream.read(bArr, 0, i);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                i2 += read;
            } else {
                outputStream.flush();
                return true;
            }
        } while (!C0998b.m2828a(c0997a, i2, available));
        return false;
    }
}
