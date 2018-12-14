package com.shuame.rootgenius.hook;

import com.shuame.rootgenius.common.C1323b;

public class HookData {
    private static final String HOOKED_UNINSTALL_ERROR_FILE_FLAG = "hooked_uninstall_error_file_flag";
    private static final String HOOKED_UNINSTALL_ERROR_REPORT_FLAG = "_uninstall_result_report_flag";
    private static final String HOOKED_UNINSTALL_ERROR_VERSION_CODE = "hooked_uninstall_error_version_code";
    private static final String INJECT_RESULT_CODE = "inject_result_code";
    private static final String INJECT_RESULT_DESC = "inject_result_desc";
    public static boolean allowDebugModelHook = false;
    private static HookData mInstance = new HookData();

    private HookData() {
    }

    public static HookData getInstance() {
        return mInstance;
    }

    public void existHookedUninstallErrorFileFlag(boolean z) {
        C1323b.m3688a().mo6996a(HOOKED_UNINSTALL_ERROR_FILE_FLAG, z);
    }

    public boolean existHookedUninstallErrorFileFlag() {
        return C1323b.m3688a().mo6997b(HOOKED_UNINSTALL_ERROR_FILE_FLAG, false);
    }

    public int getHookedUninstallErrorVersionCode() {
        return C1323b.m3688a().mo6999e(HOOKED_UNINSTALL_ERROR_VERSION_CODE);
    }

    public int getInjectResultCode() {
        return C1323b.m3688a().mo6999e(INJECT_RESULT_CODE);
    }

    public String getInjectResultDesc() {
        return C1323b.m3688a().mo7001g(INJECT_RESULT_DESC);
    }

    public void hookedUninstallErrorReported(boolean z) {
        C1323b.m3688a().mo6996a(HOOKED_UNINSTALL_ERROR_REPORT_FLAG, z);
    }

    public boolean isHookedUninstallErrorReported() {
        return C1323b.m3688a().mo6997b(HOOKED_UNINSTALL_ERROR_REPORT_FLAG, true);
    }

    public void saveHookedUninstallErrorVersionCode(int i) {
        C1323b.m3688a().mo6993a(HOOKED_UNINSTALL_ERROR_VERSION_CODE, i);
    }

    public void saveInjectResultCode(int i) {
        C1323b.m3688a().mo6993a(INJECT_RESULT_CODE, i);
    }

    public void saveInjectResultDesc(String str) {
        C1323b.m3688a().mo6995a(INJECT_RESULT_DESC, str);
    }
}
