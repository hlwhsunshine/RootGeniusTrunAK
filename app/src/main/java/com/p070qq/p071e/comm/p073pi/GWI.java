package com.p070qq.p071e.comm.p073pi;

import android.view.View;
import com.p070qq.p071e.ads.appwall.GridAPPWallListener;
import com.p070qq.p071e.ads.cfg.DownAPPConfirmPolicy;

/* renamed from: com.qq.e.comm.pi.GWI */
public interface GWI {
    GridAPPWallListener getAdListener();

    void setAdListener(GridAPPWallListener gridAPPWallListener);

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void show();

    void showRelativeTo(int i, int i2);

    void showRelativeTo(View view);
}
