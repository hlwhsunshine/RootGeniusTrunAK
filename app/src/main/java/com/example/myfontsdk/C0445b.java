package com.example.myfontsdk;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* renamed from: com.example.myfontsdk.b */
public final class C0445b {
    /* renamed from: a */
    private static int f1206a = 4096;

    /* renamed from: a */
    public static void m977a(String str, String str2) {
        if (!new File(str2).exists()) {
            try {
                ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
                while (zipInputStream.getNextEntry() != null) {
                    try {
                        byte[] bArr = new byte[4096];
                        File file = new File(str2);
                        File file2 = new File(file.getParent());
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 4096);
                        while (true) {
                            int read = zipInputStream.read(bArr, 0, 4096);
                            if (read == -1) {
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                zipInputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        File file3 = new File(str);
        if (file3.exists()) {
            file3.delete();
        }
    }

    /* renamed from: a */
    public static void m978a(String str, String str2, String str3) {
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str)));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return;
                }
                try {
                    if (nextEntry.getName().contains("font")) {
                        Object obj = nextEntry.getName().contains("font-en") ? 1 : null;
                        byte[] bArr = new byte[f1206a];
                        File file = new File(new StringBuilder(String.valueOf(str2)).append(str3).append("-zh.ttf").toString());
                        if (obj != null) {
                            file = new File(new StringBuilder(String.valueOf(str2)).append(str3).append("-en.ttf").toString());
                        }
                        File file2 = new File(file.getParent());
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), f1206a);
                        while (true) {
                            int read = zipInputStream.read(bArr, 0, f1206a);
                            if (read == -1) {
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
