package com.p070qq.p071e.comm.p073pi;

import com.p070qq.p071e.ads.cfg.DownAPPConfirmPolicy;

/* renamed from: com.qq.e.comm.pi.AWI */
public interface AWI {
    void prepare();

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void setScreenOrientation(int i);

    void showAppWall();
}
