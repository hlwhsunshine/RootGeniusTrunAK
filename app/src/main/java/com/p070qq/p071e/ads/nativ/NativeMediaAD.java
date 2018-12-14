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
import com.p070qq.p071e.comm.p073pi.NVADI;
import com.p070qq.p071e.comm.p073pi.POFactory;
import com.p070qq.p071e.comm.util.GDTLogger;
import com.p070qq.p071e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qq.e.ads.nativ.NativeMediaAD */
public class NativeMediaAD {
    /* renamed from: a */
    private volatile boolean f2748a;
    /* renamed from: b */
    private volatile boolean f2749b;
    /* renamed from: c */
    private List<Integer> f2750c = new ArrayList();
    /* renamed from: d */
    private volatile boolean f2751d = false;
    /* renamed from: e */
    private NVADI f2752e;
    /* renamed from: f */
    private NativeMediaADListener f2753f;
    /* renamed from: g */
    private BrowserType f2754g;
    /* renamed from: h */
    private DownAPPConfirmPolicy f2755h;

    /* renamed from: com.qq.e.ads.nativ.NativeMediaAD$ADListenerAdapter */
    class ADListenerAdapter implements ADListener {
        private ADListenerAdapter() {
        }

        /* synthetic */ ADListenerAdapter(NativeMediaAD nativeMediaAD, byte b) {
            this();
        }

        public void onADEvent(ADEvent aDEvent) {
            if (NativeMediaAD.this.f2753f == null) {
                GDTLogger.m3133i("No DevADListener Binded");
                return;
            }
            switch (aDEvent.getType()) {
                case 1:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        NativeMediaAD.this.f2753f.onNoAD(((Integer) aDEvent.getParas()[0]).intValue());
                        return;
                    } else {
                        GDTLogger.m3131e("AdEvent.Paras error for NativeMediaAD(" + aDEvent + ")");
                        return;
                    }
                case 2:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof List)) {
                        NativeMediaAD.this.f2753f.onADLoaded((List) aDEvent.getParas()[0]);
                        return;
                    } else {
                        GDTLogger.m3131e("ADEvent.Paras error for NativeMediaAD(" + aDEvent + ")");
                        return;
                    }
                case 3:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                        NativeMediaAD.this.f2753f.onADStatusChanged((NativeMediaADData) aDEvent.getParas()[0]);
                        return;
                    } else {
                        GDTLogger.m3131e("ADEvent.Paras error for NativeMediaAD(" + aDEvent + ")");
                        return;
                    }
                case 4:
                    if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[0] instanceof NativeADDataRef) && (aDEvent.getParas()[1] instanceof Integer)) {
                        NativeMediaAD.this.f2753f.onADError((NativeMediaADData) aDEvent.getParas()[0], ((Integer) aDEvent.getParas()[1]).intValue());
                        return;
                    } else {
                        GDTLogger.m3131e("ADEvent.Paras error for NativeMediaAD(" + aDEvent + ")");
                        return;
                    }
                case 5:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof NativeMediaADData)) {
                        NativeMediaAD.this.f2753f.onADVideoLoaded((NativeMediaADData) aDEvent.getParas()[0]);
                        return;
                    } else {
                        GDTLogger.m3131e("ADEvent.Paras error for NativeMediaAD(" + aDEvent + ")");
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* renamed from: com.qq.e.ads.nativ.NativeMediaAD$NativeMediaADListener */
    public interface NativeMediaADListener {
        void onADError(NativeMediaADData nativeMediaADData, int i);

        void onADLoaded(List<NativeMediaADData> list);

        void onADStatusChanged(NativeMediaADData nativeMediaADData);

        void onADVideoLoaded(NativeMediaADData nativeMediaADData);

        void onNoAD(int i);
    }

    public NativeMediaAD(final Context context, final String str, final String str2, NativeMediaADListener nativeMediaADListener) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || context == null) {
            GDTLogger.m3131e(String.format("NativeMediaAD Contructor paras error, appid=%s, posId=%s, context=%s", new Object[]{str, str2, context}));
            return;
        }
        this.f2748a = true;
        if (C1058a.m3070a(context)) {
            this.f2749b = true;
            this.f2753f = nativeMediaADListener;
            GDTADManager.INIT_EXECUTOR.execute(new Runnable() {
                public void run() {
                    if (GDTADManager.getInstance().initWith(context, str)) {
                        try {
                            final POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public void run() {
                                    try {
                                        if (pOFactory != null) {
                                            Object obj = NativeMediaAD.this;
                                            obj.f2752e = pOFactory.getNativeVideoADDelegate(context, str, str2, new ADListenerAdapter(NativeMediaAD.this, (byte) 0));
                                            if (obj != null) {
                                                NativeMediaAD.this.setBrowserType(NativeMediaAD.this.f2754g);
                                            }
                                            if (NativeMediaAD.this.f2755h != null) {
                                                NativeMediaAD.this.setDownAPPConfirmPolicy(NativeMediaAD.this.f2755h);
                                            }
                                            for (Integer intValue : NativeMediaAD.this.f2750c) {
                                                NativeMediaAD.this.loadAD(intValue.intValue());
                                            }
                                        }
                                    } catch (Throwable th) {
                                        GDTLogger.m3132e("Exception while init NativeMediaAD Core", th);
                                        return;
                                    } finally {
                                        NativeMediaAD.this.f2751d = true;
                                        return;
                                    }
                                    NativeMediaAD.this.f2751d = true;
                                }
                            });
                            return;
                        } catch (Throwable th) {
                            GDTLogger.m3132e("Exception while init NativeMediaAD plugin", th);
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
        if (!this.f2748a || !this.f2749b) {
            GDTLogger.m3131e("AD init Paras OR Context error, details in logs produced while init NativeMediaAD");
        } else if (!this.f2751d) {
            this.f2750c.add(Integer.valueOf(i));
        } else if (this.f2752e != null) {
            this.f2752e.loadAd(i);
        } else {
            GDTLogger.m3131e("NativeMediaAD Init error, See More Logs");
        }
    }

    public void setBrowserType(BrowserType browserType) {
        this.f2754g = browserType;
        if (this.f2752e != null && browserType != null) {
            this.f2752e.setBrowserType(browserType.value());
        }
    }

    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.f2755h = downAPPConfirmPolicy;
        if (this.f2752e != null && downAPPConfirmPolicy != null) {
            this.f2752e.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }
}
