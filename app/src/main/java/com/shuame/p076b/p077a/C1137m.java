package com.shuame.p076b.p077a;

/* renamed from: com.shuame.b.a.m */
public final class C1137m extends C1124p {
    /* JADX WARNING: Removed duplicated region for block: B:70:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A:{SYNTHETIC, RETURN, ORIG_RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x008a  */
    /* renamed from: a */
    public final boolean mo6729a(java.util.Map<java.lang.String, java.lang.String> r9, boolean r10, com.shuame.p076b.p077a.C1141q r11) {
        /*
        r8 = this;
        r2 = 0;
        r1 = 1;
        if (r10 != 0) goto L_0x022c;
    L_0x0004:
        r0 = r11.mo6735d();
        r0 = r0.getPackageManager();
        r3 = new android.content.Intent;
        r3.<init>();
        r4 = "android.intent.category.HOME";
        r3.addCategory(r4);
        r4 = "android.intent.action.MAIN";
        r3.setAction(r4);
        r0 = r0.queryIntentActivities(r3, r2);
        r3 = r0.size();
        if (r3 <= 0) goto L_0x0217;
    L_0x0025:
        r3 = r0.iterator();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = new java.lang.StringBuilder;
        r5.<init>();
    L_0x0033:
        r0 = r3.hasNext();
        if (r0 != 0) goto L_0x009a;
    L_0x0039:
        r0 = r4.toString();
        r3 = r0.length();
        r3 = r3 + -1;
        r0 = r0.substring(r2, r3);
        r3 = "launcherpackages";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r3, r0);
        r3 = r5.toString();
        r4 = r3.length();
        r4 = r4 + -1;
        r3 = r3.substring(r2, r4);
        r4 = "launcherapps";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r4, r3);
        r4 = android.os.Build.BRAND;
        r5 = "com.htc.launcher";
        r5 = r0.contains(r5);
        if (r5 == 0) goto L_0x00e1;
    L_0x0069:
        r5 = r4.toLowerCase();
        r6 = "htc";
        r5 = r5.contains(r6);
        if (r5 == 0) goto L_0x00e1;
    L_0x0075:
        r0 = "rombrand";
        r3 = "htc";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = "romversion";
        r3 = r11.mo6736e();
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = r1;
    L_0x0086:
        r3 = r8.f3014b;
        if (r3 == 0) goto L_0x0099;
    L_0x008a:
        r4 = r8.f3014b;
        if (r10 != 0) goto L_0x022f;
    L_0x008e:
        if (r0 != 0) goto L_0x022f;
    L_0x0090:
        r3 = r2;
    L_0x0091:
        r3 = r4.mo6729a(r9, r3, r11);
        if (r0 != 0) goto L_0x0232;
    L_0x0097:
        if (r3 != 0) goto L_0x0232;
    L_0x0099:
        return r2;
    L_0x009a:
        r0 = r3.next();
        r0 = (android.content.p013pm.ResolveInfo) r0;
        r6 = r0.activityInfo;
        r6 = r6.packageName;
        r7 = new java.lang.StringBuilder;
        r6 = java.lang.String.valueOf(r6);
        r7.<init>(r6);
        r6 = ",";
        r6 = r7.append(r6);
        r6 = r6.toString();
        r4.append(r6);
        r0 = r0.activityInfo;
        r0 = r0.applicationInfo;
        r0 = r0.sourceDir;
        r6 = new java.io.File;
        r6.<init>(r0);
        r0 = new java.lang.StringBuilder;
        r6 = r6.getName();
        r6 = java.lang.String.valueOf(r6);
        r0.<init>(r6);
        r6 = ",";
        r0 = r0.append(r6);
        r0 = r0.toString();
        r5.append(r0);
        goto L_0x0033;
    L_0x00e1:
        r5 = "com.sec.android.app.twlauncher";
        r5 = r0.contains(r5);
        if (r5 == 0) goto L_0x0107;
    L_0x00e9:
        r5 = r4.toLowerCase();
        r6 = "samsung";
        r5 = r5.contains(r6);
        if (r5 == 0) goto L_0x0107;
    L_0x00f5:
        r0 = "rombrand";
        r3 = "samsung";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = "romversion";
        r3 = r11.mo6736e();
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = r1;
        goto L_0x0086;
    L_0x0107:
        r5 = "com.sonyericsson.home";
        r5 = r0.contains(r5);
        if (r5 == 0) goto L_0x012e;
    L_0x010f:
        r5 = r4.toLowerCase();
        r6 = "semc";
        r5 = r5.contains(r6);
        if (r5 == 0) goto L_0x012e;
    L_0x011b:
        r0 = "rombrand";
        r3 = "sony";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = "romversion";
        r3 = r11.mo6736e();
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = r1;
        goto L_0x0086;
    L_0x012e:
        r5 = "com.sonyericsson.homescreen";
        r5 = r0.contains(r5);
        if (r5 == 0) goto L_0x0155;
    L_0x0136:
        r5 = r4.toLowerCase();
        r6 = "semc";
        r5 = r5.contains(r6);
        if (r5 == 0) goto L_0x0155;
    L_0x0142:
        r0 = "rombrand";
        r3 = "sony";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = "romversion";
        r3 = r11.mo6736e();
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = r1;
        goto L_0x0086;
    L_0x0155:
        r5 = "huawei";
        r5 = r0.contains(r5);
        if (r5 == 0) goto L_0x017c;
    L_0x015d:
        r5 = r4.toLowerCase();
        r6 = "huawei";
        r5 = r5.contains(r6);
        if (r5 == 0) goto L_0x017c;
    L_0x0169:
        r0 = "rombrand";
        r3 = "huawei";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = "romversion";
        r3 = r11.mo6736e();
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = r1;
        goto L_0x0086;
    L_0x017c:
        r5 = "com.motorola.blur.home";
        r5 = r0.contains(r5);
        if (r5 == 0) goto L_0x01a3;
    L_0x0184:
        r5 = r4.toLowerCase();
        r6 = "moto";
        r5 = r5.contains(r6);
        if (r5 == 0) goto L_0x01a3;
    L_0x0190:
        r0 = "rombrand";
        r3 = "moto";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = "romversion";
        r3 = r11.mo6736e();
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = r1;
        goto L_0x0086;
    L_0x01a3:
        r5 = "com.android.launcher";
        r5 = r0.contains(r5);
        if (r5 == 0) goto L_0x01ca;
    L_0x01ab:
        r5 = r4.toLowerCase();
        r6 = "google";
        r5 = r5.contains(r6);
        if (r5 == 0) goto L_0x01ca;
    L_0x01b7:
        r0 = "rombrand";
        r3 = "android";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = "romversion";
        r3 = r11.mo6736e();
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = r1;
        goto L_0x0086;
    L_0x01ca:
        r5 = "com.android.launcher";
        r5 = r0.contains(r5);
        if (r5 == 0) goto L_0x01fd;
    L_0x01d2:
        r3 = r3.toLowerCase();
        r5 = "oppolauncher.apk";
        r3 = r3.contains(r5);
        if (r3 == 0) goto L_0x01fd;
    L_0x01de:
        r3 = r4.toLowerCase();
        r4 = "oppo";
        r3 = r3.contains(r4);
        if (r3 == 0) goto L_0x01fd;
    L_0x01ea:
        r0 = "rombrand";
        r3 = "oppo";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = "romversion";
        r3 = r11.mo6736e();
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = r1;
        goto L_0x0086;
    L_0x01fd:
        r3 = "com.android.launcher";
        r3 = r0.contains(r3);
        if (r3 != 0) goto L_0x020d;
    L_0x0205:
        r3 = "com.android.launcher2";
        r0 = r0.contains(r3);
        if (r0 == 0) goto L_0x0214;
    L_0x020d:
        r0 = "rombrand2";
        r3 = "android";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
    L_0x0214:
        r0 = r2;
        goto L_0x0086;
    L_0x0217:
        r0 = "launcherpackages";
        r3 = "unknown";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = "launcherapps";
        r3 = "unknown";
        com.shuame.p076b.p077a.C1124p.m3267a(r9, r0, r3);
        r0 = "PhoneBrandHandler";
        r3 = "Can't find launcher app through android.intent.category.HOME category and android.intent.action.MAIN action";
        com.shuame.p078c.C1146b.m3304b(r0, r3);
    L_0x022c:
        r0 = r2;
        goto L_0x0086;
    L_0x022f:
        r3 = r1;
        goto L_0x0091;
    L_0x0232:
        r2 = r1;
        goto L_0x0099;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.b.a.m.a(java.util.Map, boolean, com.shuame.b.a.q):boolean");
    }
}
