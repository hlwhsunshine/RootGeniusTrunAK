package com.tencent.stat.common;

import java.io.File;
import java.io.InputStream;

/* renamed from: com.tencent.stat.common.l */
class C1728l {
    /* renamed from: a */
    static int m4755a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C1729m()).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    /* renamed from: b */
    static int m4756b() {
        int i = 0;
        try {
            String str = "";
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            str = str.trim();
            if (str.length() > 0) {
                i = Integer.valueOf(str).intValue();
            }
        } catch (Throwable e) {
            StatCommonHelper.f5022m.mo7900e(e);
        }
        return i * 1000;
    }

    /* renamed from: c */
    static int m4757c() {
        int i = 0;
        try {
            String str = "";
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            str = str.trim();
            if (str.length() > 0) {
                i = Integer.valueOf(str).intValue();
            }
        } catch (Throwable th) {
            StatCommonHelper.f5022m.mo7900e(th);
        }
        return i * 1000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b A:{SYNTHETIC, Splitter: B:20:0x005b} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060 A:{Catch:{ IOException -> 0x0064 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006a A:{SYNTHETIC, Splitter: B:28:0x006a} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006f A:{Catch:{ IOException -> 0x0073 }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b A:{SYNTHETIC, Splitter: B:20:0x005b} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060 A:{Catch:{ IOException -> 0x0064 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006a A:{SYNTHETIC, Splitter: B:28:0x006a} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006f A:{Catch:{ IOException -> 0x0073 }} */
    /* renamed from: d */
    static java.lang.String m4758d() {
        /*
        r1 = 0;
        r3 = 2;
        r8 = 0;
        r0 = "/proc/cpuinfo";
        r4 = new java.lang.String[r3];
        r2 = "";
        r4[r8] = r2;
        r2 = 1;
        r5 = "";
        r4[r2] = r5;
        r2 = new java.io.FileReader;	 Catch:{ IOException -> 0x0057, all -> 0x0066 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0057, all -> 0x0066 }
        r0 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x007c, all -> 0x0075 }
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r0.<init>(r2, r5);	 Catch:{ IOException -> 0x007c, all -> 0x0075 }
        r1 = r0.readLine();	 Catch:{ IOException -> 0x0080, all -> 0x0077 }
        if (r1 == 0) goto L_0x004e;
    L_0x0022:
        r5 = "\\s+";
        r5 = r1.split(r5);	 Catch:{ IOException -> 0x0080, all -> 0x0077 }
        r1 = r3;
    L_0x0029:
        r3 = r5.length;	 Catch:{ IOException -> 0x0080, all -> 0x0077 }
        if (r1 >= r3) goto L_0x004e;
    L_0x002c:
        r3 = 0;
        r6 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0080, all -> 0x0077 }
        r6.<init>();	 Catch:{ IOException -> 0x0080, all -> 0x0077 }
        r7 = 0;
        r7 = r4[r7];	 Catch:{ IOException -> 0x0080, all -> 0x0077 }
        r6 = r6.append(r7);	 Catch:{ IOException -> 0x0080, all -> 0x0077 }
        r7 = r5[r1];	 Catch:{ IOException -> 0x0080, all -> 0x0077 }
        r6 = r6.append(r7);	 Catch:{ IOException -> 0x0080, all -> 0x0077 }
        r7 = " ";
        r6 = r6.append(r7);	 Catch:{ IOException -> 0x0080, all -> 0x0077 }
        r6 = r6.toString();	 Catch:{ IOException -> 0x0080, all -> 0x0077 }
        r4[r3] = r6;	 Catch:{ IOException -> 0x0080, all -> 0x0077 }
        r1 = r1 + 1;
        goto L_0x0029;
    L_0x004e:
        r0.close();	 Catch:{ IOException -> 0x0083 }
        r2.close();	 Catch:{ IOException -> 0x0083 }
    L_0x0054:
        r0 = r4[r8];
        return r0;
    L_0x0057:
        r0 = move-exception;
        r0 = r1;
    L_0x0059:
        if (r0 == 0) goto L_0x005e;
    L_0x005b:
        r0.close();	 Catch:{ IOException -> 0x0064 }
    L_0x005e:
        if (r1 == 0) goto L_0x0054;
    L_0x0060:
        r1.close();	 Catch:{ IOException -> 0x0064 }
        goto L_0x0054;
    L_0x0064:
        r0 = move-exception;
        goto L_0x0054;
    L_0x0066:
        r0 = move-exception;
        r2 = r1;
    L_0x0068:
        if (r1 == 0) goto L_0x006d;
    L_0x006a:
        r1.close();	 Catch:{ IOException -> 0x0073 }
    L_0x006d:
        if (r2 == 0) goto L_0x0072;
    L_0x006f:
        r2.close();	 Catch:{ IOException -> 0x0073 }
    L_0x0072:
        throw r0;
    L_0x0073:
        r1 = move-exception;
        goto L_0x0072;
    L_0x0075:
        r0 = move-exception;
        goto L_0x0068;
    L_0x0077:
        r1 = move-exception;
        r9 = r1;
        r1 = r0;
        r0 = r9;
        goto L_0x0068;
    L_0x007c:
        r0 = move-exception;
        r0 = r1;
        r1 = r2;
        goto L_0x0059;
    L_0x0080:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0059;
    L_0x0083:
        r0 = move-exception;
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.l.d():java.lang.String");
    }
}
