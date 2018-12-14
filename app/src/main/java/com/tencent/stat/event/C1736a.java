package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatAccount;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.Util;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.a */
public class C1736a extends C1735f {
    /* renamed from: a */
    private StatAccount f5106a = null;

    public C1736a(Context context, int i, StatAccount statAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f5106a = statAccount;
    }

    /* renamed from: a */
    public EventType mo7924a() {
        return EventType.ADDITION;
    }

    /* renamed from: a */
    public boolean mo7925a(JSONObject jSONObject) {
        Util.jsonPut(jSONObject, "qq", this.f5106a.getAccount());
        jSONObject.put("acc", this.f5106a.toJsonString());
        return true;
    }
}
