package com.p070qq.p071e.comm.managers;

import android.content.Context;
import android.os.Build.VERSION;
import com.p070qq.p071e.comm.C1058a;
import com.p070qq.p071e.comm.constants.CustomPkgConstants;
import com.p070qq.p071e.comm.managers.plugin.C1061PM;
import com.p070qq.p071e.comm.managers.setting.C1066SM;
import com.p070qq.p071e.comm.managers.status.APPStatus;
import com.p070qq.p071e.comm.managers.status.DeviceStatus;
import com.p070qq.p071e.comm.services.C1078a;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* renamed from: com.qq.e.comm.managers.GDTADManager */
public class GDTADManager {
    public static final ExecutorService INIT_EXECUTOR = Executors.newSingleThreadExecutor();
    /* renamed from: a */
    private volatile Boolean f2765a;
    /* renamed from: b */
    private volatile Context f2766b;
    /* renamed from: c */
    private volatile C1066SM f2767c;
    /* renamed from: d */
    private volatile C1061PM f2768d;
    /* renamed from: e */
    private volatile APPStatus f2769e;
    /* renamed from: f */
    private volatile DeviceStatus f2770f;

    /* renamed from: com.qq.e.comm.managers.GDTADManager$a */
    static final class C1059a {
        /* renamed from: a */
        private static GDTADManager f2764a = new GDTADManager();
    }

    private GDTADManager() {
        this.f2765a = Boolean.valueOf(false);
    }

    /* synthetic */ GDTADManager(byte b) {
        this();
    }

    public static GDTADManager getInstance() {
        return C1059a.f2764a;
    }

    public JSONObject buildS2SSBaseInfo() {
        if (!isInitialized()) {
            return null;
        }
        JSONObject a = C1058a.m3067a(this.f2767c);
        a.put("app", C1058a.m3068a(this.f2769e));
        a.put("c", C1058a.m3069a(this.f2770f));
        a.put("sdk", C1058a.m3066a(this.f2768d));
        return a;
    }

    public String getADActivityClazz() {
        return CustomPkgConstants.getADActivityName();
    }

    public Context getAppContext() {
        return this.f2766b;
    }

    public APPStatus getAppStatus() {
        return this.f2769e;
    }

    public DeviceStatus getDeviceStatus() {
        return this.f2770f;
    }

    public String getDownLoadClazz() {
        return CustomPkgConstants.getDownLoadServiceName();
    }

    public C1061PM getPM() {
        return this.f2768d;
    }

    public C1066SM getSM() {
        return this.f2767c;
    }

    public synchronized boolean initWith(Context context, String str) {
        boolean z;
        if (this.f2765a.booleanValue()) {
            z = true;
        } else {
            if (context != null) {
                if (!StringUtil.isEmpty(str)) {
                    try {
                        long nanoTime = System.nanoTime();
                        this.f2766b = context.getApplicationContext();
                        this.f2767c = new C1066SM(this.f2766b);
                        this.f2768d = new C1061PM(this.f2766b);
                        this.f2769e = new APPStatus(str, this.f2766b);
                        this.f2770f = new DeviceStatus(this.f2766b);
                        if (VERSION.SDK_INT > 7) {
                            C1078a.m3125a().mo6627a(this.f2766b, this.f2767c, this.f2768d, this.f2770f, this.f2769e, nanoTime);
                        }
                        this.f2765a = Boolean.valueOf(true);
                        z = true;
                    } catch (Throwable th) {
                        GDTLogger.report("ADManager init error", th);
                        z = false;
                    }
                }
            }
            GDTLogger.m3131e("Context And APPID should Never Be NULL while init GDTADManager");
            z = false;
        }
        return z;
    }

    public boolean isInitialized() {
        return this.f2765a == null ? false : this.f2765a.booleanValue();
    }
}
