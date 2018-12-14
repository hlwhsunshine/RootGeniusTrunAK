package com.shuame.rootgenius.common.util;

import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Type;

/* renamed from: com.shuame.rootgenius.common.util.k */
final /* synthetic */ class C1398k {
    /* renamed from: a */
    static final /* synthetic */ int[] f3878a = new int[Type.values().length];

    static {
        try {
            f3878a[Type.APK.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3878a[Type.ROM.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
