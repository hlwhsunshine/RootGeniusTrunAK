package com.baidu.mobad.feeds;

import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class RequestParameters implements IXAdFeedsRequestParameters {
    public static final int ADS_TYPE_DOWNLOAD = 2;
    public static final int ADS_TYPE_OPENPAGE = 1;
    public static final int DOWNLOAD_APP_CONFIRM_ALWAYS = 2;
    public static final int DOWNLOAD_APP_CONFIRM_CUSTOM_BY_APP = 4;
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    public static final int MAX_ASSETS_RESERVED = 15;
    public static final String TAG = "RequestParameters";
    /* renamed from: a */
    private final String f223a;
    /* renamed from: b */
    private int f224b;
    /* renamed from: c */
    private boolean f225c;
    /* renamed from: d */
    private Map<String, String> f226d;
    /* renamed from: e */
    private int f227e;
    /* renamed from: f */
    private int f228f;
    /* renamed from: g */
    private int f229g;
    protected String mPlacementId;

    public static class Builder {
        /* renamed from: a */
        private String f216a;
        /* renamed from: b */
        private Map<String, String> f217b = new HashMap();
        /* renamed from: c */
        private int f218c = 3;
        /* renamed from: d */
        private boolean f219d = false;
        /* renamed from: e */
        private int f220e = 640;
        /* renamed from: f */
        private int f221f = 480;
        /* renamed from: g */
        private int f222g = 1;

        public final Builder addExtra(String str, String str2) {
            this.f217b.put(str, str2);
            return this;
        }

        public final RequestParameters build() {
            return new RequestParameters(this);
        }

        @Deprecated
        public final Builder confirmDownloading(boolean z) {
            if (z) {
                downloadAppConfirmPolicy(2);
            } else {
                downloadAppConfirmPolicy(3);
            }
            return this;
        }

        public final Builder downloadAppConfirmPolicy(int i) {
            this.f222g = i;
            return this;
        }

        public final Builder setHeight(int i) {
            this.f221f = i;
            return this;
        }

        public final Builder setWidth(int i) {
            this.f220e = i;
            return this;
        }
    }

    private RequestParameters(Builder builder) {
        this.f227e = 0;
        this.f228f = 0;
        this.f223a = builder.f216a;
        this.f224b = builder.f218c;
        this.f227e = builder.f220e;
        this.f228f = builder.f221f;
        this.f225c = builder.f219d;
        this.f229g = builder.f222g;
        setExtras(builder.f217b);
    }

    public final int getAPPConfirmPolicy() {
        return this.f229g;
    }

    public final String getAdPlacementId() {
        return this.mPlacementId;
    }

    public final int getAdsType() {
        return this.f224b;
    }

    public final Map<String, String> getExtras() {
        return this.f226d;
    }

    public final int getHeight() {
        return this.f228f;
    }

    public final String getKeywords() {
        return this.f223a;
    }

    public final int getWidth() {
        return this.f227e;
    }

    public final boolean isConfirmDownloading() {
        return this.f225c;
    }

    public final void setAdsType(int i) {
        this.f224b = i;
    }

    public final void setExtras(Map<String, String> map) {
        this.f226d = map;
    }

    public final HashMap<String, Object> toHashMap() {
        HashMap<String, Object> hashMap = new HashMap();
        hashMap.put("mKeywords", this.f223a);
        hashMap.put("adsType", Integer.valueOf(this.f224b));
        hashMap.put("confirmDownloading", Boolean.valueOf(this.f225c));
        HashMap hashMap2 = new HashMap();
        if (this.f226d != null) {
            for (Entry entry : this.f226d.entrySet()) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        hashMap.put("extras", hashMap2);
        return hashMap;
    }
}
