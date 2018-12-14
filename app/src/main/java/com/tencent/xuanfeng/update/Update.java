package com.tencent.xuanfeng.update;

import android.content.Context;
import com.tencent.xuanfeng.libInterface.IUpdate;
import com.tencent.xuanfeng.libInterface.UpdateListener;

public class Update implements IUpdate, UpdateListener {
    private static Update update = null;
    private KernelModuleManage kernelManage = new KernelModuleManage();
    private UpdateListener updateCallback = null;

    public static Update getInstance() {
        if (update == null) {
            update = new Update();
        }
        return update;
    }

    public static void releaseInstance() {
        update = null;
    }

    public void UpdateError(int i) {
        if (this.updateCallback != null) {
            this.updateCallback.UpdateError(i);
        }
    }

    public void UpdateStatus(int i) {
        if (this.updateCallback != null) {
            this.updateCallback.UpdateStatus(i);
        }
    }

    public void UpdateSuccess() {
        if (this.updateCallback != null) {
            this.updateCallback.UpdateSuccess();
        }
    }

    public void autoUpdateKernel() {
        if (!this.kernelManage.updateKernel()) {
            this.kernelManage.startQuery();
        }
    }

    public void downloadKernel() {
        this.kernelManage.startQuery();
    }

    public boolean hasKernelInstalled() {
        return this.kernelManage.hasKernelInstalled();
    }

    public void setUpdateListener(UpdateListener updateListener) {
        this.updateCallback = updateListener;
    }

    public void updateInit(Context context, String str) {
        if (context != null) {
            this.kernelManage.setAppDataDir(context.getDir(KernelModuleManage.kernelInstallPath, 0).getPath());
            this.kernelManage.setUpdateCallback(this);
            this.kernelManage.init(str);
        }
    }
}
