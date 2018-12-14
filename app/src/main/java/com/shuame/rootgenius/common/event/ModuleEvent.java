package com.shuame.rootgenius.common.event;

import android.content.Context;
import android.content.Intent;

public final class ModuleEvent {
    /* renamed from: a */
    public Type f3606a;
    /* renamed from: b */
    public String f3607b;
    /* renamed from: c */
    public Context f3608c;
    /* renamed from: d */
    public Intent f3609d;

    public enum Type {
        START_ACTIVITY,
        START_ACTIVITY_FOR_RESULT,
        STAT,
        NOTIFICATION,
        ACTIVITY_STATUS,
        MISC
    }
}
