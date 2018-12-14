package com.p070qq.p071e.ads.nativ;

import com.p070qq.p071e.comm.adevent.ADEvent;
import com.p070qq.p071e.comm.adevent.ADListener;
import com.p070qq.p071e.comm.util.GDTLogger;

/* renamed from: com.qq.e.ads.nativ.MediaListenerAdapter */
public class MediaListenerAdapter implements ADListener {
    /* renamed from: a */
    private MediaListener f2725a;

    public MediaListenerAdapter(MediaListener mediaListener) {
        this.f2725a = mediaListener;
    }

    public void onADEvent(ADEvent aDEvent) {
        switch (aDEvent.getType()) {
            case 1:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    this.f2725a.onVideoReady((long) ((Integer) aDEvent.getParas()[0]).intValue());
                    return;
                } else {
                    GDTLogger.m3131e("NativeMedia ADEvent Paras error!");
                    return;
                }
            case 2:
                this.f2725a.onVideoStart();
                return;
            case 3:
                this.f2725a.onVideoPause();
                return;
            case 4:
                this.f2725a.onVideoComplete();
                return;
            case 5:
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    this.f2725a.onVideoError(((Integer) aDEvent.getParas()[0]).intValue());
                    return;
                } else {
                    GDTLogger.m3131e("NativeMedia ADEvent Paras error!");
                    return;
                }
            case 6:
                this.f2725a.onReplayButtonClicked();
                return;
            case 7:
                this.f2725a.onADButtonClicked();
                return;
            default:
                return;
        }
    }
}
