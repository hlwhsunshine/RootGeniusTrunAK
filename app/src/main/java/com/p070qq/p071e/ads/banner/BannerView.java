package com.p070qq.p071e.ads.banner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.p070qq.p071e.ads.cfg.BannerRollAnimation;
import com.p070qq.p071e.ads.cfg.DownAPPConfirmPolicy;
import com.p070qq.p071e.comm.C1058a;
import com.p070qq.p071e.comm.adevent.ADEvent;
import com.p070qq.p071e.comm.adevent.ADListener;
import com.p070qq.p071e.comm.managers.GDTADManager;
import com.p070qq.p071e.comm.p073pi.BVI;
import com.p070qq.p071e.comm.p073pi.POFactory;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.qq.e.ads.banner.BannerView */
public class BannerView extends FrameLayout {
    /* renamed from: a */
    private BVI f2693a;
    /* renamed from: b */
    private BannerADListener f2694b;
    /* renamed from: c */
    private boolean f2695c = false;
    /* renamed from: d */
    private boolean f2696d = false;
    /* renamed from: e */
    private boolean f2697e = false;
    /* renamed from: f */
    private Integer f2698f;
    /* renamed from: g */
    private BannerRollAnimation f2699g;
    /* renamed from: h */
    private DownAPPConfirmPolicy f2700h;
    /* renamed from: i */
    private Boolean f2701i;
    /* renamed from: j */
    private volatile int f2702j = 0;

    /* renamed from: com.qq.e.ads.banner.BannerView$ADListenerAdapter */
    class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(BannerView bannerView, byte b) {
            this();
        }

        public void onADEvent(ADEvent aDEvent) {
            if (BannerView.this.f2694b == null) {
                GDTLogger.m3133i("No DevADListener Binded");
                return;
            }
            switch (aDEvent.getType()) {
                case 1:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        BannerView.this.f2694b.onNoAD(((Integer) aDEvent.getParas()[0]).intValue());
                        return;
                    } else {
                        GDTLogger.m3131e("AdEvent.Paras error for Banner(" + aDEvent + ")");
                        return;
                    }
                case 2:
                    BannerView.this.f2694b.onADReceiv();
                    return;
                case 3:
                    BannerView.this.f2694b.onADExposure();
                    return;
                case 4:
                    BannerView.this.f2694b.onADClosed();
                    return;
                case 5:
                    BannerView.this.f2694b.onADClicked();
                    return;
                case 6:
                    BannerView.this.f2694b.onADLeftApplication();
                    return;
                case 7:
                    BannerView.this.f2694b.onADOpenOverlay();
                    return;
                case 8:
                    BannerView.this.f2694b.onADCloseOverlay();
                    return;
                default:
                    return;
            }
        }
    }

    public BannerView(Activity activity, ADSize aDSize, String str, String str2) {
        super(activity);
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || activity == null) {
            GDTLogger.m3131e(String.format("Banner ADView Contructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, activity}));
            return;
        }
        this.f2695c = true;
        if (C1058a.m3070a((Context) activity)) {
            this.f2696d = true;
            setLayoutParams(new LayoutParams(-1, -2));
            final Activity activity2 = activity;
            final String str3 = str;
            final ADSize aDSize2 = aDSize;
            final String str4 = str2;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() {
                public void run() {
                    if (GDTADManager.getInstance().initWith(activity2, str3)) {
                        try {
                            final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public void run() {
                                    try {
                                        if (pOFactory != null) {
                                            BannerView.this.f2693a = pOFactory.getBannerView(activity2, aDSize2, str3, str4);
                                            BannerView.this.f2693a.setAdListener(new ADListenerAdapter(BannerView.this, (byte) 0));
                                            Object obj = BannerView.this;
                                            obj.addView(BannerView.this.f2693a.getView());
                                            if (obj != null) {
                                                BannerView.this.setDownConfirmPilicy(BannerView.this.f2700h);
                                            }
                                            if (BannerView.this.f2698f != null) {
                                                BannerView.this.setRefresh(BannerView.this.f2698f.intValue());
                                            }
                                            if (BannerView.this.f2699g != null) {
                                                BannerView.this.setRollAnimation(BannerView.this.f2699g);
                                            }
                                            if (BannerView.this.f2701i != null) {
                                                BannerView.this.setShowClose(BannerView.this.f2701i.booleanValue());
                                            }
                                            while (BannerView.this.f2702j = BannerView.this.f2702j - 1 > 0) {
                                                BannerView.this.loadAD();
                                            }
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.m3132e("Exception while init Banner Core", th);
                                        return;
                                    } finally {
                                        BannerView.this.f2697e = true;
                                        return;
                                    }
                                    BannerView.this.f2697e = true;
                                }
                            });
                            return;
                        } catch (Throwable th) {
                            GDTLogger.m3132e("Exception while init Banner plugin", th);
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

    public void destroy() {
        if (this.f2693a != null) {
            this.f2693a.destroy();
        }
    }

    public void loadAD() {
        if (!this.f2695c || !this.f2696d) {
            GDTLogger.m3131e("Banner init Paras OR Context error,See More logs while new BannerView");
        } else if (!this.f2697e) {
            this.f2702j++;
        } else if (this.f2693a != null) {
            this.f2693a.fetchAd();
        } else {
            GDTLogger.m3131e("Banner Init error,See More Logs");
        }
    }

    public void setADListener(BannerADListener bannerADListener) {
        this.f2694b = bannerADListener;
    }

    public void setDownConfirmPilicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f2700h = downAPPConfirmPolicy;
        if (downAPPConfirmPolicy != null && this.f2693a != null) {
            this.f2693a.setDownAPPConfirmPolicy(downAPPConfirmPolicy.value());
        }
    }

    public void setRefresh(int i) {
        this.f2698f = Integer.valueOf(i);
        if (i < 30 && i != 0) {
            i = 30;
        } else if (i > 120) {
            i = 120;
        }
        if (this.f2693a != null) {
            this.f2693a.setRefresh(i);
        }
    }

    public void setRollAnimation(BannerRollAnimation bannerRollAnimation) {
        this.f2699g = bannerRollAnimation;
        if (bannerRollAnimation != null && this.f2693a != null) {
            this.f2693a.setRollAnimation(bannerRollAnimation.value());
        }
    }

    public void setShowClose(boolean z) {
        this.f2701i = Boolean.valueOf(z);
        if (this.f2693a != null) {
            this.f2693a.setShowCloseButton(z);
        }
    }
}
