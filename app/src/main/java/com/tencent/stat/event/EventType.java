package com.tencent.stat.event;

import com.baidu.mobads.CpuInfoManager;

public enum EventType {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    BACKGROUND(4),
    CUSTOM(1000),
    ADDITION(CpuInfoManager.CHANNEL_ENTERTAINMENT),
    MONITOR_STAT(1002),
    MTA_GAME_USER(CpuInfoManager.CHANNEL_PICTURE),
    NETWORK_MONITOR(1004),
    NETWORK_DETECTOR(CpuInfoManager.CHANNEL_MOBILE);
    
    /* renamed from: a */
    private int f5092a;

    private EventType(int i) {
        this.f5092a = i;
    }

    /* renamed from: a */
    public final int mo7923a() {
        return this.f5092a;
    }
}
