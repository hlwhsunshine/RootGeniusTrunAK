package com.kingroot.sdk;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.CRC32;

/* renamed from: com.kingroot.sdk.ck */
public final class C0705ck {
    /* renamed from: f */
    public static long m1693f(File file) {
        Throwable th;
        long j = 0;
        Closeable fileInputStream;
        try {
            CRC32 crc32 = new CRC32();
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    crc32.update(bArr, 0, read);
                }
                j = crc32.getValue();
                C0842gf.m2185a(fileInputStream);
            } catch (Exception e) {
                C0842gf.m2185a(fileInputStream);
                return j;
            } catch (Throwable th2) {
                th = th2;
                C0842gf.m2185a(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            fileInputStream = null;
            C0842gf.m2185a(fileInputStream);
            return j;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            C0842gf.m2185a(fileInputStream);
            throw th;
        }
        return j;
    }
}
