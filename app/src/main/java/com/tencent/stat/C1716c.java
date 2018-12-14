package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatCommonHelper;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.stat.c */
public class C1716c {
    /* renamed from: b */
    private static volatile C1716c f5000b = null;
    /* renamed from: a */
    private Timer f5001a = null;
    /* renamed from: c */
    private Context f5002c = null;

    private C1716c(Context context) {
        this.f5002c = context.getApplicationContext();
        this.f5001a = new Timer(false);
    }

    /* renamed from: a */
    public static C1716c m4715a(Context context) {
        if (f5000b == null) {
            synchronized (C1716c.class) {
                if (f5000b == null) {
                    f5000b = new C1716c(context);
                }
            }
        }
        return f5000b;
    }

    /* renamed from: a */
    public void mo7888a() {
        if (StatConfig.getStatSendStrategy() == StatReportStrategy.PERIOD) {
            long sendPeriodMinutes = (long) ((StatConfig.getSendPeriodMinutes() * 60) * 1000);
            if (StatConfig.isDebugEnable()) {
                StatCommonHelper.getLogger().mo7904i("setupPeriodTimer delay:" + sendPeriodMinutes);
            }
            mo7889a(new C1733d(this), sendPeriodMinutes);
        }
    }

    /* renamed from: a */
    public void mo7889a(TimerTask timerTask, long j) {
        if (this.f5001a != null) {
            if (StatConfig.isDebugEnable()) {
                StatCommonHelper.getLogger().mo7904i("setupPeriodTimer schedule delay:" + j);
            }
            this.f5001a.schedule(timerTask, j);
        } else if (StatConfig.isDebugEnable()) {
            StatCommonHelper.getLogger().mo7912w("setupPeriodTimer schedule timer == null");
        }
    }
}
