package com.shuame.mobile.utils;

public final class NativeUtils {
    static {
        System.loadLibrary("shuametools");
    }

    public static native int checkRootFileExecute(String str);

    public static native int ensureFileExecute(String str);
}
