package com.tencent.mid.p116a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mid.api.MidCallback;
import com.tencent.mid.api.MidConstants;
import com.tencent.mid.api.MidEntity;
import com.tencent.mid.p117b.C1643a;
import com.tencent.mid.p117b.C1649g;
import com.tencent.mid.util.C1658i;
import com.tencent.mid.util.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mid.a.d */
public class C1634d {
    /* renamed from: b */
    private static String f4659b = "iikVs3FGzEQ23RaD1JlHsSWSI5Z26m2hX3gO51mH3ag=";
    /* renamed from: c */
    private static C1634d f4660c = null;
    /* renamed from: d */
    private static Context f4661d = null;
    /* renamed from: a */
    Handler f4662a = null;

    private C1634d(Context context) {
        try {
            HandlerThread handlerThread = new HandlerThread("HttpManager");
            handlerThread.start();
            this.f4662a = new Handler(handlerThread.getLooper());
            f4661d = context.getApplicationContext();
        } catch (Throwable th) {
            Util.logWarn(th);
        }
    }

    /* renamed from: a */
    static Context m4467a() {
        return f4661d;
    }

    /* renamed from: a */
    public static synchronized C1634d m4468a(Context context) {
        C1634d c1634d;
        synchronized (C1634d.class) {
            if (f4660c == null) {
                f4660c = new C1634d(context);
            }
            c1634d = f4660c;
        }
        return c1634d;
    }

    /* renamed from: a */
    private String m4469a(C1636f c1636f, MidCallback midCallback) {
        int i = -1;
        boolean z = true;
        boolean z2 = false;
        int a = c1636f.mo7614a();
        String b = c1636f.mo7615b();
        String str = "0";
        String str2;
        if (a == 200) {
            int i2;
            if (Util.isStringValid(b)) {
                JSONObject jSONObject = new JSONObject(b);
                str = jSONObject.optString("mid", null);
                if (Util.isMidValid(str)) {
                    MidEntity midEntity = new MidEntity();
                    midEntity.setMid(str);
                    midEntity.setMac(Util.getWifiMacAddress(f4661d));
                    midEntity.setImei(Util.getImei(f4661d));
                    if (jSONObject.isNull("ts")) {
                        midEntity.setTimestamps(System.currentTimeMillis());
                    } else {
                        long optLong = jSONObject.optLong("ts");
                        if (optLong > 0) {
                            midEntity.setTimestamps(optLong);
                        }
                    }
                    Util.logInfo("new mid midEntity:" + midEntity.toString());
                    midCallback.onSuccess(midEntity.toString());
                    if (jSONObject.optInt("force", 0) == 1) {
                        z2 = true;
                    }
                    midEntity.setForceWrite(z2);
                    C1649g.m4537a(f4661d).mo7663a(midEntity);
                } else {
                    z = false;
                }
                int i3 = !jSONObject.isNull(C1643a.f4688c) ? jSONObject.getInt(C1643a.f4688c) : -1;
                String str3;
                if (jSONObject.isNull(C1643a.f4689d)) {
                    str3 = str;
                    i2 = i3;
                    str2 = str3;
                } else {
                    i = jSONObject.getInt(C1643a.f4689d);
                    str3 = str;
                    i2 = i3;
                    str2 = str3;
                }
            } else {
                z = false;
                str2 = str;
                i2 = -1;
            }
            C1649g.m4537a(f4661d).mo7662a(i2, i);
            if (z) {
                return str2;
            }
            midCallback.onSuccess(C1649g.m4537a(f4661d).mo7660a());
            return str2;
        }
        str2 = "Server response error code:" + a + ", error:" + b;
        Util.logInfo(str2);
        midCallback.onFail(a, str2);
        return str;
    }

    /* renamed from: b */
    private String m4471b() {
        return Util.decode(f4659b);
    }

    /* renamed from: b */
    private void m4472b(C1637g c1637g, MidCallback midCallback) {
        JSONObject jSONObject;
        try {
            String httpUrl = Util.getHttpUrl();
            C1636f a = C1632b.m4461a(httpUrl);
            String str;
            if (a.mo7614a() != 200) {
                str = "response code invalid:" + a.mo7614a();
                Util.logInfo(str);
                midCallback.onFail(a.mo7614a(), str);
                C1632b.m4466b();
                return;
            }
            int i = 0;
            Object obj = null;
            JSONObject jSONObject2 = new JSONObject(a.mo7615b());
            if (!jSONObject2.isNull("rand")) {
                i = jSONObject2.getInt("rand");
                obj = C1658i.m4563a(Util.getHMAC(m4471b(), String.valueOf(i)));
            }
            if (obj == null || i == 0) {
                Util.logInfo("hmac == null");
                C1632b.m4466b();
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put("k", obj);
            hashMap.put("s", String.valueOf(i));
            str = httpUrl + C1632b.m4463a(hashMap);
            C1636f a2 = C1632b.m4461a(str);
            if (a2.mo7614a() != 200) {
                str = "hmac invalid.";
                Util.logInfo(str);
                midCallback.onFail(a2.mo7614a(), str);
                C1632b.m4466b();
                return;
            }
            jSONObject = new JSONObject();
            c1637g.mo7617a(jSONObject);
            Util.jsonPut(jSONObject, "rip", Util.getRemoteUrlIp(Util.getHttpUrl()));
            str = m4469a(C1632b.m4462a(str, "[" + jSONObject.toString() + "]"), midCallback);
            if (Util.isMidValid(jSONObject.optString("mid")) || Util.isMidValid(str)) {
                C1632b.m4466b();
                return;
            }
            throw new Exception("get Mid failed, something wrong");
        } catch (Throwable th) {
            midCallback.onFail(MidConstants.ERROR_SDK_LOGIC, th.toString());
        }
        C1632b.m4466b();
    }

    /* renamed from: a */
    void mo7612a(C1637g c1637g, MidCallback midCallback) {
        if (c1637g == null || this.f4662a == null || midCallback == null) {
            if (midCallback != null) {
                midCallback.onFail(MidConstants.ERROR_ARGUMENT, "packet == null || handler == null");
            }
        } else if (Thread.currentThread().getId() == this.f4662a.getLooper().getThread().getId()) {
            m4472b(c1637g, midCallback);
        } else {
            this.f4662a.post(new C1635e(this, c1637g, midCallback));
        }
    }
}
