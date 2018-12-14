package com.baidu.mobads.interfaces;

public interface IXAdConstants4PDK {
    public static final String EVENT_ERROR = "EVENT_ERROR";
    public static final String EVENT_REQUEST_COMPLETE = "EVENT_REQUEST_COMPLETE";
    public static final String EVENT_REQUEST_CONTENT_VIDEO_PAUSE = "EVENT_REQUEST_CONTENT_VIDEO_PAUSE";
    public static final String EVENT_REQUEST_CONTENT_VIDEO_RESUME = "EVENT_REQUEST_CONTENT_VIDEO_RESUME";
    public static final String EVENT_SLOT_CLICKED = "EVENT_SLOT_CLICKED";
    public static final String EVENT_SLOT_ENDED = "EVENT_SLOT_ENDED";
    public static final String EVENT_SLOT_PRELOADED = "EVENT_SLOT_PRELOADED";
    public static final String EVENT_SLOT_STARTED = "EVENT_SLOT_STARTED";

    public enum ActivityState {
        CREATE("CREATE"),
        START("START"),
        RESTART("RESTART"),
        PAUSE("PAUSE"),
        RESUME("RESUME"),
        STOP("STOP"),
        DESTROY("DESTROY");
        
        /* renamed from: a */
        private final String f631a;

        private ActivityState(String str) {
            this.f631a = str;
        }

        public static ActivityState parse(String str) {
            for (ActivityState activityState : values()) {
                if (activityState.f631a.equalsIgnoreCase(str)) {
                    return activityState;
                }
            }
            return null;
        }

        public final String getValue() {
            return this.f631a;
        }
    }

    public enum ScreenSizeMode {
        NORMAL("normal"),
        FULL_SCREEN("full_screen");
        
        /* renamed from: a */
        private final String f633a;

        private ScreenSizeMode(String str) {
            this.f633a = str;
        }

        public static ScreenSizeMode parse(String str) {
            for (ScreenSizeMode screenSizeMode : values()) {
                if (screenSizeMode.f633a.equalsIgnoreCase(str)) {
                    return screenSizeMode;
                }
            }
            return null;
        }

        public final String getValue() {
            return this.f633a;
        }
    }

    public enum SlotState {
        IDEL("idel"),
        LOADING("loading"),
        LOADED("loaded"),
        PLAYING("playing"),
        PAUSED("paused"),
        COMPLETED("completed"),
        ERROR("error");
        
        /* renamed from: a */
        private final String f635a;

        private SlotState(String str) {
            this.f635a = str;
        }

        public static SlotState parse(String str) {
            for (SlotState slotState : values()) {
                if (slotState.f635a.equalsIgnoreCase(str)) {
                    return slotState;
                }
            }
            return null;
        }

        public final String getValue() {
            return this.f635a;
        }
    }

    public enum SlotType {
        SLOT_TYPE_BANNER("banner"),
        SLOT_TYPE_SPLASH("rsplash"),
        SLOT_TYPE_VERLINK("verlink"),
        SLOT_TYPE_FRONTLINK("frontlink"),
        SLOT_TYPE_INTERSTITIAL("int"),
        SLOT_TYPE_FEEDS("feed"),
        SLOT_TYPE_PREROLL("preroll"),
        SLOT_TYPE_MIDROLL("midroll"),
        SLOT_TYPE_POSTROLL("postroll"),
        SLOT_TYPE_OVERLAY("overlay"),
        SLOT_TYPE_PAUSE_ROLL("pauseroll");
        
        /* renamed from: a */
        private final String f637a;

        private SlotType(String str) {
            this.f637a = str;
        }

        public static SlotType parse(String str) {
            for (SlotType slotType : values()) {
                if (slotType.f637a.equalsIgnoreCase(str)) {
                    return slotType;
                }
            }
            return null;
        }

        public final String getValue() {
            return this.f637a;
        }
    }

    public enum VideoAssetPlayMode {
        VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED("VIDEO_ASSET_AUTO_PLAY_TYPE_ATTENDED"),
        VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED("VIDEO_ASSET_AUTO_PLAY_TYPE_UNATTENDED");
        
        /* renamed from: a */
        private final String f639a;

        private VideoAssetPlayMode(String str) {
            this.f639a = str;
        }

        public static VideoAssetPlayMode parse(String str) {
            for (VideoAssetPlayMode videoAssetPlayMode : values()) {
                if (videoAssetPlayMode.f639a.equalsIgnoreCase(str)) {
                    return videoAssetPlayMode;
                }
            }
            return null;
        }

        public final String getValue() {
            return this.f639a;
        }
    }

    public enum VideoState {
        IDLE("IDLE"),
        PLAYING("PLAYING"),
        PAUSED("PAUSED"),
        COMPLETED("COMPLETED");
        
        /* renamed from: a */
        private final String f641a;

        private VideoState(String str) {
            this.f641a = str;
        }

        public static VideoState parse(String str) {
            for (VideoState videoState : values()) {
                if (videoState.f641a.equalsIgnoreCase(str)) {
                    return videoState;
                }
            }
            return null;
        }

        public final String getValue() {
            return this.f641a;
        }
    }

    public enum VisitorAction {
        PAUSE_BUTTON_CLICKED("PAUSE_BUTTON_CLICKED"),
        RESUME_BUTTON_CLICKED("RESUME_BUTTON_CLICKED");
        
        /* renamed from: a */
        private final String f643a;

        private VisitorAction(String str) {
            this.f643a = str;
        }

        public static VisitorAction parse(String str) {
            for (VisitorAction visitorAction : values()) {
                if (visitorAction.f643a.equalsIgnoreCase(str)) {
                    return visitorAction;
                }
            }
            return null;
        }

        public final String getValue() {
            return this.f643a;
        }
    }
}
