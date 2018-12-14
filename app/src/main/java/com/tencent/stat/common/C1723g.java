package com.tencent.stat.common;

import android.content.p013pm.PermissionInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import java.io.File;

/* renamed from: com.tencent.stat.common.g */
public class C1723g {
    /* renamed from: a */
    private static int m4743a(int i, int i2) {
        return i < i2 ? i : i2;
    }

    /* renamed from: a */
    private static int m4744a(Options options, int i) {
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        i2 = ((i3 > i2 ? (int) Math.floor((double) (((float) i2) / ((float) i))) : (int) Math.floor((double) (((float) i3) / ((float) i)))) / 2) * 2;
        return i2 <= 0 ? 0 : i2;
    }

    /* renamed from: a */
    private static Bitmap m4745a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        float a = 240.0f / ((float) C1723g.m4743a(bitmap.getWidth(), bitmap.getHeight()));
        matrix.postScale(a, a);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: a */
    private static Bitmap m4746a(String str, int i) {
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
                return null;
            }
            options.inSampleSize = C1723g.m4744a(options, i);
            options.inJustDecodeBounds = false;
            options.inDither = false;
            options.inPreferredConfig = Config.RGB_565;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            Bitmap a = C1723g.m4745a(decodeFile);
            if (decodeFile == null || decodeFile.isRecycled()) {
                return a;
            }
            decodeFile.recycle();
            return a;
        } catch (OutOfMemoryError e) {
            System.gc();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f A:{SYNTHETIC, Splitter: B:17:0x002f} */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038 A:{Catch:{ IOException -> 0x003c }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0048 A:{SYNTHETIC, Splitter: B:29:0x0048} */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0051 A:{Catch:{ IOException -> 0x0055 }} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005e A:{SYNTHETIC, Splitter: B:39:0x005e} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0067 A:{Catch:{ IOException -> 0x006b }} */
    /* renamed from: a */
    private static void m4747a(android.graphics.Bitmap r3, java.io.File r4) {
        /*
        if (r3 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r4.toString();
        r2 = 0;
        r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0028, IOException -> 0x0041, all -> 0x005a }
        r1.<init>(r4);	 Catch:{ FileNotFoundException -> 0x0028, IOException -> 0x0041, all -> 0x005a }
        r0 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ FileNotFoundException -> 0x0074, IOException -> 0x0072 }
        r2 = 75;
        r3.compress(r0, r2, r1);	 Catch:{ FileNotFoundException -> 0x0074, IOException -> 0x0072 }
        r1.flush();	 Catch:{ FileNotFoundException -> 0x0074, IOException -> 0x0072 }
        r1.close();	 Catch:{ IOException -> 0x0023 }
        r0 = r3.isRecycled();	 Catch:{ IOException -> 0x0023 }
        if (r0 != 0) goto L_0x0002;
    L_0x001f:
        r3.recycle();	 Catch:{ IOException -> 0x0023 }
        goto L_0x0002;
    L_0x0023:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0002;
    L_0x0028:
        r0 = move-exception;
        r1 = r2;
    L_0x002a:
        r0.printStackTrace();	 Catch:{ all -> 0x0070 }
        if (r1 == 0) goto L_0x0032;
    L_0x002f:
        r1.close();	 Catch:{ IOException -> 0x003c }
    L_0x0032:
        r0 = r3.isRecycled();	 Catch:{ IOException -> 0x003c }
        if (r0 != 0) goto L_0x0002;
    L_0x0038:
        r3.recycle();	 Catch:{ IOException -> 0x003c }
        goto L_0x0002;
    L_0x003c:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0002;
    L_0x0041:
        r0 = move-exception;
        r1 = r2;
    L_0x0043:
        r0.printStackTrace();	 Catch:{ all -> 0x0070 }
        if (r1 == 0) goto L_0x004b;
    L_0x0048:
        r1.close();	 Catch:{ IOException -> 0x0055 }
    L_0x004b:
        r0 = r3.isRecycled();	 Catch:{ IOException -> 0x0055 }
        if (r0 != 0) goto L_0x0002;
    L_0x0051:
        r3.recycle();	 Catch:{ IOException -> 0x0055 }
        goto L_0x0002;
    L_0x0055:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0002;
    L_0x005a:
        r0 = move-exception;
        r1 = r2;
    L_0x005c:
        if (r1 == 0) goto L_0x0061;
    L_0x005e:
        r1.close();	 Catch:{ IOException -> 0x006b }
    L_0x0061:
        r1 = r3.isRecycled();	 Catch:{ IOException -> 0x006b }
        if (r1 != 0) goto L_0x006a;
    L_0x0067:
        r3.recycle();	 Catch:{ IOException -> 0x006b }
    L_0x006a:
        throw r0;
    L_0x006b:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x006a;
    L_0x0070:
        r0 = move-exception;
        goto L_0x005c;
    L_0x0072:
        r0 = move-exception;
        goto L_0x0043;
    L_0x0074:
        r0 = move-exception;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.common.g.a(android.graphics.Bitmap, java.io.File):void");
    }

    /* renamed from: a */
    public static void m4748a(String str, File file) {
        C1723g.m4747a(C1723g.m4746a(str, (int) PermissionInfo.PROTECTION_MASK_FLAGS), file);
    }
}
