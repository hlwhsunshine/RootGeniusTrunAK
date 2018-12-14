package com.kingroot.sdk;

import android.content.Context;
import android.os.Looper;
import krsdk.RootConfig;
import krsdk.RootExecutorFactory;
import krsdk.RootShell;

/* renamed from: com.kingroot.sdk.ds */
class C0757ds extends C0734dr {
    public C0757ds(Context context, RootConfig rootConfig, Looper looper) {
        super(context, rootConfig, looper);
        C0633at.m1464h("YybRootExecutor.<init>");
    }

    public RootShell execute() {
        Object B = mo5723B(0);
        RootExecutorFactory.saveShell(B);
        return B;
    }

    public int prepare() {
        int checkCanRoot = checkCanRoot(5);
        return checkCanRoot > 0 ? super.prepare() : checkCanRoot;
    }
}
