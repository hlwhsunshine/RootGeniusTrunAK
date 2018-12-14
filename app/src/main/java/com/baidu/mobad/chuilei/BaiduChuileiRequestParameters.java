package com.baidu.mobad.chuilei;

import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobad.feeds.RequestParameters.Builder;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import java.util.HashMap;
import java.util.Map;

public class BaiduChuileiRequestParameters implements IXAdFeedsRequestParameters {
    /* renamed from: a */
    private RequestParameters f153a = new Builder().build();

    public int getAPPConfirmPolicy() {
        return this.f153a.getAPPConfirmPolicy();
    }

    public String getAdPlacementId() {
        return this.f153a.getAdPlacementId();
    }

    public int getAdsType() {
        return this.f153a.getAdsType();
    }

    public Map<String, String> getExtras() {
        return this.f153a.getExtras();
    }

    public String getKeywords() {
        return this.f153a.getKeywords();
    }

    public RequestParameters getRequestParameters() {
        return this.f153a;
    }

    @Deprecated
    public boolean isConfirmDownloading() {
        return this.f153a.isConfirmDownloading();
    }

    public HashMap<String, Object> toHashMap() {
        return this.f153a.toHashMap();
    }
}
