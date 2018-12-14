package com.shuame.rootgenius.p115ui.adapter;

import com.shuame.rootgenius.common.manager.AppManager.AppStatus;
import com.shuame.rootgenius.common.qqdownload.QQDownloadFile.Status;

/* renamed from: com.shuame.rootgenius.ui.adapter.q */
final /* synthetic */ class C1526q {
    /* renamed from: a */
    static final /* synthetic */ int[] f4342a = new int[Status.values().length];
    /* renamed from: b */
    static final /* synthetic */ int[] f4343b = new int[AppStatus.values().length];

    static {
        try {
            f4343b[AppStatus.PENDING_INSTALL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f4343b[AppStatus.SIGN_CHECKING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f4343b[AppStatus.SILENT_INSTALLING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f4343b[AppStatus.SILENT_INSTALL_FAILURE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f4343b[AppStatus.SYSTEM_INSTALL.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f4343b[AppStatus.SILENT_INSTALL_SUCCESS.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f4343b[AppStatus.SYSTEM_INSTALL_SUCCESS.ordinal()] = 7;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f4342a[Status.PENDING.ordinal()] = 1;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f4342a[Status.DOWNLOADING.ordinal()] = 2;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f4342a[Status.STOPING.ordinal()] = 3;
        } catch (NoSuchFieldError e10) {
        }
        try {
            f4342a[Status.ERROR_STOPED.ordinal()] = 4;
        } catch (NoSuchFieldError e11) {
        }
        try {
            f4342a[Status.PENDING_STOPED.ordinal()] = 5;
        } catch (NoSuchFieldError e12) {
        }
        try {
            f4342a[Status.STOPED.ordinal()] = 6;
        } catch (NoSuchFieldError e13) {
        }
        try {
            f4342a[Status.FINISHED.ordinal()] = 7;
        } catch (NoSuchFieldError e14) {
        }
        try {
            f4342a[Status.STARTING.ordinal()] = 8;
        } catch (NoSuchFieldError e15) {
        }
    }
}
