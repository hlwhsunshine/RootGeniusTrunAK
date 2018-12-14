package com.tencent.xuanfeng.downloadsdkkernel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.tencent.xuanfeng.libInterface.Config;
import com.tencent.xuanfeng.libInterface.LinkStruct;
import com.tencent.xuanfeng.libInterface.OnFileDownloadListener;
import com.tencent.xuanfeng.libInterface.P2PInitParam;
import com.tencent.xuanfeng.libInterface.TASKINFO;

@SuppressLint({"NewApi"})
class Kernel {
    private static Kernel instance = new Kernel();
    private static boolean isKernelLoaded = false;
    private boolean hasInit = false;
    private String libName;
    private OnFileDownloadListener listener;
    private NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();

    Kernel() {
    }

    public static Kernel getKernel() {
        return instance;
    }

    private void onComplete(int i, long j) {
        if (this.listener != null) {
            this.listener.onComplete(i, j);
        }
    }

    private void onDonwloadInfo(int i, LinkStruct[] linkStructArr) {
        if (this.listener != null) {
            this.listener.onDonwloadInfo(i, linkStructArr);
        }
    }

    private void onFileName(int i, String str) {
        if (this.listener != null) {
            this.listener.onFileName(i, str);
        }
    }

    private void onOnlySrcUrl(int i) {
        if (this.listener != null) {
            this.listener.onOnlySrcUrl(i);
        }
    }

    private void onTaskInfo(int i, int i2, int i3) {
        if (this.listener != null) {
            this.listener.onTaskInfo(i, i2, i3);
        }
    }

    private void onWaitStart(int i) {
        if (this.listener != null) {
            this.listener.onWaitStart(i);
        }
    }

    native int CreateHttpTask(TASKINFO taskinfo);

    native int DelTask(String str);

    native boolean Init(P2PInitParam p2PInitParam);

    public boolean KernelInit(Context context, P2PInitParam p2PInitParam) {
        int i = 1;
        if (this.hasInit) {
            return true;
        }
        if (context == null) {
            return this.hasInit;
        }
        try {
            new StringBuilder("libName").append(this.libName);
            System.loadLibrary(this.libName);
            isKernelLoaded = true;
        } catch (UnsatisfiedLinkError e) {
            isKernelLoaded = false;
            new StringBuilder("load library failed.message:").append(e.getMessage()).append(",localized message:").append(e.getLocalizedMessage());
        }
        if (!Init(p2PInitParam)) {
            return this.hasInit;
        }
        context.registerReceiver(this.networkChangeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.hasInit = true;
        int cpuProcessorCount = NetCallUntl.getCpuProcessorCount();
        if (cpuProcessorCount > 0) {
            i = cpuProcessorCount;
        }
        setDevEnv(i, NetCallUntl.getMaxCpuFreq(), VERSION.SDK_INT);
        NetCallUntl.netEnvChange(context);
        return this.hasInit;
    }

    public boolean KernelUnInit(Context context) {
        if (this.hasInit && context != null) {
            try {
                context.unregisterReceiver(this.networkChangeReceiver);
            } catch (IllegalArgumentException e) {
            }
        }
        boolean UnInit = UnInit();
        if (UnInit) {
            this.hasInit = false;
        }
        return UnInit;
    }

    native boolean UnInit();

    native int addTaskInQueue(TASKINFO taskinfo);

    native void cleanQueue(int i);

    native int createQueue(Config config);

    native void netEnvChange(int i, int i2, int i3, String str);

    native int removeTaskInQueue(int i);

    native void setConfig(int i, Config config);

    native void setDevEnv(int i, int i2, int i3);

    native void setIncrementFileSizeMB(int i);

    void setLibName(String str) {
        this.libName = str;
    }

    native void setLocalLogEnable(boolean z);

    native void setLogLevel(int i);

    native void setLogPath(String str);

    native void setLogcatEnable(boolean z);

    public void setOnFileDownloadListener(OnFileDownloadListener onFileDownloadListener) {
        this.listener = onFileDownloadListener;
    }

    native void setSmallFileStrategy(int i);

    native void setUserInfo(String str, String str2);

    native void setUseragent(String str);
}
