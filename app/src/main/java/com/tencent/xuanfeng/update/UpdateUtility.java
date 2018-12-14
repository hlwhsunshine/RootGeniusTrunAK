package com.tencent.xuanfeng.update;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

public class UpdateUtility {
    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    fileInputStream.close();
                    return new BigInteger(1, instance.digest()).toString(16);
                }
                instance.update(bArr, 0, read);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045 A:{SYNTHETIC, Splitter: B:19:0x0045} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004a A:{SYNTHETIC, Splitter: B:22:0x004a} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045 A:{SYNTHETIC, Splitter: B:19:0x0045} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004a A:{SYNTHETIC, Splitter: B:22:0x004a} */
    public static boolean installKernelModule(com.tencent.xuanfeng.update.KernelModuleInfo r8, com.tencent.xuanfeng.update.KernelModuleInfo r9) {
        /*
        r2 = 0;
        r0 = 0;
        r1 = 1;
        r5 = new java.io.File;	 Catch:{ IOException -> 0x0065 }
        r3 = r9.kernelLocalPath;	 Catch:{ IOException -> 0x0065 }
        r5.<init>(r3);	 Catch:{ IOException -> 0x0065 }
        r3 = new java.io.File;	 Catch:{ IOException -> 0x0065 }
        r4 = r8.kernelLocalPath;	 Catch:{ IOException -> 0x0065 }
        r3.<init>(r4);	 Catch:{ IOException -> 0x0065 }
        r4 = r3.exists();	 Catch:{ IOException -> 0x0065 }
        if (r4 != 0) goto L_0x0018;
    L_0x0017:
        return r0;
    L_0x0018:
        r4 = r5.exists();	 Catch:{ IOException -> 0x0065 }
        if (r4 == 0) goto L_0x0021;
    L_0x001e:
        r5.delete();	 Catch:{ IOException -> 0x0065 }
    L_0x0021:
        r5.createNewFile();	 Catch:{ IOException -> 0x0065 }
        r4 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x0065 }
        r4.<init>(r3);	 Catch:{ IOException -> 0x0065 }
        r3 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0068 }
        r3.<init>(r5);	 Catch:{ IOException -> 0x0068 }
        r5 = 20480; // 0x5000 float:2.8699E-41 double:1.01185E-319;
        r5 = new byte[r5];	 Catch:{ IOException -> 0x0058 }
    L_0x0032:
        r6 = 0;
        r7 = 20480; // 0x5000 float:2.8699E-41 double:1.01185E-319;
        r6 = r4.read(r5, r6, r7);	 Catch:{ IOException -> 0x0058 }
        r7 = -1;
        if (r6 != r7) goto L_0x0053;
    L_0x003c:
        r3.flush();	 Catch:{ IOException -> 0x0058 }
        r3.close();	 Catch:{ IOException -> 0x0058 }
        r0 = r1;
    L_0x0043:
        if (r2 == 0) goto L_0x0048;
    L_0x0045:
        r2.close();	 Catch:{ IOException -> 0x0060 }
    L_0x0048:
        if (r4 == 0) goto L_0x0017;
    L_0x004a:
        r4.close();	 Catch:{ IOException -> 0x004e }
        goto L_0x0017;
    L_0x004e:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0017;
    L_0x0053:
        r7 = 0;
        r3.write(r5, r7, r6);	 Catch:{ IOException -> 0x0058 }
        goto L_0x0032;
    L_0x0058:
        r1 = move-exception;
        r2 = r3;
        r3 = r4;
    L_0x005b:
        r1.printStackTrace();
        r4 = r3;
        goto L_0x0043;
    L_0x0060:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0048;
    L_0x0065:
        r1 = move-exception;
        r3 = r2;
        goto L_0x005b;
    L_0x0068:
        r1 = move-exception;
        r3 = r4;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xuanfeng.update.UpdateUtility.installKernelModule(com.tencent.xuanfeng.update.KernelModuleInfo, com.tencent.xuanfeng.update.KernelModuleInfo):boolean");
    }

    public static void makesureDirCreated(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
