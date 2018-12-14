package com.shuame.p075ad;

import java.io.Serializable;

/* renamed from: com.shuame.ad.FragmentBuildContext */
class FragmentBuildContext implements Serializable {
    private AdType mAdType;
    private String mBaiduPositionId = "";
    private String mGdtPositionId = "";
    private String mPositionName = "";

    public AdType getAdType() {
        return this.mAdType;
    }

    public String getBaiduPositionId() {
        return this.mBaiduPositionId;
    }

    public String getGdtPositionId() {
        return this.mGdtPositionId;
    }

    public String getPositionName() {
        return this.mPositionName;
    }

    public void setAdType(AdType adType) {
        this.mAdType = adType;
    }

    public void setBaiduPositionId(String str) {
        this.mBaiduPositionId = str;
    }

    public void setGdtPositionId(String str) {
        this.mGdtPositionId = str;
    }

    public void setPositionName(String str) {
        this.mPositionName = str;
    }
}
