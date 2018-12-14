package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.event.C1735f;
import com.tencent.stat.event.C1739c;
import com.tencent.stat.event.EventType;

/* renamed from: com.tencent.stat.av */
class C1700av {
    /* renamed from: f */
    private static volatile long f4947f = 0;
    /* renamed from: a */
    private C1735f f4948a;
    /* renamed from: b */
    private StatReportStrategy f4949b = null;
    /* renamed from: c */
    private boolean f4950c = false;
    /* renamed from: d */
    private Context f4951d = null;
    /* renamed from: e */
    private long f4952e = System.currentTimeMillis();

    public C1700av(C1735f c1735f) {
        this.f4948a = c1735f;
        this.f4949b = StatConfig.getStatSendStrategy();
        this.f4950c = c1735f.mo7931g();
        this.f4951d = c1735f.mo7930f();
    }

    /* renamed from: a */
    private void m4665a(StatDispatchCallback statDispatchCallback) {
        C1748g.m4809b(StatServiceImpl.f4887t).mo7948a(this.f4948a, statDispatchCallback);
    }

    /* renamed from: b */
    private void m4667b() {
        if (this.f4948a.mo7924a() == EventType.CUSTOM) {
            String str = ((C1739c) this.f4948a).mo7934b().f5113a;
            if (StatConfig.m4603a(str)) {
                StatServiceImpl.f4884q.mo7897d("eventid=" + str + " matched, report instant.");
                m4670d();
                return;
            } else if (StatConfig.isEventIdInDontReportEventIdsSet(str)) {
                StatServiceImpl.f4884q.mo7912w("eventid=" + str + " In DontReportEventIdsSet, droped.");
                return;
            }
        }
        if (this.f4948a.mo7929e() != null && this.f4948a.mo7929e().isSendImmediately()) {
            this.f4949b = StatReportStrategy.INSTANT;
        }
        if (StatConfig.f4837j && NetworkManager.getInstance(StatServiceImpl.f4887t).isWifi()) {
            this.f4949b = StatReportStrategy.INSTANT;
        }
        if (StatConfig.isDebugEnable()) {
            StatServiceImpl.f4884q.mo7904i("strategy=" + this.f4949b.name());
        }
        switch (C1689ak.f4927a[this.f4949b.ordinal()]) {
            case 1:
                m4668c();
                return;
            case 2:
                C1706ba.m4673a(this.f4951d).mo7871a(this.f4948a, null, this.f4950c, false);
                if (StatConfig.isDebugEnable()) {
                    StatServiceImpl.f4884q.mo7904i("PERIOD currTime=" + this.f4952e + ",nextPeriodSendTs=" + StatServiceImpl.f4870c + ",difftime=" + (StatServiceImpl.f4870c - this.f4952e));
                }
                if (StatServiceImpl.f4870c == 0) {
                    StatServiceImpl.f4870c = StatPreferences.getLong(this.f4951d, "last_period_ts", 0);
                    if (this.f4952e > StatServiceImpl.f4870c) {
                        StatServiceImpl.m4649f(this.f4951d);
                    }
                    long sendPeriodMinutes = this.f4952e + ((long) ((StatConfig.getSendPeriodMinutes() * 60) * 1000));
                    if (StatServiceImpl.f4870c > sendPeriodMinutes) {
                        StatServiceImpl.f4870c = sendPeriodMinutes;
                    }
                    C1716c.m4715a(this.f4951d).mo7888a();
                }
                if (StatConfig.isDebugEnable()) {
                    StatServiceImpl.f4884q.mo7904i("PERIOD currTime=" + this.f4952e + ",nextPeriodSendTs=" + StatServiceImpl.f4870c + ",difftime=" + (StatServiceImpl.f4870c - this.f4952e));
                }
                if (this.f4952e > StatServiceImpl.f4870c) {
                    StatServiceImpl.m4649f(this.f4951d);
                    return;
                }
                return;
            case 3:
            case 4:
                C1706ba.m4673a(this.f4951d).mo7871a(this.f4948a, null, this.f4950c, false);
                return;
            case 5:
                C1706ba.m4673a(this.f4951d).mo7871a(this.f4948a, new C1701aw(this), this.f4950c, true);
                return;
            case 6:
                if (NetworkManager.getInstance(StatServiceImpl.f4887t).getNetworkType() == 1) {
                    m4668c();
                    return;
                } else {
                    C1706ba.m4673a(this.f4951d).mo7871a(this.f4948a, null, this.f4950c, false);
                    return;
                }
            case 7:
                if (StatCommonHelper.isWiFiActive(this.f4951d)) {
                    m4665a(new C1702ax(this));
                    return;
                }
                return;
            default:
                StatServiceImpl.f4884q.error("Invalid stat strategy:" + StatConfig.getStatSendStrategy());
                return;
        }
    }

    /* renamed from: c */
    private void m4668c() {
        if ((C1706ba.m4689b().f4961a <= 0 || !StatConfig.f4839l) && this.f4948a.mo7924a() != EventType.BACKGROUND) {
            m4665a(new C1703ay(this));
            return;
        }
        C1706ba.m4689b().mo7871a(this.f4948a, null, this.f4950c, true);
        C1706ba.m4689b().mo7870a(-1);
    }

    /* renamed from: d */
    private void m4670d() {
        m4665a(new C1704az(this));
    }

    /* renamed from: e */
    private boolean m4671e() {
        if (StatConfig.f4835h > 0) {
            if (this.f4952e > StatServiceImpl.f4875h) {
                StatServiceImpl.f4874g.clear();
                StatServiceImpl.f4875h = this.f4952e + StatConfig.f4836i;
                if (StatConfig.isDebugEnable()) {
                    StatServiceImpl.f4884q.mo7904i("clear methodsCalledLimitMap, nextLimitCallClearTime=" + StatServiceImpl.f4875h);
                }
            }
            Integer valueOf = Integer.valueOf(this.f4948a.mo7924a().mo7923a());
            Integer num = (Integer) StatServiceImpl.f4874g.get(valueOf);
            if (num != null) {
                StatServiceImpl.f4874g.put(valueOf, Integer.valueOf(num.intValue() + 1));
                if (num.intValue() > StatConfig.f4835h) {
                    if (StatConfig.isDebugEnable()) {
                        StatServiceImpl.f4884q.mo7899e("event " + this.f4948a.mo7932h() + " was discard, cause of called limit, current:" + num + ", limit:" + StatConfig.f4835h + ", period:" + StatConfig.f4836i + " ms");
                    }
                    return true;
                }
            }
            StatServiceImpl.f4874g.put(valueOf, Integer.valueOf(1));
        }
        return false;
    }

    /* renamed from: a */
    public void mo7867a() {
        if (!m4671e()) {
            if (StatConfig.f4843p != null) {
                String h = this.f4948a.mo7932h();
                if (StatConfig.isDebugEnable()) {
                    StatServiceImpl.f4884q.mo7904i("transfer event data:" + h);
                }
                StatConfig.f4843p.onTransfer(h);
                return;
            }
            if (StatConfig.f4840m > 0 && this.f4952e >= f4947f) {
                StatServiceImpl.flushDataToDB(this.f4951d);
                f4947f = this.f4952e + StatConfig.f4841n;
                if (StatConfig.isDebugEnable()) {
                    StatServiceImpl.f4884q.mo7904i("nextFlushTime=" + f4947f);
                }
            }
            if (NetworkManager.getInstance(this.f4951d).isNetworkAvailable()) {
                if (StatConfig.isDebugEnable()) {
                    StatServiceImpl.f4884q.mo7904i("sendFailedCount=" + StatServiceImpl.f4868a);
                }
                if (StatServiceImpl.m4630a()) {
                    C1706ba.m4673a(this.f4951d).mo7871a(this.f4948a, null, this.f4950c, false);
                    if (this.f4952e - StatServiceImpl.f4869b > 1800000) {
                        StatServiceImpl.m4647e(this.f4951d);
                        return;
                    }
                    return;
                }
                m4667b();
                return;
            }
            C1706ba.m4673a(this.f4951d).mo7871a(this.f4948a, null, this.f4950c, false);
        }
    }
}
