package com.p070qq.p071e.comm.p073pi;

import android.app.Activity;
import com.p070qq.p071e.ads.cfg.DownAPPConfirmPolicy;
import com.p070qq.p071e.comm.adevent.ADListener;

/* renamed from: com.qq.e.comm.pi.IADI */
public interface IADI {
    void closePopupWindow();

    void destory();

    void loadAd();

    void setAdListener(ADListener aDListener);

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void show();

    void show(Activity activity);

    void showAsPopupWindown();

    void showAsPopupWindown(Activity activity);
}
