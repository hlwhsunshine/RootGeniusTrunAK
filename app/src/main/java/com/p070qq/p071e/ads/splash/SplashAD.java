package com.p070qq.p071e.ads.splash;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.p070qq.p071e.comm.C1058a;
import com.p070qq.p071e.comm.adevent.ADEvent;
import com.p070qq.p071e.comm.adevent.ADListener;
import com.p070qq.p071e.comm.constants.ErrorCode.InitError;
import com.p070qq.p071e.comm.constants.ErrorCode.OtherError;
import com.p070qq.p071e.comm.managers.GDTADManager;
import com.p070qq.p071e.comm.p073pi.NSPVI;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;

/* renamed from: com.qq.e.ads.splash.SplashAD */
public final class SplashAD {
    /* renamed from: a */
    private NSPVI f2757a;
    /* renamed from: b */
    private SplashADListener f2758b;

    /* renamed from: com.qq.e.ads.splash.SplashAD$ADListenerAdapter */
    class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(SplashAD splashAD, byte b) {
            this();
        }

        public void onADEvent(ADEvent aDEvent) {
            if (SplashAD.this.f2758b == null) {
                GDTLogger.m3131e("SplashADListener == null");
                return;
            }
            switch (aDEvent.getType()) {
                case 1:
                    SplashAD.this.f2758b.onADDismissed();
                    return;
                case 2:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        SplashAD.this.f2758b.onNoAD(((Integer) aDEvent.getParas()[0]).intValue());
                        return;
                    } else {
                        GDTLogger.m3131e("Splash ADEvent error,");
                        return;
                    }
                case 3:
                    SplashAD.this.f2758b.onADPresent();
                    return;
                case 4:
                    SplashAD.this.f2758b.onADClicked();
                    return;
                default:
                    return;
            }
        }
    }

    public SplashAD(Activity activity, ViewGroup viewGroup, String str, String str2, SplashADListener splashADListener) {
        this(activity, viewGroup, str, str2, splashADListener, 0);
    }

    public SplashAD(Activity activity, ViewGroup viewGroup, String str, String str2, SplashADListener splashADListener, int i) {
        this.f2758b = splashADListener;
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || viewGroup == null || activity == null) {
            GDTLogger.m3131e(String.format("SplashAd Constructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
            SplashAD.m3064a(splashADListener, InitError.INIT_AD_ERROR);
        } else if (C1058a.m3070a((Context) activity)) {
            try {
                if (GDTADManager.getInstance().initWith(activity, str)) {
                    this.f2757a = GDTADManager.getInstance().getPM().getPOFactory().getNativeSplashAdView(activity, str, str2);
                    if (this.f2757a != null) {
                        this.f2757a.setFetchDelay(i);
                        this.f2757a.setAdListener(new ADListenerAdapter(this, (byte) 0));
                        this.f2757a.fetchAndShowIn(viewGroup);
                        return;
                    }
                    GDTLogger.m3131e("SplashAdView created by factory return null");
                    SplashAD.m3064a(splashADListener, InitError.GET_INTERFACE_ERROR);
                    return;
                }
                GDTLogger.m3131e("Fail to Init GDT AD SDK,report logcat info filter by gdt_ad_mob");
                SplashAD.m3064a(splashADListener, InitError.INIT_ADMANGER_ERROR);
            } catch (Throwable e) {
                GDTLogger.m3132e("Fail to init splash plugin", e);
                SplashAD.m3064a(splashADListener, InitError.INIT_PLUGIN_ERROR);
            } catch (Throwable e2) {
                GDTLogger.m3132e("Unknown Exception", e2);
                SplashAD.m3064a(splashADListener, OtherError.UNKNOWN_ERROR);
            }
        } else {
            GDTLogger.m3131e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
            SplashAD.m3064a(splashADListener, InitError.INIT_AD_ERROR);
        }
    }

    /* renamed from: a */
    private static void m3064a(SplashADListener splashADListener, int i) {
        if (splashADListener != null) {
            splashADListener.onNoAD(i);
        }
    }
}
