package com.shuame.rootgenius.common.event;

import android.content.Intent;
import android.os.Handler;
import com.shuame.rootgenius.common.C1150a;
import com.shuame.rootgenius.common.C1323b;
import com.shuame.rootgenius.common.C1325c;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.shuame.rootgenius.common.event.i */
public class C1345i {
    /* renamed from: a */
    private static final String f3664a = C1345i.class.getSimpleName();
    /* renamed from: c */
    private static C1345i f3665c = new C1345i();
    /* renamed from: b */
    private final long f3666b = 10000;
    /* renamed from: d */
    private Handler f3667d = new Handler(new C1346j(this));
    /* renamed from: e */
    private boolean f3668e = false;
    /* renamed from: f */
    private boolean f3669f = false;
    /* renamed from: g */
    private boolean f3670g = false;
    /* renamed from: h */
    private boolean f3671h = false;
    /* renamed from: i */
    private boolean f3672i = false;
    /* renamed from: j */
    private ArrayList<C1344a> f3673j;

    /* renamed from: com.shuame.rootgenius.common.event.i$a */
    public interface C1344a {
        /* renamed from: a */
        void mo7014a();
    }

    private C1345i() {
    }

    /* renamed from: a */
    public static C1345i m3749a() {
        return f3665c;
    }

    /* renamed from: a */
    public final void mo7015a(C1344a c1344a) {
        if (this.f3673j == null) {
            this.f3673j = new ArrayList();
        }
        this.f3673j.add(c1344a);
    }

    /* renamed from: a */
    public final void mo7016a(String str) {
        mo7017a(true);
        mo7019b(true);
        if ("Heartbeat".equals(str)) {
            this.f3667d.removeMessages(1000);
            this.f3667d.sendEmptyMessageDelayed(1000, 10000);
            return;
        }
        Intent intent = new Intent();
        if ("Connection".equals(str)) {
            this.f3670g = true;
            intent.putExtra("EXTAR_ACTIVITY", "JointPCActivity");
        } else if ("UnsinstallApp".equals(str)) {
            this.f3671h = true;
            intent.putExtra("EXTAR_ACTIVITY", "AppUninstallActivity");
        } else if ("AutorunMgr".equals(str)) {
            this.f3672i = true;
            intent.putExtra("EXTAR_ACTIVITY", "AutoBootManagerActivity");
        } else if ("rooted".equals(str)) {
            C1323b.m3694c(true);
            C1325c.m3724a().sendBroadcast(new Intent(C1340e.f3630a));
        } else if ("unroot".equals(str)) {
            C1323b.m3694c(false);
            C1325c.m3724a().sendBroadcast(new Intent(C1340e.f3630a));
        }
        if (intent.hasExtra("EXTAR_ACTIVITY")) {
            intent.setFlags(268435456);
            C1150a.m3309a(C1325c.m3724a(), intent);
        }
    }

    /* renamed from: a */
    public final void mo7017a(boolean z) {
        if (this.f3668e != z) {
            this.f3668e = z;
            if (this.f3673j != null) {
                Iterator it = this.f3673j.iterator();
                while (it.hasNext()) {
                    ((C1344a) it.next()).mo7014a();
                }
            }
            if (!this.f3668e) {
                mo7019b(false);
            }
        }
    }

    /* renamed from: b */
    public final void mo7018b(C1344a c1344a) {
        if (this.f3673j != null) {
            this.f3673j.remove(c1344a);
        }
    }

    /* renamed from: b */
    public final void mo7019b(boolean z) {
        if (this.f3669f != z) {
            this.f3669f = z;
            if (this.f3673j != null) {
                Iterator it = this.f3673j.iterator();
                while (it.hasNext()) {
                    ((C1344a) it.next()).mo7014a();
                }
            }
        }
    }

    /* renamed from: b */
    public final boolean mo7020b() {
        return this.f3668e && this.f3669f;
    }

    /* renamed from: c */
    public final boolean mo7021c() {
        return !mo7020b() ? false : this.f3670g || this.f3671h || this.f3672i;
    }

    /* renamed from: d */
    public final boolean mo7022d() {
        return this.f3670g;
    }

    /* renamed from: e */
    public final boolean mo7023e() {
        return this.f3671h;
    }

    /* renamed from: f */
    public final boolean mo7024f() {
        return this.f3672i;
    }

    /* renamed from: g */
    public final void mo7025g() {
        this.f3670g = false;
    }

    /* renamed from: h */
    public final void mo7026h() {
        this.f3671h = false;
    }

    /* renamed from: i */
    public final void mo7027i() {
        this.f3672i = false;
    }
}
