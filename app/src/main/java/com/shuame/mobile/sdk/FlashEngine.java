package com.shuame.mobile.sdk;

import java.util.List;
import java.util.Map;

public interface FlashEngine {

    public static class Dialog {
        public static final int CANCEL_BUTTON = 2;
        public static final int OK_BUTTON = 1;
        public static final int STYLE1 = 1;
        public static final int STYLE2 = 2;
    }

    public interface FlashListener {
        public static final int STEP_COPY_ROM = 2;
        public static final int STEP_DOWNLOAD_LUA = -1;
        public static final int STEP_DOWNLOAD_RECOVERY = 3;
        public static final int STEP_FLASH_RECOVERY = 4;
        public static final int STEP_PRE_CHECK = 0;
        public static final int STEP_REBOOT_TIMER_COUNT = 7;
        public static final int STEP_SAVE_SHUAME_ROM = 5;
        public static final int STEP_SCAN_ROM = 1;
        public static final int STEP_UNLOCK_PHONE = 8;
        public static final int STEP_WRITE_UPDATE_COMMAND = 6;

        void onDialog(String str, int i);

        void onFlash(int i, int i2, Map<String, Object> map);
    }

    public static class FlashResult {
        public static final int ERROR_CANCELED = 10;
        public static final int ERROR_CLIENT_EVN = 24;
        public static final int ERROR_CONFIG = 12;
        public static final int ERROR_COPY_ROM = 5;
        public static final int ERROR_DATA_PARTITION_NOT_ENOUGH = 1;
        public static final int ERROR_DOWNLOAD_LUA = 10003;
        public static final int ERROR_DOWNLOAD_RECOVERY = 6;
        public static final int ERROR_DOWNLOAD_SHUAME = 7;
        public static final int ERROR_DOWNLOAD_UNLOCK_FILE = 22;
        public static final int ERROR_ERROR_REBOOT = 21;
        public static final int ERROR_EXE_LUA = 10002;
        public static final int ERROR_FLASH_RECOVERY = 9;
        public static final int ERROR_LUA_UNKOWN = 15;
        public static final int ERROR_MULTI_SD_STATE_NOT_AGREED = 19;
        public static final int ERROR_NO_ROM = 11;
        public static final int ERROR_OBTAIN_ROOT = 3;
        public static final int ERROR_REPLACE_ZIP_UB_NOT_SPACE = 18;
        public static final int ERROR_ROM_ERROR = 2;
        public static final int ERROR_ROM_NOT_MATCH = 20;
        public static final int ERROR_SCAN_ROM = 4;
        public static final int ERROR_SDCARD_NOT_ENOUGH = 13;
        public static final int ERROR_SDCARD_NOT_MOUNT = 14;
        public static final int ERROR_SYSTEM_NOT_SUPPORTED = 23;
        public static final int ERROR_UNKONW = 10001;
        public static final int ERROR_UNLOCK_PHONE = 17;
        public static final int ERROR_UNZIP_FILE = 16;
        public static final int ERROR_WRITE_UPDATE_COMMAND = 8;
        /* renamed from: OK */
        public static final int f3171OK = 0;
    }

    void cancelFlash();

    void clickDialogButton(int i);

    int getDownloadResultCode();

    String getLuaErrorMsg();

    List<String> getReportList();

    boolean init(String str, String str2, String str3, Map<String, Object> map);

    int preCheck();

    void registerListener(FlashListener flashListener);

    void release();

    int showDialog(String str, int i);

    int startFlash();

    void unregisterListener(FlashListener flashListener);
}
