package com.kingroot.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.kingroot.sdk.util.C0883c;
import com.kingroot.sdk.util.C0885e;
import com.kingroot.sdk.util.C0893l;
import com.kingroot.sdk.util.C0896o;
import com.kingroot.sdk.util.C0897q;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Properties;

/* renamed from: com.kingroot.sdk.an */
public class C0624an {
    /* renamed from: bw */
    private static Context f1539bw;
    /* renamed from: bx */
    private static String f1540bx;
    /* renamed from: by */
    private static String f1541by;
    /* renamed from: bz */
    private static Properties f1542bz;

    /* renamed from: a */
    private static void m1425a(String str, Properties properties) {
        Throwable th;
        Closeable byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                properties.store(byteArrayOutputStream, "");
                byte[] a = C0896o.m2458a(C0896o.m2460i(C0624an.m1431w().getBytes()), byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.close();
                C0883c.m2393a(a, str);
                C0885e.m2419a(byteArrayOutputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    C0885e.m2419a(byteArrayOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    C0885e.m2419a(byteArrayOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            C0885e.m2419a(byteArrayOutputStream);
            throw th;
        }
    }

    private static synchronized String getProperty(String str) {
        String property;
        synchronized (C0624an.class) {
            property = f1542bz.getProperty(str);
            if (property == null) {
                new StringBuilder("Str:").append(str).append(property);
            }
            if (property == null) {
                property = "";
            }
        }
        return property;
    }

    /* renamed from: h */
    public static void m1426h(Context context) {
        f1539bw = context;
        f1540bx = f1539bw.getFilesDir() + File.separator + "kr-stock-conf";
        if (C0883c.m2404bh()) {
            f1541by = Environment.getExternalStorageDirectory() + File.separator + "kr-stock-conf";
        }
        if (new File(f1540bx).exists()) {
            f1542bz = C0624an.m1428o(f1540bx);
            if (!(f1541by == null || new File(f1541by).exists())) {
                C0624an.m1425a(f1541by, f1542bz);
            }
        } else if (f1541by != null && new File(f1541by).exists()) {
            f1542bz = C0624an.m1428o(f1541by);
            C0624an.m1425a(f1540bx, f1542bz);
        }
        if (f1542bz == null) {
            f1542bz = new Properties();
        }
    }

    /* renamed from: n */
    public static void m1427n(String str) {
        C0624an.setProperty("w.g", C0897q.m2462ab(str));
    }

    /* renamed from: o */
    private static Properties m1428o(String str) {
        Exception e;
        Throwable th;
        Properties properties = new Properties();
        Closeable closeable = null;
        Closeable byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(C0896o.m2459b(C0896o.m2460i(C0624an.m1431w().getBytes()), C0883c.m2387W(str)));
            try {
                properties.load(byteArrayInputStream);
                C0885e.m2419a(byteArrayInputStream);
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    C0885e.m2419a(byteArrayInputStream);
                    return properties;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = byteArrayInputStream;
                    C0885e.m2419a(closeable);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayInputStream = null;
            e.printStackTrace();
            C0885e.m2419a(byteArrayInputStream);
            return properties;
        } catch (Throwable th3) {
            th = th3;
            C0885e.m2419a(closeable);
            throw th;
        }
        return properties;
    }

    private static synchronized void setProperty(String str, String str2) {
        synchronized (C0624an.class) {
            f1542bz.setProperty(str, str2);
            C0624an.m1425a(f1540bx, f1542bz);
            if (f1541by == null && C0883c.m2404bh()) {
                f1541by = Environment.getExternalStorageDirectory() + File.separator + "kr-stock-conf";
            }
            if (f1541by != null) {
                C0624an.m1425a(f1541by, f1542bz);
            }
        }
    }

    /* renamed from: u */
    public static String m1429u() {
        Object property = C0624an.getProperty("s.i");
        if (!TextUtils.isEmpty(property)) {
            return property;
        }
        String M = C0893l.m2440M(f1539bw);
        if (M == null) {
            return "";
        }
        if (M == "00000000000001") {
            return M;
        }
        C0624an.setProperty("s.i", M);
        return M;
    }

    /* renamed from: v */
    public static String m1430v() {
        return C0897q.m2462ab(C0624an.getProperty("w.g"));
    }

    /* renamed from: w */
    private static String m1431w() {
        StringBuilder stringBuilder = new StringBuilder();
        Field[] fields = Build.class.getFields();
        for (int i = 0; i < 10; i++) {
            int length = (i << 3) % fields.length;
            Field field = fields[length];
            if (field != null && field.getType().equals(String.class)) {
                try {
                    stringBuilder.append(field.get(null));
                } catch (IllegalArgumentException e) {
                    stringBuilder.append(String.valueOf(length));
                } catch (IllegalAccessException e2) {
                    stringBuilder.append(String.valueOf(length));
                }
            }
        }
        return stringBuilder.toString();
    }
}
