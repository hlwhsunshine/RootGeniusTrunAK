package com.shuame.rootgenius.sdk;

import android.util.Base64;
import com.shuame.rootgenius.sdk.proto.ProtoBase;
import java.util.HashMap;

public class JniHelper {
    private static final String TAG = JniHelper.class.getSimpleName();

    public static class Data implements Cloneable {
        Object cntx;
        HashMap field;

        public Data clone() {
            try {
                return (Data) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    static {
        System.loadLibrary(RgsdkConfig.AZ_RGSDK);
    }

    public static void asyncPostData(String str, String str2) {
        new Thread(new C1467b(str, str2)).start();
    }

    public static byte[] base64Decode(String str) {
        return Base64.decode(str, 0);
    }

    public static String base64Encode(byte[] bArr) {
        return new String(Base64.encode(bArr, 0));
    }

    public static String calcMd5(byte[] bArr) {
        return CommUtils.calcMd5(bArr);
    }

    public static native int checkState(String str);

    public static native byte[] decrypt(byte[] bArr);

    public static int download(String str, String str2) {
        return CommUtils.download(str, str2);
    }

    public static native byte[] encrypt(byte[] bArr);

    public static native boolean hasSetuid(String str);

    public static int install(String str) {
        return C1469d.m4072b(str);
    }

    public static int logcat(String str) {
        C1473h.m4104c(TAG, str);
        return 0;
    }

    public static String postData(String str, String str2) {
        C1473h.m4104c(TAG, "server:" + str + ",data:" + str2);
        byte[] postReq = ProtoBase.postReq(str, str2);
        return postReq != null ? new String(postReq) : "";
    }

    public static native int rgMain(Data data);

    public static native String rgsInstall(Object obj, String str);

    public static native String rgsexec(Object obj, String str, String str2);

    public static int uninstall(String str) {
        return C1469d.m4074c(str);
    }

    public static boolean verify() {
        return true;
    }

    public static native boolean verify(Object obj);
}
