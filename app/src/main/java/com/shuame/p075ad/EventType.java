package com.shuame.p075ad;

/* renamed from: com.shuame.ad.EventType */
enum EventType {
    EMPTY_EVENT_TYPE(0),
    SOURCELOAD_EVENT_TYPE(1),
    CLOSE_EVENT_TYPE(2),
    CLICK_EVENT_TYPE(3);
    
    private int mValue;

    private EventType(int i) {
        this.mValue = i;
    }

    public static EventType from(int i) {
        for (EventType eventType : EventType.values()) {
            if (eventType.mValue == i) {
                return eventType;
            }
        }
        return EMPTY_EVENT_TYPE;
    }
}
