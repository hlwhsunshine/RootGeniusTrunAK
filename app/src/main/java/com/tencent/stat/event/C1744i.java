package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.Util;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.i */
public class C1744i extends C1735f {
    /* renamed from: a */
    public static final StatSpecifyReportedInfo f5123a;

    static {
        StatSpecifyReportedInfo statSpecifyReportedInfo = new StatSpecifyReportedInfo();
        f5123a = statSpecifyReportedInfo;
        statSpecifyReportedInfo.setAppKey("A9VH9B8L4GX4");
    }

    public C1744i(Context context) {
        super(context, 0, f5123a);
    }

    /* renamed from: a */
    public EventType mo7924a() {
        return EventType.NETWORK_DETECTOR;
    }

    /* renamed from: a */
    public boolean mo7925a(JSONObject jSONObject) {
        Util.jsonPut(jSONObject, "actky", StatConfig.getAppKey(this.f5105m));
        return true;
    }
}
