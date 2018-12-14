package com.tencent.stat;

public enum StatReportStrategy {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    
    /* renamed from: a */
    int f4865a;

    private StatReportStrategy(int i) {
        this.f4865a = i;
    }

    public static StatReportStrategy getStatReportStrategy(int i) {
        for (StatReportStrategy statReportStrategy : values()) {
            if (i == statReportStrategy.mo7829a()) {
                return statReportStrategy;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final int mo7829a() {
        return this.f4865a;
    }
}
