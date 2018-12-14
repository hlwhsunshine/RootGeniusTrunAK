package com.p070qq.p071e.ads.nativ;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.p070qq.p071e.ads.cfg.BrowserType;
import com.p070qq.p071e.ads.cfg.DownAPPConfirmPolicy;
import com.p070qq.p071e.comm.C1058a;
import com.p070qq.p071e.comm.adevent.ADEvent;
import com.p070qq.p071e.comm.adevent.ADListener;
import com.p070qq.p071e.comm.managers.GDTADManager;
import com.p070qq.p071e.comm.p073pi.NADI;
import com.p070qq.p071e.comm.p073pi.POFactory;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qq.e.ads.nativ.NativeAD */
public class NativeAD {
    /* renamed from: a */
    private NADI f2733a;
    /* renamed from: b */
    private NativeAdListener f2734b;
    /* renamed from: c */
    private boolean f2735c;
    /* renamed from: d */
    private boolean f2736d;
    /* renamed from: e */
    private List<Integer> f2737e = new ArrayList();
    /* renamed from: f */
    private boolean f2738f = false;
    /* renamed from: g */
    private BrowserType f2739g;
    /* renamed from: h */
    private DownAPPConfirmPolicy f2740h;

    /* renamed from: com.qq.e.ads.nativ.NativeAD$ADListenerAdapter */
    class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(NativeAD nativeAD, byte b) {
            this();
        }

        public void onADEvent(ADEvent aDEvent) {
            if (NativeAD.this.f2734b == null) {
                GDTLogger.m3133i("No DevADListener Binded");
                return;
            }
            switch (aDEvent.getType()) {
                case 1:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        NativeAD.this.f2734b.onNoAD(((Integer) aDEvent.getParas()[0]).intValue());
                        return;
                    } else {
                        GDTLogger.m3131e("AdEvent.Paras error for NativeAD(" + aDEvent + ")");
                        return;
                    }
                case 2:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                        NativeAD.this.f2734b.onADLoaded((List) aDEvent.getParas()[0]);
                        return;
                    } else {
                        GDTLogger.m3131e("ADEvent.Paras error for NativeAD(" + aDEvent + ")");
                        return;
                    }
                case 3:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeADDataRef)) {
                        NativeAD.this.f2734b.onADStatusChanged((NativeADDataRef) aDEvent.getParas()[0]);
                        return;
                    } else {
                        GDTLogger.m3131e("ADEvent.Paras error for NativeAD(" + aDEvent + ")");
                        return;
                    }
                case 4:
                    if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeADDataRef) && (aDEvent.getParas()[1] instanceof Integer)) {
                        NativeAD.this.f2734b.onADError((NativeADDataRef) aDEvent.getParas()[0], ((Integer) aDEvent.getParas()[1]).intValue());
                        return;
                    } else {
                        GDTLogger.m3131e("ADEvent.Paras error for NativeAD(" + aDEvent + ")");
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* renamed from: com.qq.e.ads.nativ.NativeAD$NativeAdListener */
    public interface NativeAdListener {
        void onADError(NativeADDataRef nativeADDataRef, int i);

        void onADLoaded(List<NativeADDataRef> list);

        void onADStatusChanged(NativeADDataRef nativeADDataRef);

        void onNoAD(int i);
    }

    public NativeAD(final Context context, final String str, final String str2, NativeAdListener nativeAdListener) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || context == null) {
            GDTLogger.m3131e(String.format("GDTNativeAd Contructor paras error,appid=%s,posId=%s,context=%s", new Object[]{str, str2, context}));
            return;
        }
        this.f2735c = true;
        if (C1058a.m3070a(context)) {
            this.f2736d = true;
            this.f2734b = nativeAdListener;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() {
                public void run() {
                    if (GDTADManager.getInstance().initWith(context, str)) {
                        try {
                            final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public void run() {
                                    try {
                                        if (pOFactory != null) {
                                            Object obj = NativeAD.this;
                                            obj.f2733a = pOFactory.getNativeADDelegate(context, str, str2, new ADListenerAdapter(NativeAD.this, (byte) 0));
                                            if (obj != null) {
                                                NativeAD.this.setBrowserType(NativeAD.this.f2739g);
                                            }
                                            if (NativeAD.this.f2740h != null) {
                                                NativeAD.this.setDownAPPConfirmPolicy(NativeAD.this.f2740h);
                                            }
                                            for (Integer intValue : NativeAD.this.f2737e) {
                                                NativeAD.this.loadAD(intValue.intValue());
                                            }
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.m3132e("Exception while init Native Core", th);
                                        return;
                                    } finally {
                                        NativeAD.this.f2738f = true;
                                        return;
                                    }
                                    NativeAD.this.f2738f = true;
                                }
                            });
                            return;
                        } catch (Throwable th) {
                            GDTLogger.m3132e("Exception while init Native plugin", th);
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

    public void loadAD(int i) {
        if (!this.f2735c || !this.f2736d) {
            GDTLogger.m3131e("AD init Paras OR Context error,details in logs produced while init NativeAD");
        } else if (!this.f2738f) {
            this.f2737e.add(Integer.valueOf(i));
        } else if (this.f2733a != null) {
            this.f2733a.loadAd(i);
        } else {
            GDTLogger.m3131e("NativeAD Init error,See More Logs");
        }
    }

    public void setBrowserType(BrowserType browserType) {
        this.f2739g = browserType;
        if (this.f2733a != null && browserType != null) {
            this.f2733a.setBrowserType(browserType.value());
        }
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f2740h = downAPPConfirmPolicy;
        if (this.f2733a != null && downAPPConfirmPolicy != null) {
            this.f2733a.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }
}
