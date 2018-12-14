package com.shuame.p076b.p077a;

/* renamed from: com.shuame.b.a.j */
public final class C1134j extends C1124p {
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ae  */
    /* renamed from: a */
    public final boolean mo6729a(java.util.Map<java.lang.String, java.lang.String> r9, boolean r10, com.shuame.p076b.p077a.C1141q r11) {
        /*
        r8 = this;
        r1 = 0;
        r2 = 1;
        r0 = new java.io.File;
        r3 = "/system/framework/framework-miui-res.apk";
        r0.<init>(r3);
        r4 = r0.exists();
        r0 = "ro.miui.ui.version.code";
        r0 = android.p014os.SystemProperties.get(r0);
        r3 = "ro.miui.ui.version.name";
        r3 = android.p014os.SystemProperties.get(r3);
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x00ce;
    L_0x001f:
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x00ce;
    L_0x0025:
        r0 = r1;
    L_0x0026:
        r3 = r11.mo6733b();
        r3 = r3.toLowerCase();
        r5 = "miui";
        r5 = r3.contains(r5);
        r3 = "ro.config.ringtone";
        r3 = android.p014os.SystemProperties.get(r3);
        r6 = android.text.TextUtils.isEmpty(r3);
        if (r6 != 0) goto L_0x0109;
    L_0x0040:
        r6 = "mi.ogg";
        r3 = r3.equalsIgnoreCase(r6);
        if (r3 == 0) goto L_0x0109;
    L_0x0048:
        r3 = r2;
    L_0x0049:
        if (r4 != 0) goto L_0x00d1;
    L_0x004b:
        if (r5 != 0) goto L_0x00d1;
    L_0x004d:
        if (r3 != 0) goto L_0x00d1;
    L_0x004f:
        if (r0 != 0) goto L_0x00d1;
    L_0x0051:
        r5 = r1;
    L_0x0052:
        if (r10 != 0) goto L_0x00c8;
    L_0x0054:
        if (r5 == 0) goto L_0x00c8;
    L_0x0056:
        r4 = "miui";
        r0 = r11.mo6735d();
        r3 = p018b.p019a.C0220a.f144c;
        if (r3 != 0) goto L_0x0072;
    L_0x0060:
        r0 = r0.getContentResolver();
        r3 = "update_stable_version_only";
        r0 = android.provider.Settings.System.getInt(r0, r3, r1);
        if (r0 == r2) goto L_0x0106;
    L_0x006c:
        r0 = r1;
    L_0x006d:
        if (r0 != r2) goto L_0x00d3;
    L_0x006f:
        r0 = r2;
    L_0x0070:
        if (r0 != 0) goto L_0x00d5;
    L_0x0072:
        r0 = "X";
    L_0x0074:
        r3 = "";
        r6 = "X";
        if (r0 != r6) goto L_0x00d8;
    L_0x007a:
        r0 = "develop";
    L_0x007c:
        r3 = "ro.miui.ui.version.code";
        r3 = android.p014os.SystemProperties.get(r3);
        r6 = "ro.miui.ui.version.name";
        r6 = android.p014os.SystemProperties.get(r6);
        r7 = android.text.TextUtils.isEmpty(r3);
        if (r7 == 0) goto L_0x0094;
    L_0x008e:
        r7 = android.text.TextUtils.isEmpty(r6);
        if (r7 != 0) goto L_0x00e2;
    L_0x0094:
        r7 = "V6";
        r6 = r7.equalsIgnoreCase(r6);
        if (r6 != 0) goto L_0x00a4;
    L_0x009c:
        r6 = "4";
        r3 = r6.equals(r3);
        if (r3 == 0) goto L_0x00df;
    L_0x00a4:
        r3 = "v6";
    L_0x00a6:
        r6 = "v6";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x00e5;
    L_0x00ae:
        r4 = "miui_v6";
    L_0x00b0:
        r6 = "rombrand";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r6, r4);
        r4 = "rombranch";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r4, r0);
        r0 = "romversion";
        r4 = r11.mo6732a();
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r4);
        r0 = "romsubbranch";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
    L_0x00c8:
        r0 = r8.f3014b;
        if (r0 != 0) goto L_0x00f0;
    L_0x00cc:
        r1 = r5;
    L_0x00cd:
        return r1;
    L_0x00ce:
        r0 = r2;
        goto L_0x0026;
    L_0x00d1:
        r5 = r2;
        goto L_0x0052;
    L_0x00d3:
        r0 = r1;
        goto L_0x0070;
    L_0x00d5:
        r0 = "S";
        goto L_0x0074;
    L_0x00d8:
        r6 = "S";
        if (r0 != r6) goto L_0x0103;
    L_0x00dc:
        r0 = "stable";
        goto L_0x007c;
    L_0x00df:
        r3 = "v5";
        goto L_0x00a6;
    L_0x00e2:
        r3 = "v4";
        goto L_0x00a6;
    L_0x00e5:
        r6 = "v5";
        r6 = r6.equals(r3);
        if (r6 == 0) goto L_0x00b0;
    L_0x00ed:
        r4 = "miui_v5";
        goto L_0x00b0;
    L_0x00f0:
        r3 = r8.f3014b;
        if (r10 != 0) goto L_0x0101;
    L_0x00f4:
        if (r5 != 0) goto L_0x0101;
    L_0x00f6:
        r0 = r1;
    L_0x00f7:
        r0 = r3.mo6729a(r9, r0, r11);
        if (r5 != 0) goto L_0x00ff;
    L_0x00fd:
        if (r0 == 0) goto L_0x00cd;
    L_0x00ff:
        r1 = r2;
        goto L_0x00cd;
    L_0x0101:
        r0 = r2;
        goto L_0x00f7;
    L_0x0103:
        r0 = r3;
        goto L_0x007c;
    L_0x0106:
        r0 = r2;
        goto L_0x006d;
    L_0x0109:
        r3 = r1;
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.b.a.j.a(java.util.Map, boolean, com.shuame.b.a.q):boolean");
    }
}
