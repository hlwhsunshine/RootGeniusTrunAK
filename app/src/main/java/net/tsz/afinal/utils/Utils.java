package net.tsz.afinal.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class Utils {
    private static final long INITIALCRC = -1;
    private static final long POLY64REV = -7661587058870466123L;
    private static final String TAG = "BitmapCommonUtils";
    private static long[] sCrcTable = new long[256];

    static {
        for (int i = 0; i < 256; i++) {
            long j = (long) i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j >> 1) ^ ((((int) j) & 1) != 0 ? POLY64REV : 0);
            }
            sCrcTable[i] = j;
        }
    }

    public static byte[] copyOfRange(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(i)).append(" > ").append(i2).toString());
        }
        Object obj = new byte[i3];
        System.arraycopy(bArr, i, obj, 0, Math.min(bArr.length - i, i3));
        return obj;
    }

    public static final long crc64Long(String str) {
        return (str == null || str.length() == 0) ? 0 : crc64Long(getBytes(str));
    }

    public static final long crc64Long(byte[] bArr) {
        long j = -1;
        for (byte b : bArr) {
            j = (j >> 8) ^ sCrcTable[(((int) j) ^ b) & 255];
        }
        return j;
    }

    public static int getBitmapSize(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static byte[] getBytes(String str) {
        int i = 0;
        byte[] bArr = new byte[(str.length() * 2)];
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        int i2 = 0;
        while (i < length) {
            char c = toCharArray[i];
            int i3 = i2 + 1;
            bArr[i2] = (byte) (c & 255);
            i2 = i3 + 1;
            bArr[i3] = (byte) (c >> 8);
            i++;
        }
        return bArr;
    }

    public static File getDiskCacheDir(Context context, String str) {
        return new File(new StringBuilder(String.valueOf("mounted".equals(Environment.getExternalStorageState()) ? getExternalCacheDir(context).getPath() : context.getCacheDir().getPath())).append(File.separator).append(str).toString());
    }

    public static File getExternalCacheDir(Context context) {
        return new File(new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath())).append("/Android/data/" + context.getPackageName() + "/cache/").toString());
    }

    public static long getUsableSpace(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static boolean isSameKey(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (bArr2.length < length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] makeKey(String str) {
        return getBytes(str);
    }
}
