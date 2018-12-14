package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatSpecifyReportedInfo;
import com.tencent.stat.common.C1717a;
import com.tencent.stat.common.Util;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONObject;

/* renamed from: com.tencent.stat.event.e */
public class C1741e extends C1735f {
    /* renamed from: a */
    private String f5116a;
    /* renamed from: n */
    private int f5117n;
    /* renamed from: o */
    private Thread f5118o = null;

    public C1741e(Context context, int i, int i2, Throwable th, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        m4782a(i2, th);
    }

    public C1741e(Context context, int i, int i2, Throwable th, Thread thread, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        m4782a(i2, th);
        this.f5118o = thread;
    }

    public C1741e(Context context, int i, String str, int i2, int i3, Thread thread, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        if (str != null) {
            if (i3 <= 0) {
                i3 = StatConfig.getMaxReportEventLength();
            }
            if (str.length() <= i3) {
                this.f5116a = str;
            } else {
                this.f5116a = str.substring(0, i3);
            }
        }
        this.f5118o = thread;
        this.f5117n = i2;
    }

    /* renamed from: a */
    private void m4782a(int i, Throwable th) {
        if (th != null) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            this.f5116a = stringWriter.toString();
            this.f5117n = i;
            printWriter.close();
        }
    }

    /* renamed from: a */
    public EventType mo7924a() {
        return EventType.ERROR;
    }

    /* renamed from: a */
    public void mo7938a(long j) {
        this.f5097c = j;
    }

    /* renamed from: a */
    public boolean mo7925a(JSONObject jSONObject) {
        Util.jsonPut(jSONObject, "er", this.f5116a);
        jSONObject.put("ea", this.f5117n);
        if (this.f5117n == 2 || this.f5117n == 3) {
            new C1717a(this.f5105m).mo7914a(jSONObject, this.f5118o);
        }
        return true;
    }
}
