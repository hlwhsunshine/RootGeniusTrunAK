package com.kingroot.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.kingroot.sdk.util.C0883c;
import com.kingroot.sdk.util.C0885e;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.kingroot.sdk.dq */
public class C0756dq {
    /* renamed from: fM */
    public static String f1839fM = "";
    /* renamed from: fN */
    public static volatile boolean f1840fN = false;
    /* renamed from: aX */
    private BufferedWriter f1841aX;
    /* renamed from: aY */
    private SimpleDateFormat f1842aY = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /* renamed from: fL */
    private File f1843fL;

    /* renamed from: com.kingroot.sdk.dq$1 */
    final class C07541 implements FilenameFilter {
        C07541() {
        }

        public final boolean accept(File file, String str) {
            return str.endsWith(".log");
        }
    }

    public C0756dq() {
        open();
    }

    /* renamed from: b */
    public static void m1848b(final Context context, Handler handler) {
        if ("105006".equals(C0625ao.f1552bJ)) {
            handler.post(new Runnable() {
                public final void run() {
                    if (C0756dq.f1840fN) {
                        C0633at.m1467s("正在执行方案打Log中，不上报Log...");
                        return;
                    }
                    File[] aW = C0756dq.m1849i();
                    if (aW == null || aW.length <= 0) {
                        C0633at.m1464h("No reportLogFiles");
                        return;
                    }
                    for (File file : aW) {
                        if (!file.exists()) {
                            C0633at.m1464h("reportLogFiles not exists, " + file.getAbsolutePath());
                        } else if (file.length() < 10) {
                            C0633at.m1465i("日志文件大小，忽略, size = " + file.length());
                            C0883c.m2406h(file);
                        } else {
                            try {
                                C0633at.m1464h("reportLogFiles start");
                                int c = C0769dy.m1927c(context, file);
                                C0633at.m1465i("reportLogFiles end.....uploadResult = " + c + ", " + file.getAbsolutePath());
                                if (c == 0) {
                                    C0883c.m2406h(file);
                                }
                            } catch (Throwable e) {
                                C0633at.m1458a("reportLogFile exception, " + file.getAbsolutePath(), e);
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }

    /* renamed from: i */
    private static File[] m1849i() {
        if (!"105006".equals(C0625ao.f1552bJ)) {
            return new File[0];
        }
        File file = new File(C0741dg.m1804aL().f1806em.workingDir, "selog");
        return !file.exists() ? new File[0] : file.listFiles(new C07541());
    }

    private void open() {
        if ("105006".equals(C0625ao.f1552bJ)) {
            f1840fN = true;
            File file = new File(C0741dg.m1804aL().f1806em.workingDir, "selog");
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(file, "kr_" + C0627aq.f1567bU + "_" + System.currentTimeMillis() + "_" + Build.BRAND + "_" + Build.MODEL + ".log");
            try {
                this.f1841aX = new BufferedWriter(new FileWriter(file2));
                mo5747Q(f1839fM);
            } catch (IOException e) {
                C0885e.m2419a(this.f1841aX);
                this.f1841aX = null;
            }
            this.f1843fL = file2;
        }
    }

    /* renamed from: Q */
    public void mo5747Q(String str) {
        if ("105006".equals(C0625ao.f1552bJ)) {
            mo5751l("d", str);
        }
    }

    /* renamed from: aV */
    public void mo5748aV() {
        if ("105006".equals(C0625ao.f1552bJ)) {
            close();
            if (this.f1843fL != null && this.f1843fL.exists()) {
                C0883c.m2406h(this.f1843fL);
            }
        }
    }

    /* renamed from: c */
    public void mo5749c(Context context, Handler handler) {
        if ("105006".equals(C0625ao.f1552bJ)) {
            close();
            C0756dq.m1848b(context, handler);
        }
    }

    public void close() {
        if ("105006".equals(C0625ao.f1552bJ)) {
            C0885e.m2419a(this.f1841aX);
            f1840fN = false;
        }
    }

    /* renamed from: l */
    public void mo5751l(String str, String str2) {
        if ("105006".equals(C0625ao.f1552bJ) && this.f1841aX != null) {
            try {
                this.f1841aX.append(this.f1842aY.format(new Date())).append(" ").append("[" + str + "]").append(" ").append(str2).append("\n");
                this.f1841aX.flush();
            } catch (Exception e) {
                C0885e.m2419a(this.f1841aX);
                this.f1841aX = null;
            }
        }
    }
}
