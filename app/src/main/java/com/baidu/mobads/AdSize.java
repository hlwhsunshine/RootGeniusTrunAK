package com.baidu.mobads;

public enum AdSize {
    Banner(0),
    Square(1),
    InterstitialGame(6),
    InterstitialReader(7),
    InterstitialRefresh(9),
    InterstitialOther(10),
    InterstitialForVideoBeforePlay(12),
    InterstitialForVideoPausePlay(13),
    PrerollVideoNative(15);
    
    /* renamed from: a */
    private int f343a;

    private AdSize(int i) {
        this.f343a = i;
    }

    public final int getValue() {
        return this.f343a;
    }
}
