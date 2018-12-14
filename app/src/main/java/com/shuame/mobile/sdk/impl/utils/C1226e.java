package com.shuame.mobile.sdk.impl.utils;

import com.shuame.mobile.utils.ShuameEncrypt;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.shuame.mobile.sdk.impl.utils.e */
public class C1226e {
    /* renamed from: a */
    private static final String f3233a = C1226e.class.getSimpleName();
    /* renamed from: b */
    private static Map<String, Object> f3234b = new HashMap();
    /* renamed from: c */
    private static Pattern f3235c = Pattern.compile("(.+)_(\\d+)_(\\d+)(.+)");

    /* renamed from: a */
    private static int m3452a(File file) {
        try {
            Matcher matcher = f3235c.matcher(file.getName());
            return matcher.matches() ? Integer.parseInt(matcher.group(2)) : -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* renamed from: a */
    public static String m3453a(String str) {
        File file = new File(str);
        if (file.exists()) {
            try {
                int a = C1226e.m3452a(file);
                C1228g.m3458a(f3233a, "loadFile decrypt type:" + a);
                Object b = C1226e.m3455b(file);
                C1228g.m3458a(f3233a, "loadFile decrypt encryptedData:" + b);
                Object encryptBytes = ShuameEncrypt.encryptBytes(C1219a.m3445a(), 0, a, b);
                C1228g.m3458a(f3233a, "loadFile decrypt decryptedData:" + encryptBytes);
                return new String(encryptBytes);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        C1228g.m3458a(f3233a, "loadFile filePath:" + str + " not exists");
        return null;
    }

    /* renamed from: a */
    public static String m3454a(String str, String str2) {
        try {
            int a = C1226e.m3452a(new File(str));
            C1228g.m3458a(f3233a, "loadFileInZip decrypt type:" + a);
            return new String(ShuameEncrypt.encryptBytes(C1219a.m3445a(), 0, a, C1234j.m3498b(str, str2)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private static byte[] m3455b(File file) {
        Throwable th;
        InputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                ByteBuffer allocate = ByteBuffer.allocate((int) file.length());
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        byte[] array = allocate.array();
                        bufferedInputStream.close();
                        return array;
                    }
                    allocate.put(bArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw th;
        }
    }
}
