package com.p070qq.p071e.ads.nativ;

/* renamed from: com.qq.e.ads.nativ.MediaListener */
public interface MediaListener {
    void onADButtonClicked();

    void onReplayButtonClicked();

    void onVideoComplete();

    void onVideoError(int i);

    void onVideoPause();

    void onVideoReady(long j);

    void onVideoStart();
}
