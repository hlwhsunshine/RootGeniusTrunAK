package com.p070qq.p071e.comm.managers.status;

import android.content.Context;
import com.p070qq.p071e.comm.util.StringUtil;

/* renamed from: com.qq.e.comm.managers.status.APPStatus */
public class APPStatus {
    /* renamed from: a */
    private String f2803a;
    /* renamed from: b */
    private Context f2804b;

    public APPStatus(String str, Context context) {
        this.f2803a = str;
        this.f2804b = context;
    }

    public String getAPPID() {
        return this.f2803a;
    }

    public String getAPPName() {
        return this.f2804b.getPackageName();
    }

    public String getAPPVersion() {
        String str = null;
        String aPPName = getAPPName();
        if (StringUtil.isEmpty(aPPName)) {
            return str;
        }
        try {
            return this.f2804b.getPackageManager().getPackageInfo(aPPName, 0).versionName;
        } catch (Exception e) {
            return str;
        }
    }
}
