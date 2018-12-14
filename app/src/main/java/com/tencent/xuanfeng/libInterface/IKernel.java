package com.tencent.xuanfeng.libInterface;

import android.content.Context;

public interface IKernel {
    int CreateTask(TASKINFO taskinfo);

    int DelTask(String str);

    boolean KernelInit(Context context, P2PInitParam p2PInitParam);

    boolean KernelUnInit(Context context);

    int addTaskInQueue(TASKINFO taskinfo);

    int removeTaskInQueue(int i);

    void setIncrementFileSizeMB(int i);

    void setLibName(String str);

    void setLocalLogEnable(boolean z);

    void setLogLevel(int i);

    void setLogPath(String str);

    void setLogcatEnable(boolean z);

    void setOnFileDownloadListener(OnFileDownloadListener onFileDownloadListener);

    void setSmallFileStrategy(int i);

    void setUseSearchDir(boolean z);

    void setUserInfo(String str, String str2);

    void setUseragent(String str);
}
