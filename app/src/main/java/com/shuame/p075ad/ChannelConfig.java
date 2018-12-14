package com.shuame.p075ad;

import android.text.TextUtils;
import com.google.gson.p051a.C0471c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.shuame.ad.ChannelConfig */
class ChannelConfig {
    @C0471c(a = "content")
    /* renamed from: a */
    public List<PositionConfig> f2878a;

    /* renamed from: com.shuame.ad.ChannelConfig$PositionConfig */
    public static class PositionConfig implements Serializable, Cloneable {
        @C0471c(a = "delay")
        public long delay;
        @C0471c(a = "display_name")
        public String displayName;
        @C0471c(a = "enabled")
        public boolean enabled;
        @C0471c(a = "id")
        /* renamed from: id */
        public int f2877id;
        @C0471c(a = "name")
        public String name;
        @C0471c(a = "params")
        public Params params;
        @C0471c(a = "priority")
        public List<String> priority;
        @C0471c(a = "sourceDetails")
        public List<SourceDetails> sourceDetails;
        @C0471c(a = "switchRule")
        public SwitchRuleEntity switchRule;
        private AdType type;

        /* renamed from: com.shuame.ad.ChannelConfig$PositionConfig$Params */
        public static class Params implements Serializable, Cloneable {
            @C0471c(a = "splash_load_time")
            public int splashLoadTime;
            @C0471c(a = "splash_show_time")
            public int splashShowTime;

            protected Object clone() {
                Params params = new Params();
                params.splashLoadTime = this.splashLoadTime;
                params.splashShowTime = this.splashShowTime;
                return params;
            }
        }

        /* renamed from: com.shuame.ad.ChannelConfig$PositionConfig$SourceDetails */
        public static class SourceDetails implements Serializable, Cloneable {
            @C0471c(a = "close_btn")
            public boolean closeBtn;
            @C0471c(a = "image_url")
            public String imageUrl;
            @C0471c(a = "is_mini_os")
            public int isMiniOs;
            @C0471c(a = "jump_url")
            public String jumpUrl;
            @C0471c(a = "refresh")
            public int refresh;
            @C0471c(a = "source")
            public String source;

            protected Object clone() {
                SourceDetails sourceDetails = new SourceDetails();
                sourceDetails.refresh = this.refresh;
                sourceDetails.closeBtn = this.closeBtn;
                sourceDetails.source = this.source;
                sourceDetails.imageUrl = this.imageUrl;
                sourceDetails.jumpUrl = this.jumpUrl;
                sourceDetails.isMiniOs = this.isMiniOs;
                return sourceDetails;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                SourceDetails sourceDetails = (SourceDetails) obj;
                return this.refresh != sourceDetails.refresh ? false : this.closeBtn != sourceDetails.closeBtn ? false : this.source != null ? this.source.equals(sourceDetails.source) : sourceDetails.source == null;
            }

            public int hashCode() {
                int i = 0;
                int i2 = ((this.closeBtn ? 1 : 0) + (this.refresh * 31)) * 31;
                if (this.source != null) {
                    i = this.source.hashCode();
                }
                return i2 + i;
            }

            public String toString() {
                return "SourceDetails{refresh=" + this.refresh + ", closeBtn=" + this.closeBtn + ", source='" + this.source + '\'' + '}';
            }
        }

        /* renamed from: com.shuame.ad.ChannelConfig$PositionConfig$SwitchRuleEntity */
        public static class SwitchRuleEntity implements Serializable, Cloneable {
            @C0471c(a = "on_blank")
            public boolean onBlank;
            @C0471c(a = "on_failed_timeout")
            public int onFailedTimeout;
            @C0471c(a = "on_no_click_timeout")
            public int onNoClickTimeout;

            protected Object clone() {
                SwitchRuleEntity switchRuleEntity = new SwitchRuleEntity();
                switchRuleEntity.onBlank = this.onBlank;
                switchRuleEntity.onNoClickTimeout = this.onNoClickTimeout;
                switchRuleEntity.onFailedTimeout = this.onFailedTimeout;
                return switchRuleEntity;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                SwitchRuleEntity switchRuleEntity = (SwitchRuleEntity) obj;
                return this.onBlank != switchRuleEntity.onBlank ? false : this.onNoClickTimeout != switchRuleEntity.onNoClickTimeout ? false : this.onFailedTimeout == switchRuleEntity.onFailedTimeout;
            }

            public int hashCode() {
                return ((((this.onBlank ? 1 : 0) * 31) + this.onNoClickTimeout) * 31) + this.onFailedTimeout;
            }

            public String toString() {
                return "SwitchRuleEntity{onBlank=" + this.onBlank + ", onNoClickTimeout=" + this.onNoClickTimeout + ", onFailedTimeout=" + this.onFailedTimeout + '}';
            }
        }

        protected Object clone() {
            PositionConfig positionConfig = new PositionConfig();
            positionConfig.delay = this.delay;
            positionConfig.name = this.name;
            if (this.priority != null) {
                positionConfig.priority = new ArrayList(this.priority);
            }
            positionConfig.enabled = this.enabled;
            positionConfig.displayName = this.displayName;
            positionConfig.f2877id = this.f2877id;
            if (this.sourceDetails != null) {
                positionConfig.sourceDetails = new ArrayList(this.sourceDetails.size());
                for (SourceDetails clone : this.sourceDetails) {
                    positionConfig.sourceDetails.add((SourceDetails) clone.clone());
                }
            }
            if (this.switchRule != null) {
                positionConfig.switchRule = (SwitchRuleEntity) this.switchRule.clone();
            }
            if (this.params != null) {
                positionConfig.params = (Params) this.params.clone();
            }
            return positionConfig;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PositionConfig positionConfig = (PositionConfig) obj;
            return this.delay != positionConfig.delay ? false : this.enabled != positionConfig.enabled ? false : this.f2877id != positionConfig.f2877id ? false : (this.name == null ? positionConfig.name != null : !this.name.equals(positionConfig.name)) ? false : (this.priority == null ? positionConfig.priority != null : !this.priority.equals(positionConfig.priority)) ? false : (this.sourceDetails == null ? positionConfig.sourceDetails != null : !this.sourceDetails.equals(positionConfig.sourceDetails)) ? false : (this.switchRule == null ? positionConfig.switchRule != null : !this.switchRule.equals(positionConfig.switchRule)) ? false : (this.displayName == null ? positionConfig.displayName != null : !this.displayName.equals(positionConfig.displayName)) ? false : this.type == positionConfig.type;
        }

        int getClickTimeout() {
            return this.switchRule == null ? 0 : this.switchRule.onNoClickTimeout * 1000;
        }

        boolean getCloseBtn(String str) {
            SourceDetails sourceDetail = getSourceDetail(str);
            return sourceDetail == null || sourceDetail.closeBtn;
        }

        long getDelay() {
            return this.delay * 1000;
        }

        int getFailTimeout() {
            return this.switchRule == null ? 0 : this.switchRule.onFailedTimeout * 1000;
        }

        int getFreshTime(String str) {
            SourceDetails sourceDetail = getSourceDetail(str);
            return sourceDetail == null ? 0 : sourceDetail.refresh * 1000;
        }

        String getName() {
            return this.name;
        }

        SourceDetails getSourceDetail(String str) {
            if (!TextUtils.isEmpty(str)) {
                for (SourceDetails sourceDetails : this.sourceDetails) {
                    if (str.equals(sourceDetails.source)) {
                        return sourceDetails;
                    }
                }
            }
            return null;
        }

        int getSplashLoadTime() {
            return this.params == null ? 0 : this.params.splashLoadTime * 1000;
        }

        int getSplashShowTime() {
            return this.params.splashShowTime * 1000;
        }

        SwitchRuleEntity getSwitchRule() {
            return this.switchRule;
        }

        AdType getType() {
            return this.type;
        }

        boolean isEnabled() {
            return this.enabled;
        }

        public PositionConfig mergePositionConfig(PositionConfig positionConfig) {
            PositionConfig positionConfig2 = (PositionConfig) positionConfig.clone();
            if (positionConfig2.switchRule == null) {
                positionConfig.switchRule = (SwitchRuleEntity) this.switchRule.clone();
            }
            if ((positionConfig.priority == null || positionConfig.priority.size() == 0) && this.priority != null) {
                positionConfig2.priority = new ArrayList(this.priority);
            }
            if (positionConfig.params == null && this.params != null) {
                positionConfig2.params = (Params) this.params.clone();
            }
            if (positionConfig.sourceDetails == null || positionConfig.sourceDetails.size() == 0) {
                if (this.sourceDetails != null) {
                    positionConfig2.sourceDetails = new ArrayList();
                    for (SourceDetails clone : this.sourceDetails) {
                        positionConfig2.sourceDetails.add((SourceDetails) clone.clone());
                    }
                }
            } else if (this.sourceDetails != null) {
                for (SourceDetails clone2 : this.sourceDetails) {
                    Object obj;
                    Object obj2 = null;
                    Iterator it = positionConfig.sourceDetails.iterator();
                    while (true) {
                        obj = obj2;
                        if (!it.hasNext()) {
                            break;
                        }
                        obj2 = clone2.source.equals(((SourceDetails) it.next()).source) ? 1 : obj;
                    }
                    if (obj == null) {
                        positionConfig2.sourceDetails.add(clone2);
                    }
                }
            }
            return positionConfig2;
        }

        boolean reLoadForBlank() {
            return this.switchRule != null && this.switchRule.onBlank;
        }

        void setCloseBtn(String str, boolean z) {
            SourceDetails sourceDetail = getSourceDetail(str);
            if (sourceDetail == null) {
                z = true;
            }
            sourceDetail.closeBtn = z;
        }

        void setFreshTime(String str, int i) {
            SourceDetails sourceDetail = getSourceDetail(str);
            if (sourceDetail == null) {
                i = 0;
            }
            sourceDetail.refresh = i;
        }

        void setType(AdType adType) {
            this.type = adType;
        }

        public String toString() {
            return "PositionConfig{enabled=" + this.enabled + ", delay=" + this.delay + ", name='" + this.name + '\'' + ", priority=" + this.priority + ", sourceDetails=" + this.sourceDetails + ", switchRule=" + this.switchRule + '}';
        }
    }

    ChannelConfig() {
    }

    /* renamed from: a */
    final ChannelConfig mo6659a(ChannelConfig channelConfig) {
        ChannelConfig channelConfig2 = new ChannelConfig();
        channelConfig2.f2878a = new ArrayList();
        for (PositionConfig positionConfig : this.f2878a) {
            Object obj = null;
            String str = positionConfig.name;
            if (!(channelConfig == null || channelConfig.f2878a == null)) {
                Object obj2;
                Iterator it = channelConfig.f2878a.iterator();
                while (true) {
                    obj2 = obj;
                    if (!it.hasNext()) {
                        break;
                    }
                    PositionConfig positionConfig2 = (PositionConfig) it.next();
                    if (str.equals(positionConfig2.name)) {
                        obj2 = 1;
                        channelConfig2.f2878a.add(positionConfig.mergePositionConfig(positionConfig2));
                    }
                    obj = obj2;
                }
                obj = obj2;
            }
            if (obj == null) {
                channelConfig2.f2878a.add((PositionConfig) positionConfig.clone());
            }
        }
        return channelConfig2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChannelConfig channelConfig = (ChannelConfig) obj;
        return this.f2878a != null ? this.f2878a.equals(channelConfig.f2878a) : channelConfig.f2878a == null;
    }

    public int hashCode() {
        return this.f2878a != null ? this.f2878a.hashCode() : 0;
    }

    public String toString() {
        return "ChannelConfig{content=" + this.f2878a + '}';
    }
}
