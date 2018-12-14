package com.p070qq.p071e.ads.appwall;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.p070qq.p071e.comm.C1058a;
import com.p070qq.p071e.comm.constants.ErrorCode.InitError;
import com.p070qq.p071e.comm.constants.ErrorCode.OtherError;
import com.p070qq.p071e.comm.managers.GDTADManager;
import com.p070qq.p071e.comm.p073pi.GWI;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;

/* renamed from: com.qq.e.ads.appwall.GridAPPWall */
public final class GridAPPWall {
    /* renamed from: a */
    private GWI f2683a;

    public GridAPPWall(Activity activity, String str, String str2, GridAPPWallListener gridAPPWallListener) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null) {
            GDTLogger.m3131e(String.format("GridAPPWall ADView Contructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
        } else if (C1058a.m3070a((Context) activity)) {
            try {
                if (GDTADManager.getInstance().initWith(activity.getApplicationContext(), str)) {
                    this.f2683a = GDTADManager.getInstance().getPM().getPOFactory().createGridAppWallView(activity, str, str2);
                    if (this.f2683a != null) {
                        this.f2683a.setAdListener(gridAPPWallListener);
                        return;
                    }
                    GDTLogger.m3131e("Fail to INIT GDT SDK");
                    GridAPPWall.m3036a(gridAPPWallListener, InitError.GET_INTERFACE_ERROR);
                    return;
                }
                GDTLogger.m3131e("Fail to Init GDT AD SDK,report logcat info filter by gdt_ad_mob");
                GridAPPWall.m3036a(gridAPPWallListener, InitError.INIT_ADMANGER_ERROR);
            } catch (Throwable e) {
                GDTLogger.m3132e("Fail to init new appwall plugin", e);
                GridAPPWall.m3036a(gridAPPWallListener, InitError.INIT_PLUGIN_ERROR);
            } catch (Throwable e2) {
                GDTLogger.m3132e("Unknown Exception", e2);
                GridAPPWall.m3036a(gridAPPWallListener, OtherError.UNKNOWN_ERROR);
            }
        } else {
            GDTLogger.m3131e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            GridAPPWall.m3036a(gridAPPWallListener, OtherError.ANDROID_PERMMISON_ERROR);
        }
    }

    /* renamed from: a */
    private static void m3036a(GridAPPWallListener gridAPPWallListener, int i) {
        if (gridAPPWallListener != null) {
            gridAPPWallListener.onNoAD(i);
        }
    }

    public final void show() {
        if (this.f2683a != null) {
            this.f2683a.show();
        }
    }

    public final void showRelativeTo(int i, int i2) {
        if (this.f2683a != null) {
            this.f2683a.showRelativeTo(i, i2);
        }
    }

    public final void showRelativeTo(View view) {
        if (this.f2683a != null) {
            this.f2683a.showRelativeTo(view);
        }
    }
}
