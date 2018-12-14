package com.shuame.mobile.sdk.impl.utils.http;

import java.util.Map;

public interface OnDownloadListener {
    void onComplete(int i, int i2, Map<String, Object> map);

    void onTaskInfo(int i, int i2, int i3);
}
