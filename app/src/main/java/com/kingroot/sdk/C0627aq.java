package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.aq */
public final class C0627aq {
    /* renamed from: aW */
    public static boolean f1564aW = false;
    /* renamed from: bS */
    public static String f1565bS = "http://pmir.3g.qq.com/";
    /* renamed from: bT */
    public static String f1566bT = "http://bh.3g.qq.com";
    /* renamed from: bU */
    public static int f1567bU = 201;
    @Deprecated
    /* renamed from: bV */
    private static int f1568bV = 15;
    /* renamed from: bW */
    private static String f1569bW = "1.1.0";

    /* renamed from: A */
    public static int m1443A() {
        return f1568bV;
    }

    /* renamed from: B */
    public static String m1444B() {
        return f1569bW + "." + f1567bU;
    }

    /* renamed from: a */
    public static void m1445a(boolean z, boolean z2) {
        f1565bS = z ? "http://wuptest.cs0309.3g.qq.com" : "http://pmir.3g.qq.com/";
        f1564aW = z2;
        C0633at.m1464h("useTestURL = " + z + ", logSwitchOn = " + z2);
        f1566bT = z ? "http://bh.cs0309.3g.qq.com" : "http://bh.3g.qq.com";
    }

    /* renamed from: y */
    public static boolean m1446y() {
        return f1565bS.equals("http://wuptest.cs0309.3g.qq.com");
    }

    /* renamed from: z */
    public static String m1447z() {
        return f1569bW;
    }
}
