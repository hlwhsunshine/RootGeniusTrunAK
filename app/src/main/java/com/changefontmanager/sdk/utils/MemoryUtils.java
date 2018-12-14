package com.changefontmanager.sdk.utils;

import android.os.Environment;
import android.os.StatFs;

public class MemoryUtils {
    private static final int ERROR = -1;

    private static boolean externalMemoryAvailable() {
        return Environment.getExternalStorageState().equals("mounted") && Environment.getExternalStorageDirectory().canWrite();
    }

    public static long getAvailableExternalMemorySize() {
        Object obj = (Environment.getExternalStorageState().equals("mounted") && Environment.getExternalStorageDirectory().canWrite()) ? 1 : null;
        if (obj == null) {
            return -1;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }
}
