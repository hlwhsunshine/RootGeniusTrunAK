package com.kingroot.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.kingroot.sdk.util.C0609p;

/* renamed from: com.kingroot.sdk.ae */
public class C0613ae {
    /* renamed from: aL */
    private static C0613ae f1497aL;
    /* renamed from: aI */
    private boolean f1498aI = false;
    /* renamed from: aJ */
    private boolean f1499aJ = false;
    /* renamed from: aK */
    private boolean f1500aK = false;
    /* renamed from: aM */
    private C0606ad f1501aM = new C06071();
    /* renamed from: aN */
    private BroadcastReceiver f1502aN = new C06082();
    /* renamed from: aO */
    private C0609p f1503aO = new C06113();
    /* renamed from: aP */
    private C0609p f1504aP = new C06124();
    private Context mContext;

    /* renamed from: com.kingroot.sdk.ae$1 */
    class C06071 extends C0606ad {
        C06071() {
        }

        /* renamed from: j */
        public void mo5586j() {
            C0617ai.m1380g("Network connected");
            C0613ae.this.m1363k();
        }
    }

    /* renamed from: com.kingroot.sdk.ae$2 */
    class C06082 extends BroadcastReceiver {
        C06082() {
        }

        public void onReceive(Context context, Intent intent) {
            C0617ai.m1380g("Screen off");
            if (!C0613ae.this.f1498aI) {
                C0613ae.this.f1503aO.mo5590bs();
            }
        }
    }

    /* renamed from: com.kingroot.sdk.ae$3 */
    class C06113 extends C0609p {
        C06113() {
        }

        public void run() {
            C0613ae.this.f1498aI = true;
            C0614af.m1366a(C0613ae.this.mContext, false);
            C0614af.m1369b(C0613ae.this.mContext, false);
            C0613ae.this.f1498aI = false;
            C0613ae.this.m1363k();
        }
    }

    /* renamed from: com.kingroot.sdk.ae$4 */
    class C06124 extends C0609p {
        C06124() {
        }

        public void run() {
            C0613ae.this.f1499aJ = true;
            C0622al.m1417i(C0613ae.this.mContext);
            C0622al.m1418j(C0613ae.this.mContext);
            C0613ae.this.f1499aJ = false;
        }
    }

    private C0613ae(Context context) {
        this.mContext = context;
    }

    /* renamed from: e */
    public static C0613ae m1362e(Context context) {
        if (f1497aL == null) {
            synchronized (C0613ae.class) {
                if (f1497aL == null) {
                    f1497aL = new C0613ae(context);
                }
            }
        }
        return f1497aL;
    }

    /* renamed from: k */
    private void m1363k() {
        if (!this.f1499aJ) {
            this.f1504aP.mo5590bs();
        }
    }

    public void start() {
        C0617ai.m1381h("Starting...");
        if (this.f1500aK) {
            C0617ai.m1380g("It has been running, not to start again");
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(this.f1502aN, intentFilter);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        this.mContext.registerReceiver(this.f1501aM, intentFilter);
        C0617ai.m1380g("Started!");
        this.f1500aK = true;
    }
}
