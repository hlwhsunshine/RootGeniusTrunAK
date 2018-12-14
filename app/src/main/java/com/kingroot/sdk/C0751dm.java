package com.kingroot.sdk;

import android.content.Context;
import com.kingroot.sdk.util.C0885e;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import krsdk.C1774c;

/* renamed from: com.kingroot.sdk.dm */
public class C0751dm {
    /* renamed from: D */
    public static C1774c m1841D(Context context) {
        C1774c c1774c = new C1774c();
        c1774c.f5199kA = 0;
        c1774c.f5198hi = new C0787eo();
        c1774c.f5198hi.f1936hI = 1;
        C0626ap c0626ap = new C0626ap();
        c0626ap.f1556bK = "000";
        c0626ap.f1561bP = 3;
        c1774c.f5200kB = new C0626ap[]{c0626ap};
        return c1774c;
    }

    /* renamed from: aS */
    public static boolean m1842aS() {
        return C0627aq.f1564aW && C0627aq.m1446y() && new File("/data/local/tmp/krexp").exists();
    }

    /* renamed from: b */
    public static boolean m1843b(Context context, C0626ap c0626ap) {
        Exception e;
        Throwable th;
        Closeable closeable = null;
        File file = new File(c0626ap.f1563bR);
        byte[] bArr = new byte[1024];
        Closeable fileInputStream;
        Closeable fileOutputStream;
        try {
            fileInputStream = new FileInputStream(new File("/data/local/tmp/krexp/0000.zip"));
            try {
                fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.getChannel().force(true);
                            fileOutputStream.flush();
                            C0885e.m2419a(fileOutputStream);
                            C0885e.m2419a(fileInputStream);
                            return true;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        closeable = fileInputStream;
                        try {
                            e.printStackTrace();
                            C0885e.m2419a(fileOutputStream);
                            C0885e.m2419a(closeable);
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = closeable;
                            closeable = fileOutputStream;
                            C0885e.m2419a(closeable);
                            C0885e.m2419a(fileInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = fileOutputStream;
                        C0885e.m2419a(closeable);
                        C0885e.m2419a(fileInputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                closeable = fileInputStream;
                e.printStackTrace();
                C0885e.m2419a(fileOutputStream);
                C0885e.m2419a(closeable);
                return false;
            } catch (Throwable th4) {
                th = th4;
                C0885e.m2419a(closeable);
                C0885e.m2419a(fileInputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            e.printStackTrace();
            C0885e.m2419a(fileOutputStream);
            C0885e.m2419a(closeable);
            return false;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            C0885e.m2419a(closeable);
            C0885e.m2419a(fileInputStream);
            throw th;
        }
    }
}
