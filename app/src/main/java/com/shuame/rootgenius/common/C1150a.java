package com.shuame.rootgenius.common;

import android.content.Context;
import android.content.Intent;
import com.shuame.rootgenius.common.event.ModuleEvent;
import com.shuame.rootgenius.common.event.ModuleEvent.Type;
import p120de.greenrobot.event.EventBus;

/* renamed from: com.shuame.rootgenius.common.a */
public class C1150a {
    /* renamed from: a */
    public static void m3309a(Context context, Intent intent) {
        C1150a.class.getName();
        new StringBuilder("post task to startModuleActivity:").append(intent.getStringExtra("EXTAR_ACTIVITY"));
        Type type = Type.START_ACTIVITY;
        String name = C1150a.class.getName();
        ModuleEvent moduleEvent = new ModuleEvent();
        moduleEvent.f3606a = type;
        moduleEvent.f3607b = name;
        moduleEvent.f3608c = context;
        moduleEvent.f3609d = intent;
        EventBus.getDefault().post(moduleEvent);
    }
}
