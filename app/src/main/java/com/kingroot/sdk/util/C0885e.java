package com.kingroot.sdk.util;

import android.util.Base64;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kingroot.sdk.util.e */
public class C0885e {
    /* renamed from: a */
    public static long m2418a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    /* renamed from: a */
    public static void m2419a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: a */
    public static void m2420a(File file, String str) {
        IOException e;
        Throwable th;
        if (file != null && file.exists() && file.length() > 102400) {
            file.delete();
        }
        Closeable bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            try {
                bufferedWriter.append(new String(Base64.encode(str.getBytes(), 2))).append("\n");
                bufferedWriter.flush();
                C0885e.m2419a(bufferedWriter);
            } catch (IOException e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    C0885e.m2419a(bufferedWriter);
                } catch (Throwable th2) {
                    th = th2;
                    C0885e.m2419a(bufferedWriter);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                th.printStackTrace();
                C0885e.m2419a(bufferedWriter);
            }
        } catch (IOException e3) {
            e = e3;
            bufferedWriter = null;
            e.printStackTrace();
            C0885e.m2419a(bufferedWriter);
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter = null;
            C0885e.m2419a(bufferedWriter);
            throw th;
        }
    }

    /* renamed from: a */
    public static void m2421a(File file, String... strArr) {
        Throwable th;
        Closeable bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            try {
                for (String str : strArr) {
                    bufferedWriter.write(str + "\n");
                }
                bufferedWriter.flush();
                C0885e.m2419a(bufferedWriter);
            } catch (Throwable th2) {
                th = th2;
                C0885e.m2419a(bufferedWriter);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter = null;
            C0885e.m2419a(bufferedWriter);
            throw th;
        }
    }

    /* renamed from: j */
    public static List<String> m2422j(File file) {
        IOException e;
        ArrayIndexOutOfBoundsException e2;
        Throwable th;
        List<String> arrayList = new ArrayList();
        if (file.exists()) {
            Closeable bufferedReader;
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            C0885e.m2419a(bufferedReader);
                            break;
                        }
                        try {
                            arrayList.add(new String(Base64.decode(readLine, 2)));
                        } catch (IllegalArgumentException e3) {
                            e3.printStackTrace();
                        }
                    } catch (IOException e4) {
                        e = e4;
                    } catch (ArrayIndexOutOfBoundsException e5) {
                        e2 = e5;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (IOException e6) {
                e = e6;
                bufferedReader = null;
                try {
                    e.printStackTrace();
                    C0885e.m2419a(bufferedReader);
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                    C0885e.m2419a(bufferedReader);
                    throw th;
                }
            } catch (ArrayIndexOutOfBoundsException e7) {
                e2 = e7;
                bufferedReader = null;
                e2.printStackTrace();
                C0885e.m2419a(bufferedReader);
                return arrayList;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                C0885e.m2419a(bufferedReader);
                throw th;
            }
        }
        return arrayList;
    }
}
