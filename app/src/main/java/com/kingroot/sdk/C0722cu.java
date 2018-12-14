package com.kingroot.sdk;

/* renamed from: com.kingroot.sdk.cu */
public class C0722cu {
    /* renamed from: a */
    public static boolean m1743a(int i, int... iArr) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: aD */
    public static boolean m1744aD() {
        long parseLong;
        try {
            parseLong = Long.parseLong(C0625ao.f1552bJ);
        } catch (Exception e) {
            e.printStackTrace();
            parseLong = 0;
        }
        return parseLong >= 200000;
    }
}
