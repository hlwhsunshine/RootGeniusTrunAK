package com.nostra13.universalimageloader.p057a.p058a.p059a.p060a;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: com.nostra13.universalimageloader.a.a.a.a.g */
final class C0983g {
    /* renamed from: a */
    static final Charset f2465a = Charset.forName("US-ASCII");
    /* renamed from: b */
    static final Charset f2466b = Charset.forName("UTF-8");

    /* renamed from: a */
    static void m2788a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: a */
    static void m2789a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + file);
        }
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file2 = listFiles[i];
            if (file2.isDirectory()) {
                C0983g.m2789a(file2);
            }
            if (file2.delete()) {
                i++;
            } else {
                throw new IOException("failed to delete file: " + file2);
            }
        }
    }
}
