package com.tencent.stat;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.stat.common.C1721e;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.Util;
import org.apache.http.HttpHost;

public class NetworkManager {
    public static final int TYPE_NOT_WIFI = 2;
    public static final int TYPE_NO_NETWORK = 0;
    public static final int TYPE_WIFI = 1;
    /* renamed from: f */
    private static NetworkManager f4774f = null;
    /* renamed from: a */
    private volatile int f4775a = 2;
    /* renamed from: b */
    private volatile String f4776b = "";
    /* renamed from: c */
    private volatile HttpHost f4777c = null;
    /* renamed from: d */
    private C1721e f4778d = null;
    /* renamed from: e */
    private int f4779e = 0;
    /* renamed from: g */
    private Context f4780g = null;
    /* renamed from: h */
    private StatLogger f4781h = null;

    private NetworkManager(Context context) {
        if (context != null) {
            this.f4780g = context.getApplicationContext();
        } else {
            this.f4780g = StatServiceImpl.getContext(null);
        }
        this.f4778d = new C1721e();
        C1748g.m4806a(context);
        this.f4781h = StatCommonHelper.getLogger();
        m4591b();
        mo7759a();
    }

    /* renamed from: b */
    private void m4591b() {
        this.f4775a = 0;
        this.f4777c = null;
        this.f4776b = null;
    }

    public static NetworkManager getInstance(Context context) {
        if (f4774f == null) {
            synchronized (NetworkManager.class) {
                if (f4774f == null) {
                    f4774f = new NetworkManager(context);
                }
            }
        }
        return f4774f;
    }

    /* renamed from: a */
    void mo7759a() {
        if (Util.isNetworkAvailable(this.f4780g)) {
            this.f4776b = StatCommonHelper.getLinkedWay(this.f4780g);
            if (StatConfig.isDebugEnable()) {
                this.f4781h.mo7904i("NETWORK name:" + this.f4776b);
            }
            if (StatCommonHelper.isStringValid(this.f4776b)) {
                if ("WIFI".equalsIgnoreCase(this.f4776b)) {
                    this.f4775a = 1;
                } else {
                    this.f4775a = 2;
                }
                this.f4777c = StatCommonHelper.getHttpProxy(this.f4780g);
            }
            if (StatServiceImpl.m4630a()) {
                StatServiceImpl.m4647e(this.f4780g);
                return;
            }
            return;
        }
        if (StatConfig.isDebugEnable()) {
            this.f4781h.mo7904i("NETWORK TYPE: network is close.");
        }
        m4591b();
    }

    public String getCurNetwrokName() {
        return this.f4776b;
    }

    public HttpHost getHttpProxy() {
        return this.f4777c;
    }

    public int getNetworkType() {
        return this.f4775a;
    }

    public boolean isNetworkAvailable() {
        return this.f4775a != 0;
    }

    public boolean isWifi() {
        return this.f4775a == 1;
    }

    public void onDispatchFailed() {
    }

    public void registerBroadcast() {
        try {
            this.f4780g.getApplicationContext().registerReceiver(new C1678a(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
