package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatGameUser;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.Util;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.g */
public class C1742g extends C1735f {
    /* renamed from: a */
    private StatGameUser f5119a = null;

    public C1742g(Context context, int i, StatGameUser statGameUser, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.f5119a = statGameUser.clone();
    }

    /* renamed from: a */
    public EventType mo7924a() {
        return EventType.MTA_GAME_USER;
    }

    /* renamed from: a */
    public boolean mo7925a(JSONObject jSONObject) {
        if (this.f5119a == null) {
            return false;
        }
        Util.jsonPut(jSONObject, "wod", this.f5119a.getWorldName());
        Util.jsonPut(jSONObject, "gid", this.f5119a.getAccount());
        Util.jsonPut(jSONObject, "lev", this.f5119a.getLevel());
        return true;
    }
}
