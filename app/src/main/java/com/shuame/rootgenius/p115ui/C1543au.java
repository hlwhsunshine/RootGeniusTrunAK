package com.shuame.rootgenius.p115ui;

import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;

/* renamed from: com.shuame.rootgenius.ui.au */
final /* synthetic */ class C1543au {
    /* renamed from: a */
    static final /* synthetic */ int[] f4361a = new int[Status.values().length];

    static {
        try {
            f4361a[Status.ERROR_STOPED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4361a[Status.FINISHED.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
