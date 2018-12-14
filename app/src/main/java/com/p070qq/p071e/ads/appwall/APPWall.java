package com.p070qq.p071e.ads.appwall;

import android.content.Context;
import com.p070qq.p071e.comm.C1058a;
import com.p070qq.p071e.comm.managers.GDTADManager;
import com.p070qq.p071e.comm.p073pi.AWI;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;

/* renamed from: com.qq.e.ads.appwall.APPWall */
public class APPWall {
    /* renamed from: a */
    private AWI f2682a;

    public APPWall(Context context, String str, String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || context == null) {
            GDTLogger.m3131e(String.format("APPWall ADView Contructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, context}));
        } else if (!C1058a.m3070a(context)) {
            GDTLogger.m3131e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
        } else if (GDTADManager.getInstance().initWith(context, str)) {
            try {
                this.f2682a = GDTADManager.getInstance().getPM().getPOFactory().getAppWallView(context, str, str2);
            } catch (Throwable e) {
                GDTLogger.m3132e("Exception while init APPWall plugin", e);
            }
        } else {
            GDTLogger.m3131e("Fail to init ADManager");
        }
    }

    public void doShowAppWall() {
        if (this.f2682a != null) {
            this.f2682a.showAppWall();
        }
    }

    public void prepare() {
        if (this.f2682a != null) {
            this.f2682a.prepare();
        }
    }

    public void setScreenOrientation(int i) {
        if (this.f2682a != null) {
            this.f2682a.setScreenOrientation(i);
        }
    }
}
