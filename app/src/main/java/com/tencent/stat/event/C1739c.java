package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatServiceImpl;
import com.tencent.stat.StatSpecifyReportedInfo;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.c */
public class C1739c extends C1735f {
    /* renamed from: a */
    protected C1740d f5111a = new C1740d();
    /* renamed from: n */
    private long f5112n = -1;

    public C1739c(Context context, int i, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f5111a.f5113a = str;
    }

    /* renamed from: i */
    private void m4777i() {
        if (this.f5111a.f5113a != null) {
            Map commonKeyValueForKVEvent = StatServiceImpl.getCommonKeyValueForKVEvent(this.f5111a.f5113a);
            if (commonKeyValueForKVEvent != null && commonKeyValueForKVEvent.size() > 0) {
                if (this.f5111a.f5115c == null || this.f5111a.f5115c.length() == 0) {
                    this.f5111a.f5115c = new JSONObject(commonKeyValueForKVEvent);
                    return;
                }
                for (Entry entry : commonKeyValueForKVEvent.entrySet()) {
                    try {
                        this.f5111a.f5115c.put(entry.getKey().toString(), entry.getValue());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public EventType mo7924a() {
        return EventType.CUSTOM;
    }

    /* renamed from: a */
    public void mo7933a(long j) {
        this.f5112n = j;
    }

    /* renamed from: a */
    public boolean mo7925a(JSONObject jSONObject) {
        jSONObject.put("ei", this.f5111a.f5113a);
        if (this.f5112n > 0) {
            jSONObject.put("du", this.f5112n);
        }
        if (this.f5111a.f5114b == null) {
            m4777i();
            jSONObject.put("kv", this.f5111a.f5115c);
        } else {
            jSONObject.put("ar", this.f5111a.f5114b);
        }
        return true;
    }

    /* renamed from: b */
    public C1740d mo7934b() {
        return this.f5111a;
    }
}
