package com.baidu.mobads.command;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.p021j.C0338m;

/* renamed from: com.baidu.mobads.command.b */
public abstract class C0269b {
    /* renamed from: a */
    protected Context f458a;
    /* renamed from: b */
    protected IXNonLinearAdSlot f459b;
    /* renamed from: c */
    protected IXAdInstanceInfo f460c;
    /* renamed from: d */
    protected IXAdResource f461d;
    /* renamed from: e */
    protected IXAdLogger f462e = C0338m.m569a().mo5033f();

    public C0269b(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource) {
        this.f459b = iXNonLinearAdSlot;
        this.f458a = iXNonLinearAdSlot.getApplicationContext();
        this.f460c = iXAdInstanceInfo;
        this.f461d = iXAdResource;
    }
}
