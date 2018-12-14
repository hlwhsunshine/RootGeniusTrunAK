package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.NetworkManager;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.Util;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.j */
public class C1745j extends C1735f {
    /* renamed from: a */
    private static String f5124a = null;
    /* renamed from: n */
    private String f5125n = null;
    /* renamed from: o */
    private String f5126o = null;

    public C1745j(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f5125n = NetworkManager.getInstance(context).getCurNetwrokName();
        if (f5124a == null) {
            f5124a = StatCommonHelper.getSimOperator(context);
        }
    }

    /* renamed from: a */
    public EventType mo7924a() {
        return EventType.NETWORK_MONITOR;
    }

    /* renamed from: a */
    public void mo7939a(String str) {
        this.f5126o = str;
    }

    /* renamed from: a */
    public boolean mo7925a(JSONObject jSONObject) {
        Util.jsonPut(jSONObject, "op", f5124a);
        Util.jsonPut(jSONObject, "cn", this.f5125n);
        jSONObject.put("sp", this.f5126o);
        return true;
    }
}
