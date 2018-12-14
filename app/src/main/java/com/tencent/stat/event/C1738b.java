package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.StatPreferences;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.b */
public class C1738b extends C1737k {
    /* renamed from: p */
    private static int f5110p = 0;

    public C1738b(Context context, int i, Long l, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, null, null, i, l, statSpecifyReportedInfo);
        if (f5110p == 0) {
            int i2 = StatPreferences.getInt(context, "back_ev_index", 0);
            f5110p = i2;
            if (i2 > 2147383647) {
                f5110p = 0;
            }
        }
        f5110p++;
        StatPreferences.putInt(context, "back_ev_index", f5110p);
    }

    /* renamed from: a */
    public EventType mo7924a() {
        return EventType.BACKGROUND;
    }

    /* renamed from: a */
    public boolean mo7925a(JSONObject jSONObject) {
        jSONObject.put("bc", f5110p);
        return super.mo7925a(jSONObject);
    }
}
