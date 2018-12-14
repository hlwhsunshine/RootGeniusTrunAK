package com.baidu.mobads.production;

import com.baidu.mobads.p034h.C0307g;

public class BaiduXAdSDKContext {
    protected static Boolean isRemoteLoadSuccess = Boolean.valueOf(false);
    protected static C0307g mApkLoader;

    public static void exit() {
        mApkLoader = null;
        isRemoteLoadSuccess = Boolean.valueOf(false);
    }
}
