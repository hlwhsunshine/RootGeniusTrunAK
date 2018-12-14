package com.tencent.xuanfeng.libInterface;

import android.content.Context;

public interface IUpdate {
    void autoUpdateKernel();

    void downloadKernel();

    boolean hasKernelInstalled();

    void setUpdateListener(UpdateListener updateListener);

    void updateInit(Context context, String str);
}
