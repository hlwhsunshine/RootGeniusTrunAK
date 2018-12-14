package com.p070qq.p071e.comm.managers.setting;

import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.managers.setting.c */
public class C1068c {
    /* renamed from: a */
    private JSONObject f2800a;

    public C1068c() {
        this.f2800a = new JSONObject();
    }

    public C1068c(String str) {
        this();
        GDTLogger.m3130d("Initialize GDTSDKSetting,Json=" + str);
        if (!StringUtil.isEmpty(str)) {
            try {
                this.f2800a = new JSONObject(str);
            } catch (Throwable e) {
                GDTLogger.report("Exception while building GDTSDKSetting from json", e);
            }
        }
    }

    /* renamed from: a */
    final Object mo6493a(String str) {
        return this.f2800a.opt(str);
    }

    /* renamed from: a */
    final void mo6494a(String str, Object obj) {
        try {
            this.f2800a.putOpt(str, obj);
        } catch (Throwable e) {
            GDTLogger.m3132e("Exception while update setting", e);
        }
    }

    public String toString() {
        return "GDTSDKSetting[" + this.f2800a.toString() + "]";
    }
}
