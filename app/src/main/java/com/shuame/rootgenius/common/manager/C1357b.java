package com.shuame.rootgenius.common.manager;

import com.shuame.rootgenius.common.manager.AppManager.AppStatus;

/* renamed from: com.shuame.rootgenius.common.manager.b */
final /* synthetic */ class C1357b {
    /* renamed from: a */
    static final /* synthetic */ int[] f3713a = new int[AppStatus.values().length];

    static {
        try {
            f3713a[AppStatus.SILENT_INSTALL_SUCCESS.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3713a[AppStatus.SYSTEM_INSTALL_SUCCESS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f3713a[AppStatus.SILENT_INSTALLING.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f3713a[AppStatus.SYSTEM_INSTALL.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f3713a[AppStatus.SILENT_INSTALL_FAILURE.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f3713a[AppStatus.SYSTEM_UNINSTALL_SUCCESS.ordinal()] = 6;
        } catch (NoSuchFieldError e6) {
        }
    }
}
