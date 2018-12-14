package com.shuame.mobile.sdk.impl.utils;

/* renamed from: com.shuame.mobile.sdk.impl.utils.j */
public final class C1234j {
    /* renamed from: a */
    private static final String f3275a = C1234j.class.getSimpleName();

    /* renamed from: com.shuame.mobile.sdk.impl.utils.j$a */
    public interface C1189a {
        /* renamed from: a */
        void mo6836a(int i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0043 A:{SYNTHETIC, Splitter: B:28:0x0043} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0048 A:{SYNTHETIC, Splitter: B:31:0x0048} */
    /* renamed from: a */
    private static void m3493a(java.io.InputStream r5, java.lang.String r6) {
        /*
        r1 = 0;
        r0 = new java.io.File;	 Catch:{ IOException -> 0x005c, all -> 0x0054 }
        r0.<init>(r6);	 Catch:{ IOException -> 0x005c, all -> 0x0054 }
        r2 = r0.getParentFile();	 Catch:{ IOException -> 0x005c, all -> 0x0054 }
        r2 = r2.exists();	 Catch:{ IOException -> 0x005c, all -> 0x0054 }
        if (r2 != 0) goto L_0x0017;
    L_0x0010:
        r0 = r0.getParentFile();	 Catch:{ IOException -> 0x005c, all -> 0x0054 }
        r0.mkdirs();	 Catch:{ IOException -> 0x005c, all -> 0x0054 }
    L_0x0017:
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = new byte[r0];	 Catch:{ IOException -> 0x005c, all -> 0x0054 }
        r3 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x005c, all -> 0x0054 }
        r3.<init>(r5);	 Catch:{ IOException -> 0x005c, all -> 0x0054 }
        r2 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x005f, all -> 0x0057 }
        r2.<init>(r6);	 Catch:{ IOException -> 0x005f, all -> 0x0057 }
    L_0x0025:
        r1 = 0;
        r4 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r1 = r3.read(r0, r1, r4);	 Catch:{ IOException -> 0x003b, all -> 0x0059 }
        r4 = -1;
        if (r1 != r4) goto L_0x0036;
    L_0x002f:
        r3.close();	 Catch:{ IOException -> 0x0050 }
    L_0x0032:
        r2.close();	 Catch:{ IOException -> 0x0052 }
    L_0x0035:
        return;
    L_0x0036:
        r4 = 0;
        r2.write(r0, r4, r1);	 Catch:{ IOException -> 0x003b, all -> 0x0059 }
        goto L_0x0025;
    L_0x003b:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
    L_0x003e:
        throw r0;	 Catch:{ all -> 0x003f }
    L_0x003f:
        r0 = move-exception;
        r3 = r2;
    L_0x0041:
        if (r3 == 0) goto L_0x0046;
    L_0x0043:
        r3.close();	 Catch:{ IOException -> 0x004c }
    L_0x0046:
        if (r1 == 0) goto L_0x004b;
    L_0x0048:
        r1.close();	 Catch:{ IOException -> 0x004e }
    L_0x004b:
        throw r0;
    L_0x004c:
        r2 = move-exception;
        goto L_0x0046;
    L_0x004e:
        r1 = move-exception;
        goto L_0x004b;
    L_0x0050:
        r0 = move-exception;
        goto L_0x0032;
    L_0x0052:
        r0 = move-exception;
        goto L_0x0035;
    L_0x0054:
        r0 = move-exception;
        r3 = r1;
        goto L_0x0041;
    L_0x0057:
        r0 = move-exception;
        goto L_0x0041;
    L_0x0059:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0041;
    L_0x005c:
        r0 = move-exception;
        r2 = r1;
        goto L_0x003e;
    L_0x005f:
        r0 = move-exception;
        r2 = r3;
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.sdk.impl.utils.j.a(java.io.InputStream, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x002e A:{SYNTHETIC, Splitter: B:21:0x002e} */
    /* renamed from: a */
    public static boolean m3494a(java.lang.String r4, java.lang.String r5) {
        /*
        r0 = 0;
        r3 = 0;
        r1 = new java.io.File;	 Catch:{ Exception -> 0x001e, all -> 0x002b }
        r1.<init>(r4);	 Catch:{ Exception -> 0x001e, all -> 0x002b }
        r2 = r1.exists();	 Catch:{ Exception -> 0x001e, all -> 0x002b }
        if (r2 != 0) goto L_0x000e;
    L_0x000d:
        return r0;
    L_0x000e:
        r2 = new java.util.zip.ZipFile;	 Catch:{ Exception -> 0x001e, all -> 0x002b }
        r2.<init>(r1);	 Catch:{ Exception -> 0x001e, all -> 0x002b }
        r1 = r2.getEntry(r5);	 Catch:{ Exception -> 0x003f }
        if (r1 == 0) goto L_0x0032;
    L_0x0019:
        r2.close();	 Catch:{ Exception -> 0x0038 }
    L_0x001c:
        r0 = 1;
        goto L_0x000d;
    L_0x001e:
        r1 = move-exception;
        r2 = r3;
    L_0x0020:
        r1.printStackTrace();	 Catch:{ all -> 0x003c }
        if (r2 == 0) goto L_0x000d;
    L_0x0025:
        r2.close();	 Catch:{ Exception -> 0x0029 }
        goto L_0x000d;
    L_0x0029:
        r1 = move-exception;
        goto L_0x000d;
    L_0x002b:
        r0 = move-exception;
    L_0x002c:
        if (r3 == 0) goto L_0x0031;
    L_0x002e:
        r3.close();	 Catch:{ Exception -> 0x003a }
    L_0x0031:
        throw r0;
    L_0x0032:
        r2.close();	 Catch:{ Exception -> 0x0036 }
        goto L_0x000d;
    L_0x0036:
        r1 = move-exception;
        goto L_0x000d;
    L_0x0038:
        r0 = move-exception;
        goto L_0x001c;
    L_0x003a:
        r1 = move-exception;
        goto L_0x0031;
    L_0x003c:
        r0 = move-exception;
        r3 = r2;
        goto L_0x002c;
    L_0x003f:
        r1 = move-exception;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.sdk.impl.utils.j.a(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006a A:{SYNTHETIC, Splitter: B:27:0x006a} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0073 A:{SYNTHETIC, Splitter: B:33:0x0073} */
    /* renamed from: a */
    public static boolean m3495a(java.lang.String r9, java.lang.String r10, com.shuame.mobile.sdk.impl.utils.C1234j.C1189a r11) {
        /*
        r1 = 0;
        r3 = 0;
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0063, all -> 0x006f }
        r0.<init>(r9);	 Catch:{ Exception -> 0x0063, all -> 0x006f }
        r2 = r0.exists();	 Catch:{ Exception -> 0x0063, all -> 0x006f }
        if (r2 != 0) goto L_0x000f;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        return r0;
    L_0x000f:
        r2 = new java.util.zip.ZipFile;	 Catch:{ Exception -> 0x0063, all -> 0x006f }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0063, all -> 0x006f }
        r5 = r2.entries();	 Catch:{ Exception -> 0x007f }
        r6 = r2.size();	 Catch:{ Exception -> 0x007f }
        r3 = r1;
        r4 = r1;
    L_0x001e:
        r0 = r5.hasMoreElements();	 Catch:{ Exception -> 0x007f }
        if (r0 != 0) goto L_0x0029;
    L_0x0024:
        r2.close();	 Catch:{ Exception -> 0x0077 }
    L_0x0027:
        r0 = 1;
        goto L_0x000e;
    L_0x0029:
        r0 = r5.nextElement();	 Catch:{ Exception -> 0x007f }
        r0 = (java.util.zip.ZipEntry) r0;	 Catch:{ Exception -> 0x007f }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x007f }
        r8 = java.lang.String.valueOf(r10);	 Catch:{ Exception -> 0x007f }
        r7.<init>(r8);	 Catch:{ Exception -> 0x007f }
        r8 = java.io.File.separator;	 Catch:{ Exception -> 0x007f }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x007f }
        r8 = r0.getName();	 Catch:{ Exception -> 0x007f }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x007f }
        r7 = r7.toString();	 Catch:{ Exception -> 0x007f }
        r0 = r2.getInputStream(r0);	 Catch:{ Exception -> 0x007f }
        com.shuame.mobile.sdk.impl.utils.C1234j.m3493a(r0, r7);	 Catch:{ Exception -> 0x007f }
        r4 = r4 + 1;
        if (r11 == 0) goto L_0x001e;
    L_0x0055:
        r0 = r4 * 100;
        r0 = r0 / r6;
        if (r0 > r3) goto L_0x005e;
    L_0x005a:
        r7 = 100;
        if (r0 != r7) goto L_0x001e;
    L_0x005e:
        r11.mo6836a(r0);	 Catch:{ Exception -> 0x007f }
        r3 = r0;
        goto L_0x001e;
    L_0x0063:
        r0 = move-exception;
        r2 = r3;
    L_0x0065:
        r0.printStackTrace();	 Catch:{ all -> 0x007d }
        if (r2 == 0) goto L_0x006d;
    L_0x006a:
        r2.close();	 Catch:{ Exception -> 0x0079 }
    L_0x006d:
        r0 = r1;
        goto L_0x000e;
    L_0x006f:
        r0 = move-exception;
        r2 = r3;
    L_0x0071:
        if (r2 == 0) goto L_0x0076;
    L_0x0073:
        r2.close();	 Catch:{ Exception -> 0x007b }
    L_0x0076:
        throw r0;
    L_0x0077:
        r0 = move-exception;
        goto L_0x0027;
    L_0x0079:
        r0 = move-exception;
        goto L_0x006d;
    L_0x007b:
        r1 = move-exception;
        goto L_0x0076;
    L_0x007d:
        r0 = move-exception;
        goto L_0x0071;
    L_0x007f:
        r0 = move-exception;
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.sdk.impl.utils.j.a(java.lang.String, java.lang.String, com.shuame.mobile.sdk.impl.utils.j$a):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:? A:{SYNTHETIC, RETURN, Catch:{ Exception -> 0x0052, all -> 0x005f }} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059 A:{SYNTHETIC, Splitter: B:22:0x0059} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A:{SYNTHETIC, Splitter: B:28:0x0063} */
    /* renamed from: a */
    public static boolean m3496a(java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
        r0 = 0;
        r3 = 0;
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0052, all -> 0x005f }
        r1.<init>(r6);	 Catch:{ Exception -> 0x0052, all -> 0x005f }
        r2 = r1.exists();	 Catch:{ Exception -> 0x0052, all -> 0x005f }
        if (r2 != 0) goto L_0x000e;
    L_0x000d:
        return r0;
    L_0x000e:
        r2 = new java.util.zip.ZipFile;	 Catch:{ Exception -> 0x0052, all -> 0x005f }
        r2.<init>(r1);	 Catch:{ Exception -> 0x0052, all -> 0x005f }
        r1 = r2.getEntry(r7);	 Catch:{ Exception -> 0x006d }
        if (r1 != 0) goto L_0x0026;
    L_0x0019:
        r1 = f3275a;	 Catch:{ Exception -> 0x006d }
        r3 = "unzipFileEntry zipEntry is null";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r3);	 Catch:{ Exception -> 0x006d }
        r2.close();	 Catch:{ IOException -> 0x0024 }
        goto L_0x000d;
    L_0x0024:
        r1 = move-exception;
        goto L_0x000d;
    L_0x0026:
        r3 = new java.io.File;	 Catch:{ Exception -> 0x006d }
        r3.<init>(r7);	 Catch:{ Exception -> 0x006d }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006d }
        r5 = java.lang.String.valueOf(r8);	 Catch:{ Exception -> 0x006d }
        r4.<init>(r5);	 Catch:{ Exception -> 0x006d }
        r5 = java.io.File.separator;	 Catch:{ Exception -> 0x006d }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x006d }
        r3 = r3.getName();	 Catch:{ Exception -> 0x006d }
        r3 = r4.append(r3);	 Catch:{ Exception -> 0x006d }
        r3 = r3.toString();	 Catch:{ Exception -> 0x006d }
        r1 = r2.getInputStream(r1);	 Catch:{ Exception -> 0x006d }
        com.shuame.mobile.sdk.impl.utils.C1234j.m3493a(r1, r3);	 Catch:{ Exception -> 0x006d }
        r2.close();	 Catch:{ IOException -> 0x0067 }
    L_0x0050:
        r0 = 1;
        goto L_0x000d;
    L_0x0052:
        r1 = move-exception;
        r2 = r3;
    L_0x0054:
        r1.printStackTrace();	 Catch:{ all -> 0x006b }
        if (r2 == 0) goto L_0x000d;
    L_0x0059:
        r2.close();	 Catch:{ IOException -> 0x005d }
        goto L_0x000d;
    L_0x005d:
        r1 = move-exception;
        goto L_0x000d;
    L_0x005f:
        r0 = move-exception;
        r2 = r3;
    L_0x0061:
        if (r2 == 0) goto L_0x0066;
    L_0x0063:
        r2.close();	 Catch:{ IOException -> 0x0069 }
    L_0x0066:
        throw r0;
    L_0x0067:
        r0 = move-exception;
        goto L_0x0050;
    L_0x0069:
        r1 = move-exception;
        goto L_0x0066;
    L_0x006b:
        r0 = move-exception;
        goto L_0x0061;
    L_0x006d:
        r1 = move-exception;
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.sdk.impl.utils.j.a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ed A:{SYNTHETIC, Splitter: B:51:0x00ed} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f2 A:{SYNTHETIC, Splitter: B:54:0x00f2} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f7 A:{SYNTHETIC, Splitter: B:57:0x00f7} */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A:{SYNTHETIC, RETURN, Catch:{ Exception -> 0x0153, all -> 0x010e }} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fc A:{SYNTHETIC, Splitter: B:60:0x00fc} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0114 A:{SYNTHETIC, Splitter: B:72:0x0114} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0119 A:{SYNTHETIC, Splitter: B:75:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x011e A:{SYNTHETIC, Splitter: B:78:0x011e} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0123 A:{SYNTHETIC, Splitter: B:81:0x0123} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ed A:{SYNTHETIC, Splitter: B:51:0x00ed} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f2 A:{SYNTHETIC, Splitter: B:54:0x00f2} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f7 A:{SYNTHETIC, Splitter: B:57:0x00f7} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fc A:{SYNTHETIC, Splitter: B:60:0x00fc} */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A:{SYNTHETIC, RETURN, Catch:{ Exception -> 0x0153, all -> 0x010e }} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0114 A:{SYNTHETIC, Splitter: B:72:0x0114} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0119 A:{SYNTHETIC, Splitter: B:75:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x011e A:{SYNTHETIC, Splitter: B:78:0x011e} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0123 A:{SYNTHETIC, Splitter: B:81:0x0123} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0114 A:{SYNTHETIC, Splitter: B:72:0x0114} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0119 A:{SYNTHETIC, Splitter: B:75:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x011e A:{SYNTHETIC, Splitter: B:78:0x011e} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0123 A:{SYNTHETIC, Splitter: B:81:0x0123} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ed A:{SYNTHETIC, Splitter: B:51:0x00ed} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f2 A:{SYNTHETIC, Splitter: B:54:0x00f2} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f7 A:{SYNTHETIC, Splitter: B:57:0x00f7} */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A:{SYNTHETIC, RETURN, Catch:{ Exception -> 0x0153, all -> 0x010e }} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fc A:{SYNTHETIC, Splitter: B:60:0x00fc} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0114 A:{SYNTHETIC, Splitter: B:72:0x0114} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0119 A:{SYNTHETIC, Splitter: B:75:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x011e A:{SYNTHETIC, Splitter: B:78:0x011e} */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0123 A:{SYNTHETIC, Splitter: B:81:0x0123} */
    /* renamed from: b */
    public static boolean m3497b(java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
        r3 = 0;
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        r1.<init>(r12);	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        r7 = new java.io.File;	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        r7.<init>(r14);	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        r2 = r1.exists();	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        if (r2 == 0) goto L_0x0018;
    L_0x0012:
        r2 = r7.exists();	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        if (r2 != 0) goto L_0x0020;
    L_0x0018:
        r1 = f3275a;	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        r2 = "zipFileEntry file not exists";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r2);	 Catch:{ Exception -> 0x0153, all -> 0x010e }
    L_0x001f:
        return r0;
    L_0x0020:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        r5 = java.lang.String.valueOf(r12);	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        r4.<init>(r5);	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        r5 = ".tmp";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        r4 = r4.append(r8);	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0153, all -> 0x010e }
        r4 = r1.renameTo(r2);	 Catch:{ Exception -> 0x0158, all -> 0x0141 }
        if (r4 != 0) goto L_0x0053;
    L_0x0046:
        r1 = f3275a;	 Catch:{ Exception -> 0x0158, all -> 0x0141 }
        r4 = "zipFileEntry rename failed";
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r4);	 Catch:{ Exception -> 0x0158, all -> 0x0141 }
        r2.delete();	 Catch:{ Exception -> 0x0051 }
        goto L_0x001f;
    L_0x0051:
        r1 = move-exception;
        goto L_0x001f;
    L_0x0053:
        r4 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r8 = new byte[r4];	 Catch:{ Exception -> 0x0158, all -> 0x0141 }
        r5 = new java.util.zip.ZipInputStream;	 Catch:{ Exception -> 0x0158, all -> 0x0141 }
        r4 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0158, all -> 0x0141 }
        r4.<init>(r2);	 Catch:{ Exception -> 0x0158, all -> 0x0141 }
        r5.<init>(r4);	 Catch:{ Exception -> 0x0158, all -> 0x0141 }
        r4 = new java.util.zip.ZipOutputStream;	 Catch:{ Exception -> 0x015c, all -> 0x0145 }
        r6 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x015c, all -> 0x0145 }
        r6.<init>(r1);	 Catch:{ Exception -> 0x015c, all -> 0x0145 }
        r4.<init>(r6);	 Catch:{ Exception -> 0x015c, all -> 0x0145 }
    L_0x006b:
        r1 = r5.getNextEntry();	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        if (r1 != 0) goto L_0x00aa;
    L_0x0071:
        r1 = f3275a;	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r9 = "zipFileEntry add new file:";
        r6.<init>(r9);	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r6 = r6.append(r13);	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r1, r6);	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r6 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r6.<init>(r7);	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r1 = new java.util.zip.ZipEntry;	 Catch:{ Exception -> 0x0109, all -> 0x014c }
        r1.<init>(r13);	 Catch:{ Exception -> 0x0109, all -> 0x014c }
        r4.putNextEntry(r1);	 Catch:{ Exception -> 0x0109, all -> 0x014c }
    L_0x0092:
        r1 = r6.read(r8);	 Catch:{ Exception -> 0x0109, all -> 0x014c }
        if (r1 > 0) goto L_0x0104;
    L_0x0098:
        r4.closeEntry();	 Catch:{ Exception -> 0x0109, all -> 0x014c }
        r6.close();	 Catch:{ Exception -> 0x0127 }
    L_0x009e:
        r5.close();	 Catch:{ Exception -> 0x012a }
    L_0x00a1:
        r4.close();	 Catch:{ Exception -> 0x012d }
    L_0x00a4:
        r2.delete();	 Catch:{ Exception -> 0x0130 }
    L_0x00a7:
        r0 = 1;
        goto L_0x001f;
    L_0x00aa:
        r6 = r1.getName();	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r6 = r6.equals(r13);	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        if (r6 != 0) goto L_0x006b;
    L_0x00b4:
        r6 = f3275a;	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r10 = "zipFileEntry add old file:";
        r9.<init>(r10);	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r10 = r1.getName();	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r9 = r9.append(r10);	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r9 = r9.toString();	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        com.shuame.mobile.sdk.impl.utils.C1228g.m3458a(r6, r9);	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r6 = new java.util.zip.ZipEntry;	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r1 = r1.getName();	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r6.<init>(r1);	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        r4.putNextEntry(r6);	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
    L_0x00d8:
        r1 = r5.read(r8);	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        if (r1 <= 0) goto L_0x006b;
    L_0x00de:
        r6 = 0;
        r4.write(r8, r6, r1);	 Catch:{ Exception -> 0x00e3, all -> 0x0148 }
        goto L_0x00d8;
    L_0x00e3:
        r1 = move-exception;
        r11 = r4;
        r4 = r5;
        r5 = r3;
        r3 = r11;
    L_0x00e8:
        r1.printStackTrace();	 Catch:{ all -> 0x014f }
        if (r5 == 0) goto L_0x00f0;
    L_0x00ed:
        r5.close();	 Catch:{ Exception -> 0x0133 }
    L_0x00f0:
        if (r4 == 0) goto L_0x00f5;
    L_0x00f2:
        r4.close();	 Catch:{ Exception -> 0x0135 }
    L_0x00f5:
        if (r3 == 0) goto L_0x00fa;
    L_0x00f7:
        r3.close();	 Catch:{ Exception -> 0x0137 }
    L_0x00fa:
        if (r2 == 0) goto L_0x001f;
    L_0x00fc:
        r2.delete();	 Catch:{ Exception -> 0x0101 }
        goto L_0x001f;
    L_0x0101:
        r1 = move-exception;
        goto L_0x001f;
    L_0x0104:
        r3 = 0;
        r4.write(r8, r3, r1);	 Catch:{ Exception -> 0x0109, all -> 0x014c }
        goto L_0x0092;
    L_0x0109:
        r1 = move-exception;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        goto L_0x00e8;
    L_0x010e:
        r0 = move-exception;
        r2 = r3;
        r5 = r3;
        r6 = r3;
    L_0x0112:
        if (r6 == 0) goto L_0x0117;
    L_0x0114:
        r6.close();	 Catch:{ Exception -> 0x0139 }
    L_0x0117:
        if (r5 == 0) goto L_0x011c;
    L_0x0119:
        r5.close();	 Catch:{ Exception -> 0x013b }
    L_0x011c:
        if (r3 == 0) goto L_0x0121;
    L_0x011e:
        r3.close();	 Catch:{ Exception -> 0x013d }
    L_0x0121:
        if (r2 == 0) goto L_0x0126;
    L_0x0123:
        r2.delete();	 Catch:{ Exception -> 0x013f }
    L_0x0126:
        throw r0;
    L_0x0127:
        r0 = move-exception;
        goto L_0x009e;
    L_0x012a:
        r0 = move-exception;
        goto L_0x00a1;
    L_0x012d:
        r0 = move-exception;
        goto L_0x00a4;
    L_0x0130:
        r0 = move-exception;
        goto L_0x00a7;
    L_0x0133:
        r1 = move-exception;
        goto L_0x00f0;
    L_0x0135:
        r1 = move-exception;
        goto L_0x00f5;
    L_0x0137:
        r1 = move-exception;
        goto L_0x00fa;
    L_0x0139:
        r1 = move-exception;
        goto L_0x0117;
    L_0x013b:
        r1 = move-exception;
        goto L_0x011c;
    L_0x013d:
        r1 = move-exception;
        goto L_0x0121;
    L_0x013f:
        r1 = move-exception;
        goto L_0x0126;
    L_0x0141:
        r0 = move-exception;
        r5 = r3;
        r6 = r3;
        goto L_0x0112;
    L_0x0145:
        r0 = move-exception;
        r6 = r3;
        goto L_0x0112;
    L_0x0148:
        r0 = move-exception;
        r6 = r3;
        r3 = r4;
        goto L_0x0112;
    L_0x014c:
        r0 = move-exception;
        r3 = r4;
        goto L_0x0112;
    L_0x014f:
        r0 = move-exception;
        r6 = r5;
        r5 = r4;
        goto L_0x0112;
    L_0x0153:
        r1 = move-exception;
        r2 = r3;
        r4 = r3;
        r5 = r3;
        goto L_0x00e8;
    L_0x0158:
        r1 = move-exception;
        r4 = r3;
        r5 = r3;
        goto L_0x00e8;
    L_0x015c:
        r1 = move-exception;
        r4 = r5;
        r5 = r3;
        goto L_0x00e8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.sdk.impl.utils.j.b(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0066 A:{SYNTHETIC, Splitter: B:41:0x0066} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006b A:{SYNTHETIC, Splitter: B:44:0x006b} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0066 A:{SYNTHETIC, Splitter: B:41:0x0066} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006b A:{SYNTHETIC, Splitter: B:44:0x006b} */
    /* renamed from: b */
    public static byte[] m3498b(java.lang.String r7, java.lang.String r8) {
        /*
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ Exception -> 0x007d, all -> 0x0060 }
        r1.<init>(r7);	 Catch:{ Exception -> 0x007d, all -> 0x0060 }
        r2 = r1.exists();	 Catch:{ Exception -> 0x007d, all -> 0x0060 }
        if (r2 != 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r3 = new java.util.zip.ZipFile;	 Catch:{ Exception -> 0x007d, all -> 0x0060 }
        r3.<init>(r1);	 Catch:{ Exception -> 0x007d, all -> 0x0060 }
        r1 = r3.getEntry(r8);	 Catch:{ Exception -> 0x0081, all -> 0x0077 }
        if (r1 != 0) goto L_0x001e;
    L_0x0018:
        r3.close();	 Catch:{ IOException -> 0x001c }
        goto L_0x000c;
    L_0x001c:
        r1 = move-exception;
        goto L_0x000c;
    L_0x001e:
        r2 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0081, all -> 0x0077 }
        r1 = r3.getInputStream(r1);	 Catch:{ Exception -> 0x0081, all -> 0x0077 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x0081, all -> 0x0077 }
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x004f }
        r1.<init>();	 Catch:{ Exception -> 0x004f }
        r4 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r4 = new byte[r4];	 Catch:{ Exception -> 0x004f }
    L_0x0030:
        r5 = r2.read(r4);	 Catch:{ Exception -> 0x004f }
        r6 = -1;
        if (r5 != r6) goto L_0x004a;
    L_0x0037:
        r1.flush();	 Catch:{ Exception -> 0x004f }
        r1.close();	 Catch:{ Exception -> 0x004f }
        r0 = r1.toByteArray();	 Catch:{ Exception -> 0x004f }
        r3.close();	 Catch:{ IOException -> 0x006f }
    L_0x0044:
        r2.close();	 Catch:{ IOException -> 0x0048 }
        goto L_0x000c;
    L_0x0048:
        r1 = move-exception;
        goto L_0x000c;
    L_0x004a:
        r6 = 0;
        r1.write(r4, r6, r5);	 Catch:{ Exception -> 0x004f }
        goto L_0x0030;
    L_0x004f:
        r1 = move-exception;
    L_0x0050:
        r1.printStackTrace();	 Catch:{ all -> 0x007b }
        if (r3 == 0) goto L_0x0058;
    L_0x0055:
        r3.close();	 Catch:{ IOException -> 0x0071 }
    L_0x0058:
        if (r2 == 0) goto L_0x000c;
    L_0x005a:
        r2.close();	 Catch:{ IOException -> 0x005e }
        goto L_0x000c;
    L_0x005e:
        r1 = move-exception;
        goto L_0x000c;
    L_0x0060:
        r1 = move-exception;
        r2 = r0;
        r3 = r0;
        r0 = r1;
    L_0x0064:
        if (r3 == 0) goto L_0x0069;
    L_0x0066:
        r3.close();	 Catch:{ IOException -> 0x0073 }
    L_0x0069:
        if (r2 == 0) goto L_0x006e;
    L_0x006b:
        r2.close();	 Catch:{ IOException -> 0x0075 }
    L_0x006e:
        throw r0;
    L_0x006f:
        r1 = move-exception;
        goto L_0x0044;
    L_0x0071:
        r1 = move-exception;
        goto L_0x0058;
    L_0x0073:
        r1 = move-exception;
        goto L_0x0069;
    L_0x0075:
        r1 = move-exception;
        goto L_0x006e;
    L_0x0077:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        goto L_0x0064;
    L_0x007b:
        r0 = move-exception;
        goto L_0x0064;
    L_0x007d:
        r1 = move-exception;
        r2 = r0;
        r3 = r0;
        goto L_0x0050;
    L_0x0081:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuame.mobile.sdk.impl.utils.j.b(java.lang.String, java.lang.String):byte[]");
    }
}
