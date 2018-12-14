package com.kingroot.sdk.util;

/* renamed from: com.kingroot.sdk.util.n */
public class C0895n {
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e7 A:{SYNTHETIC, Splitter: B:45:0x00e7} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dc A:{Catch:{ IOException -> 0x00d1, Exception -> 0x00ec, all -> 0x0107, all -> 0x010f }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0102 A:{SYNTHETIC, Splitter: B:55:0x0102} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f7 A:{Catch:{ IOException -> 0x00d1, Exception -> 0x00ec, all -> 0x0107, all -> 0x010f }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dc A:{Catch:{ IOException -> 0x00d1, Exception -> 0x00ec, all -> 0x0107, all -> 0x010f }} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e7 A:{SYNTHETIC, Splitter: B:45:0x00e7} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f7 A:{Catch:{ IOException -> 0x00d1, Exception -> 0x00ec, all -> 0x0107, all -> 0x010f }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0102 A:{SYNTHETIC, Splitter: B:55:0x0102} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e7 A:{SYNTHETIC, Splitter: B:45:0x00e7} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dc A:{Catch:{ IOException -> 0x00d1, Exception -> 0x00ec, all -> 0x0107, all -> 0x010f }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0102 A:{SYNTHETIC, Splitter: B:55:0x0102} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f7 A:{Catch:{ IOException -> 0x00d1, Exception -> 0x00ec, all -> 0x0107, all -> 0x010f }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fe  */
    /* renamed from: g */
    public static final int m2457g(boolean r7) {
        /*
        r0 = 8;
        r3 = 0;
        r1 = 0;
        if (r7 == 0) goto L_0x005a;
    L_0x0006:
        r2 = new com.kingroot.sdk.av;	 Catch:{ IOException -> 0x00d1, Exception -> 0x00ec, all -> 0x0107 }
        r4 = "su";
        r2.<init>(r4);	 Catch:{ IOException -> 0x00d1, Exception -> 0x00ec, all -> 0x0107 }
        r3 = "id";
        r3 = r2.mo5609t(r3);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r5 = "RootUtilBlocking.getRootState id r.success() = ";
        r4.<init>(r5);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r5 = r3.success();	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r5 = ", r.mStdOut = ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r5 = r3.f1585cs;	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r5 = ", r.mStdErr = ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r5 = r3.f1586ct;	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        com.kingroot.sdk.C0633at.m1464h(r4);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r4 = r3.success();	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        if (r4 == 0) goto L_0x0087;
    L_0x0047:
        r4 = r3.f1585cs;	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        if (r4 == 0) goto L_0x0087;
    L_0x004b:
        r3 = r3.f1585cs;	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r4 = "uid=0";
        r3 = r3.contains(r4);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        if (r3 == 0) goto L_0x0087;
    L_0x0055:
        r1 = r0;
    L_0x0056:
        r2.shutdown();	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r3 = r2;
    L_0x005a:
        r2 = new com.kingroot.sdk.av;	 Catch:{ IOException -> 0x0126, Exception -> 0x0119, all -> 0x0111 }
        r0 = "sh";
        r2.<init>(r0);	 Catch:{ IOException -> 0x0126, Exception -> 0x0119, all -> 0x0111 }
        r0 = "su -v";
        r4 = 8000; // 0x1f40 float:1.121E-41 double:3.9525E-320;
        r0 = r2.mo5606b(r0, r4);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r3 = r0.success();	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        if (r3 == 0) goto L_0x012e;
    L_0x006f:
        r3 = r0.f1585cs;	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        if (r3 == 0) goto L_0x012e;
    L_0x0073:
        r0 = r0.f1585cs;	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r3 = "kinguser";
        r0 = r0.contains(r3);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        if (r0 == 0) goto L_0x012e;
    L_0x007d:
        r1 = r1 | 4;
        r0 = r1;
    L_0x0080:
        com.kingroot.sdk.C0625ao.m1440p(r0);	 Catch:{ IOException -> 0x012c, Exception -> 0x011f }
        r2.shutdown();
    L_0x0086:
        return r0;
    L_0x0087:
        r3 = "/system/bin/id";
        r3 = r2.mo5609t(r3);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r5 = "RootUtilBlocking.getRootState /system/bin/id r.success() = ";
        r4.<init>(r5);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r5 = r3.success();	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r5 = ", r.mStdOut = ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r5 = r3.f1585cs;	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r5 = ", r.mStdErr = ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r5 = r3.f1586ct;	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        com.kingroot.sdk.C0633at.m1464h(r4);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r4 = r3.success();	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        if (r4 == 0) goto L_0x0056;
    L_0x00c1:
        r4 = r3.f1585cs;	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        if (r4 == 0) goto L_0x0056;
    L_0x00c5:
        r3 = r3.f1585cs;	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        r4 = "uid=0";
        r3 = r3.contains(r4);	 Catch:{ IOException -> 0x0121, Exception -> 0x0114 }
        if (r3 == 0) goto L_0x0056;
    L_0x00cf:
        r1 = r0;
        goto L_0x0056;
    L_0x00d1:
        r0 = move-exception;
        r2 = r3;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x00d6:
        r3 = r1.getMessage();	 Catch:{ all -> 0x010f }
        if (r3 != 0) goto L_0x00e7;
    L_0x00dc:
        r1 = "getRootState throws IOException";
    L_0x00de:
        com.kingroot.sdk.C0633at.m1465i(r1);	 Catch:{ all -> 0x010f }
        if (r2 == 0) goto L_0x0086;
    L_0x00e3:
        r2.shutdown();
        goto L_0x0086;
    L_0x00e7:
        r1 = r1.getMessage();	 Catch:{ all -> 0x010f }
        goto L_0x00de;
    L_0x00ec:
        r0 = move-exception;
        r2 = r3;
        r6 = r1;
        r1 = r0;
        r0 = r6;
    L_0x00f1:
        r3 = r1.getMessage();	 Catch:{ all -> 0x010f }
        if (r3 != 0) goto L_0x0102;
    L_0x00f7:
        r1 = "getRootState throws Exception";
    L_0x00f9:
        com.kingroot.sdk.C0633at.m1465i(r1);	 Catch:{ all -> 0x010f }
        if (r2 == 0) goto L_0x0086;
    L_0x00fe:
        r2.shutdown();
        goto L_0x0086;
    L_0x0102:
        r1 = r1.getMessage();	 Catch:{ all -> 0x010f }
        goto L_0x00f9;
    L_0x0107:
        r0 = move-exception;
        r2 = r3;
    L_0x0109:
        if (r2 == 0) goto L_0x010e;
    L_0x010b:
        r2.shutdown();
    L_0x010e:
        throw r0;
    L_0x010f:
        r0 = move-exception;
        goto L_0x0109;
    L_0x0111:
        r0 = move-exception;
        r2 = r3;
        goto L_0x0109;
    L_0x0114:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x00f1;
    L_0x0119:
        r0 = move-exception;
        r2 = r3;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x00f1;
    L_0x011f:
        r1 = move-exception;
        goto L_0x00f1;
    L_0x0121:
        r0 = move-exception;
        r6 = r0;
        r0 = r1;
        r1 = r6;
        goto L_0x00d6;
    L_0x0126:
        r0 = move-exception;
        r2 = r3;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x00d6;
    L_0x012c:
        r1 = move-exception;
        goto L_0x00d6;
    L_0x012e:
        r0 = r1;
        goto L_0x0080;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kingroot.sdk.util.n.g(boolean):int");
    }
}
