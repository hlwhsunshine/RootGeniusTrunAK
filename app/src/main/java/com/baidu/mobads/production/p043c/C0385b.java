package com.baidu.mobads.production.p043c;

import android.content.Context;
import android.content.p013pm.PackageInfo;
import android.content.p013pm.PackageManager.NameNotFoundException;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.webkit.CookieManager;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.p021j.C0338m;
import com.tencent.stat.common.DeviceInfo;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.baidu.mobads.production.c.b */
public class C0385b {
    /* renamed from: a */
    private Set<String> f864a;
    /* renamed from: b */
    private Set<String> f865b;
    /* renamed from: c */
    private Set<String> f866c;
    /* renamed from: d */
    private CookieManager f867d;
    /* renamed from: e */
    private IXAdSystemUtils f868e = C0338m.m569a().mo5041n();
    /* renamed from: f */
    private IXAdCommonUtils f869f = C0338m.m569a().mo5040m();
    /* renamed from: g */
    private Context f870g;
    /* renamed from: h */
    private int f871h;
    /* renamed from: i */
    private String f872i;

    public C0385b(Context context, int i, String str) {
        this.f870g = context;
        this.f871h = i;
        this.f872i = str;
        this.f867d = CookieManager.getInstance();
        this.f867d.setAcceptCookie(true);
        m777b();
    }

    /* renamed from: a */
    private String m775a(String str) {
        return str == null ? null : str.replace(":", "-");
    }

    /* renamed from: a */
    private void m776a(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("=");
        stringBuffer.append(obj);
        stringBuffer.append(";");
        this.f867d.setCookie("http://cpu.baidu.com/", stringBuffer.toString());
    }

    /* renamed from: b */
    private void m777b() {
        this.f864a = new HashSet();
        this.f864a.add("46000");
        this.f864a.add("46002");
        this.f864a.add("46007");
        this.f865b = new HashSet();
        this.f865b.add("46001");
        this.f865b.add("46006");
        this.f866c = new HashSet();
        this.f866c.add("46003");
        this.f866c.add("46005");
    }

    /* renamed from: c */
    private void m778c() {
        Object obj = null;
        int i = 0;
        Rect screenRect = this.f869f.getScreenRect(this.f870g);
        int height = screenRect.height();
        int width = screenRect.width();
        boolean d = m779d();
        Object a = d ? m775a(m782g()) : null;
        int e = d ? m780e() : 0;
        if (d) {
            obj = m781f();
        }
        if (d) {
            i = 1;
        }
        String cuid = this.f868e.getCUID(this.f870g);
        m776a(IXAdRequestInfo.f650V, m783h());
        m776a(IXAdRequestInfo.IMSI, this.f868e.getIMEI(this.f870g));
        m776a(DeviceInfo.TAG_ANDROID_ID, this.f868e.getAndroidId(this.f870g));
        m776a("m", m775a(this.f868e.getMacAddress(this.f870g)));
        m776a("cuid", cuid);
        m776a("ct", Integer.valueOf(C0384a.m773a(this.f870g)));
        m776a("oi", Integer.valueOf(m784i()));
        m776a("src", Integer.valueOf(1));
        m776a(IXAdRequestInfo.HEIGHT, Integer.valueOf(height));
        m776a(IXAdRequestInfo.WIDTH, Integer.valueOf(width));
        m776a("apm", a);
        m776a("rssi", Integer.valueOf(e));
        m776a("apn", obj);
        m776a("isc", Integer.valueOf(i));
    }

    /* renamed from: d */
    private boolean m779d() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f870g.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: e */
    private int m780e() {
        try {
            WifiInfo connectionInfo = ((WifiManager) this.f870g.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
            return connectionInfo == null ? 0 : connectionInfo.getRssi();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: f */
    private String m781f() {
        try {
            WifiInfo connectionInfo = ((WifiManager) this.f870g.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
            String ssid = connectionInfo == null ? "" : connectionInfo.getSSID();
            if (ssid.startsWith("\"") && ssid.endsWith("\"")) {
                return ssid.substring(1, ssid.length() - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /* renamed from: g */
    private String m782g() {
        try {
            WifiInfo connectionInfo = ((WifiManager) this.f870g.getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo();
            return connectionInfo == null ? null : connectionInfo.getMacAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: h */
    private String m783h() {
        try {
            PackageInfo packageInfo = this.f870g.getPackageManager().getPackageInfo(this.f870g.getPackageName(), 0);
            String str = packageInfo == null ? null : packageInfo.versionName;
            return str != null ? str.replace(".", "-") : null;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: i */
    private int m784i() {
        String networkOperator = this.f868e.getNetworkOperator(this.f870g);
        return networkOperator == null ? 0 : this.f864a.contains(networkOperator) ? 1 : this.f866c.contains(networkOperator) ? 2 : this.f865b.contains(networkOperator) ? 3 : 99;
    }

    /* renamed from: a */
    public String mo5199a() {
        m778c();
        return "http://cpu.baidu.com/" + this.f871h + "/" + this.f872i;
    }
}
