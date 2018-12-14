package com.baidu.mobads.p021j;

import android.content.Context;
import android.os.Environment;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import java.io.File;

/* renamed from: com.baidu.mobads.j.i */
public class C0335i implements IXAdIOUtils {
    public void copyFileFromAssetsTo(Context context, String str, String str2) {
        try {
            C0338m.m569a().mo5038k().copyFileInputStream(context.getAssets().open(str), str2);
        } catch (Throwable e) {
            C0338m.m569a().mo5033f().mo4924d(e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0018  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x001d  */
    public void copyFileInputStream(java.io.InputStream r5, java.lang.String r6) {
        /*
        r4 = this;
        r2 = 0;
        r1 = new java.io.FileOutputStream;	 Catch:{ all -> 0x0032 }
        r1.<init>(r6);	 Catch:{ all -> 0x0032 }
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ all -> 0x0015 }
    L_0x000a:
        r2 = r5.read(r0);	 Catch:{ all -> 0x0015 }
        if (r2 <= 0) goto L_0x0021;
    L_0x0010:
        r3 = 0;
        r1.write(r0, r3, r2);	 Catch:{ all -> 0x0015 }
        goto L_0x000a;
    L_0x0015:
        r0 = move-exception;
    L_0x0016:
        if (r5 == 0) goto L_0x001b;
    L_0x0018:
        r5.close();
    L_0x001b:
        if (r1 == 0) goto L_0x0020;
    L_0x001d:
        r1.close();
    L_0x0020:
        throw r0;
    L_0x0021:
        r5.close();	 Catch:{ all -> 0x0015 }
        r1.close();	 Catch:{ all -> 0x0015 }
        if (r5 == 0) goto L_0x002c;
    L_0x0029:
        r5.close();
    L_0x002c:
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r1.close();
    L_0x0031:
        return;
    L_0x0032:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.j.i.copyFileInputStream(java.io.InputStream, java.lang.String):void");
    }

    public File deleteFileRecursive(File file) {
        try {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= listFiles.length) {
                        break;
                    }
                    File deleteFileRecursive = deleteFileRecursive(listFiles[i2]);
                    if (deleteFileRecursive != null) {
                        return deleteFileRecursive;
                    }
                    i = i2 + 1;
                }
            }
            return file.delete() ? null : file;
        } catch (Exception e) {
            return file.delete() ? null : file;
        }
    }

    public File deleteFileRecursive(String str) {
        return deleteFileRecursive(new File(str));
    }

    public File getExternalFilesDir(Context context) {
        try {
            return C0338m.m569a().mo5041n().isUseOldStoragePath() ? Environment.getExternalStorageDirectory() : context.getExternalFilesDir(null);
        } catch (Exception e) {
            C0338m.m569a().mo5033f().mo4929e("XAdIOUtils", e.getMessage());
            return null;
        }
    }

    public String getStoreagePath(Context context) {
        return getStoreagePath(context, IXAdIOUtils.DEFAULT_SD_CARD_PATH, IXAdIOUtils.DEFAULT_CACHE_PATH);
    }

    public String getStoreagePath(Context context, String str, String str2) {
        try {
            return getExternalFilesDir(context).getPath() + str2;
        } catch (Exception e) {
            return str + str2;
        }
    }

    public boolean renameFile(String str, String str2) {
        try {
            File file = new File(str);
            return file.exists() ? file.renameTo(new File(str2)) : false;
        } catch (Exception e) {
            return false;
        }
    }
}
