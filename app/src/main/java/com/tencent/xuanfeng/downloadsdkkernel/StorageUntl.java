package com.tencent.xuanfeng.downloadsdkkernel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import java.io.File;
import java.util.ArrayList;

public class StorageUntl {
    public static final int PATH_ERROR = 101;
    public static final int PATH_FULL = 102;

    static class Info {
        String path;
        long size;

        Info() {
        }
    }

    static long getCardAvailableSize(String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            StatFs statFs = new StatFs(str);
            long blockSize = (long) statFs.getBlockSize();
            long availableBlocks = (long) statFs.getAvailableBlocks();
            new StringBuilder("create_task getCardAvailableSize:").append(System.currentTimeMillis() - currentTimeMillis);
            return blockSize * availableBlocks;
        } catch (Exception e) {
            return 4294967296L;
        }
    }

    @SuppressLint({"NewApi"})
    static Info getMaxSize(ArrayList<String> arrayList) {
        int i = 0;
        Info info = new Info();
        if (arrayList.size() == 1) {
            info.path = (String) arrayList.get(0);
            info.size = getCardAvailableSize((String) arrayList.get(0));
        } else {
            int i2 = 0;
            while (i < arrayList.size()) {
                if (new File((String) arrayList.get(i)).canWrite()) {
                    if (VERSION.SDK_INT <= 18 || !((String) arrayList.get(i)).equals(Environment.getExternalStorageDirectory().getPath())) {
                        long cardAvailableSize = getCardAvailableSize((String) arrayList.get(i));
                        if (cardAvailableSize > info.size) {
                            info.size = cardAvailableSize;
                            i2 = i;
                        }
                    } else {
                        info.path = (String) arrayList.get(i);
                        info.size = getCardAvailableSize((String) arrayList.get(i));
                        return info;
                    }
                }
                i++;
            }
            info.path = (String) arrayList.get(i2);
        }
        return info;
    }

    static ArrayList<String> getSDDir(Context context) {
        if (context == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            String[] strArr = (String[]) storageManager.getClass().getMethod("getVolumePaths", new Class[0]).invoke(storageManager, new Object[0]);
            if (strArr != null) {
                for (Object obj : strArr) {
                    if ("mounted".equals((String) storageManager.getClass().getMethod("getVolumeState", new Class[]{String.class}).invoke(storageManager, new Object[]{obj}))) {
                        arrayList.add(strArr[r4]);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            arrayList.add(Environment.getExternalStorageDirectory().getPath());
        }
        return arrayList;
    }

    static String getSize(long j) {
        StringBuilder stringBuilder = new StringBuilder();
        if (j > 1024) {
            long j2 = j / 1024;
            if (j2 > 1024) {
                j2 /= 1024;
                if (j2 > 1024) {
                    stringBuilder.append(j2 / 1024).append("GB");
                } else {
                    stringBuilder.append(j2).append("MB");
                }
            } else {
                stringBuilder.append(j2).append("KB");
            }
        } else {
            stringBuilder.append(j).append("B");
        }
        return stringBuilder.toString();
    }

    @SuppressLint({"NewApi"})
    static boolean isDirCanWrite(String str) {
        if (str == null) {
            return false;
        }
        try {
            if (str.length() <= 0 || "/".equals(str)) {
                return false;
            }
            int length = str.length() - 1;
            if ("/".equals(str.substring(length))) {
                str = str.substring(0, length);
            }
            if (str.lastIndexOf("/") < 0) {
                return false;
            }
            File file = new File(str);
            if (!file.exists()) {
                try {
                    if (!file.mkdirs()) {
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            if (!file.canWrite()) {
                return false;
            }
            if (VERSION.SDK_INT <= 18) {
                return true;
            }
            File file2 = new File(file.getAbsoluteFile() + "/test");
            file2.mkdirs();
            if (!file2.exists()) {
                return false;
            }
            file2.delete();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }
}
