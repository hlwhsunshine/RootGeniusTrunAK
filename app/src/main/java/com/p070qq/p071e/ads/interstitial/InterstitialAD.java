package com.p070qq.p071e.ads.interstitial;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.p070qq.p071e.comm.C1058a;
import com.p070qq.p071e.comm.adevent.ADEvent;
import com.p070qq.p071e.comm.adevent.ADListener;
import com.p070qq.p071e.comm.managers.GDTADManager;
import com.p070qq.p071e.comm.p073pi.IADI;
import com.p070qq.p071e.comm.p073pi.POFactory;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.qq.e.ads.interstitial.InterstitialAD */
public class InterstitialAD {
    /* renamed from: a */
    private IADI f2719a;
    /* renamed from: b */
    private InterstitialADListener f2720b;
    /* renamed from: c */
    private boolean f2721c = false;
    /* renamed from: d */
    private boolean f2722d = false;
    /* renamed from: e */
    private boolean f2723e = false;
    /* renamed from: f */
    private volatile int f2724f = 0;

    /* renamed from: com.qq.e.ads.interstitial.InterstitialAD$ADListenerAdapter */
    class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(InterstitialAD interstitialAD, byte b) {
            this();
        }

        public void onADEvent(ADEvent aDEvent) {
            if (InterstitialAD.this.f2720b == null) {
                GDTLogger.m3133i("No DevADListener Binded");
                return;
            }
            switch (aDEvent.getType()) {
                case 1:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        InterstitialAD.this.f2720b.onNoAD(((Integer) aDEvent.getParas()[0]).intValue());
                        return;
                    } else {
                        GDTLogger.m3131e("AdEvent.Paras error for Banner(" + aDEvent + ")");
                        return;
                    }
                case 2:
                    InterstitialAD.this.f2720b.onADReceive();
                    return;
                case 3:
                    InterstitialAD.this.f2720b.onADExposure();
                    return;
                case 4:
                    InterstitialAD.this.f2720b.onADOpened();
                    return;
                case 5:
                    InterstitialAD.this.f2720b.onADClicked();
                    return;
                case 6:
                    InterstitialAD.this.f2720b.onADLeftApplication();
                    return;
                case 7:
                    InterstitialAD.this.f2720b.onADClosed();
                    return;
                default:
                    return;
            }
        }
    }

    public InterstitialAD(final Activity activity, final String str, final String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null) {
            GDTLogger.m3131e(String.format("Intersitial Contructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
            return;
        }
        this.f2721c = true;
        if (C1058a.m3070a((Context) activity)) {
            this.f2722d = true;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() {
                public void run() {
                    if (GDTADManager.getInstance().initWith(activity, str)) {
                        try {
                            final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public void run() {
                                    try {
                                        if (pOFactory != null) {
                                            InterstitialAD.this.f2719a = pOFactory.getIADView(activity, str, str2);
                                            InterstitialAD.this.f2719a.setAdListener(new ADListenerAdapter(InterstitialAD.this, (byte) 0));
                                            while (InterstitialAD.this.f2724f = InterstitialAD.this.f2724f - 1 > 0) {
                                                InterstitialAD.this.loadAD();
                                            }
                                        }
                                        InterstitialAD.this.f2723e = true;
                                    } catch (Throwable th) {
                                        GDTLogger.m3132e("Exception while init IAD Core", th);
                                    } finally {
                                        InterstitialAD.this.f2723e = true;
                                    }
                                }
                            });
                            return;
                        } catch (Throwable th) {
                            GDTLogger.m3132e("Exception while init IAD plugin", th);
                            return;
                        }
                    }
                    GDTLogger.m3131e("Fail to init ADManager");
                }
            });
            return;
        }
        GDTLogger.m3131e("Required Activity/Service/Permission Not Declared in AndroidManifest.xml");
    }

    public void closePopupWindow() {
        if (this.f2719a != null) {
            this.f2719a.closePopupWindow();
        }
    }

    public void destory() {
        if (this.f2719a != null) {
            this.f2719a.destory();
        }
    }

    public void loadAD() {
        if (!this.f2721c || !this.f2722d) {
            GDTLogger.m3131e("InterstitialAD init Paras OR Context error,See More logs while new InterstitialAD");
        } else if (!this.f2723e) {
            this.f2724f++;
        } else if (this.f2719a != null) {
            this.f2719a.loadAd();
        } else {
            GDTLogger.m3131e("InterstitialAD Init error,See More Logs");
        }
    }

    public void setADListener(InterstitialADListener interstitialADListener) {
        this.f2720b = interstitialADListener;
    }

    public synchronized void show() {
        if (this.f2719a != null) {
            this.f2719a.show();
        }
    }

    public synchronized void show(Activity activity) {
        if (this.f2719a != null) {
            this.f2719a.show(activity);
        }
    }

    public synchronized void showAsPopupWindow() {
        if (this.f2719a != null) {
            this.f2719a.showAsPopupWindown();
        }
    }

    public synchronized void showAsPopupWindow(Activity activity) {
        if (this.f2719a != null) {
            this.f2719a.showAsPopupWindown(activity);
        }
    }
}
