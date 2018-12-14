package com.shuame.rootgenius.sdk;

import android.content.Context;
import com.shuame.rootgenius.sdk.proto.C1478d;
import com.shuame.rootgenius.sdk.proto.ProtoData.DeviceSolution;
import com.shuame.rootgenius.sdk.proto.ProtoData.QuerySupportResult;
import com.shuame.rootgenius.sdk.proto.ProtoData.RootingDev;

public class RootGenius {
    public static final int PROCESS_CLEAR = 7;
    public static final int PROCESS_CONNECT_OK = 3;
    public static final int PROCESS_INSTALLING_SUPERUSER = 4;
    public static final int PROCESS_MANUAL_REBOOT = 8;
    public static final int PROCESS_NONE = 0;
    public static final int PROCESS_QUERY_SOLUTION = 6;
    public static final int PROCESS_SUPERUSER_OK = 5;
    public static final int PROCESS_WAITING_CONNECT = 2;
    public static final int PROCESS_WILL_REBOOT = 1;
    public static final int PROGRESS_BEGIN = 1;
    public static final int PROGRESS_END = 100;
    public static final int PROGRESS_INSTALL_APK_COMPLETE = 5;
    public static final int PROGRESS_INSTALL_SW = 15;
    public static final int PROGRESS_NONE = 0;
    public static final int PROGRESS_QUERY_SOLUTION_COMPLETE = 10;
    public static final int PROGRESS_UPDATE_KINGUSER_COMPLETE = 15;
    public static final int RESULT_BUSY_ROOTING = -10;
    public static final int RESULT_DEVICE_EXCEPTION = -2;
    public static final int RESULT_EXCEPTION = -13;
    public static final int RESULT_FAIL = -1;
    public static final int RESULT_NETWORK_FAIL = -11;
    public static final int RESULT_NORMAL = 0;
    public static final int RESULT_OK = 1;
    public static final int RESULT_OK_NEED_REBOOT = 2;
    public static final int RESULT_RES_ERROR = -5;
    public static final int RESULT_SYSTEM_REMOUNT_FAIL = -14;
    public static final int RESULT_UNINITED = -12;
    public static final int RESULT_UNSUPORT = -4;
    public static final int RESULT_WAIT = -3;
    public static final int SOLUTION_ID_UPDATE_SU = 1002;

    public interface RootListener {
        void onProcess(int i);

        void onProgress(int i);

        void onResult(int i);
    }

    public static RootingDev GetDeviceInfo() {
        return C1469d.m4067a().mo7276c();
    }

    public static void SetQIMEI(String str, String str2, String str3) {
        C1469d.m4067a().mo7273a(str, str2, str3);
    }

    public static void SetVersionInfo(String str) {
        RgsdkConfig.SetVersionName(str);
    }

    public static boolean checkRootState() {
        return C1469d.m4067a().mo7280g();
    }

    public static boolean connect() {
        return C1469d.m4067a().mo7280g();
    }

    public static String getBuildInKinguserMd5() {
        return C1469d.m4067a().mo7281h();
    }

    public static void initialize(Context context) {
        C1469d.m4067a().mo7270a(context);
    }

    public static void onBootCompleted(Context context) {
        C1469d.m4067a().mo7275b(context);
    }

    public static DeviceSolution preQueryRoot() {
        return C1469d.m4067a().mo7277d();
    }

    public static QuerySupportResult querySupport(Context context) {
        return new C1478d().mo7292a(context);
    }

    public static int removeRoot() {
        return C1469d.m4067a().mo7279f();
    }

    public static void setBusyboxPath(String str) {
        C1469d.m4067a();
        C1469d.m4078e(str);
    }

    public static void setRootBySupportTip() {
        C1469d.m4067a().mo7282i();
    }

    public static void setSuSuite(String[] strArr) {
        C1469d.m4067a().mo7274a(strArr);
    }

    public static void setTestMode(String str) {
        C1469d.m4067a().mo7271a(str);
    }

    public static int startRoot(RootListener rootListener) {
        return C1469d.m4067a().mo7269a(rootListener);
    }

    public static int startRootRunScript(String str, RootListener rootListener) {
        C1469d.m4067a();
        return C1469d.m4077e();
    }

    public static String suExec(Context context, String str) {
        return C1469d.m4067a().mo7278d(str);
    }

    public static void updateSU(String str, RootListener rootListener) {
        C1469d.m4067a().mo7272a(str, rootListener);
    }
}
