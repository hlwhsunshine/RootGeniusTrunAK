package com.shuame.rootgenius.p115ui.adapter;

import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;

/* renamed from: com.shuame.rootgenius.ui.adapter.k */
final /* synthetic */ class C1518k {
    /* renamed from: a */
    static final /* synthetic */ int[] f4320a = new int[Status.values().length];

    static {
        try {
            f4320a[Status.STARTING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4320a[Status.DOWNLOADING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f4320a[Status.PENDING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f4320a[Status.ERROR_STOPED.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f4320a[Status.STOPING.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f4320a[Status.STOPED.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f4320a[Status.PENDING_STOPED.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f4320a[Status.FINISHED.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
    }
}
