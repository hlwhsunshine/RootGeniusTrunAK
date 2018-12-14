package com.baidu.mobads;

import com.baidu.mobads.VideoAdView.VideoDuration;
import com.baidu.mobads.VideoAdView.VideoSize;

public class VideoAdRequest {
    /* renamed from: a */
    private VideoDuration f363a;
    /* renamed from: b */
    private boolean f364b;
    /* renamed from: c */
    private VideoSize f365c;

    public static class Builder {
        /* renamed from: a */
        private VideoDuration f360a;
        /* renamed from: b */
        private boolean f361b = false;
        /* renamed from: c */
        private VideoSize f362c;

        public VideoAdRequest build() {
            return new VideoAdRequest(this);
        }

        public Builder isShowCountdown(boolean z) {
            this.f361b = z;
            return this;
        }

        public Builder setVideoDuration(VideoDuration videoDuration) {
            this.f360a = videoDuration;
            return this;
        }

        public Builder setVideoSize(VideoSize videoSize) {
            this.f362c = videoSize;
            return this;
        }
    }

    private VideoAdRequest(Builder builder) {
        this.f363a = builder.f360a;
        this.f364b = builder.f361b;
        this.f365c = builder.f362c;
    }

    protected int getVideoDuration() {
        return this.f363a == null ? VideoDuration.DURATION_15_SECONDS.getValue() : this.f363a.getValue();
    }

    protected int getVideoHeight() {
        if (this.f365c == null) {
            this.f365c = VideoSize.SIZE_16x9;
        }
        return this.f365c.getHeight();
    }

    protected int getVideoWidth() {
        if (this.f365c == null) {
            this.f365c = VideoSize.SIZE_16x9;
        }
        return this.f365c.getWidth();
    }

    protected boolean isShowCountdown() {
        return this.f364b;
    }
}
