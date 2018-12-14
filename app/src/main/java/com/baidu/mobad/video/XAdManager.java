package com.baidu.mobad.video;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.baidu.mobads.interfaces.IXAdContext;
import com.baidu.mobads.interfaces.IXAdManager;
import com.baidu.mobads.p021j.C0338m;

public class XAdManager implements IXAdManager {
    /* renamed from: d */
    private static IXAdManager f274d;
    /* renamed from: a */
    private String f275a;
    /* renamed from: b */
    private Location f276b;
    /* renamed from: c */
    private Context f277c;

    private XAdManager(Context context) {
        if (context instanceof Activity) {
            context = context.getApplicationContext();
        }
        this.f277c = context;
    }

    public static IXAdManager getInstance(Context context) {
        if (f274d == null) {
            f274d = new XAdManager(context);
        }
        return f274d;
    }

    public String getVersion() {
        return "8.25";
    }

    public IXAdContext newAdContext() {
        return new XAdContext(this.f277c, this.f275a, this.f276b);
    }

    public void setAppSid(String str) {
        this.f275a = str;
        C0338m.m569a().mo5040m().setAppId(str);
    }

    public void setLocation(Location location) {
        this.f276b = location;
    }
}
