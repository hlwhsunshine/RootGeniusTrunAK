package com.changefontmanager.sdk.utils;

import android.os.Environment;

public class Constant {
    public static final String FOLDER_FONT = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath())).append("/fontsdk/").toString();
    private static String FOLDER_MIUI_FONT = null;
    public static final String FOLDER_MIUI_SYSTEM_FONT = new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath())).append("/MIUI/theme/").toString();
    private static String FOLDER_MIUI_TEMP = null;
    /* renamed from: M */
    private static String f1164M = "com.android.thememanager";
    private static String MEIZU_DIR = "/data/mtheme";
    /* renamed from: N */
    private static String f1165N = "com.android.thememanager.ThemeResourceTabActivity";
    /* renamed from: O */
    private static String f1166O = "com.huawei.android.thememanager";
    /* renamed from: P */
    private static String f1167P = "com.huawei.android.thememanager.font.FontManagerActivity";
    /* renamed from: Q */
    private static String f1168Q = "com.baidu.thememanager.ui";
    /* renamed from: R */
    private static String f1169R = "com.baidu.thememanager.ui.OpenThemeActivity";
    /* renamed from: S */
    private static String f1170S = "com.android.settings";
    private static String SDCARD_FONT_APK = null;
    private static String SDCARD_FONT_EN = null;
    private static String SDCARD_FONT_ZH = null;
    private static String SYSTEM_FONT_EN = "/system/fonts/DroidSans.ttf";
    private static String SYSTEM_FONT_EN_14 = "/system/fonts/Roboto-Regular.ttf";
    private static String SYSTEM_FONT_EN_MIUI = "/system/fonts/Arial.ttf";
    private static String SYSTEM_FONT_FangZhengLTH = "/system/fonts/FangZhengLTH.ttf";
    private static String SYSTEM_FONT_MTLMR3M = "/system/fonts/MTLmr3m.ttf";
    private static String SYSTEM_FONT_ZH = "/system/fonts/DroidSansFallback.ttf";
    private static String SYSTEM_FONT_ZH_MIUI = "/system/fonts/Chinese-Hei.ttf";
    /* renamed from: T */
    private static String f1171T = "com.android.settings.ScreenDisplay";
    /* renamed from: U */
    private static String f1172U = "com.android.settings.DisplaySettings";
    /* renamed from: V */
    private static String f1173V = "com.android.settings.Display";

    static {
        new StringBuilder(String.valueOf(FOLDER_FONT)).append("default.apk");
        new StringBuilder(String.valueOf(FOLDER_FONT)).append("default-zh.ttf");
        new StringBuilder(String.valueOf(FOLDER_FONT)).append("default-en.ttf");
        new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath())).append("/MIUI/theme/.data/meta/fonts");
        new StringBuilder(String.valueOf(FOLDER_FONT)).append("/miui/");
    }
}
