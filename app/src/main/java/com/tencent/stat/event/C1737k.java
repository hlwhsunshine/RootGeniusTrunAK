package com.tencent.stat.event;

import android.content.Context;
import com.p070qq.p071e.comm.constants.Constants.KEYS;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.Util;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.k */
public class C1737k extends C1735f {
    /* renamed from: a */
    Long f5107a = null;
    /* renamed from: n */
    String f5108n;
    /* renamed from: o */
    String f5109o;

    public C1737k(Context context, String str, String str2, int i, Long l, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f5109o = str;
        this.f5108n = str2;
        this.f5107a = l;
    }

    /* renamed from: a */
    public EventType mo7924a() {
        return EventType.PAGE_VIEW;
    }

    /* renamed from: a */
    public boolean mo7925a(JSONObject jSONObject) {
        Util.jsonPut(jSONObject, "pi", this.f5108n);
        Util.jsonPut(jSONObject, KEYS.Banner_RF, this.f5109o);
        if (this.f5107a != null) {
            jSONObject.put("du", this.f5107a);
        }
        return true;
    }
}
