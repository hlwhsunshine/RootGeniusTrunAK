package com.shuame.mobile.utils;

import android.content.Context;

public class ShuameEncrypt {
    static {
        System.loadLibrary("shuameencrypt");
    }

    public static native byte[] encryptBytes(Context context, int i, int i2, byte[] bArr);
}
