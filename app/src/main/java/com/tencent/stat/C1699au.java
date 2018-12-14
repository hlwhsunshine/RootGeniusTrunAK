package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.event.C1735f;
import com.tencent.stat.event.C1745j;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;

/* renamed from: com.tencent.stat.au */
class C1699au implements Runnable {
    /* renamed from: a */
    private Context f4944a = null;
    /* renamed from: b */
    private Map<String, Integer> f4945b = null;
    /* renamed from: c */
    private StatSpecifyReportedInfo f4946c = null;

    public C1699au(Context context, Map<String, Integer> map, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f4944a = context;
        this.f4946c = statSpecifyReportedInfo;
        if (map != null) {
            this.f4945b = map;
        }
    }

    /* renamed from: a */
    private NetworkMonitor m4662a(String str, int i) {
        Throwable th;
        NetworkMonitor networkMonitor = new NetworkMonitor();
        Socket socket = new Socket();
        int i2 = 0;
        try {
            networkMonitor.setDomain(str);
            networkMonitor.setPort(i);
            long currentTimeMillis = System.currentTimeMillis();
            SocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            socket.connect(inetSocketAddress, 30000);
            networkMonitor.setMillisecondsConsume(System.currentTimeMillis() - currentTimeMillis);
            networkMonitor.setRemoteIp(inetSocketAddress.getAddress().getHostAddress());
            socket.close();
            try {
                socket.close();
            } catch (Throwable th2) {
                StatServiceImpl.f4884q.mo7900e(th2);
            }
        } catch (Throwable e) {
            th2 = e;
            i2 = -1;
            StatServiceImpl.f4884q.mo7900e(th2);
            socket.close();
        } catch (Throwable th22) {
            StatServiceImpl.f4884q.mo7900e(th22);
        }
        networkMonitor.setStatusCode(i2);
        return networkMonitor;
    }

    /* renamed from: a */
    private Map<String, Integer> m4663a() {
        Map<String, Integer> hashMap = new HashMap();
        String sDKProperty = StatConfig.getSDKProperty("__MTA_TEST_SPEED__", null);
        if (!(sDKProperty == null || sDKProperty.trim().length() == 0)) {
            for (String sDKProperty2 : sDKProperty2.split(";")) {
                String[] split = sDKProperty2.split(",");
                if (split != null && split.length == 2) {
                    String str = split[0];
                    if (!(str == null || str.trim().length() == 0)) {
                        try {
                            hashMap.put(str, Integer.valueOf(Integer.valueOf(split[1]).intValue()));
                        } catch (Throwable e) {
                            StatServiceImpl.f4884q.mo7900e(e);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public void run() {
        try {
            if (this.f4945b == null) {
                this.f4945b = m4663a();
            }
            if (this.f4945b == null || this.f4945b.size() == 0) {
                StatServiceImpl.f4884q.mo7904i("empty domain list.");
                return;
            }
            JSONArray jSONArray = new JSONArray();
            for (Entry entry : this.f4945b.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null || str.length() == 0) {
                    StatServiceImpl.f4884q.mo7912w("empty domain name.");
                } else if (((Integer) entry.getValue()) == null) {
                    StatServiceImpl.f4884q.mo7912w("port is null for " + str);
                } else {
                    jSONArray.put(m4662a((String) entry.getKey(), ((Integer) entry.getValue()).intValue()).toJSONObject());
                }
            }
            if (jSONArray.length() != 0) {
                C1735f c1745j = new C1745j(this.f4944a, StatServiceImpl.m4619a(this.f4944a, false, this.f4946c), this.f4946c);
                c1745j.mo7939a(jSONArray.toString());
                new C1700av(c1745j).mo7867a();
            }
        } catch (Throwable th) {
            StatServiceImpl.f4884q.mo7900e(th);
        }
    }
}
