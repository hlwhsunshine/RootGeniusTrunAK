package krsdk;

import android.content.Context;
import com.kingroot.sdk.C0627aq;
import com.kingroot.sdk.C0726cw;
import com.kingroot.sdk.C0741dg;
import java.io.File;

public class RootExecutorFactory {
    public static int checkHasRooted() {
        return C0741dg.m1804aL().checkHasRooted();
    }

    public static C0726cw dealWithUnFinishSolution(Context context) {
        return C0741dg.m1804aL().dealWithUnFinishSolution(context);
    }

    public static synchronized void destoryThread() {
        synchronized (RootExecutorFactory.class) {
            C0741dg.m1804aL().destoryThread();
        }
    }

    public static boolean extractAndInit(Context context) {
        return extractAndInit(context, null);
    }

    public static boolean extractAndInit(Context context, RootConfig rootConfig) {
        return C0741dg.m1804aL().extractAndInit(context, rootConfig);
    }

    public static boolean extractFileToWorkDir(Context context, String str, File file, boolean z) {
        return C0741dg.m1804aL().extractFileToWorkDir(context, str, file, z);
    }

    public static RootExecutor getRootExecutor() {
        return C0741dg.m1804aL().getRootExecutor();
    }

    public static int getRootSdkVersion() {
        return C0627aq.f1567bU;
    }

    public static boolean init(Context context, RootConfig rootConfig) {
        return init(context, rootConfig, context);
    }

    public static boolean init(Context context, RootConfig rootConfig, Context context2) {
        return C0741dg.m1804aL().init(context, rootConfig, context2);
    }

    public static synchronized boolean saveShell(IShell iShell) {
        boolean saveShell;
        synchronized (RootExecutorFactory.class) {
            saveShell = C0741dg.m1804aL().saveShell(iShell);
        }
        return saveShell;
    }
}
