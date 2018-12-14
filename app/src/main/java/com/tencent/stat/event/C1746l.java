package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.C1717a;
import com.tencent.stat.common.StatCommonHelper;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.l */
public class C1746l extends C1735f {
    /* renamed from: a */
    private C1717a f5127a;
    /* renamed from: n */
    private JSONObject f5128n = null;

    public C1746l(Context context, int i, JSONObject jSONObject, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f5127a = new C1717a(context);
        this.f5128n = jSONObject;
    }

    /* renamed from: a */
    public EventType mo7924a() {
        return EventType.SESSION_ENV;
    }

    /* renamed from: a */
    public boolean mo7925a(JSONObject jSONObject) {
        if (this.f5099e != null) {
            jSONObject.put("ut", this.f5099e.getUserType());
        }
        if (this.f5128n != null) {
            jSONObject.put("cfg", this.f5128n);
        }
        if (StatCommonHelper.needCheckTime(this.f5105m)) {
            jSONObject.put("ncts", 1);
        }
        this.f5127a.mo7914a(jSONObject, null);
        return true;
    }
}
