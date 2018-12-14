package com.shuame.rootgenius.p115ui.adapter;

import com.shuame.rootgenius.common.manager.AppManager.AppStatus;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;

/* renamed from: com.shuame.rootgenius.ui.adapter.e */
final /* synthetic */ class C1512e {
    /* renamed from: a */
    static final /* synthetic */ int[] f4307a = new int[Status.values().length];
    /* renamed from: b */
    static final /* synthetic */ int[] f4308b = new int[AppStatus.values().length];

    static {
        try {
            f4308b[AppStatus.PENDING_INSTALL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4308b[AppStatus.CANCELLED_PENDING_INSTALL.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f4308b[AppStatus.SIGN_CHECKING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f4308b[AppStatus.SIGN_NOT_SAME.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f4308b[AppStatus.SILENT_INSTALLING.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f4308b[AppStatus.SILENT_INSTALL_SUCCESS.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f4308b[AppStatus.SILENT_INSTALL_FAILURE.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f4308b[AppStatus.SYSTEM_INSTALL.ordinal()] = 8;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f4308b[AppStatus.SYSTEM_INSTALL_SUCCESS.ordinal()] = 9;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f4307a[Status.PENDING.ordinal()] = 1;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f4307a[Status.DOWNLOADING.ordinal()] = 2;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f4307a[Status.STOPING.ordinal()] = 3;
        } catch (NoSuchFieldError e12) {
        }
        try {
            f4307a[Status.ERROR_STOPED.ordinal()] = 4;
        } catch (NoSuchFieldError e13) {
        }
        try {
            f4307a[Status.PENDING_STOPED.ordinal()] = 5;
        } catch (NoSuchFieldError e14) {
        }
        try {
            f4307a[Status.STOPED.ordinal()] = 6;
        } catch (NoSuchFieldError e15) {
        }
        try {
            f4307a[Status.FINISHED.ordinal()] = 7;
        } catch (NoSuchFieldError e16) {
        }
        try {
            f4307a[Status.STARTING.ordinal()] = 8;
        } catch (NoSuchFieldError e17) {
        }
    }
}
