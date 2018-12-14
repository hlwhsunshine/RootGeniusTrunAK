package com.kingroot.sdk;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.kingroot.sdk.util.C0609p;
import com.kingroot.sdk.util.C0885e;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.kingroot.sdk.at */
public class C0633at {
    /* renamed from: aX */
    private static BufferedWriter f1578aX;
    /* renamed from: aY */
    private static SimpleDateFormat f1579aY;
    /* renamed from: cc */
    private static boolean f1580cc = false;
    private static Handler handler;

    /* renamed from: com.kingroot.sdk.at$1 */
    final class C06311 extends C0609p {

        /* renamed from: com.kingroot.sdk.at$1$1 */
        class C06301 extends Handler {
            C06301() {
            }

            public void handleMessage(Message message) {
                C0632a c0632a = (C0632a) message.obj;
                C0633at.m1457a(c0632a.f1576ce, c0632a.f1577cf);
            }
        }

        C06311() {
        }

        public final void run() {
            Looper.prepare();
            C0633at.handler = new C06301();
            Looper.loop();
        }
    }

    /* renamed from: com.kingroot.sdk.at$a */
    private static class C0632a implements Serializable {
        /* renamed from: ce */
        public String f1576ce;
        /* renamed from: cf */
        public String f1577cf;

        private C0632a() {
        }

        /* synthetic */ C0632a(C06311 c06311) {
            this();
        }
    }

    /* renamed from: a */
    public static void m1456a(C0756dq c0756dq, String str) {
        c0756dq.mo5751l("e", str);
        C0633at.m1465i(str);
    }

    /* renamed from: a */
    private static void m1457a(String str, String str2) {
        if (f1578aX == null) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (externalStorageDirectory.exists()) {
                    try {
                        f1578aX = new BufferedWriter(new FileWriter(new File(externalStorageDirectory, "krsdk_debug.txt")));
                    } catch (IOException e) {
                        C0885e.m2419a(f1578aX);
                        f1578aX = null;
                    }
                } else {
                    return;
                }
            }
            return;
        }
        if (f1578aX != null) {
            try {
                f1578aX.append(f1579aY.format(new Date())).append(" ").append("[" + str + "]").append(" ").append(str2).append("\n");
                f1578aX.flush();
            } catch (Exception e2) {
                C0885e.m2419a(f1578aX);
                f1578aX = null;
            }
        }
    }

    /* renamed from: a */
    public static void m1458a(String str, Throwable th) {
        if (C0627aq.f1564aW) {
            C0633at.m1460b("e", str + "\n" + Log.getStackTraceString(th));
        }
    }

    /* renamed from: a */
    public static void m1459a(Throwable th) {
        if (C0627aq.f1564aW) {
            C0633at.m1460b(IXAdRequestInfo.WIDTH, Log.getStackTraceString(th));
        }
    }

    /* renamed from: b */
    public static void m1460b(String str, String str2) {
        if (f1580cc && handler != null) {
            C0632a c0632a = new C0632a();
            c0632a.f1576ce = str;
            c0632a.f1577cf = str2;
            handler.obtainMessage(1000, c0632a).sendToTarget();
        }
    }

    /* renamed from: b */
    public static void m1461b(boolean z) {
        f1580cc = z;
        if (z) {
            f1579aY = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            new C06311().mo5590bs();
        }
    }

    /* renamed from: g */
    public static void m1463g(String str) {
        if (C0627aq.f1564aW) {
            C0633at.m1460b("i", str);
        }
    }

    /* renamed from: h */
    public static void m1464h(String str) {
        if (C0627aq.f1564aW) {
            C0633at.m1460b("d", str);
        }
    }

    /* renamed from: i */
    public static void m1465i(String str) {
        if (C0627aq.f1564aW) {
            C0633at.m1460b("e", str);
        }
    }

    /* renamed from: r */
    public static void m1466r(String str) {
        if (C0627aq.f1564aW) {
            C0633at.m1460b(IXAdRequestInfo.f650V, str);
        }
    }

    /* renamed from: s */
    public static void m1467s(String str) {
        if (C0627aq.f1564aW) {
            C0633at.m1460b(IXAdRequestInfo.WIDTH, str);
        }
    }
}
