package com.tencent.stat.event;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.stat.NetworkManager;
import com.tencent.stat.StatAppMonitor;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.Util;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.h */
public class C1743h extends C1735f {
    /* renamed from: n */
    private static String f5120n = null;
    /* renamed from: o */
    private static String f5121o = null;
    /* renamed from: a */
    private StatAppMonitor f5122a = null;

    public C1743h(Context context, int i, StatAppMonitor statAppMonitor, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f5122a = statAppMonitor.clone();
    }

    /* renamed from: a */
    public EventType mo7924a() {
        return EventType.MONITOR_STAT;
    }

    /* renamed from: a */
    public boolean mo7925a(JSONObject jSONObject) {
        if (this.f5122a == null) {
            return false;
        }
        jSONObject.put("na", this.f5122a.getInterfaceName());
        jSONObject.put("rq", this.f5122a.getReqSize());
        jSONObject.put("rp", this.f5122a.getRespSize());
        jSONObject.put("rt", this.f5122a.getResultType());
        jSONObject.put(IXAdRequestInfo.MAX_TITLE_LENGTH, this.f5122a.getMillisecondsConsume());
        jSONObject.put("rc", this.f5122a.getReturnCode());
        jSONObject.put("sp", this.f5122a.getSampling());
        if (f5121o == null) {
            f5121o = StatCommonHelper.getAppVersion(this.f5105m);
        }
        Util.jsonPut(jSONObject, "av", f5121o);
        if (f5120n == null) {
            f5120n = StatCommonHelper.getSimOperator(this.f5105m);
        }
        Util.jsonPut(jSONObject, "op", f5120n);
        jSONObject.put("cn", NetworkManager.getInstance(this.f5105m).getCurNetwrokName());
        return true;
    }
}
